package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class PalindromeTest {

    // Any string, followed by the reverse of that string is a palindrome
    @Property
    void stringFollowedByReverse(@ForAll @AlphaChars String s){
        assertTrue(Palindrome.isPalindrome(s + reverse(s)));
    }

    // Any string, followed by a single character, then the reverse of the string is a palindrome
    @Property
    void stringWithLetterAndReverse(@ForAll @AlphaChars String s, @ForAll @AlphaChars char c){
        assertTrue(Palindrome.isPalindrome(s + c + reverse(s)));
    }

    // Any string made up of unique characters of length 2 or greater is not a palindrome
    @Property
    void uniqueCharacters(@ForAll @UniqueElements @AlphaChars @Size(min = 2) char[] c){
        assertFalse(Palindrome.isPalindrome(String.valueOf(c)));
    }

    // Any palindrome set to uppercase is still a palindrome
    // Note* should have used @UpperChars from jqwik, but it was not imported.
    @Property
    void upperCasePalindrome(@ForAll @AlphaChars String s){
        s = s.toUpperCase();
        // System.out.println(s);
        assertTrue(Palindrome.isPalindrome(s + reverse(s)));
    }

    // Test a null string (word == null)
    @Property
    void noString(){
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindrome(null));
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}