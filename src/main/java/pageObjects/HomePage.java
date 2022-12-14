package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    private final By signInAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    // Локатор кнопки "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // Локатор кнопки "Оформить заказ"
    private final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод нажатия на кнопку "Войти в аккаунт"
     */
    public void clickSignInAccountButton() {
        driver.findElement(signInAccountButton).click();
    }

    /**
     * Метод нажатия на кнопку "Личный кабинет"
     */
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    /**
     * Метод обнаружения на странице надписи "Соберите бургер"
     */
    public String getMakeOrderButton() {
        return driver.findElement(makeOrderButton).getText();
    }

    /**
     * Метод ожидания загрузки основной страницы
     */
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
    }
}
