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
    private final String result = "Вход";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        personalAccountPage = new PersonalAccountPage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickSignInAccountButton();
        loginPage.login("apollo@yandex.ru", "qazWSX_12345");
        homePage.clickPersonalAccountButton();
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
        personalAccountPage.clickQuitButton();
        assertEquals(result, loginPage.getTitleLogin());
    }
}
