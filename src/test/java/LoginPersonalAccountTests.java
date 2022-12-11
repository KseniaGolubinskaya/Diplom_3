import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;

import static org.junit.Assert.assertEquals;

public class LoginPersonalAccountTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private HomePage homePage;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;
    private final String loginLabel = "Вход";
    private final String profileLabel = "Профиль";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Переход по клику на «Личный кабинет»
     */
    @Test
    public void signInPersonalAccountSuccessTest() {
        // Регистрация пользователя
        driver.get("https://stellarburgers.nomoreparties.site/register");
        String email = TestsHelper.generateEmail();
        String password = "qazWSX_12345";
        registerPage.register("Аполлинария", email, password);
        loginPage.waitForLoad();
        assertEquals(loginLabel, loginPage.getTitleLogin());

        // Логин пользователя
        loginPage.login(email, password);
        homePage.waitForLoad();

        // Переход в Личный кабинет
        homePage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertEquals(profileLabel, personalAccountPage.getTitleProfileLabel());
    }
}
