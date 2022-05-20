# Assignment 1b
### Alex Holland - V00928553

**Q1)** Consider a program for the determination of the largest amongst three numbers. Its
input is a triple of positive integers (say x, y and z) and values of each x, y and z are from
interval [1, 300]. Design test cases according to Equivalence class: (4M)
Generate any 16 equivalence classes for valid and invalid combination of x, y and z.

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
