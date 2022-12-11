import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.PersonalAccountPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class SignInPersonalAccountTests {
    private WebDriver driver;
    private HomePage homePage;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;
    private final String result = "Профиль";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage = new HomePage(driver);
        homePage.clickSignInAccountButton();
        loginPage.login("apollo@yandex.ru", "qazWSX_12345");
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
        homePage.clickPersonalAccountButton();
        assertEquals(result, personalAccountPage.isTitleProfile());
    }
}
