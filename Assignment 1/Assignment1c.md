# Assignment 1c
### Alex Holland - V00928553

**Q1)** 

Boundry conditinos for equilateral triangle condition testing:

**Boundry 1:** Floating point numbers x, y, and z must be greater then zero </br>
**Boundry 2:** Floating point numbers x, y, and z are equal to one another </br>

**Q2)**

On-point: `half` </br>
Off-point: `half-1` </br>
In-points:`left` 0 ≤ i ≤ half - 1 </br>
Out-points: `right` i ≥ half </br>


**Q3)**

**Legs:** </br>
On-point: `0` </br>
Off-point: `1` </br>
In-points: `numberOfLegs = 2k` where `k ∈ Z` </br>
Out-points: `numberOfLegs = 2k - 1` where `k ∈ Z` </br>

**Tail:** </br>
On-point: `hasTail` </br>
Off-point: `!hasTail` </br>
In-points: `hasTail`</br>
Out-points: `!hasTail` </br>

**Lives:** </br>
On-point: `1` and `9` </br>
Off-point: `0` and `10` </br>
In-points: `1 ≤ numberOfLives ≤ 9`</br>
Out-points: `numberOfLives > 9` and `numberOfLives < 1` </br>

**Nails:** </br>
On-point: `hasSharpNails` </br>
Off-point: `!hasSharpNails` </br>
In-points: `hasSharpNails`</br>
Out-points: `!hasSharpNails` </br>

**Sound:** </br>
`sound = "miauw"`
On-point: `sound` </br>
Off-point: `!sound` </br>
In-points: `sound`</br>
Out-points: `!sound` </br>
