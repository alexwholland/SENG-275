# Assignment 2a
### Alex Holland - V00928553

**Q1)** 

**1. C: Conformance**

email id standard format: `id@domain`

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Input an email id that only contains `@` and `domain` | 1. Go to the Registration page <br> 2. Enter an email id that only contains `@` and `domain` | Email ID: @uvic.ca | Prompt the user to input a valid email with `id@domain` | As Expected | Pass | 
| TC02 | Input an email id that only contains `id` and `domain` | 1. Go to Go to the Registration page <br> 2. Enter and email id that only includes `id` and `domain` | Email ID: alexanderwholland.ca | Prompt the user to input a valid email with `id@domain` | As expected | Pass |
| TC03 | Input an email id that only contains `id` and `@` | 1. Go to Go to the Registration page <br> 2. Enter an email id that only contains `id` and `@` | Email ID: alexanderwholland@ | Indicate to the user to input a valid email with `id@domain` | As expected | Pass |
| TC05 | Input an email id that only contains `@` | 1. Go to Go to the Registration page <br> 2. Enter an email id that only contains `@` | Email ID: @| Prompt the user to input a valid email with `id@domain` | As expected | Pass |
| TC06 | Input an email id that only contains `domain` | 1. Go to Go to the Registration page <br> 2. Enter an email id that only contains `domain` | Email ID: uvic.ca| Prompt the user to input a valid email with `id@domain` | As expected | Pass |

              
**2. O: Order** 

Since prerequistite courses must be taken before the successor of that course. We assume that the only valid option is to have a student register in ECE courses in term 1 and SENG courses in term 2.

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Student selects only all ECE prerequisites in term 1 and SENG courses in term 2 | 1. Go to Go to the Registration page <br> 2. Register in all ECE prequisites in term 1 and any SENG course in term 2 | Courses term 1: ECE 242, ECE 211 Courses term 2: SENG 275 | Registration is successful without error message | As expected | Pass |
| TC02 | Student selects only SENG courses in term 1 without ECE prerequisites | 1. Go to Go to the Registration page <br> 2. Select a SENG course for term 1 | Course: SENG 321 | Registration is refused and an error message is displayed requesting the user must select prerequisite for the course | As expected | Pass |
| TC03 | Student selects an ECE prerequisite and SENG course in term 1 | 1. Go to Go to the Registration pagen <br> 2. Select a SENG course and ECE prerequisite for term 1| Course: SENG 321, ECE 242 | Registration is refused and an error message is displayed requesting the user must select all prerequisite for SENG 321 | As expected | Pass |
| TC04 | Student selects only ECE prerequisites for both terms | 1. Go to Go to the Registration page <br> 2. Select a ECE prerequisites for both terms | Course term 1: ECE 242 Course term 2: ECE 211 | Registration is successful without error message | As expected | Pass |
| TC05 | Student selects some ECE prerequisites for term 1 and a SENG course for term 2 | 1. Go to Go to the Registration page <br> 2. Select at least 1 but not all ECE prerequisites for term 1, and a SENG course for term 2 | Course term 1: ECE 242 Course term 2: SENG 275 | Registration is refused and an error message is displayed requesting the user must select all prerequisite for SENG 275 | As expected | Pass |


**3. R: Range** 

valid ages are between 15-70 years

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Enter an `Age` that is less than 15 | 1. Go to the Registration page <br> 2. Enter an `Age` that is less than 15 in the Age text field | Age: 14 | Indicate that the age is invalid | As expected | Pass |
| TC02 | Enter an `Age` of 15 | 1. Go tothe Registration page <br> 2. Enter an Age of 15 in the `Age` text field | Age: 15 | Accept the age | As expected | Pass |
| TC03 | Enter an `Age` of 70 | 1. Go to the Registration page <br> 2. Enter an Age of 70 in the `Age` text field | Age: 70 | Accept the age  | As expected | Pass |
| TC04 | Enter an `Age` that is greater than 70 | 1. Go to the Registration page <br> 2. Enter an Age that is greater than 70 in the `Age` text field | Age: 71 | Indicate that the age is invalid | As expected | Pass |
| TC04 | Enter an `Age` of 0 | 1. Go to the Registration page <br> 2. Enter an Age of 0 in the `Age` text field | Age: 0 | Indicate that the age is invalid | As expected | Pass |

