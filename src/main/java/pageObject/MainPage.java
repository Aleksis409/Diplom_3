package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    //кнопка "Войти в аккаунт"
    private final By logInToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //кнопка "Личный Кабинет"
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");

    //кнопка "Конструктор"
    private final By designerButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/')]");

    //кнопка "Лента заказов"
    private final By orderFeedButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/feed')]");

    //поле "Соберите бургер"
    private final By collectBurgerField = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");

    //раздел "Булки"
    private final By bunsSection = By.xpath(".//div[@style='display: flex;']/div[1]/span");

    //заголовок "Булки"
    private final By bunsTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][1]");

    //раздел "Соусы"
    private final By saucesSection = By.xpath(".//div[@style='display: flex;']/div[2]/span");

    //заголовок "Соусы"
    private final By saucesTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][2]");

    //раздел "Начинки"
    private final By ingredientsSection = By.xpath(".//div[@style='display: flex;']/div[3]/span");

    //заголовок "Начинки"
    private final By ingredientsTitle  = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10'][3]");

    //кнопка "Оформить заказ"
    private final By placeAnOrder = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");

    //открытие страницы тестирования
    public void openPage() {
        driver.get(mainPageUrl);
    }

    //ожидание видимости элемента
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //нажатие кнопки "Войти в аккаунт"
    @Step("Clicking on the \"Login to account\" button")
    public void clickLogInToAccountButton(){
        wait(logInToAccountButton);
        driver.findElement(logInToAccountButton).click();
    }

    //нажатие кнопки "Личный Кабинет"
    @Step("Clicking on the \"Personal Account\" button")
    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    //нажатие кнопки "Конструктор"
    @Step("Clicking on the \"Constructor\" button")
    public void clickDesignerButton(){
        wait(designerButton);
        driver.findElement(designerButton).click();
    }

    //нажатие кнопки "Лента заказов"
    @Step("Clicking on the \"Order Feed\" button")
    public void clickOrderFeedButton(){
        wait(orderFeedButton);
        driver.findElement(orderFeedButton).click();
    }

    //выбор раздела "Булки"
    @Step("Choosing the \"Buns\" section")
    public void clickBunsSection(){
        driver.findElement(bunsSection).click();
    }

    //выбор раздела "Соусы"
    @Step("Choosing the \"Sauces\" section")
    public void clickSaucesSection(){
        driver.findElement(saucesSection).click();
    }

    //выбор раздела "Начинки"
    @Step("Choosing the \"Ingredients\" section")
    public void clickIngredientsSection(){
        driver.findElement(ingredientsSection).click();
    }

    //ожидание загрузки поля "Соберите бургер"
    @Step("Waiting a field to collect burger")
    public boolean waitСollectBurgerField() {
        wait(collectBurgerField);
        String text = driver.findElement(collectBurgerField).getText();
        return (text.equals("Соберите бургер"));
    }

    //получение url главной страницы MainPage
    @Step("Getting url of the main page")
    public String getMainPageUrl() {
        return mainPageUrl;
    }

    //ожидание появления кнопки "Оформить заказ". Появляется, когда пользователь вошел в аккаунт
    @Step("Waiting for the place an order button to load")
    public boolean waitPlaceAnOrderButton() {
        wait(placeAnOrder);
        String text = driver.findElement(placeAnOrder).getText();
        return (text.equals("Оформить заказ"));
    }

    //получение значения заголовка "Булки"
    @Step("Getting the value of the \"Buns\" title")
    public String getBunsTitle() {
        String text = driver.findElement(bunsTitle).getText();
        return text;
    }

    //получение значения заголовка "Соусы"
    @Step("Getting the value of the \"Sauces\" title")
    public String getSaucesTitle() {
        String text = driver.findElement(saucesTitle).getText();
        return text;
    }

    //получение значения заголовка "Начинки"
    @Step("Getting the value of the \"Ingredients\" title")
    public String getIngredientsTitle() {
        String text = driver.findElement(ingredientsSection).getText();
        return text;
    }
}
