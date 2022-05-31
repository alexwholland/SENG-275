# Assignment 1b
### Alex Holland - V00928553

**Q1)** 
```
I1 = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (All inputs are valid)
I2 = { x < 1 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (x is invalid , y is valid and z is valid) 
I3 = { 1 ≤ x ≤ 300 and y < 300 and 1 ≤ z ≤ 300 } (y is invalid , x is valid and z is valid)
I4 = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z < 1 } (z is invalid , x is valid and y is valid)
I5 = { x < 1 and y < 1 and z < 1 } (All inputs are invalid)
I6 = { x = 1 and y = 1 and z = 1 } (All inputs are valid)
I7 = { x > 300 and y > 300 and z > 300 } (All inputs are invalid)
I8 = { x > 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (x is invalid , y is valid and z is valid) 
I9 = { 1 ≤ x ≤ 300 and y > 300 and 1 ≤ z ≤ 300 } (y is invalid , x is valid and z is valid)
I10 = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z > 300 } (z is invalid , x is valid and y is valid)
I11 = { x < 1 and y < 1 and 1 ≤ z ≤ 300 } (x is invalid and y is invalid, z is valid)
I12 = { x < 1 and 1 ≤ y ≤ 300 and z < 1 } (x is invalid and z is invalid, y is valid) 
I13 = {1 ≤ x ≤ 300 and y < 1 and z < 1 } (y is invalid and z is invalid, x is valid) 
I14 = { x < 1 and 1 ≤ y ≤ 300 and z > 300 } (x is invalid and z is invalid, y is valid)
I15 = { 1 ≤ x ≤ 300 and y < 1 and z > 300 } (y is invalid and z is invalid, x is valid)
I16 = { x > 300 and y < 1 and 1 ≤ z ≤ 300 } (x is invalid and y is invalid, z is valid) 
I17 = { x > 300 and y < 1 and z > 300 } (All inputs are invalid) 
```
**Q2)** 

**a)**

```
public class FizzBuzz {
  public static String detFizzBuzz(int n) {
    String result;
    if (n % 3 == 0 && n % 5 == 0)
      result = "FizzBuzz";
    else if(n % 3 == 0)
      result = "Fizz!";
    else if(n % 5 == 0)
      result = "Buzz!";
    else
      result = n + "!";
    return result;
  }
}
```

**b)**

`T2` can be removed from the test suite because both `T1 = 15` and `T2 = 30` result in the output being "FizzBuz".

**c)**

To detemine the tests that can be removed (Test Suite Minimization), we can use Equivalence Partitioning.

**d)**
```
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class FizzBuzzTesting {
    FizzBuzz fb;

    @Before
    public void init(){
        fb = new FizzBuzz();
    }
    
    @Test
    public void testFizzBuzz(){
        String expected = "FizzBuzz"; 
        String actual = fb.detFizzBuzz(15);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFizz(){
        String expected = "Fizz!";
        String actual = fb.detFizzBuzz(3);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testBuzz(){
        String expected = "Buzz!";
        String actual = fb.detFizzBuzz(5);
        Assert.assertEquals(actual, expected);
    }
    
    @Test
    public void testInteger(){
        String expected = "4!";
        String actual = fb.detFizzBuzz(4);
        Assert.assertEquals(actual, expected);
    }
    
}
```

**Q3)**

**a)**
```
T<sub>1</sub> = I = 1 
T<sub>2</sub> = XXXI = 31
T<sub>3</sub> = CCXCIV = 294
T<sub>4</sub> = MDCLVIII = 1658
T<sub>5</sub> = MCMXCIV = 1994 
T<sub>6</sub> = MMMCMXCIX = 3999 
```
**b)**

```
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before:

public class RomanNumeralTesting {
    RomanNumeral rn;

    @Before
    public void init(){
        rn = new RomanNumeral();
    }
    
    @Test
    public void test1(){
        int expected = 1;
        int actual = rn.convert("I");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        int expected = 31;
        int actual = rn.convert("XXXI");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test3(){
        int expected = 294;
        int actual = rn.convert("CCXCIV");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test4(){
        int expected = 1658;
        int actual = rn.convert("MDCLVIII");
        Assert.assertEquals(actual, expected);
    }

    public void test5(){
        int expected = 3999;
        int actual = rn.convert("MMMCMXCIX");
        Assert.assertEquals(actual, expected);
    }
}
```

