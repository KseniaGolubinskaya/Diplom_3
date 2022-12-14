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
    private final String loginLabel = "Вход";

    @Before
    public void setUp() {
        driver = TestsHelper.getDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
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
        EmailAndPassword emailAndPassword = TestsHelper.registerUser(driver, registerPage, loginPage, loginLabel);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickSignInAccountButton();
        loginPage.waitForLoad();
        loginPage.login(emailAndPassword.getEmail(), emailAndPassword.getPassword());
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку «Личный кабинет»
     */
    @Test
    public void loginFromPersonalAccountSuccessTest() {
        EmailAndPassword emailAndPassword = TestsHelper.registerUser(driver, registerPage, loginPage, loginLabel);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickPersonalAccountButton();
        loginPage.waitForLoad();
        loginPage.login(emailAndPassword.getEmail(), emailAndPassword.getPassword());
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку "Войти" в форме регистрации
     */
    @Test
    public void loginFromRegisterSuccessTest() {
        EmailAndPassword emailAndPassword = TestsHelper.registerUser(driver, registerPage, loginPage, loginLabel);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage.clickSignInButton();
        loginPage.waitForLoad();
        loginPage.login(emailAndPassword.getEmail(), emailAndPassword.getPassword());
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }

    /**
     * Вход через кнопку в форме восстановления пароля
     */
    @Test
    public void loginFromRecoveryPasswordSuccessTest() {
        EmailAndPassword emailAndPassword = TestsHelper.registerUser(driver, registerPage, loginPage, loginLabel);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        recoveryPasswordPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.login(emailAndPassword.getEmail(), emailAndPassword.getPassword());
        homePage.waitForLoad();
        assertEquals(makeOrderLabel, homePage.getMakeOrderButton());
    }
}
