package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;
import java.util.List;

/*
3. Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
4. Write down the following test into ‘LoginTest’
class
1. userSholdLoginSuccessfullyWithValid
Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed
on page
 */

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //* Verify the text “PRODUCTS”
        String exceptedText = "Products";
        String actualText = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(exceptedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int excepted = 6;
        int actual = products.size();
        Assert.assertEquals(excepted, actual);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}