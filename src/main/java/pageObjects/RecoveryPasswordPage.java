package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;

    private final By SignInButton = By.className("Auth_link__1fOlj");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод нажатия на кнопку "Войти"
     */
    public void clickSignInButton() {
        driver.findElement(SignInButton).click();
    }
}
