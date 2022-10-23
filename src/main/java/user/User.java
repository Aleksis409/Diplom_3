package user;

import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private String userName;
    private String userEmail;
    private String userPassword;

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    //создание "случайного" пользователя
    public static User getRandomUser() {
        return new User(
                "TestUser_" + RandomStringUtils.randomAlphanumeric(6),
                RandomStringUtils.randomAlphanumeric(10) + "@example.com",
                "12345678"
        );
    }

    //создание "случайного" пользователя с паролем меньше 6 символов
    public static User getRandomUserWithPasswordFiveCharacters() {
        return new User(
                "TestUser_" + RandomStringUtils.randomAlphanumeric(6),
                RandomStringUtils.randomAlphanumeric(10) + "@example.com",
                "12345"
        );
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
