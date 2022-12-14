package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;

    // Локатор кнопки "Войти"
    private final By loginButton = By.xpath("//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод нажатия на кнопку "Войти"
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
