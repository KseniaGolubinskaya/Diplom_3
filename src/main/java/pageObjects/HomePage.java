package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    private final By signInAccountButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");

    // Локатор кнопки "Личный кабинет"
    private final By personalAccountButton = By.className("AppHeader_header__linkText__3q_va ml-2");

    // Локатор надписи "Соберите бургер"
    private final By titleConstructorBurger = By.className("class=text text_type_main-large mb-5 mt-10");

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
    public WebElement isTitleConstructorBurger() {
        return driver.findElement(titleConstructorBurger);
    }
}
