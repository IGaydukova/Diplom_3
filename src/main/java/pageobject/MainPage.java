package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    // Кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath(".//header//a[contains(@href,'/account')]");
    //Кнопка войти в аккаунт
    private final By enterAccountButton = By.xpath(".//main//button[text()='Войти в аккаунт']");// "AppHeader_header__link__3D_hX");
    //Кнопка Зарегистрироваться


    public MainPage (WebDriver driver) {super(driver);}
    //открыть страницу
    public MainPage openPage(){
        driver.get(URL);
        return this;
    }
    //переход к окну личной страницы
    @Step("Click Personal area button")
    public AuthorizationPage clickPersonalAreaButton()
    {
        driver.findElement(personalAreaButton).click();
        return new AuthorizationPage(driver);
    }
    @Step("Click Enter account button")
    public AuthorizationPage clickEnterAccountButton()
    {
        driver.findElement(enterAccountButton).click();
        return new AuthorizationPage(driver);
    }

}
