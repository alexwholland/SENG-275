package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

    /**insideDisplayArea() Tests*/
    /*Note: HD tests must be called before FHD*/

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"0,0", "0,719", "1279,0", "1279,719"})
    void trueHD(int x, int y) {
        assertTrue(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"-1,0", "0,-1", "-1,-1", "1280,0", "1279,-1", "0,720", "-1,719", "1280,719", "1279,720"})
    void falseHD(int x, int y) {
        assertFalse(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"0,0", "0,1079", "1919,0", "1919,1079"})
    void trueFHD(int x, int y){
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"-1,0", "0,-1", "-1,-1", "1920,0", "1919,-1", "0,1080", "-1,1979", "1920,1079", "1919,1080"})
    void falseFHD(int x, int y){
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(x,y));
    }

    /**messageIsValid() Tests*/

    /*Test valid license plates*/
    @ParameterizedTest(name = "input{0}, motorcycle{1}")
    @MethodSource("validPlates")
    void validPlates(String input, boolean motorcycle) {
        assertTrue(Specification.messageIsValid(input, motorcycle));
    }

    private static Stream<Arguments> validPlates() {
        return Stream.of(
                Arguments.of("A1", true), //2 characters accepted
                Arguments.of("A1", false), //2 characters accepted
                Arguments.of("A1B1C1", false), //6 characters
                Arguments.of("Z-A1BCD", false), //6 characters and 1 hyphen
                Arguments.of("A-1 G-3", false), //hyphen and space seperated by characters
                Arguments.of("AB-ABA", true) //5 characters and hyphen
        );
    }

    /*Test invalid licence plates*/
    @ParameterizedTest(name = "input{0}, motorcycle{1}")
    @MethodSource("invalidPlates")
    void invalidPlates(String input, boolean motorcycle) {
        assertFalse(Specification.messageIsValid(input, motorcycle));
    }

    private static Stream<Arguments> invalidPlates() {
        return Stream.of(
                Arguments.of("34ABA5B", false), //7 characters
                Arguments.of("Ot0-", false), //hyphen must have character before and after
                Arguments.of("123456", false), //Can't be only numbers
                Arguments.of("654-321", false), //Can't be only numbers
                Arguments.of("   ", true), //Can't be less than 2 characters (letters and numbers)
                Arguments.of("", false) //Can't be less than 2 characters
        );
    }


}