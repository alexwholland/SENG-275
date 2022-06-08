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

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Input an email id that only contains `@` and `domain` | 1. Go to www.uvic.ca <br> 2. Enter an email id that only contains `@` and `domain` | Email ID: @uvic.ca | Prompt the user that the `id` portion of their `email is` is missing | As Expected | Pass | 
| TC02 | Input an email id that only contains `id` and `domain` | 1. Go to www.uvic.ca <br> 2. Enter and email id that only includes `id` and `domain` | Email ID: alexanderwholland.ca | Prompt the user that the `@` portion of their `email id` is missing | As expected | Pass |
| TC03 | Input an email id that only contains `id` and `@` | 1. Go to www.uvic.ca <br> 2. Enter an email id that only contains `id` and `@` | Email ID: alexanderwholland@ | Prompt the user to input a valid email with `id@domain` | As expected | Pass |
| TC04 | Input an email id that only contains `id` | 1. Go to www.uvic.ca <br> 2. Enter an email id that only contains `id` | Email ID: alexanderwholland | Prompt the user to input a valid email with `id@domain` | As expected | Pass |
| TC05 | Input an email id that only contains `@` | 1. Go to www.uvic.ca <br> 2. Enter an email id that only contains `@` | Email ID: @| Prompt the user to input a valid email with `id@domain` | As expected | Pass |
| TC06 | Input an email id that only contains `domain` | 1. Go to www.uvic.ca <br> 2. Enter an email id that only contains `domain` | Email ID: uvic.ca| Prompt the user to input a valid email with `id@domain` | As expected | Pass |

              
**2. O: Order** 

All ECE courses are prerequisites for any SENG course

- T1: Student selects all ECE prerequisites before a SENG course
- T2: Sudent selects some ECE courses before a SENG course
- T3: A Student selects a SENG course and then selects an ECE prerequisite course
- T4: Student selects only ECE courses
- T5: Student selects only SENG courses

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Select only an ECE course | 1. Go to www.uvic.ca/registration <br> 2. Select an ECE course | Course: ECE 242 | Registration is successful without error message | As expected | Pass |
| TC02 | Select only a SENG course | 1. Go to www.uvic.ca/registration <br> 2. Select a SENG course | Course: SENG 321 | Registration is refused and an error message is displayed requesting the user must select prerequisite for the course | As expected | Pass |
| TC03 | Select all ECE prerequisites before a SENG course | 1. Go to www.uvic.ca/registration <br> 2. Select a SENG course | Course: SENG 321 | Registration is refused and an error message is displayed requesting the user must select prerequisite for the course | As expected | Pass |

**3. R: Range** 

valid ages are between 15-70 years

- T1: Age is `14`
- T2: Age is minimum accepted value of `15`
- T3: Age is maximum accepted value of `70`
- T4: Age is `71`
- T5: Age is the minimum humanely possible age of `0`

If we are concerned with negative integers:   
- T6: Impossible negative age of E.g. `-1` 

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Enter an `Age` that is less than 15 | 1. Go to the Registration page <br> 2. Enter an `Age` that is less than 15 in the Age text field | Age: 14 | Indicate that the age is invalid | As expected | Pass |
| TC02 | Enter an `Age` of 15 | 1. Go tothe Registration page <br> 2. Enter an Age of 15 in the `Age` text field | Age: 15 | Accept the age | As expected | Pass |
| TC03 | Enter an `Age` of 70 | 1. Go to the Registration page <br> 2. Enter an Age of 70 in the `Age` text field | Age: 70 | Accept the age  | As expected | Pass |
| TC04 | Enter an `Age` that is greater than 70 | 1. Go to the Registration page <br> 2. Enter an Age that is greater than 70 in the `Age` text field | Age: 71 | Indicate that the age is invalid | As expected | Pass |
| TC04 | Enter an `Age` of 0 | 1. Go to the Registration page <br> 2. Enter an Age of 0 in the `Age` text field | Age: 0 | Indicate that the age is invalid | As expected | Pass |

**4. R: Reference** 

Login shoud be successful

- T1: The `uname` must be a valid username in the database
- T2: The `Pword` must be a valid password in the database
- T3: The account using `uname` and `Pword` is not currently logged in on a different machine

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Enter a `uname` and `Pword` that is recognized by the database | 1. Go to the Registration page <br> 2. Enter a `uname` and `pword` that is recognized by the database | uname: alexwholland <br> Pword: testpassword123 | Initiate a successful login | As expected | Pass |
| TC02 | Enter a `uname` and `Pword` that is NOT recognized by the database | 1. Go to the Registration page <br> 2. Enter a `uname` and `pword` that is not recognized by the database | uname: alexwholland1 <br> Pword: invalidpassword123 | Prompt the user that their login credentials are incorrect | As expected | Pass |

**5. E: Existence** 

- T1: Registering in a course that isn't offered in a specific term
- T2: Registering in a course with an invalid name
- T3: Registering in a course with an empty name

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Register for a course that isn't offered in a specific term | 1. Go to the Registration page <br> 2. Enter a course name that is not offered in the specific term | Course: SENG 310 | Indicate to the user that the course is not available in the selected term | As expected | Pass |

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

- T1: A timeout error is given if there is a failure to connect to the databse in time T
- T2: A timeout error is given if there is a failure to check for duplicity in the database in time T 
- T3: A timeour error is given if there is a failure to write the email id to the database in time T
