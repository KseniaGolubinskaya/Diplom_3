import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;

import static org.junit.Assert.assertEquals;

public class QuitFromAccountTests {
    private WebDriver driver;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private RegisterPage registerPage;
    private ConstructorPage constructorPage;
    private final String loginLabel = "Вход";
    private final String profileLabel = "Профиль";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        personalAccountPage = new PersonalAccountPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        constructorPage = new ConstructorPage(driver);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Выход из аккаунта по кнопке «Выход» в личном кабинете
     */
    @Test
    public void loginWithSignInAccountSuccessTest() {
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

        // Выход из аккаунта
        personalAccountPage.clickQuitButton();
        loginPage.waitForLoad();
        assertEquals(loginLabel, loginPage.getTitleLogin());
    }
}
