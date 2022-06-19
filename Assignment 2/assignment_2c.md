# Assignment 2c
### Alex Holland

**Q1)**

**a)**

![](Assignment%20Images/UML.png)

**b)**

We assume that a valid payment type is `card payment` and an valid payment type is `Bitcoin`.
| Node | Action |
| - | - |
| 1 | User enters a parking space ID |
| 2 | User selects a method of payment |
| 3 | User selects a  payment method that is invalid <br> and is prompted to select a different method of payment |
| 4 | User selects a valid payment method of card payment |
| 5 | User selects to save payment information |
| 6 | User selects to not save payment information |
| 7 | User completes the payment and receives a payment receipt in their email |


![](Assignment%20Images/Activity%20Graph.png)

**c)**

We assume that a valid payment type is `card payment` and an valid payment type is `Bitcoin`.
| Path | 1-2-4-5-7 | 1-2-4-6-7 | 1-2-3-2-4-6-7 | 1-2-3-2-4-5-7 |
| - | - | - | - | - |
| Initial Conditions | Parking space ID is valid <br> Valid payment type is card payment. | Parking space ID is valid <br> Valid payment type is card payment. | Parking space ID is valid <br> Valid payment type is card payment. | Parking space ID is valid <br> Valid payment type is card payment. | 
| Test Steps | 1. User enters a parking space ID <br> 2. User selects a valid payment method: card payment <br> 3. User selects to save payment information <br> 4. User completes the payment | 1. User enters a parking space ID <br> 2. User selects a valid payment method: card payment <br> 3. User selects to not save payment information <br> 4. User completes the payment | 1. User enters a parking space ID <br> 2. User selects an invalid payment method: Bitcoin <br> 3. User selects a valid payment method: card payment <br> 4. User selects to not save payment information <br> 5. User completes the payment | 1. User enters a parking space ID <br> 2. User selects an invalid payment method: Bitcoin <br> 3. User selects a valid payment method: card payment <br> 4. User selects to save payment information <br> 5. User completes the payment| 
| Expected Result | User successfuly pays for parking, saves payment information, and receives receipt in their email | User successfuly pays for parking and receives receipt in their email | User successfuly pays for parking and receives receipt in their email | User successfuly pays for parking, saves payment information, and receives receipt in their email |
