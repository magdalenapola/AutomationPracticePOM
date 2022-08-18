package BaseForTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseForTests {

    protected static WebDriver driver;
    static final String WebsiteName = "http://automationpractice.com/index.php";

    @BeforeAll
    static void prepareBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(WebsiteName);
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    static void closeBrowser(){
        driver.close();
    }
}
