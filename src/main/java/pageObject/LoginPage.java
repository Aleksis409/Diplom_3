package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;
import java.time.Duration;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private final String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";

    //ссылка "Зарегистрироваться"
    private final By registrationLink =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/register')]");

    //ссылка "Восстановить пароль"
    private final By recoverPasswordLink =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/forgot-password')]");

    //кнопка "Войти"
    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Кнопка "Личный Кабинет"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");

    //поле "Email"
    private final By userEmailField = By.xpath(".//input[(@name='name')]");

    //поле "Пароль"
    private final By userPasswordField = By.xpath(".//input[(@name='Пароль')]");

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //переход по ссылке "Зарегистрироваться"
    @Step("Click on the register link")
    public void clickRegistrationLink(){
        wait(registrationLink);
        driver.findElement(registrationLink).click();
    }

    //переход по ссылке "Восстановить пароль"
    @Step("Click on the recover password link")
    public void clickRecoverPasswordLink(){
        wait(recoverPasswordLink);
        driver.findElement(recoverPasswordLink).click();
    }

    //получение url страницы входа в аккаунт LoginPage
    @Step("Getting url of the account login page")
    public String getLoginPageUrl() {
        return loginPageUrl;
    }

    //нажатие кнопки "Вход"
    @Step("Clicking on the \"Login\" button")
    public void clickLoginButton(){
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    //нажатие кнопки "Личный Кабинет"
    @Step("Clicking on the \"Personal Account\" button")
    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    //ожидание загрузки страницы входа в аккаунт (видимость ссылки "Восстановить пароль")
    @Step("Waiting for the account login page to load")
    public void waitLoginPageToLoad() {
        wait(recoverPasswordLink);
    }

    //заполнения поля "Email"
    @Step("Input user email")
    public void inputUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
    }

    //заполнения поля "Пароль"
    @Step("Input user password")
    public void inputUserPassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
    }

    //вход в аккаунт
    @Step("Login to the user account")
    public void loginToUserAccount(User user) {
        waitLoginPageToLoad();                       //ожидание загрузки страницы входа в аккаунт
        inputUserEmail(user.getUserEmail());         //ввод email пользователя
        inputUserPassword(user.getUserPassword());   //ввод пароля пользователя
        clickLoginButton();                          //нажатие кнопки "Вход"
    }
}
