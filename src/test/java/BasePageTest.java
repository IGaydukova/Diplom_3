import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class BasePageTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
         // Google Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
   @After
    public void tearDown(){
        driver.quit();
    }
}