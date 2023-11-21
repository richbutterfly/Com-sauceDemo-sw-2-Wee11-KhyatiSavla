package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/** 1. Create the package ‘browser factory’ and create the
 class with the name ‘BaseTest’ inside the
 ‘browser factory’ package. And write the browser setup
 code inside the class ‘Base Test’.
 2. Create the package ‘testsuite’ and create the
 following class inside the ‘testsuite’ package.
 1. LoginTest
 3. Write down the following test into ‘LoginTest’ class
 1. userShouldLoginSuccessfullyWithValid Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”
 2. verifyThatSixProductsAreDisplayedOnPage
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify that six products are displayed on
 page
 *
 */
public class BaseTest {

    static String browser = "Chrome";
    public static WebDriver driver;

    public void openBrowser(String baseURL) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
