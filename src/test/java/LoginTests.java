import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.RecoveryPasswordPage;
import pageObjects.RegisterPage;

import static org.junit.Assert.assertEquals;

public class LoginTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private SignInPage signInPage;
    private HomePage homePage;
    private RecoveryPasswordPage recoveryPasswordPage;
    private final String result = "Соберите бургер";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        registerPage = new RegisterPage(driver);
        signInPage = new SignInPage(driver);
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
        homePage.clickSignInAccountButton();
        signInPage.login("apollo@yandex.ru", "qazWSX_12345");
        assertEquals(result, homePage.isTitleConstructorBurger());
    }

    /**
     * Вход через кнопку «Личный кабинет»
     */
    @Test
    public void loginFromPersonalAccountSuccessTest() {
        homePage.clickPersonalAccountButton();
        signInPage.login("apollo@yandex.ru", "qazWSX_12345");
        assertEquals(result, homePage.isTitleConstructorBurger());
    }

    /**
     * Вход через кнопку "Войти" в форме регистрации
     */
    @Test
    public void loginFromRegisterSuccessTest(){
        homePage.clickPersonalAccountButton();
        registerPage.clickSignInButton();
        signInPage.login("apollo@yandex.ru", "qazWSX_12345");
        assertEquals(result, homePage.isTitleConstructorBurger());
    }

    /**
     * вход через кнопку в форме восстановления пароля
     */
    @Test
    public void loginFromRecoveryPasswordSuccessTest(){
        homePage.clickPersonalAccountButton();
        signInPage.clickRecoveryPasswordButton();
        recoveryPasswordPage.clickSignInButton();
        assertEquals(result, homePage.isTitleConstructorBurger());
    }
}
