import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.ConstructorPage;
import pageObjects.HomePage;
import pageObjects.PersonalAccountPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginConstructorTests {
    private WebDriver driver;
    private PersonalAccountPage personalAccountPage;
    private ConstructorPage constructorPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private final String result = "Соберите бургер";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        personalAccountPage = new PersonalAccountPage(driver);
        homePage.clickSignInAccountButton();
        loginPage.login("apollo@yandex.ru", "qazWSX_12345");
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
    public void signInConstructorSuccessTest() {
        personalAccountPage.clickConstructorButton();
        assertEquals(result, constructorPage.isTitleConstructorBurger());
    }

    /**
     * Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers
     */
    @Test
    public void signInLogoSuccessTest() {
        personalAccountPage.clickLogoStellarBurgers();
        assertEquals(result, constructorPage.isTitleConstructorBurger());
    }
}
