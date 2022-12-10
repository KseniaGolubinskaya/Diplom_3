import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedRegisterWithIncorrectPasswordTests {
    private final String userNameField;
    private final String emailField;
    private final String passwordField;
    private final String result = "Некорректный пароль";

    public ParametrizedRegisterWithIncorrectPasswordTests(String userNameField, String emailField, String passwordField, boolean result) {
        this.userNameField = userNameField;
        this.emailField = emailField;
        this.passwordField = passwordField;
    }

    @Parameterized.Parameters
    public static Object[][] getRegister() {
        return new Object[][] {
                { "Аполлинария", "apollo@yandex.ru", "qazWS"},
                { "Аполлинария", "apollo@yandex.ru", "qaz"},
                { "Аполлинария", "apollo@yandex.ru", "q"},
        };
    }

    /**
     * Ошибка при регистрации с некорректным паролем (менее 6 символов)
     */
    @Test
    public void incorrectPasswordFailedTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.findElement(By.xpath(".//label[@value='Имя']//input")).sendKeys(userNameField);
        driver.findElement(By.xpath(".//label[@value='Email']//input")).sendKeys(emailField);
        driver.findElement(By.xpath(".//label[@value='Пароль']//input")).sendKeys(passwordField);
        driver.findElement(By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa")).click();

        assertEquals(result, driver.findElement(By.className("class=input__error text_type_main-default")));
    }
}
