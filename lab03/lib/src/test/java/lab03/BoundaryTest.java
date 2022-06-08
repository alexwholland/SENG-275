package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.InvalidApplicationException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

    /*isComfortable() Tests*/

    @ParameterizedTest
    @ValueSource(ints = {5, 15, 20})
    //On point, In point, On point
    void isComfortable(int temp) {
        assertTrue(Boundary.isComfortable(temp));
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 21})
    //Off point, Off point
    void isUnComfortable(int temp) {
        assertFalse(Boundary.isComfortable(temp));
    }

    /*elevatorsRequired() Tests*/

    @Test
    void noElevator() {
        int storeys = 1; //Off point
        int expectedElevators = 0;
        assertEquals(expectedElevators, Boundary.elevatorsRequired(storeys));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5})
    void oneElevator(int storeys) {
        assertEquals(1, Boundary.elevatorsRequired(storeys));
    }

    @Test
    void twoElevators() {
        int storeys = 6; //On point
        int expectedElevators = 2;
        assertEquals(expectedElevators, Boundary.elevatorsRequired(storeys));
    }

    /*percentageToLetterGrade*/

    /*Test the exception*/
    @ParameterizedTest
    @ValueSource(doubles = {-1, 101})
    void invalidGrade(double grade) {
        /*
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> Boundary.percentageToLetterGrade(grade));
        Assertions.assertEquals("", thrown.getMessage());
        */
        //https://howtodoinjava.com/junit5/expected-exception-example/
        assertThrows(IllegalArgumentException.class, () -> Boundary.percentageToLetterGrade(grade));
    }

    /*Test grades from F to A*/
    @ParameterizedTest
    @ValueSource(doubles = {0, 49})
    void fGrade(double grade) {
        assertEquals("F", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {50, 59})
    void dGrade(double grade) {
        assertEquals("D", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {60, 64})
    void cGrade(double grade) {
        assertEquals("C", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {65, 69})
    void cPlusGrade(double grade) {
        assertEquals("C+", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {70, 72})
    void bMinusGrade(double grade) {
        assertEquals("B-", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {73, 76})
    void bGrade(double grade) {
        assertEquals("B", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {77, 79})
    void bPlusGrade(double grade) {
        assertEquals("B+", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {80, 84})
    void aMinusGrade(double grade) {
        assertEquals("A-", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {85, 89})
    void aGrade(double grade) {
        assertEquals("A", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {90, 100})
    void aPlusGrade(double grade) {
        assertEquals("A+", Boundary.percentageToLetterGrade(grade));
    }

}