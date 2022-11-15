import pageobject.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import com.github.javafaker.Faker;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BasePageTest {
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
    @Test
    @DisplayName("REGISTRATION USER TEST")
    @Description("Check code and answer")
    public void registrationTest() {
        boolean isOrderStatusNotFound = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .registrationHrefClick()
                .enterPersonalData(name, email,password)
                .clickRegisteredButton()
                .enterLabelIsDisplayed();
       //Проверяем результат
        assertTrue("The user isn't registrated!", isOrderStatusNotFound);
    }

    @Test
    @DisplayName("REGISTRATION Already registered User TEST")
    @Description("Check code and answer")
    public void registrationUserAlredyRegisteredTest() {
        boolean isOrderStatusNotFound = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .registrationHrefClick()
                .enterPersonalData(name, email,password)
                .clickRegisteredButton()
                .warningUserAlredyRegisteredDisplayed();
        //Проверяем результат
        assertTrue("Warning is not displayed", isOrderStatusNotFound);
    }
    @Test
    @DisplayName("REGISTRATION Incorrect Password TEST")
    @Description("Check code and answer")
    public void registrationIncorrectPasswordCreatedTest() {
        boolean isOrderStatusNotFound = new MainPage(driver)
                .openPage()
                .clickEnterAccountButton()
                .registrationHrefClick()
                .enterPersonalData(name, email,"111")
                .clickRegisteredButton()
                .warningIncorrectPassword();
        //Проверяем результат
        assertTrue("Warning Incorrect Password is not displayed", isOrderStatusNotFound);
    }

}