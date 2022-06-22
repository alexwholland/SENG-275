package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {

    @ParameterizedTest
    @MethodSource("generator")
    void swapCase(String description, String str, String expected) {
        String result = WordUtilities.swapCase(str);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of( Arguments.of("empty str", "", ""),
                Arguments.of("null string", null, null),
                Arguments.of("empty string", " ", " "),
                Arguments.of("only lower case", "hi", "HI"),
                Arguments.of("only upper case", "HI", "hi"),
                Arguments.of("upper and lower no space", "LowerUpper", "lOWERuPPER"),
                Arguments.of("upper and lower with space", "lOWER Upper", "Lower uPPER"),
                Arguments.of("lower with spaces", "lower with spaces", "LOWER WITH SPACES"));
    }
}