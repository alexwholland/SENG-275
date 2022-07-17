package Lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task t;

    @BeforeEach
    public void init(){
        t = new Task();
        t.setPatientNumber(1);
        t.setCareProvided(t.needs[0]);
        t.setTimeOfCare("10 am");
        t.setAssignedNurseName("Margaret Atwood");
    }

    @Test
    public void getPatientNumberTest(){
        int result = t.getPatientNumber();
        System.out.println(result);
        assertEquals(1, result);
    }

    @Test
    public void getCareProvidedTest(){
        String result = t.getCareProvided();
        System.out.println(result);
        assertEquals(t.needs[0], result);
    }

    @Test
    public void getTimeOfCareTest(){
        String result = t.getTimeOfCare();
        System.out.println(result);
        assertEquals("10 am", result);
    }

    @Test
    public void getAssignedNurseNameTest(){
        String result = t.getAssignedNurseName();
        System.out.println(result);
        assertEquals("Margaret Atwood", result);
    }
}