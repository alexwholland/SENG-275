
package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class LeapYearTest {

    // Test years that are multiples of 400.
    @Property
    void validLeapYear400(@ForAll("leapYear400") int year) {
        assertTrue(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYear400() {
        return Arbitraries.integers()
                .filter(n -> n % 400 == 0)
                .filter(n -> n > 0);
    }


    // Test years that are multiples of 4 but not 100 or 400
    @Property
    void validLeapYear4(@ForAll("leapYear4") int year) {
        assertTrue(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> leapYear4() {
        return Arbitraries.integers()
                .filter(n -> n % 4 == 0)
                .filter(n -> n % 100 != 0)
                .filter(n -> n % 400 != 0)
                .filter(n -> n >= 1);
    }


    // Test when a year is invalid (less than 1)
    @Property
    void invalidYear(@ForAll("invalidYear")int year){
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> invalidYear() {
        return Arbitraries.integers().filter(n -> n < 1);
    }


    // Test years that are multiples of 100 but not 400
    @Property
    void isNotLeapWith100(@ForAll("isValid100") int year) {
        assertFalse(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> isValid100() {
        return Arbitraries.integers()
                .filter(n -> n % 100 == 0)
                .filter(n -> n % 400 != 0)
                .filter(n -> n >= 1);
    }


    // Test years that are neither a multiple of 100 nor 400
    @Property
    void not100or400(@ForAll("neither100or400") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> neither100or400() {
        return Arbitraries.integers()
                .filter(n -> n % 100 != 0)
                .filter(n -> n % 400 != 0)
                .filter(n -> n % 4 != 0)
                .filter(n -> n > 0);
    }

}