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

class AlphabeticalStringTest {

    @Test
    void constructorTest() {
        var s = new AlphabeticalString("abcdfe");
        assertThat(s.toString()).isEqualTo("abcdef");
    }

    @Test
    void toUpperTest() {
        var s = new AlphabeticalString("aAbBcC");
        assertThat(s.toString()).isEqualTo("ABCabc");
    }

    // ... add tests IF you feel they will be helpful.
    // Tests in this file will not be marked.

}