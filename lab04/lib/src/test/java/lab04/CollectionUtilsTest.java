package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CollectionUtilsTest {

    @Test
    void sameSizeContainsMultiple(){
        Collection C1 = new ArrayList();
        C1.add("a");
        C1.add("b");
        C1.add("c");
        C1.add("d");
        C1.add("d");

        Collection C2 = new ArrayList();
        C2.add("a");
        C2.add("a");
        C2.add("b");
        C2.add("c");
        C2.add("d");

        assertTrue(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void diffSizeContains3(){
        Collection C1 = new ArrayList();
        C1.add("1");
        C1.add("2");
        C1.add("3");

        Collection C2 = new ArrayList();
        C2.add("1");
        C2.add("2");
        C2.add("3");
        C2.add("4");

        assertTrue(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void diffSizeContainsMultiples(){
        Collection C1 = new ArrayList();
        C1.add("a");
        C1.add("b");
        C1.add("c");
        C1.add("c");


        Collection C2 = new ArrayList();
        C2.add("a");
        C2.add("b");
        C2.add("c");

        assertTrue(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void diffSizeContainsNone(){
        Collection C1 = new ArrayList();
        C1.add("3");
        C1.add("4");


        Collection C2 = new ArrayList();
        C2.add("0");
        C2.add("1");
        C2.add("2");

        assertFalse(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void diffSizeContainsNoneMultiples(){
        Collection C1 = new ArrayList();
        C1.add("d");
        C1.add("e");
        C1.add("e");
        C1.add("f");

        Collection C2 = new ArrayList();
        C2.add("a");
        C2.add("b");
        C2.add("c");

        assertFalse(CollectionUtils.containsAny(C1, C2));
    }

}