package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setup (){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
            // enter "tomSmith" username in userNameField
        driver.findElement(By.id("username")).sendKeys("tomsmith");
            // enter the "SuperSecretPassword!" password in passwordField
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            // click on login button
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
            // varify the text secure area
        String expectedName = "Secure Area";
        String actualName = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Secure Area",expectedName,actualName);

    }
        @Test
        public void verifyTheUsernameErrorMessage(){
           // enter "tomSmith1" username in userNameField
            driver.findElement(By.id("username")).sendKeys("tomsmith1");
           // enter the "SuperSecretPassword!" password in passwordField
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            // click on login button
            driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
            // Verify the error message "your username is invalid"
            String expectedMassage = "Your username is invalid!\n"+"×";
            String actualMessage = driver.findElement(By.id("flash")).getText();
            Assert.assertEquals("×Your username is invalid!",expectedMassage,actualMessage);
        }
            @Test
            public void verifyThePasswordErrorMessage(){
                // enter "tomSmith1" username in userNameField
                driver.findElement(By.id("username")).sendKeys("tomsmith");
                // enter the "SuperSecretPassword!" password in passwordField
                driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
                // click on login button
                driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();
                 String expectedMessage = "Your password is invalid!\n"+"×";
                 String actualMessage = driver.findElement(By.id("flash")).getText();
                 Assert.assertEquals("Your password is invalid!",expectedMessage,actualMessage);
            }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
