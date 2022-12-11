import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RecoveryPasswordPage;
import pageObjects.RegisterPage;

import static org.junit.Assert.assertEquals;

public class LoginTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private RecoveryPasswordPage recoveryPasswordPage;
    private final String makeOrderLabel = "Оформить заказ";
    private String email;
    private String password;

    @Before
    public void setUp() {
        driver = TestsHelper.getDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);

        // Создание пользователя
        driver.get("https://stellarburgers.nomoreparties.site/register");
        email = TestsHelper.generateEmail();
        password = "qazWSX_12345";
        registerPage.register("Аполлинария", email, password);
        loginPage.waitForLoad();
        assertEquals("Вход", loginPage.getTitleLogin());
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Вход по кнопке «Войти в аккаунт» на главной странице
     */
    @Test
    public void loginWithSignInAccountSuccessTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickSignInAccountButton();
        loginPage.waitForLoad();
        loginPage.login(email, password);
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку «Личный кабинет»
     */
    @Test
    public void loginFromPersonalAccountSuccessTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickPersonalAccountButton();
        loginPage.waitForLoad();
        loginPage.login(email, password);
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку "Войти" в форме регистрации
     */
    @Test
    public void loginFromRegisterSuccessTest() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage.clickSignInButton();
        loginPage.waitForLoad();
        loginPage.login(email, password);
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку в форме восстановления пароля
     */
    @Test
    public void loginFromRecoveryPasswordSuccessTest() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        recoveryPasswordPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.login(email, password);
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }
}
