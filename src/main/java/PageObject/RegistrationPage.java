package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPage extends BasePage{

    //Имя
    private final By nameInput = By.xpath(".//div/main/div/form/fieldset[1]/div/div/input");
    //E-mail
    private final By emailInput = By.xpath(".//div/main/div/form/fieldset[2]/div/div/input");
    //Пароль
    private final By passInput = By.xpath("//input[@name='Пароль']");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//main//button[text()='Зарегистрироваться']");
    //Заголовок "Вход"
    private final By enterLabel = By.xpath(".//main//div/h2[text()='Вход']");
    //Кнопка "Войти"
    private final By personalAreaButton = By.xpath(".//main//button[text()='Войти']");
    //Предупреждение "Пользователь уже существует"
    private final By warningUserAlredyRegestered= By.xpath(".//main//div/p[text()='Такой пользователь уже существует']");// By.className("input__error text_type_main-default");
    //Предупреждение "Некорректный пароль"
    private final By warningIncorrectPassword= By.xpath(".//main//div/p[text()='Некорректный пароль']");
// Кнопка "Войти" (возврат из окна регистрации)
    private final By enterButton = By.className("Auth_link__1fOlj");

    public RegistrationPage (WebDriver driver) {super(driver);}
    @Step("Enter personal data")
    public RegistrationPage enterPersonalData (String name, String email, String pass)
    {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(pass);
        return this;
    }
    @Step("Click Registered Button")
    public RegistrationPage clickRegisteredButton() {
        driver.findElement(registrationButton).click();
        return this;
    }

    @Step("Click Enter button")
    public AuthorizationPage clickEnterButton() {
        driver.findElement(enterButton).click();
        return new AuthorizationPage(driver);
    }
    @Step("Enter label is displayed")
    public boolean enterLabelIsDisplayed() {
        return driver.findElement(enterLabel).isDisplayed();
    }

    @Step("Warning User alredy registered is displayed")
    public boolean warningUserAlredyRegisteredDisplayed() {
        return driver.findElement(warningUserAlredyRegestered).isDisplayed();
    }

    @Step("Warning Incorrect password is displayed")
    public boolean warningIncorrectPassword() {
        return driver.findElement(warningIncorrectPassword).isDisplayed();
    }
}
