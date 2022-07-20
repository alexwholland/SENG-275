# Assignment 3 - Alex Holland

## Create Account
### Description 
A user is able to create an account with a unique email and their personal information.
### Test Cases
- TC_CA_001: createAccountValid
- TC_CA_002: invalidPassword
- TC_CA_003: wrongPostalCode
- TC_CA_004: emailExists

### CreateAccount.java Selenium automation test script:

```
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import java.util.Random;


public class CreateAccount {
    WebDriver browser;

    // creates a randomly generated email in the form <random string><random integer>@uvic.ca
    public static String generateEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return String.format("%s%s@%s", UUID.randomUUID().toString().substring(0,3), randomInt, "uvic.ca");
    }

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    // TC_CA_001
    @Test
    public void createAccountValid() {
        WebElement email = browser.findElement(By.id("email_create"));
        email.sendKeys(generateEmail());
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Alex");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Holland");
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("password123");
        WebElement address = browser.findElement(By.id("address1"));
        address.sendKeys("123 test st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("12345");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7899");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();
    }

    // TC_CA_002
    @Test
    public void invalidPassword(){
        WebElement email = browser.findElement(By.id("email_create"));
        email.sendKeys(generateEmail());
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Alex");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Holland");
        // input an invalid password
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("test");
        WebElement address = browser.findElement(By.id("address1"));
        address.sendKeys("123 test st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("12345");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7899");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div"))
                );
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_003
    @Test
    public void wrongPostalCode(){
        WebElement email = browser.findElement(By.id("email_create"));
        email.sendKeys(generateEmail());
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Alex");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Holland");
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("password123");
        WebElement address= browser.findElement(By.id("address1"));
        address.sendKeys("123 test st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        // input an invalid postal code
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("123456");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7899");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div")));
        assertTrue(browser.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_004
    @Test
    public void emailExists(){
        String email = "d1f403@uvic.ca";
        // d1f403@uvic.ca is an existing email
        WebElement create = browser.findElement(By.id("email_create"));
        create.sendKeys(email);

        WebElement createAcc = browser.findElement(By.id("SubmitCreate"));
        createAcc.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]"))
                );
        assertTrue(browser.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]")).size() > 0);
    }

}
```

Execution screenshot for pass/fail tests of Create Account:

