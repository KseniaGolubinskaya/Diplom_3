import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.RegisterPage;
import pageObjects.SignInPage;

import static org.junit.Assert.assertEquals;

public class RegisterTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private SignInPage signInPage;
    private final String result = "Вход";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage = new RegisterPage(driver);
        signInPage = new SignInPage(driver);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Проверка успешной регистрации
     */
    @Test
    public void successRegistrationTest() {
        String email = RandomStringUtils.randomAlphabetic(10) + '@' + RandomStringUtils.randomAlphabetic(5) + '.' + RandomStringUtils.randomAlphabetic(3);
        registerPage.register("Аполлинария", email, "qazWSX_12345");
        signInPage.waitForLoadLoginPage();
        assertEquals(result, signInPage.getTitleLogin());
    }
}
