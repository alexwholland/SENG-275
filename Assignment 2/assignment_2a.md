# Assignment 2a
### Alex Holland - V00928553

**Q1)** 

**1. C: Conformance**

email id standard format: `id@domain`

- T1: No `id`, just an `@` and `domain`
- T2: No `@`, just an `id` and `domain`
- T3: No `domain`, just an `id` and `@` 
- T4: Just an `id`
- T5: Just an `@`
- T6: Just a `domain`

**2. O: Order** 

All ECE courses are prerequisites for any SENG course

- T1: Student selects ECE prerequisites before SENG
- Student selects only ECE courses
- Student selects only SENG courses

**3. R: Range** 

Age is between 15-70 years

- T1: Age is `14`
- T2: Age is `15`
- T3: Age is `16`
- T4: Age is `70`
- T5: Age is `71`

**4. R: Reference** 

Login shoud be successful

- T1:

**5. E: Existence** 

- T1: Registering in a course that isn't offered in a specific term
- T2: Registering in a course with an invalid name
- T3: Registerming in a course with an empty name

**6. C: Cardinality** 

Assumption: A student can register in a maximum of six courses per term

- T1: Producing a message when there are no courses in the list
- T2: Producing a message when there's only one course in the list
- T3: Producing a message when there aren't yet six courses in the list
- T4: Adding a course when there are no courses in the list
- T5: Adding a course when there's only one course in the list
- T6: Adding a course when the there aren't yet six courses in the list
- T7: Adding a course when there are already six courses in the list

**6. T: Time** 

Let T be the time per timeout accoring to a global clock

- T1: A timeout error is given if the user
- T2: A timeout error is given if there is a failure to connect to the databse in time T
- T3: A timeout error is given if there is a failure to check for duplicity in the database in time T 
