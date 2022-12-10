package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // локатор кнопки "Конструктор"
    private final By constructorButton = By.className("AppHeader_header__linkText__3q_va ml-2");

    // локатор логотипа Stellar Burgers
    private final By logoStellarBurgers = By.xpath("AppHeader_header__linkText__3q_va ml-2");

    // локатор кнопки "Выход"
    private final By quitButton = By.xpath("Account_button__14Yp3 text text_type_main-medium text_color_inactive");

    // Локатор надписи "Профиль"
    private final By titleProfile = By.className("Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9");

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
    public WebElement isTitleProfile() {
        return driver.findElement(titleProfile);
    }
}
