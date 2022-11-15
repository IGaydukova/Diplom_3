import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class BasePageTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
// Google Chrome
        /*
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/
// Yandex
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\yandexdriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Users\\hdu\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver= new ChromeDriver(options);


    }
   @After
    public void tearDown(){
        driver.quit();
    }
}