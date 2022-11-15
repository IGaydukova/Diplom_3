package pageobject;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;
    protected static final String URL = "https://stellarburgers.nomoreparties.site/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
