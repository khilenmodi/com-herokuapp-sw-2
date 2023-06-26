package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        //set up the browser
        driver = new ChromeDriver();
        // get base url
        driver.get(baseUrl);
        // maximize the window size
        driver.manage().window().maximize();
        // implicitly wait time out for window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();
    }
}
