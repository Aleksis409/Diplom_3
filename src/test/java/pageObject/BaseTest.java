package pageObject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import user.User;

import java.time.Duration;

//Тесты запускаются в среде Windows 10, путь к web драйверу должен быть прописан в переменной окружения PATH,
//пути к web браузерам Google Chrome и Yandex прописаны в переменных chromeBrowserPath и yandexBrowserPath
public class BaseTest {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;
    FeedPage feedPage;
    ProfilePage profilePage;
    User user;

    @Before
    public void setup() {
        String chromeBrowserPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String yandexBrowserPath = System.getenv("USERPROFILE") + "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        ChromeOptions options = new ChromeOptions();
        options.setBinary(yandexBrowserPath);    //Запуск тестов в Yandex браузере
        //options.setBinary(chromeBrowserPath);  //Запуск тестов в Google Chrome браузере
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        feedPage = new FeedPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

