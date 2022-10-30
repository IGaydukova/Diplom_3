package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AuthorizationPage extends BasePage{
    //E-mail
    private final By emailInput = By.xpath(".//main//fieldset[1]//input");
    //Пароль
    private final By passInput = By.xpath("//input[@name='Пароль']");
    //Кнопка "Войти"
    private final By enterButton = By.xpath(".//main//button[text()='Войти']");
    //Кнопка "Зарегистрироваться"
    private final By registrationHref = By.xpath(".//main//a[contains(@href,'/register')]");
    // Кнопка "Восстановить пароль"
    private final By recoverPassword = By.xpath(".//main//a[contains(@href,'/forgot-password')]");
    //Ссылка "Войти" (возврат с восстановления пароля)
    private final By enterHref = By.xpath(".//main//a[contains(@href,'/login')]");

    public AuthorizationPage (WebDriver driver) {super(driver);}
    @Step("Enter Personal area button")
    public AuthorizationPage enterPersonalData (String email, String pass)
    {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(pass);
        return this;
    }
    @Step("Click Recover password button")
    public AuthorizationPage clickRecoverPassButton ()
    {
        driver.findElement(recoverPassword).click();
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
        return this;
    }
    @Step("Click Enter button")
    public OrderPage enterButtonClick (){
        driver.findElement(enterButton).click();
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
        return new OrderPage(driver);
    }
    @Step("Click href Enter")
    public AuthorizationPage enterHrefClick(){
        driver.findElement(enterHref).click();
        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
        return this;
    }
    @Step("Click href registration")
    public RegistrationPage registrationHrefClick (){
        driver.findElement(registrationHref).click();
        driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);
        return new RegistrationPage(driver);
    }

}
