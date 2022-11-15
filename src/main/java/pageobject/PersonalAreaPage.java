package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPage extends BasePage{
    //Заголовок Профиль
    private final By profileHeader = By.xpath(".//main//a[contains(@href,'/account/profile')]");
    //Кнопка "Выход"
    private final By exitButton = By.xpath(".//main//button[text()='Выход']");
    //Кнопка "Констурктор"
    private final By constructButton = By.xpath(".//header//p[text()='Конструктор']");


    public PersonalAreaPage (WebDriver driver) {super(driver);}

    @Step("Header Profila is displayed")
    public boolean profileHeaderIsDisplayed(){
        return driver.findElement(profileHeader).isDisplayed();
    }
    public RegistrationPage exitButtonClick(){
        driver.findElement(exitButton).click();
        return new RegistrationPage(driver);
    }
    @Step("Go to Construct")
    public OrderPage constructButtonClick(){
        driver.findElement(constructButton).click();
        return new OrderPage(driver);
    }
}
