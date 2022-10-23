package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwitchPersonalAccountToConstructorTest extends BaseTest {

    @Before
    public void tearUp() {
        user = user.getRandomUser();                  //создание случайного пользователя
        mainPage.openPage();                          //загрузка основной страницы
        mainPage.clickPersonalAccountButton();        //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();            //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);      //регистрация пользователя
        loginPage.loginToUserAccount(user);           //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();        //вход в личный кабинет
    }

    @Test //тест успешного перехода из Личного кабинета в Конструктор по кнопке "Конструктор"
    @DisplayName("Successful move from the \"Personal Account\" to the Constructor by clicking the \"Constructor\" button ")
    public void successfulMoveFromPersonalAccountToTheConstructorUsingButtonTestOK() {
        profilePage.clickDesignerButton();             //переход в "Конструктор"
        assertTrue("Не отображается поле Конструктора \"Соберите бургер\"", mainPage.waitСollectBurgerField());
        assertEquals("Ошибка перехода из Личного кабинета в Конструктор", mainPage.getMainPageUrl(), driver.getCurrentUrl());
    }

    @Test //тест успешного перехода из Личного кабинета в Конструктор по клику на логотип Stellar Burgers.
    @DisplayName("Successful move from the \"Personal Account\" to the Constructor by clicking on the Stellar Burgers logo")
    public void successfulMoveFromPersonalAccountToTheConstructorByClickLogoTestOK() {
        profilePage.clickRegistrationLink();            //переход в "Конструктор"
        assertTrue("Не отображается поле Конструктора \"Соберите бургер\"", mainPage.waitСollectBurgerField());
        assertEquals("Ошибка перехода из Личного кабинета в Конструктор", mainPage.getMainPageUrl(), driver.getCurrentUrl());
    }
}
