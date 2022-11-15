package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {
    private final By bunsTab = By.xpath(".//main//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//main//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//main//span[text()='Начинки']");

    private final By bunsHeader = By.xpath(".//main//h2[text()='Булки']");
    private final By saucesHeader = By.xpath(".//main//span[text()='Соусы']");
    private final By fillingsHeader = By.xpath(".//main//span[text()='Начинки']");

    public ConstructorPage (WebDriver driver) {super(driver);}

    @Step("Click Sauces bookmark")
    public ConstructorPage clickSauces() {
        driver.findElement(saucesTab).click();
        return this;
    }

    @Step("Click Fillings bookmark")
    public ConstructorPage clickFillings() {
        driver.findElement(fillingsTab).click();
        return this;
    }

    @Step("Click Buns bookmark")
    public ConstructorPage clickBuns() {
        driver.findElement(bunsTab).click();
        return this;
    }

    @Step("Header Buns is displayed")
    public boolean isDisplayBuns () {
        return driver.findElement(bunsHeader).isDisplayed();
    }

    @Step("Header Sauces is displayed")
    public boolean isDisplaySauces () {
        return driver.findElement(saucesHeader).isDisplayed();
    }

    @Step("Header Fillings is displayed")
    public boolean isDisplayFillings () {
        return driver.findElement(fillingsHeader).isDisplayed();
    }
}
