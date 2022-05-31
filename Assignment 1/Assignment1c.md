# Assignment 1c
### Alex Holland - V00928553

**Q1)** 

Boundry conditinos for equilateral triangle condition testing:

```
Boundry 1: Floating point numbers x, y, and z must be greater then zero 
Boundry 2: Floating point numbers x, y, and z must be equal to one another
```

**Q2)**
```
On-point: half
Off-point: half-1
In-points: left 0 ≤ i ≤ half - 1
Out-points: right i ≥ half
```

**Q3)**

**Legs:** 
```
On-point: 0 
Off-point: 1 
In-points: numberOfLegs = 2n where n is an integer
Out-points: numberOfLegs = 2n - 1 where n in an integer
```

**Tail:**
```
On-point: hasTail 
Off-point: !hasTail 
In-points: hasTail
Out-points: !hasTail 
```

**Lives:** 
```
On-point: 1 and 9 
Off-point: 0 and 10 
In-points: 1 ≤ numberOfLives ≤ 9
Out-points: numberOfLives > 9 and numberOfLives < 1
```

**Nails:** 
```
On-point: hasSharpNails 
Off-point: !hasSharpNails 
In-points: hasSharpNails
Out-points: !hasSharpNails
```

**Sound:**
```
sound = "miauw"
On-point: sound 
Off-point: !sound 
In-points: sound
Out-points: !sound 
```
