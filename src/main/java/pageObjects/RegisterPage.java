package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    // локатор поля ввода "Имя"
    private final By selectNameField = By.xpath("//label[text()='Имя']/following-sibling::input");

    // локатор поля ввода "Email"
    private final By selectEmailField = By.xpath("//label[text()='Email']/following-sibling::input");

    // локатор поля ввода "Пароль"
    private final By selectPasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input");

    // локатор кнопки "Зарегистрироваться"
    private final By selectRegisterButton = By.xpath("//button[text()='Зарегистрироваться']");

    // локатор кнопки "Войти"
    private final By selectLoginButtonOnRegisterPage = By.xpath("//button[text()='Войти']");

    // локатор надписи "Некорректный пароль"
    private final By selectIncorrectPasswordLabel = By.className("input__error");

    // конструктор класса RegisterPage
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод для заполнения поля "Имя"
     */
    public void setUsername(String username) {
        driver.findElement(selectNameField).sendKeys(username);
    }

    /**
     * Метод для заполнения поля "Email"
     */
    public void setUserEmail(String email) {
        driver.findElement(selectEmailField).sendKeys(email);
    }

    /**
     * Метод для заполнения поля "Пароль"
     */
    public void setUserPassword(String password) {
        driver.findElement(selectPasswordField).sendKeys(password);
    }

    /**
     * Метод нажатия на кнопку "Зарегистрироваться"
     */
    public void clickRegisterButton() {
        driver.findElement(selectRegisterButton).click();
    }

    /**
     * Метод нажатия на кнопку "Войти" на странице регистрации
     */
    public void clickSignInButton() {
        driver.findElement(selectLoginButtonOnRegisterPage).click();
    }

    /**
     * Метод - шаг для регистрации
     */
    public void register(String username, String email, String password) {
        setUsername(username);
        setUserEmail(email);
        setUserPassword(password);
        clickRegisterButton();
    }

    /**
     * Метод обнаружения на странице сообщения "Некорректный пароль"
     */
    public String getIncorrectPasswordLabel() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(selectIncorrectPasswordLabel));
        return driver.findElement(selectIncorrectPasswordLabel).getText();
    }
}
