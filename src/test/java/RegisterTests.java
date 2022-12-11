import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.RegisterPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class RegisterTests {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private final String loginLabel = "Вход";

    @Before
    public void setUp() {
        driver = TestsHelper.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
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
        String email = TestsHelper.generateEmail();
        registerPage.register("Аполлинария", email, "qazWSX_12345");
        loginPage.waitForLoad();
        assertEquals(loginLabel, loginPage.getTitleLogin());
    }
}
