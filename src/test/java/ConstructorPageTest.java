import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
public class ConstructorPageTest extends BasePageTest{


    @Test
    @DisplayName("Go to filling is correct")
    public void goToFillingIsCorrect() {
        boolean isFillingsDisplayed = new MainPage(driver)
                .openPage()
                .clickConstructorButton()
                .clickFillings()
                .isDisplayFillings();
        //Проверяем результат - начинка
        assertTrue("The fillings is not displayed", isFillingsDisplayed);
    }

    @Test
    @DisplayName("Go to sauses is correct")
    public void goToSausesIsCorrect() {
         boolean isSauceDisplayed = new MainPage(driver)
                .openPage()
                .clickConstructorButton()
                .clickSauces()
                .isDisplaySauces();
        //Проверяем результат - соусы
        assertTrue("The sauce is not displayed", isSauceDisplayed);
    }
        @Test
        @DisplayName("Go to buns is correct")
        public void goToBunsIsCorrect() {
                 boolean isBunsDisplayed = new MainPage(driver)
                .openPage()
                .clickConstructorButton()
                .clickSauces()
                .clickBuns()
                .isDisplayBuns();
        //Проверяем результат - булочки
        assertTrue("The buns is not displayed", isBunsDisplayed);
        }

}
