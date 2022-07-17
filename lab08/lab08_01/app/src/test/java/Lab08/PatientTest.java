package Lab08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient p;

    @BeforeEach
    public void init(){
        p = new Patient();
        p.setNumber(1);
        p.setMedicationNeeds(p.medications[0]);
        p.setCareNeeds(p.needs[0]);
    }

    @Test
    public void getNumberTest(){
        int result = p.getNumber();
        assertEquals(1, result);
    }

    @Test
    public void getMedicationNeedsTest(){
        String result = p.getMedicationNeeds();
        assertEquals(p.medications[0], result);
    }

    @Test
    public void getCareNeeds(){
        String result = p.getCareNeeds();
        assertEquals(p.needs[0], result);
    }
}