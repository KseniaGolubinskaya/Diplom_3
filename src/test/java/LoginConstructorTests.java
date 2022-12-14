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
        TestsHelper.registerAndLoginUser(driver, registerPage, loginPage, homePage, loginLabel);
        TestsHelper.goToProfile(homePage, personalAccountPage, profileLabel);

        personalAccountPage.clickConstructorButton();
        constructorPage.waitForLoad();
        assertEquals(makeBurgerLabel, constructorPage.getConstructorBurgerTitle());
    }

    /**
     * Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers
     */
    @Test
    public void loginLogoSuccessTest() {
        TestsHelper.registerAndLoginUser(driver, registerPage, loginPage, homePage, loginLabel);
        TestsHelper.goToProfile(homePage, personalAccountPage, profileLabel);

        personalAccountPage.clickLogoStellarBurgers();
        constructorPage.waitForLoad();
        assertEquals(makeBurgerLabel, constructorPage.getConstructorBurgerTitle());
    }
}
