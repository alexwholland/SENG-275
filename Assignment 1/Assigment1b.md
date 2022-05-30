# Assignment 1b
### Alex Holland - V00928553

**Q1)** 

I<sub>1</sub> = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (All inputs are valid) </br>
I<sub>2</sub> = { x < 1 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (x is invalid , y is valid and z is valid) </br>
I<sub>3</sub> = { 1 ≤ x ≤ 300 and y < 300 and 1 ≤ z ≤ 300 } (y is invalid , x is valid and z is valid) </br>
I<sub>4</sub> = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z < 1 } (z is invalid , x is valid and y is valid) </br>
I<sub>5</sub> = { x < 1 and y < 1 and z < 1 } (All inputs are invalid) </br>
I<sub>6</sub> = { x = 1 and y = 1 and z = 1 } (All inputs are valid) </br>
I<sub>7</sub> = { x > 300 and y > 300 and z > 300 } (All inputs are invalid) </br>
I<sub>8</sub> = { x > 300 and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (x is invalid , y is valid and z is valid) </br>
I<sub>9</sub> = { 1 ≤ x ≤ 300 and y > 300 and 1 ≤ z ≤ 300 } (y is invalid , x is valid and z is valid) </br>
I<sub>10</sub> = { 1 ≤ x ≤ 300 and 1 ≤ y ≤ 300 and z > 300 } (z is invalid , x is valid and y is valid) </br>
I<sub>11</sub> = { x < 1 and y < 1 and 1 ≤ z ≤ 300 } (x is invalid and y is invalid, z is valid) </br>
I<sub>12</sub> = { x < 1 and 1 ≤ y ≤ 300 and z < 1 } (x is invalid and z is invalid, y is valid) </br>
I<sub>13</sub> = {1 ≤ x ≤ 300 and y < 1 and z < 1 } (y is invalid and z is invalid, x is valid) </br>
I<sub>14</sub> = { x < 1 and 1 ≤ y ≤ 300 and z > 300 } (x is invalid and z is invalid, y is valid) </br>
I<sub>15</sub> = { 1 ≤ x ≤ 300 and y < 1 and z > 300 } (y is invalid and z is invalid, x is valid) </br>
I<sub>16</sub> = { x > 300 and y < 1 and 1 ≤ z ≤ 300 } (x is invalid and y is invalid, z is valid) </br>
I<sub>17</sub> = { x > 300 and y < 1 and z > 300 } (All inputs are invalid) </br>

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

To detemine the tests that can be removed we can use Test Suite Minimization.

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

T<sub>1</sub> = I = 1 </br>
T<sub>2</sub> = XXXI = 31</br>
T<sub>3</sub> = CCXCIV = 294</br>
T<sub>4</sub> = MDCLVIII = 1658</br>
T<sub>5</sub> = MCMXCIV = 1994 </br>
T<sub>6</sub> = MMMCMXCIX = 3999 </br>

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