**4. R: Reference** 

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Enter a `uname` and `Pword` that is recognized by the database | 1. Go to the Registration page <br> 2. Enter a `uname` and `pword` that is recognized by the database | uname: alexwholland <br> Pword: testpassword123 | Initiate a successful login | As expected | Pass |
| TC02 | Enter a `uname` and `Pword` that is NOT recognized by the database | 1. Go to the Registration page <br> 2. Enter a `uname` and `pword` that is not recognized by the database | uname: alexwholland1 <br> Pword: invalidpassword123 | Prompt the user that their login credentials are incorrect | As expected | Pass |

**5. E: Existence** 

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Register for a course that isn't offered in a specific term | 1. Go to the Registration page <br> 2. Enter a course name that is not offered in the specific term | Course: SENG 310 | Indicate to the user that the course is not available in the selected term | As expected | Pass |
| TC02 | Register for a course with an invalid course number | 1. Go to the Registration page <br> 2. Enter a course with an invalid number | Course: SENG 000 | Indicate to the user that the course number is not valid | As expected | Pass |
| TC03 | Register for a course with a empty course name (string) | 1. Go to the Registration page <br> 2. Enter a course without a name | Course: "" | Indicate to the user that the course is not valid | As expected | Pass |

**6. C: Cardinality** 

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Student selects no course | 1. Go to the Registration page <br> 2. Select no courses | \<none\> | Indicate to the user that "at least one course has to be selected" | As expected | Pass |
| TC02 | Student selects one course that requires no prerequisites | 1. Go to the Registration page <br> 2. Select an ECE course | Course: ECE 211 | Register without error | As expected | Pass |
| TC03 | Student selects one course that requires a ECE prerequisite | 1. Go to the Registration page <br> 2. Select a SENG course | Course: SENG 321 | Indicate to the user that the course requires a prerequisite | As expected | Pass |
| TC04 | Student selects many ECE courses (more than 1) | 1. Go to the Registration page <br> 2. Select two or more ECE prequisite courses | Course: ECE 211, ECE 242 | Register without error | As expected | Pass |
| TC05 | Student selects many SENG courses (more than 1) | 1. Go to the Registration page <br> 2. Select two or more SENG courses | Course: SENG 321, SENG 275 | Indicate to the user that all ECE courses are prerequisites for any SENG course | As expected | Pass |
| TC06 | Student selects all ECE prerequisites and a SENG course | 1. Go to the Registration page <br> 2. Select all ECE prequisites for any SENG course and a SENG course | Course: ECE 211, ECE 242, SENG 275 | Register without error (All ECE prerequistes have been registered for before any SENG course) | As expected | Pass |

**6. T: Time** 

Let T be the time per timeout accoring to a global clock

| Test Case | Test Scenario | Test Steps | Test Data | Expected Results | Actual Results | Pass/Fail |
|-|-|-|-|-|-|-|
| TC01 | Give a timeout error if there is a failure to connect to the database in time T | 1. Go to the Registration page <br> 2. Enter a valid `Email_ID` | Email_ID: timeoutTest@uvic.ca | Give the user a timeout error after time T has been used to connect to the database| As expected | Pass |
| TC02 | Give a timeout error if there is a failure to check for duplicity in the database in time T | 1. Go to the Registration page <br> 2. Enter a valid `Email_ID` | Email_ID: duplicityTest@uvic.ca | Give the user a timeout error after time T has been used to check for duplicity in the database| As expected | Pass |
| TC03 | Give a timeout error if there is a failure to write to the database in time T | 1. Go to the Registration page <br> 2. Enter a valid `Email_ID` | Email_ID: writeTimeoutTest@uvic.ca | Give the user a timeout error after time T has been used to write to the database| As expected | Pass |
