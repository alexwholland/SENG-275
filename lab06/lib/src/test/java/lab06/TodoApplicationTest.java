
package lab06;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.List;

class TodoApplicationTest {

    private TodoApplication todoApp;
    private PersonService personServiceMock;
    private TodoService todoServiceMock;

    private final String userName = "SomeUser";
    private final Long userID = 1L;
    private final List<String> todos = List.of("Wake up", "Test the code", "Celebrate the victory!");

    @Test
    void addTodo() {
        // Ensure that it's possible to add a todo to the app, and that the correct methods are called
        TodoService todoServiceMock = mock(TodoService.class);
        PersonService personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // promote dummy to stub
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.addTodo(userName, todos.get(0))).thenReturn(true);
        // check that a task can be added to a user ID
        assertThat(todoApp.addTodo(userID, todos.get(0))).isEqualTo(true);
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).addTodo(userName, todos.get(0));
        // verify that NO other methods were called on the mocked object other than what has already been verified
        verifyNoMoreInteractions(personServiceMock);
        verifyNoMoreInteractions(todoServiceMock);
    }

    @Test
    void retrieveTodos() {
        // add multiple todos to the app, and retrieve a strict subset of them using a substring.
        TodoService todoServiceMock = mock(TodoService.class);
        PersonService personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // promote dummy to stub
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);

        // check that the todos in the app contain a "the" substring
        String sub = "the";
        assertThat(todoApp.retrieveTodos(userID, sub)).containsExactly(todos.get(1), todos.get(2));
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).retrieveTodos(userName);
        // verify that NO other methods were called on the mocked object other than what has already been verified
        verifyNoMoreInteractions(personServiceMock);
        verifyNoMoreInteractions(todoServiceMock);
    }

    @Test
    void completeAllWithNoTodos() {
        // confirm that the appropriate behaviour occurs when there are no todos being tracked by the app
        TodoService todoServiceMock = mock(TodoService.class);
        PersonService personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // promote dummy to stub
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(List.of());

        todoApp.completeAllTodos(userID);
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).retrieveTodos(userName);
        verify(todoServiceMock, times(0)).completeTodo(anyString());
        // verify that NO other methods were called on the mocked object other than what has already been verified
        verifyNoMoreInteractions(personServiceMock);
        verifyNoMoreInteractions(todoServiceMock);
    }

    @Test
    void completeAllWithThreeTodos() {
        // confirm that the appropriate behaviour occurs when there are three todos being tracked by the app
        TodoService todoServiceMock = mock(TodoService.class);
        PersonService personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // promote dummy to a stub
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);

        todoApp.completeAllTodos(userID);

        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).retrieveTodos(userName);
        verify(todoServiceMock, times(1)).completeTodo(todos.get(0));
        verify(todoServiceMock, times(1)).completeTodo(todos.get(1));
        verify(todoServiceMock, times(1)).completeTodo(todos.get(2));
        // verify that NO other methods were called on the mocked object other than what has already been verified
        verifyNoMoreInteractions(personServiceMock);
        verifyNoMoreInteractions(todoServiceMock);
    }
}