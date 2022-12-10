package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage {
    private final WebDriver driver;
    // Локатор надписи "Соберите бургер"
    private final By titleConstructorBurger = By.className("class=text text_type_main-large mb-5 mt-10");

    // Локатор раздела "Булки"
    private final By sectionBuns = By.xpath("");

    // Локатор раздела "Соусы"
    private final By sectionSauces = By.xpath("");

    // Локатор раздела "Начинки"
    private final By sectionFillings = By.xpath("");

    // Локатор надписи "Булки"
    private final By titleBuns = By.className("text text_type_main-medium mb-6 mt-10");

    // Локатор надписи "Соусы"
    private final By titleSauces = By.className("text text_type_main-medium mb-6 mt-10");

    // Локатор надписи "Начинки"
    private final By titleFillings = By.className("text text_type_main-medium mb-6 mt-10");

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
    public WebElement isTitleConstructorBurger() {
        return driver.findElement(titleConstructorBurger);
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
}
