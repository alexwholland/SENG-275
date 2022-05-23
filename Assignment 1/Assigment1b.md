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
I<sub>10</sub> = { x < 1 and y < 1 and 1 ≤ z ≤ 300 } (x is invalid and y is invalid, z is valid) </br>


I<sub>X</sub> = { x < 1 and 1 ≤ y ≤ 300 and x > 300 } (x is invalid and z is invalid, y is valid) </br>

**Q2)** 

**a)**

```
public class FizzBuzz {
  plubic staic String FizzBuzz(int n) {
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
}
```

**b)**

`T2` can be removed from the test suite because both `T1 = 15` and `T2 = 30` result in the output being "FizzBuz".

**c)**

To detemine the tests that can be removed we can use Test Suite Minimization.

**d)**
