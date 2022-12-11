package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private final WebDriver driver;

    // Локатор надписи "Соберите бургер"
    private final By titleConstructorBurger = By.xpath("//h1[text()='Соберите бургер']");

    // Локатор раздела "Булки"
    private final By sectionBuns = By.xpath("//span[text()='Булки']");

    // Локатор раздела "Соусы"
    private final By sectionSauces = By.xpath("//span[text()='Соусы']");

    // Локатор раздела "Начинки"
    private final By sectionFillings = By.xpath("//span[text()='Начинки']");

    // Локатор надписи "Булки"
    private final By titleBuns = By.xpath("//h2[text()='Булки']");

    // Локатор надписи "Соусы"
    private final By titleSauces = By.xpath("//h2[text()='Соусы']");

    // Локатор надписи "Начинки"
    private final By titleFillings = By.xpath("//h2[text()='Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод перехода в раздел "Булки"
     */
    public void goToSectionBuns() {
        driver.findElement(sectionBuns).click();
    }

    /**
     * Метод перехода в раздел "Соусы"
     */
    public void goToSectionSauces() {
        driver.findElement(sectionSauces).click();
    }

    /**
     * Метод перехода в раздел "Начинки"
     */
    public void goToSectionFillings() {
        driver.findElement(sectionFillings).click();
    }

    /**
     * Метод обнаружения на странице надписи "Соберите бургер"
     */
    public String getConstructorBurgerTitle() {
        return driver.findElement(titleConstructorBurger).getText();
    }

    /**
     * Метод обнаружения на странице надписи "Булки"
     */
    public WebElement isTitleBuns() {
        return driver.findElement(titleBuns);
    }

    /**
     * Метод обнаружения на странице надписи "Соусы"
     */
    public WebElement isTitleSauces() {
        return driver.findElement(titleSauces);
    }

    /**
     * Метод обнаружения на странице надписи "Начинки"
     */
    public WebElement isTitleFillings() {
        return driver.findElement(titleFillings);
    }

    /**
     * Метод ожидания загрузки страницы
     */
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(titleBuns));
    }
}
