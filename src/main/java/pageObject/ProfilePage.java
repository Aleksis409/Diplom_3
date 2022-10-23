package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProfilePage {

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private static String profilePageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    //Кнопка "Выход"
    private final By logOutPersonalAccountButton =  By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    //кнопка "Конструктор"
    private final By designerButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/')]");

    //логотип "Stellar Burgers"
    private final By stellarBurgersLogo = By.cssSelector(".AppHeader_header__logo__2D0X2 svg");

    //поле "Имя"
    private final By userNameField = By.xpath(".//input[(@name='Name') and (@type='text')]");

    //поле "Email"
    private final By userEmailField = By.xpath(".//input[(@name='name') and (@type='text')]");

    //сообщение "В этом разделе вы можете изменить свои персональные данные"
    private final By personalAccountNotification =  By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //получение актуального значения поля "Имя"
    @Step("Getting the current value of the \"Name\" field")
    public String getActualValueNameField() {
        String text = driver.findElement(userNameField).getAttribute("value");
        return text;
    }

    //получение актуального значения поля "Email"
    @Step("Getting the current value of the \"Email\" field")
    public String getActualValueEmailField() {
        String text = driver.findElement(userEmailField).getAttribute("value");
        return text;
    }

    //получение уведомления "В этом разделе вы можете изменить свои персональные данные"
    @Step("Getting a personal account notification")
    public boolean getPersonalAccountNotification() {
        wait(personalAccountNotification);
        String text = driver.findElement(personalAccountNotification).getText();
        return (text.equals("В этом разделе вы можете изменить свои персональные данные"));
    }

    //нажатие кнопки "Выход"
    @Step("Clicking on the \"Log out\" button from personal account")
    public void logOutPersonalAccountButtonClick(){
        wait(logOutPersonalAccountButton);
        driver.findElement(logOutPersonalAccountButton).click();
    }

    //нажатие кнопки "Конструктор"
    @Step("Clicking on the \"Constructor\" button")
    public void clickDesignerButton(){
        wait(designerButton);
        driver.findElement(designerButton).click();
    }

    //переход по логотипу "Stellar Burgers"
    @Step("Click on the register link")
    public void clickRegistrationLink(){
        wait(stellarBurgersLogo);
        driver.findElement(stellarBurgersLogo).click();
    }

    //получение url страницы личного кабинета ProfilePage
    @Step("Getting url of the account login page")
    public String getProfilePageUrl() {
        return profilePageUrl;
    }
}
