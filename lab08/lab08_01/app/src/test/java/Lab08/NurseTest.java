package Lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NurseTest {
    Nurse n;

    @BeforeEach
    public void init(){
        n = new Nurse();
        n.setName("Margaret Atwood");
        n.setShift("8 am to 4 pm");
    }

    @Test
    public void getNameTest(){
        String result = n.getName();
        assertEquals("Margaret Atwood", result);
    }

    @Test
    public void getShiftTest(){
        String result = n.getShift();
        assertEquals("8 am to 4 pm", result);
    }
}