package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * BaseUrl = https://www.saucedemo.com/
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */

public class LoginTest extends BaseTest {
    String baseUrl =  "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        WebElement emailElement = driver.findElement(By.id("user-name"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        emailElement.sendKeys("standard_user");
        passwordElement.sendKeys("secret_sauce");

        //click login button
        driver.findElement(By.id("login-button")).click();

        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.className("title")).getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement emailElement = driver.findElement(By.id("user-name"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        emailElement.sendKeys("standard_user");
        passwordElement.sendKeys("secret_sauce");

        //click login button
        driver.findElement(By.id("login-button")).click();

        int expectedItems = 6;
        List<WebElement> listOfProducts = driver.findElements(By.className("inventory_item"));

        Assert.assertEquals(expectedItems, listOfProducts.size());
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
