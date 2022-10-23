package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoToPersonalAccountTest extends BaseTest {

    @Before
    public void tearUp() {
        user = user.getRandomUser();                      //создание случайного пользователя
        mainPage.openPage();                              //загрузка основной страницы
        mainPage.clickPersonalAccountButton();            //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();                //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);          //регистрация пользователя
    }

    @Test //тест успешного перехода в "Личный кабинет" на MainPage для авторизованного пользователя
    @DisplayName("Successful go to the \"Personal Account\" on MainPage for authorized user")
    public void successfulGoToThePersonalAccountOnMainPageAuthorizedUserTestOK() {
        mainPage.openPage();                               //загрузка основной страницы
        mainPage.clickLogInToAccountButton();              //переход на страницу входа в аккаунт
        loginPage.loginToUserAccount(user);                //вход в аккаунт пользователя
        mainPage.clickPersonalAccountButton();             //вход в "Личный кабинет"
        assertTrue("Не отображается уведомление личного кабинета об изменении данных", profilePage.getPersonalAccountNotification());
        assertEquals("Не отображается имя конкретного пользователя в поле \"Имя\"", user.getUserName(), profilePage.getActualValueNameField());
        assertEquals("Не отображается email конкретного пользователя в поле \"Email\"", user.getUserEmail().toLowerCase(), profilePage.getActualValueEmailField());
    }

    @Test //тест успешного перехода в "Личный кабинет" на FeedPage для авторизованного пользователя
    @DisplayName("Successful go to the \"Personal Account\" on FeedPage for authorized user")
    public void successfulGoToThePersonalAccountOnFeedPageAuthorizedUserTestOK() {
        mainPage.openPage();                               //загрузка основной страницы
        mainPage.clickLogInToAccountButton();              //переход на страницу входа в аккаунт
        loginPage.loginToUserAccount(user);                //вход в аккаунт пользователя
        mainPage.clickOrderFeedButton();                   //переход на страницу "Лента заказов"
        feedPage.clickPersonalAccountButton();             //вход в "Личный кабинет"
        assertTrue("Не отображается уведомление личного кабинета об изменении данных", profilePage.getPersonalAccountNotification());
        assertEquals("Не отображается имя конкретного пользователя в поле \"Имя\"", user.getUserName(), profilePage.getActualValueNameField());
        assertEquals("Не отображается email конкретного пользователя в поле \"Email\"", user.getUserEmail().toLowerCase(), profilePage.getActualValueEmailField());
    }

    @Test //тест неуспешного перехода в "Личный кабинет" на MainPage для неавторизованного пользователя
    @DisplayName("Unsuccessful go to the \"Personal Account\" on MainPage for authorized user")
    public void unsuccessfulGoToThePersonalAccountOnMainPageUnauthorizedUserTestOK() {
        mainPage.openPage();                                //загрузка основной страницы
        mainPage.clickPersonalAccountButton();              //вход в "Личный кабинет"
        assertNotEquals("Переход в Личный кабинет для неавторизованного пользователя!", profilePage.getProfilePageUrl(), driver.getCurrentUrl());
    }

    @Test //тест неуспешного перехода в "Личный кабинет" на LoginPage для неавторизованного пользователя
    @DisplayName("Unsuccessful go to the \"Personal Account\" on LoginPage for authorized user")
    public void unsuccessfulGoToThePersonalAccountOnLoginPageUnauthorizedUserTestOK() {
        mainPage.openPage();                                //загрузка основной страницы
        mainPage.clickLogInToAccountButton();               //переход на страницу входа в аккаунт
        loginPage.clickPersonalAccountButton();             //вход в "Личный кабинет"
        assertNotEquals("Переход в Личный кабинет для неавторизованного пользователя!", profilePage.getProfilePageUrl(), driver.getCurrentUrl());
    }

    @Test //тест неуспешного перехода в "Личный кабинет" на RegistrationPage для неавторизованного пользователя
    @DisplayName("Unsuccessful go to the \"Personal Account\" on RegistrationPage for authorized user")
    public void unsuccessfulGoToThePersonalAccountOnRegistrationPageUnauthorizedUserTestOK() {
        mainPage.openPage();                                 //загрузка основной страницы
        mainPage.clickLogInToAccountButton();                //переход на страницу входа в аккаунт
        loginPage.clickRegistrationLink();                   //переход на страницу регистрации
        registrationPage.clickPersonalAccountButton();       //вход в "Личный кабинет"
        assertNotEquals("Переход в Личный кабинет для неавторизованного пользователя!", profilePage.getProfilePageUrl(), driver.getCurrentUrl());
    }

    @Test //тест неуспешного перехода в "Личный кабинет" на ForgotPasswordPage для неавторизованного пользователя
    @DisplayName("Unsuccessful go to the \"Personal Account\" on ForgotPasswordPage for authorized user")
    public void unsuccessfulGoToThePersonalAccountOnForgotPasswordPageUnauthorizedUserTestOK() {
        mainPage.openPage();                                  //загрузка основной страницы
        mainPage.clickLogInToAccountButton();                 //переход на страницу входа в аккаунт
        loginPage.clickRecoverPasswordLink();                 //переход на страницу восстановления пароля
        forgotPasswordPage.clickPersonalAccountButton();      //вход в "Личный кабинет"
        assertNotEquals("Переход в Личный кабинет для неавторизованного пользователя!", profilePage.getProfilePageUrl(), driver.getCurrentUrl());
    }

    @Test //тест неуспешного перехода в "Личный кабинет" на FeedPage для неавторизованного пользователя
    @DisplayName("Unsuccessful go to the \"Personal Account\" on FeedPage for authorized user")
    public void unsuccessfulGoToThePersonalAccountOnFeedPageUnauthorizedUserTestOK() {
        mainPage.openPage();                                   //загрузка основной страницы
        mainPage.clickOrderFeedButton();                       //переход на страницу "Лента заказов"
        feedPage.clickPersonalAccountButton();                 //вход в "Личный кабинет"
        assertNotEquals("Переход в Личный кабинет для неавторизованного пользователя!", profilePage.getProfilePageUrl(), driver.getCurrentUrl());
    }
}
