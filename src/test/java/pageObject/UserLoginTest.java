package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class UserLoginTest extends BaseTest{

    @Before //регистрация пользователя
    public void tearUp() {
        user = user.getRandomUser();                      //создание случайного пользователя
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickPersonalAccountButton();            //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();                //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);          //регистрация пользователя
    }

    @Test //тест успешного входа пользователя по кнопке "Войти в аккаунт" на MainPage
    @DisplayName("Successful user login using the \"Login to account\" button on the MainPage")
    public void successfulUserLoginWithButtonLoginToAccountOnMainPageTestOK() {
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickLogInToAccountButton();             //переход на страницу входа в аккаунт
        loginPage.loginToUserAccount(user);               //вход в аккаунт пользователя
        assertTrue("Ошибка входа в аккаунт. Не появилась кнопка \"Оформить заказ\"", mainPage.waitPlaceAnOrderButton());
    }

    @Test //тест успешного входа пользователя через кнопку "Личный Кабинет" на MainPage
    @DisplayName("Successful user login using the \"Personal Account\" button on the MainPage")
    public void successfulUserLoginWithButtonPersonalAccountOnMainPageTestOK() {
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickPersonalAccountButton();            //вход в "Личный кабинет"
        loginPage.loginToUserAccount(user);               //вход в аккаунт пользователя
        assertTrue("Ошибка входа в аккаунт. Не появилась кнопка \"Оформить заказ\"", mainPage.waitPlaceAnOrderButton());
    }

    @Test //тест успешного входа пользователя через кнопку в форме регистрации на RegistrationPage
    @DisplayName("Successful user login via the button in the registration form on the RegistrationPage")
    public void successfulUserLoginViaTheButtonRegistrationFormOnRegistrationPageTestOK() {
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickPersonalAccountButton();            //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();                //переход на страницу регистрации
        registrationPage.clickLoginLink();                //переход по ссылке "Войти"
        loginPage.loginToUserAccount(user);               //вход в аккаунт пользователя
        assertTrue("Ошибка входа в аккаунт. Не появилась кнопка \"Оформить заказ\"", mainPage.waitPlaceAnOrderButton());
    }

    @Test //тест успешного входа пользователя через кнопку в форме восстановления пароля на ForgotPasswordPage
    @DisplayName("Successful user login via the button in the password recovery form on the RegistrationPage")
    public void successfulUserLoginViaTheButtonPasswordRecoveryFormOnForgotPasswordPageTestOK() {
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickLogInToAccountButton();             //вход в "Личный кабинет"
        loginPage.clickRecoverPasswordLink();             //переход на страницу восстановления пароля
        forgotPasswordPage.clickLoginLink();              //переход по ссылке "Войти"
        loginPage.loginToUserAccount(user);               //вход в аккаунт пользователя
        assertTrue("Ошибка входа в аккаунт. Не появилась кнопка \"Оформить заказ\"", mainPage.waitPlaceAnOrderButton());
    }
}
