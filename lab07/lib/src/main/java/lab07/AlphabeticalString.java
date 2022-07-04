package lab07;

import java.util.Arrays;
import java.lang.String;
import java.util.Objects;

/* AlphabeticalString
 * All characters in an AlphabeticalString are guaranteed to be in
 * alphabetical sorted order.  Create one by passing any valid string.
 * 'Alphabetical' here means sorted in ASCII order: 'ABa' is sorted,
 * 'aB' is not.
 * Cannot be null - throws a NullPointerException if null is passed in.
 */

public class AlphabeticalString {
    private String s;

    public AlphabeticalString(String newString) {
        Objects.requireNonNull(newString);
        this.s = newString;
        this.sort();
        assert this.s.length() == newString.length();
    }

    private void sort() {
        var ch = this.s.toCharArray();
        Arrays.sort(ch);
        this.s = String.valueOf(ch);
    }

    public void toUpper() {
        this.s = this.s.toUpperCase();
        assert this.invariant() : "Invariant fails in toUpper()";
    }

    private boolean invariant() {
        if (this.s == null) return false;
        if (this.s.length() < 2) return true;
        var ch = this.s.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] > ch[i+1]) return false;
        }
        return true;
    }

    public String toString() {
        return this.s;
    }
}
