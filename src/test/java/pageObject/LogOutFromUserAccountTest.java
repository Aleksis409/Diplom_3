package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LogOutFromUserAccountTest extends BaseTest{

    @Before
    public void tearUp() {
        user = user.getRandomUser();                     //создание случайного пользователя
        mainPage.openPage();                             //загрузка основной страницы
        mainPage.clickPersonalAccountButton();           //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();               //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);         //регистрация пользователя
        loginPage.loginToUserAccount(user);              //вход в аккаунт пользователя
    }

    @Test //тест успешного выхода из Личного кабинета по кнопке "Выход"
    @DisplayName("Successfully log out from the Personal Account by clicking the \"Log out\" button")
    public void successfulLogOutFromPersonalAccountByLogOutButtonClickTestOK() {
        mainPage.clickPersonalAccountButton();            //вход в "Личный кабинет"
        profilePage.logOutPersonalAccountButtonClick();   //выход из "Личного кабинета"
        loginPage.waitLoginPageToLoad();                  //ожидание загрузки страницы входа в аккаунт
        assertEquals("Ошибка выхода из Личного кабинета", loginPage.getLoginPageUrl(), driver.getCurrentUrl());
    }
}
