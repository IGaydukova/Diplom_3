import PageObject.MainPage;
import PageObject.RegistrationPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;

public class PersonalAreaTest extends BasePageTest {
    public static String name;
    public static String password;
    public static String email;
    @BeforeClass
    public static void generateUser(){
        Faker faker = new Faker();
        name = faker.name().username();
        password = faker.internet().password();
        email = faker.internet().emailAddress();

    }
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        RegistrationPage registrationTestUser = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .registrationHrefClick()
                .enterPersonalData(name, email, password)
                .clickRegisteredButton();
        // driver.quit();
    }

    @Test
    @DisplayName("Enter To Personal Area")
    public void enterToPersonalAreaCorrectTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .clickPersonalAreaButton()
                .profileHeaderIsDisplayed();

        //Проверяем результат
        assertTrue("The enter to personal area is not done", isAuthorizationCorrect);
    }
    @Test
    @DisplayName("Quit from Personal Area")
    public void quitFromPersonalAreaCorrectTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .clickPersonalAreaButton()
                .exitButtonClick()
                .enterLabelIsDisplayed();
        //Проверяем результат
        assertTrue("The quit from personal area is not done", isAuthorizationCorrect);
    }
    @Test
    @DisplayName("Enter to costructor from PA")
    public void enterToConstructorFromPersonalAreaCorrectTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .clickPersonalAreaButton()
                .constructButtonClick()
                .createBurgerHeaderIsDisplayed();
        //Проверяем результат
        assertTrue("The quit from personal area is not done", isAuthorizationCorrect);
    }

}