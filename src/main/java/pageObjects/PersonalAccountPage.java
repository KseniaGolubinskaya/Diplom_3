package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // локатор кнопки "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    // локатор логотипа Stellar Burgers
    private final By logoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");

    // локатор кнопки "Выход"
    private final By quitButton = By.xpath(".//button[text()='Выход']");

    // Локатор надписи "Профиль"
    private final By titleProfile = By.xpath(".//a[text()='Профиль']");

    /**
     * Метод нажатия на кнопку "Конструктор"
     */
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    /**
     * Метод нажатия на логотип Stellar Burgers
     */
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    /**
     * Метод нажатия на кнопку "Выход"
     */
    public void clickQuitButton() {
        driver.findElement(quitButton).click();
    }

    /**
     * Метод обнаружения на странице надписи "Профиль"
     */
    public String getTitleProfileLabel() {
        return driver.findElement(titleProfile).getText();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(titleProfile));
    }
}
