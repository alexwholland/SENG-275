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

class TwoIntegersTest {

    @Property
    void pass(@ForAll @IntRange(min = 1, max = 99) int n, @ForAll @IntRange(min = 1, max = 99) int m) {
        assertThat(TwoIntegers.sum(n, m)).isEqualTo(n + m);
    }

    @Property
    void invalidN(@ForAll("invalidRange") int n, @ForAll @IntRange(min = 1, max = 99) int m) {
        assertThrows(IllegalArgumentException.class, () -> TwoIntegers.sum(n, m));
    }

    @Property
    void invalidM(@ForAll @IntRange(min = 1, max = 99) int n, @ForAll("invalidRange") int m) {
        assertThrows(IllegalArgumentException.class, () -> TwoIntegers.sum(n, m));
    }

    @Property
    void invalidBoth(@ForAll("invalidRange") int n, @ForAll("invalidRange") int m) {
        assertThrows(IllegalArgumentException.class, () -> TwoIntegers.sum(n, m));
    }

    @Provide
    private Arbitrary<Integer> invalidRange() {
        return Arbitraries.oneOf(Arbitraries.integers().lessOrEqual(0), Arbitraries.integers().greaterOrEqual(100));
    }
}