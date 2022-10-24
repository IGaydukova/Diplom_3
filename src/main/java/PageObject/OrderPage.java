package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage{
//Кнопка "Оформить заказ"
    private final By createOrderButton = By.xpath(".//main//button[text()='Оформить заказ']");
    // Кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath(".//header//a[contains(@href,'/account')]");
    // ЗАголовок "Соберите бургер"
    private final By createBurgerHeader = By.xpath(".//main//h1[text()='Соберите бургер']");
    public OrderPage (WebDriver driver) {super(driver);}
    @Step("Button Create Order is displayed")
    public boolean createOrderButtonIsDisplayed() {
        return driver.findElement(createOrderButton).isDisplayed();
    }
    @Step("Click Personal area button")
    public PersonalAreaPage clickPersonalAreaButton(){
        driver.findElement(personalAreaButton).click();
        return new PersonalAreaPage(driver);
    }
    @Step("Header Create Burger is displayed")
    public boolean createBurgerHeaderIsDisplayed() {
        return driver.findElement(createBurgerHeader).isDisplayed();
    }
}
