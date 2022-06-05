package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // A sorted array - all at once
    @Test
    void sorted() {
        assertTrue(ArrayUtils.isSorted(new int[] {1,2,3,4}));
    }

    // Empty arrays are sorted
    @Test
    void arraySorted() {
        int[] someArray = {};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }

    // Arrays of one element are sorted
    @Test
    void oneElement() {
        int[] someArray = {1};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }

    // A partially sorted array
    @Test
    void partiallySorted() {
        int[] someArray = {1, 2, 4, 3};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertFalse(someArraySorted);
    }

    // A completely unsorted array
    @Test
    void unsorted() {
        int[] someArray = {1, 5, 2, 3};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertFalse(someArraySorted);
    }

    // An array with duplicate values
    @Test
    void duplicateValues() {
        int[] someArray = {1, 1, 2, 2, 3};
        boolean someArraySorted = ArrayUtils.isSorted(someArray);
        assertTrue(someArraySorted);
    }
}



