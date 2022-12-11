import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import static org.junit.Assert.assertEquals;

public class LoginConstructorTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private PersonalAccountPage personalAccountPage;
    private ConstructorPage constructorPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private final String makeBurgerLabel = "Соберите бургер";
    private final String loginLabel = "Вход";
    private final String profileLabel = "Профиль";

    @Before
    public void setUp() {
        driver = TestsHelper.getDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        constructorPage = new ConstructorPage(driver);

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

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Переход из личного кабинета в конструктор по клику на кнопку «Конструктор»
     */
    @Test
    public void loginConstructorSuccessTest() {
        personalAccountPage.clickConstructorButton();
        constructorPage.waitForLoad();
        assertEquals(makeBurgerLabel, constructorPage.getConstructorBurgerTitle());
    }

    /**
     * Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers
     */
    @Test
    public void loginLogoSuccessTest() {
        personalAccountPage.clickLogoStellarBurgers();
        constructorPage.waitForLoad();
        assertEquals(makeBurgerLabel, constructorPage.getConstructorBurgerTitle());
    }
}
