package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;
import java.time.Duration;

public class RegistrationPage {

    private final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    //поле "Имя"
    private final By userNameField = By.xpath(".//fieldset[1]/div/div/input");

    //поле "Email"
    private final By userEmailField = By.xpath(".//fieldset[2]/div/div/input");

    //поле "Пароль"
    private final By userPasswordField = By.xpath(".//fieldset[3]/div/div/input");

    //кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Кнопка "Личный Кабинет"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");

    //ссылка "Войти"
    private final By loginLink = By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/login')]");

    //сообщение "Некорректный пароль"
    private final By messageIncorrectPassword= By.xpath(".//p[text()='Некорректный пароль']");

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

     //заполнения поля "Имя"
    @Step("Input user name")
    public void inputUserName(String name) {
        driver.findElement(userNameField).sendKeys(name);
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

    //нажатие кнопки "Зарегистрироваться"
    @Step("Click register button")
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    //нажатие кнопки "Личный Кабинет"
    @Step("Clicking on the \"Personal Account\" button")
    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    //переход по ссылке "Войти"
    @Step("Click login link")
    public void clickLoginLink(){
        wait(loginLink);
        driver.findElement(loginLink).click();
    }

    //получение сообщения "Некорректный пароль"
    @Step("Getting the message \"Incorrect password\"")
    public String getMessageIncorrectPassword() {
        return driver.findElement(messageIncorrectPassword).getText();
    }

    //получение url страницы регистрации Registration Page
    @Step("Getting url of the registration page")
    public String getRegistrationPageUrl() {
        return registrationPageUrl;
    }

    //регистрация пользователя
    @Step("User registation")
    public void userRegistration(User user) {
        wait(registerButton);                      //ожидание видимости кнопки "Зарегистрироваться" (ожидание загрузки страницы регистрации)
        inputUserName(user.getUserName());         //ввод имени пользователя
        inputUserEmail(user.getUserEmail());       //ввод email пользователя
        inputUserPassword(user.getUserPassword()); //ввод пароля пользователя
        clickRegisterButton();                     //нажатие кнопки "Зарегистрироваться"
    }
}