![image](https://user-images.githubusercontent.com/64433812/179867530-5e2e6d16-888e-4a3d-a83e-2260ac38f133.png)

Execution screenshot of the web application interfaces:

<p align="center">
    TC_CA_001
</p>
                
![image](https://user-images.githubusercontent.com/64433812/179886730-605a9685-f5a4-4363-8542-9340a2e90b4b.png)

<p align="center">
    TC_CA_002
</p>
                
![image](https://user-images.githubusercontent.com/64433812/179886762-4256295a-ec80-4818-aafe-25ab89cba77f.png)

<p align="center">
    TC_CA_003
</p>
                
![image](https://user-images.githubusercontent.com/64433812/179886952-a0c183aa-7f42-4961-9e6a-3e197c836f7a.png)

<p align="center">
    TC_CA_004
</p>
                
![image](https://user-images.githubusercontent.com/64433812/179886993-a9f32078-7a2e-4053-aa82-2450124b0efa.png)


## Login/Logout Functionality 
### Description 
A user is able to login into their prexisting account and be able to logout of it.
### Test Cases
- TC_LF_001: ValidCredentials
- TC_LF_002: InvalidCredentials
- TC_LF_003: ValidEmailInvalidPassword
- TC_LF_004: InvalidemailValidPassword
- TC_LF_005: NoCredentials
- TC_LF_006: MultipleUnsuccessfulAttempts
- TC_LF_007: BrowsingBack
- TC_LF_008: N/A 
- TC_LF_009: SignOutCheck
- TC_LF_010: passwordHidden
- TC_LF_011: resetLinkExists
- TC_LF_012: signOutWorks
- TC_LF_013: signOutGoBack

### LoginFunctionality.java Selenium automation test script:

```
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFunctionality {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php?controller=authentication");
    }

    @AfterEach
    public void cleanUp() {
       browser.quit();
    }

    // TC_LF_001
    @Test
    public void ValidCredentials(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertEquals("My account - My Store", browser.getTitle());
    }

    // TC_LF_002
    @Test
    public void InvalidCredentials(){
        String emailInput = "invalidd1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC_LF_003
    @Test
    public void ValidEmailInvalidPassword(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "$";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC_LF_004
    @Test
    public void InvalidEmailValidPassword(){
        String emailInput = "d1f403uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC_LF_005
    @Test
    public void NoCredentials(){
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC_LF_006
    @Test
    public void MultipleUnsuccessfulAttempts(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "invalidpassword123";
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                browser.get("http://automationpractice.com/index.php?controller=authentication");
            }
            WebElement email = browser.findElement(By.id("email"));
            email.sendKeys(emailInput);
            WebElement password = browser.findElement(By.id("passwd"));
            password.sendKeys(passwordInput);
            WebElement signIn = browser.findElement(By.id("SubmitLogin"));
            signIn.click();
        }
        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC_LF_007
    @Test
    public void BrowsingBack(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        boolean login = browser.getPageSource().contains("Alex Holland");
        WebElement home = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span")
        );
        home.click();

        assertEquals(login, browser.getPageSource().contains("Alex Holland"));
    }

    // TC_LF_009
    @Test
    public void signOutCheck(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();
        boolean login = browser.getPageSource().contains("Alex Holland");
        WebElement signOut = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
        );
        signOut.click();
        boolean logout = browser.getPageSource().contains("Alex Holland");
        // reopen browser
        browser.navigate().refresh();

        assertFalse(logout); assertTrue(login);
    }

    // TC_LF_010
    @Test
    public void passwordHidden(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);

        assertTrue(browser.findElements(By.id("passwd")).size() > 0);
    }

    // TC_LF_011
    @Test
    public void resetLinkExists(){
        browser.findElement(By.partialLinkText("Forgot your password")).click();
        assertEquals("Forgot your password - My Store", browser.getTitle());
    }

    // TC_LF_012
    @Test
    public void signOutWorks(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();
        assertTrue(browser.getPageSource().contains("Alex Holland"));
        WebElement signOut = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
        );
        signOut.click();
        assertFalse(browser.getPageSource().contains("Alex Holland"));
    }

    // TC_LF_013
    @Test
    public void signOutGoBack(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();
        WebElement signOut = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
        );
        signOut.click();

        assertEquals("Login - My Store", browser.getTitle());
    }

}
```

Execution screenshot for pass/fail tests of Login Functionality:

![image](https://user-images.githubusercontent.com/64433812/179887508-aa1b7c2c-b73e-48b7-85ed-26523b79ae1a.png)

Execution screenshot of the web application interfaces:

<p align="center">
    TC_LF_001
</p>

![image](https://user-images.githubusercontent.com/64433812/179887668-b058335e-8bc9-483d-b9d4-11ce2c5c0461.png)

<p align="center">
    TC_LF_002
</p>

![image](https://user-images.githubusercontent.com/64433812/179887732-0f09fe17-7e30-4d0f-8242-2ed7451d45e1.png)

<p align="center">
    TC_LF_003
</p>

![image](https://user-images.githubusercontent.com/64433812/179887941-a509934d-5f06-4af6-bfe5-b8194d167d5c.png)

<p align="center">
    TC_LF_004
</p>

![image](https://user-images.githubusercontent.com/64433812/179869696-fffb0f63-a9a5-482c-9f46-e85f800a9974.png)

<p align="center">
    TC_LF_005
</p>

![image](https://user-images.githubusercontent.com/64433812/179887997-25f5d7a4-a118-4f8e-bad8-ecda70dbc60c.png)

<p align="center">
    TC_LF_006
</p>

![image](https://user-images.githubusercontent.com/64433812/179888030-3c159ade-d78e-4f5c-8fd7-9a8a08e92d15.png)

<p align="center">
    TC_LF_007
</p>

![image](https://user-images.githubusercontent.com/64433812/179888058-76afde53-5883-4d77-b8d6-618ce3daecf5.png)

<p align="center">
    TC_LF_009
</p>

![image](https://user-images.githubusercontent.com/64433812/179888110-ece36d02-ccd3-4923-88f5-396e9bc77d17.png)

<p align="center">
    TC_LF_010
</p>

![image](https://user-images.githubusercontent.com/64433812/179888157-2c3269c7-6545-4b2e-aa36-4f368f87d6d0.png)

<p align="center">
    TC_LF_011
</p>

![image](https://user-images.githubusercontent.com/64433812/179888196-a2a2850d-17a0-4581-908f-57a7f0abf620.png)

<p align="center">
    TC_LF_012
</p>

![image](https://user-images.githubusercontent.com/64433812/179888221-b1c4cb73-4532-4424-b354-e38942b3ae71.png)

<p align="center">
    TC_LF_013
</p>

![image](https://user-images.githubusercontent.com/64433812/179888240-70aed91f-88c6-4b5b-9959-dab6faf65749.png)


## Add-Edit-Remove from Cart
### Description 
A user is able to add, edit, or remove items from their shopping cart.
### Test Cases
- TC_ARC_001: N/A
- TC_ARC_002: AddFromHome
- TC_ARC_003: AddFromWomen
- TC_ARC_004: AddFromDresses
- TC_ARC_005: AddFromTShirt
- TC_ARC_006: FromWishlist
- TC_ARC_007: RemoveFromCart
- TC_ARC_008: IncreaseQuantity 
- TC_ARC_009: EditSize
- TC_ARC_010: LogOUTAndInCart
- TC_ARC_011: LogOutCart
- TC_ARC_012: LogOutRemoveCart

### AddEditRemoveFromCart.java Selenium automation test script:

```
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEditRemoveFromCart {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys("d1f403@uvic.ca");

        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password123");

        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    // TC_ARC_002
    @Test
    public void AddFromHome(){
        WebElement start = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span"));
        start.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCartButton = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/div[2]/a[1]/span"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    // TC_ARC_003
    @Test
    public void AddFromWomen(){
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement cart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        cart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    // TC_ARC_004
    @Test
    public void AddFromDresses(){
        WebElement dress = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
        dress.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement cart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        cart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertEquals("Order - My Store", browser.getTitle());
    }


    // TC_ARC_005
    @Test
    public void AddFromTShirt(){
        WebElement tShirt = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));
        tShirt.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertEquals("Order - My Store", browser.getTitle());
    }

    // TC_ARC_006
    @Test
    public void FromWishlist(){
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement addToWishList = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/p/a"));
        addToWishList.click();

        browser.navigate().back();
        browser.navigate().back();

        WebElement wishList = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/ul/li/a/span"));
        wishList.click();

        WebElement viewWishList = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[1]/a"));
        viewWishList.click();

        browser.get("https://tinyurl.com/mr246cz6");
        WebElement view = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div/ul/li/div/div[2]/div/div/div/a/span"));
        view.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement proceedToCheckoutButton = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        proceedToCheckoutButton.click();

        assertEquals("Order - My Store", browser.getTitle());
    }


    // TC_ARC_007
    @Test
    public void RemoveFromCart(){
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        WebElement deleteItem = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
        deleteItem.click();

        assertTrue(browser.getPageSource().contains("Your shopping cart is empty."));
    }

    // TC_ARC_008
    @Test
    public void IncreaseQuantity(){
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement increaseQuantity = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span/i"));
        increaseQuantity.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertTrue(browser.getPageSource().contains("2 Products"));
    }

    //TC_ARC_009
    @Test
    public void EditSize(){
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement editSizeDropdown = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/" +
                        "form/div/div[2]/div/fieldset[1]/div/div/select/option[3]"));
        editSizeDropdown.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertTrue(browser.getPageSource().contains("Color : Orange, Size : L"));
    }

    // TC_ARC_010
    @Test
    public void LogOUTAndInCart(){
        String emailInput = "d1f403@uvic.ca";
        String passwordInput = "password123";
        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        WebElement signOut = browser.findElement(By.partialLinkText("Sign out"));
        signOut.click();

        WebElement signIn = browser.findElement(By.partialLinkText("Sign in"));
        signIn.click();

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);

        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);

        WebElement signIn2 = browser.findElement(By.id("SubmitLogin"));
        signIn2.click();

        WebElement cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a"));
        cart.click();

        assertTrue(browser.getPageSource().contains("1 Product"));
    }

    // TC_ARC_011
    @Test
    public void LogOutCart(){
        WebElement signOut = browser.findElement(By.partialLinkText("Sign out"));
        signOut.click();

        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        assertTrue(browser.getPageSource().contains("1 Product"));
    }

    // TC_ARC_012
    @Test
    public void LogOutRemoveCart(){
        WebElement signOut = browser.findElement(By.partialLinkText("Sign out"));
        signOut.click();

        WebElement category = browser.findElement(By.partialLinkText("Women"));
        category.click();

        Actions action = new Actions(browser);
        action.moveToElement(browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();

        WebElement more = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span"));
        more.click();

        WebElement addToCart = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"));
        addToCart.click();

        WebElement gotoCheckout = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")));
        gotoCheckout.click();

        WebElement delete = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
        delete.click();

        assertTrue(browser.getPageSource().contains("Your shopping cart is empty."));
    }

}
```

Execution screenshot for pass/fail tests of Add Edit Remove From:

![image](https://user-images.githubusercontent.com/64433812/179888430-1c0d838b-f656-45af-ba7c-a90c08f83ffc.png)

Execution screenshot of the web application interfaces:

<p align="center">
    TC_ARC_002
</p>

![image](https://user-images.githubusercontent.com/64433812/179888453-037371e6-9cda-4c6f-b585-c5ce014222dc.png)

<p align="center">
    TC_ARC_003
</p>

![image](https://user-images.githubusercontent.com/64433812/179888490-207a7854-1196-4835-91d2-de6db12806d2.png)

<p align="center">
    TC_ARC_004
</p>

![image](https://user-images.githubusercontent.com/64433812/179888527-36ee695f-2253-419c-982c-3280fba393ae.png)

<p align="center">
    TC_ARC_005
</p>

![image](https://user-images.githubusercontent.com/64433812/179888558-8c003f96-b8dd-4e89-96fe-d07a0ca8b169.png)

<p align="center">
    TC_ARC_006
</p>

![image](https://user-images.githubusercontent.com/64433812/179888586-27206573-476b-4f09-b35b-c8c4d3890216.png)

<p align="center">
    TC_ARC_007
</p>

![image](https://user-images.githubusercontent.com/64433812/179888636-7d5f47af-2452-486b-9684-a5273871302e.png)

<p align="center">
    TC_ARC_008
</p>

![image](https://user-images.githubusercontent.com/64433812/179888668-4821bc35-8497-467a-b157-e64e8d066cc1.png)

<p align="center">
    TC_ARC_009
</p>

![image](https://user-images.githubusercontent.com/64433812/179888686-bda8bfcc-a316-401e-8555-1f751470efbe.png)

<p align="center">
    TC_ARC_010
</p>

![image](https://user-images.githubusercontent.com/64433812/179888709-228058a8-3245-4738-8003-d9eace3683bf.png)

<p align="center">
    TC_ARC_011
</p>

![image](https://user-images.githubusercontent.com/64433812/179888739-e6c571ac-5804-4e7b-8928-77cee6f9abc3.png)

<p align="center">
    TC_ARC_012
</p>

![image](https://user-images.githubusercontent.com/64433812/179888769-601fce73-c368-4ff6-8f52-085dcead3569.png)

