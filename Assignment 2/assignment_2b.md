# Assignment 2b
### Alex Holland

**AddMyAlphas**

```
import java.lang.String;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMyAlphas {
    public static int Add(String numbers) throws NegativeIntegerException {
        //specify the characters to extract from the string with regex
        Matcher matcher = Pattern.compile("-?\\d+").matcher(numbers);
        ArrayList<Integer> negatives = new ArrayList<>();
        int result = 0;

        while(matcher.find()) {
            int value = Integer.parseInt(matcher.group());
            //Add negative values to the ArrayList
            if (value < 0) {
                negatives.add(value);
            }
            //Discard any values over 1000
            if (value <= 1000) {
                result += value;
            }
        }
        //Throw an exception if the string contains a negative number
        if (!negatives.isEmpty()) {
            System.out.print("Negatives not allowed: ");
            for (int i = 0; i < negatives.size() - 1; i++) {
                System.out.print(negatives.get(i) + ",");
            }
            System.out.println(negatives.get(negatives.size()-1));
            throw new NegativeIntegerException("");
        }
        return result;
    }
}

class NegativeIntegerException extends Exception{
    public NegativeIntegerException(String msg) {
        super(msg);
    }
}
```

**AddMyAlphasTest**

```
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class AddMyAlphasTest {

    /*Question 1 tests*/
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "3", "0,3", "3,0"})
    public void basicSummation(String input) throws NegativeIntegerException {
        assertEquals(3, AddMyAlphas.Add(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    public void emptyString(String input) throws NegativeIntegerException {
        assertEquals(0, AddMyAlphas.Add(input));
    }

    /*Question 2 tests*/
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3", "1,1,1,1,1,1,1,1,1", "9", "1,8,0,0,0,0,0,0"})
    public void unknownArgumentCount(String input) throws NegativeIntegerException {
        assertEquals(9, AddMyAlphas.Add(input));
    }

    /*Question 3 tests*/
    @ParameterizedTest
    @ValueSource(strings = {"1\n2,3", "\n6\n\n\n", "1\n1\n1\n3"})
    public void newLineSeperation(String input) throws NegativeIntegerException {
        assertEquals(6, AddMyAlphas.Add(input));
    }

    /*Question 4 tests*/
    @ParameterizedTest
    @ValueSource(strings = {"-1, 2", "7, -1, -2", "-100"})
    public void negativeNumbers(String input) {
        assertThrows(NegativeIntegerException.class, () -> AddMyAlphas.Add(input));
    }

    /*Question 5 tests*/

    /*Ignore numbers larger than 1000*/
    @ParameterizedTest
    @ValueSource(strings = {"1001, 2", "10001, 1001, 2"})
    public void ignoreBigNumbers(String input) throws NegativeIntegerException {
        assertEquals(2, AddMyAlphas.Add(input));
    }

    /*Question 6 tests*/
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2", "//;\n1\n;1;1"})
    public void supportDelimiters(String input) throws NegativeIntegerException {
        assertEquals(3, AddMyAlphas.Add(input));
    }
}
```
