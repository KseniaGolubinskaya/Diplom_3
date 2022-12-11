import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.RegisterPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedRegisterWithIncorrectPasswordTests {
    private WebDriver driver;
    private final String userNameField;
    private final String passwordField;
    private RegisterPage registerPage;
    private final String result = "Некорректный пароль";

    public ParametrizedRegisterWithIncorrectPasswordTests(String userNameField, String passwordField) {
        this.userNameField = userNameField;
        this.passwordField = passwordField;
    }

    @Parameterized.Parameters
    public static Object[][] getRegister() {
        return new Object[][]{
                {"Аполлинария", "qazWS"},
                {"Аполлинария", "qaz"},
                {"Аполлинария", "q"},
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage = new RegisterPage(driver);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Ошибка при регистрации с некорректным паролем (менее 6 символов)
     */
    @Test
    public void incorrectPasswordFailedTest() {
        String email = RandomStringUtils.randomAlphabetic(10) + '@' + RandomStringUtils.randomAlphabetic(5) + '.' + RandomStringUtils.randomAlphabetic(3);
        registerPage.register(userNameField, email, passwordField);
        assertEquals(result, registerPage.getIncorrectPasswordLabel());
    }
}
