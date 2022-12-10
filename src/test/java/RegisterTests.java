import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // TODO: Вернуть "--headless"
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registerPage = new RegisterPage(driver);
    }

//    @After
//    public void tearDown() {
//        // Закрыть браузер
//        driver.quit();
//    }

    /**
     * Проверка успешной регистрации
     */
    @Test
    public void successRegistrationTest(){
        registerPage.register("Аполлинария", "apollo@yandex.ru", "qazWSX_12345");
        assertEquals(result, signInPage.isTitleLogin());
    }
}
