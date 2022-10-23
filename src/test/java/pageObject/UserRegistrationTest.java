package pageObject;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserRegistrationTest extends BaseTest {

    @Test //тест успешной регистрации пользователя
    @DisplayName("Successful user registration")
    public void successfulUserRegistrationTestOK() {
        user = user.getRandomUser();                              //создание случайного пользователя
        mainPage.openPage();                                      //загрузка основной страницы
        mainPage.clickPersonalAccountButton();                    //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();                        //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                  //регистрация пользователя
        loginPage.waitLoginPageToLoad();                          //ожидание загрузки страницы входа в аккаунт пользователя (LoginPage)
        assertEquals("Нет перехода на страницу входа в аккаунт", loginPage.getLoginPageUrl(), driver.getCurrentUrl());
    }

    @Test //тест неуспешной регистрации пользователя с паролем меньше 6 символов
    @DisplayName("Unsuccessful user registration with incorrect password")
    public void unSuccessfulUserRegistrationWithIncorrectPasswordTestOK() {
        user = user.getRandomUserWithPasswordFiveCharacters();     //создание случайного пользователя с паролем 5 символов
        mainPage.openPage();                                       //загрузка основной страницы
        mainPage.clickPersonalAccountButton();                     //вход в "Личный кабинет"
        loginPage.clickRegistrationLink();                         //переход по ссылке "Зарегистрироваться"
        registrationPage.userRegistration(user);                   //регистрация пользователя
        String errorMessage = registrationPage.getMessageIncorrectPassword();
        assertEquals("Нет сообщения \"Некорректный пароль\"", "Некорректный пароль", errorMessage);
        assertEquals("Ошибка! Выход из Личного кабинета", registrationPage.getRegistrationPageUrl(), driver.getCurrentUrl());
    }
}
