package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
String baseURL = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Find Username field and Type the email address
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        //Find the passwordField and Type the password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        // Find the Login button and click on it
        driver.findElement(By.id("login-button")).click();
       String expectedText = "Products";
        // Find the actual text element and get the text from element
       String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
       int actual = products.size();
        System.out.println("Actual total products displayed on the page are: " +actual);
       int expected = 6;
        System.out.println("Expected total products displayed on the page are: " + expected);
        // Validate actual and expected message
       Assert.assertEquals("Correct amount not displayed", expected,actual);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
