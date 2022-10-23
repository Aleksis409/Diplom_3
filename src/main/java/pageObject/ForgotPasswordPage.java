package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ForgotPasswordPage {

    //forgotPasswordPageUrl = "https://stellarburgers.nomoreparties.site/forgot-password";
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    //ссылка "Войти"
    private final By loginLink = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]");

    //Кнопка "Личный Кабинет"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //нажатие ссылки "Войти"
    @Step("Click login link")
    public void clickLoginLink(){
        wait(loginLink);
        driver.findElement(loginLink).click();
    }

    //нажатие кнопки "Личный Кабинет"
    @Step("Clicking on the \"Personal Account\" button")
    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }
}
