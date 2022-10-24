import PageObject.AuthorizationPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends BasePageTest{
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
        }
    @Test
    @DisplayName("Authorization USER TEST From Enter Account Button")
    public void AuthorizationCorrectFromEnterAcciuntTest(){
        System.out.println(password);
                boolean isAuthorizationCorrect = new MainPage(driver)
                        .openPage()
                        .clickEnterAccountButton()
                        .enterPersonalData(email, password)
                .enterButtonClick()
                .createOrderButtonIsDisplayed();
        //Проверяем результат
        assertTrue("The Button is not displayd", isAuthorizationCorrect);
    }

    @Test
    @DisplayName("Authorization USER TEST From Personal Area")
    public void AuthorizationCorrectFromPersonalAreaTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickPersonalAreaButton()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .createOrderButtonIsDisplayed();
        //Проверяем результат
        assertTrue("The Button is not displayd", isAuthorizationCorrect);
    }

    @Test
    @DisplayName("Authorization USER TEST Return From Registration")
    public void AuthorizationCorrectReturnFromRegistrationTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .registrationHrefClick()
                .clickEnterButton()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .createOrderButtonIsDisplayed();
        //Проверяем результат
        assertTrue("The Button is not displayd", isAuthorizationCorrect);
    }

    @Test
    @DisplayName("Authorization USER TEST Return From Recover Password")
    public void AuthorizationCorrectReturnFromRecoverPassTest(){
        boolean isAuthorizationCorrect = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .clickRecoverPassButton()
                .enterHrefClick()
                .enterPersonalData(email, password)
                .enterButtonClick()
                .createOrderButtonIsDisplayed();
        //Проверяем результат
        assertTrue("The Button is not displayed", isAuthorizationCorrect);
    }
}