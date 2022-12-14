package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private final WebDriver driver;

    // Локатор надписи "Соберите бургер"
    private final By titleConstructorBurger = By.xpath("//h1[text()='Соберите бургер']");

    // Локатор раздела "Булки"
    private final By sectionBuns = By.xpath("//span[text()='Булки']/parent::div");

    // Локатор раздела "Соусы"
    private final By sectionSauces = By.xpath("//span[text()='Соусы']/parent::div");

    // Локатор раздела "Начинки"
    private final By sectionFillings = By.xpath("//span[text()='Начинки']/parent::div");

    // Локатор выделенного раздела "Булки"
    private final By sectionBunsSelected = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Булки']");

    // Локатор выделенного раздела "Соусы"
    private final By sectionSaucesSelected = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']");

    // Локатор выделенного раздела "Начинки"
    private final By sectionFillingsSelected = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']");

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
    public String getSectionBunsSelected() {
        return driver.findElement(sectionBunsSelected).getText();
    }

    /**
     * Метод обнаружения на странице надписи "Соусы"
     */
    public String getSectionSaucesSelected() {
        return driver.findElement(sectionSaucesSelected).getText();
    }

    /**
     * Метод обнаружения на странице надписи "Начинки"
     */
    public String getSectionFillingsSelected() {
        return driver.findElement(sectionFillingsSelected).getText();
    }

    /**
     * Метод ожидания загрузки страницы
     */
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sectionBunsSelected));
    }
}
