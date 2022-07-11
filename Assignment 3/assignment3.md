# Assignment 3

CreateAccount.java Selenium automation test script:

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
       // browser.quit();
    }

    // TC_CA_001
    @Test
    public void createAccountValid() {
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(generateEmail());
        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("Alex");
        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Holland");
        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password123");
        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("123 test st.");
        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Victoria");
        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);
        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("12345");
        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("123-456-7899");
        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();
    }

    // TC_CA_002
    @Test
    public void invalidPassword(){
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(generateEmail());
        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("Alex");
        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Holland");
        // input an invalid password
        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("test");
        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("123 test st.");
        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Victoria");
        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);
        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("12345");
        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("123-456-7899");
        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div"))
                );
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_003
    @Test
    public void wrongPostalCode(){
        WebElement emailAddressInput = browser.findElement(By.id("email_create"));
        emailAddressInput.sendKeys(generateEmail());
        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstNameInput = browser.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("Alex");
        WebElement lastNameInput = browser.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Holland");
        WebElement passwordInput = browser.findElement(By.id("passwd"));
        passwordInput.sendKeys("password123");
        WebElement addressInput = browser.findElement(By.id("address1"));
        addressInput.sendKeys("123 test st.");
        WebElement cityInput = browser.findElement(By.id("city"));
        cityInput.sendKeys("Victoria");
        Select stateDropdown = new Select(browser.findElement(By.id("id_state")));
        stateDropdown.selectByIndex(1);
        // input an invalid postal code
        WebElement postcodeInput = browser.findElement(By.id("postcode"));
        postcodeInput.sendKeys("123456");
        WebElement mobilePhoneInput = browser.findElement(By.id("phone_mobile"));
        mobilePhoneInput.sendKeys("123-456-7899");
        WebElement registerButton = browser.findElement(By.id("submitAccount"));
        registerButton.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div")));
        assertTrue(browser.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_004
    @Test
    public void emailExists(){
        // d1f403@uvic.ca is an existing email
        WebElement emailAddressInput1 = browser.findElement(By.id("email_create"));
        emailAddressInput1.sendKeys("d1f403@uvic.ca");

        WebElement createAccountButton = browser.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

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

![](Create%20Account/passedTests.jpg)






