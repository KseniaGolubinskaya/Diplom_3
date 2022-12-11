package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // локатор поля ввода "Email"
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");

    // локатор поля ввода "Пароль"
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");

    // локатор кнопки "Войти"
    private final By signInButton = By.xpath("//button[text()='Войти']");

    // локатор кнопки "Зарегистрироваться"
    private final By registerButton = By.xpath(".//a[@href='/register']");

    // локатор кнопки "Восстановить пароль"
    private final By recoveryPasswordButton = By.xpath(".//a[@href='/forgot-password']");

    // локатор надписи "Вход"
    private final By titleLogin = By.xpath(".//h2[text()='Вход']");

    // конструктор класса LoginFromPersonalAccountPage
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Метод для заполнения поля "Email"
     */
    public void setUserEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Метод для заполнения поля "Пароль"
     */
    public void setUserPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Метод нажатия на кнопку "Войти"
     */
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    /**
     * Метод - шаг для входа
     */
    public void login(String email, String password) {
        setUserEmail(email);
        setUserPassword(password);
        clickSignInButton();
    }

    /**
     * Метод нажатия на кнопку "Войти"
     */
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    /**
     * Метод нажатия на кнопку "Восстановить пароль"
     */
    public void clickRecoveryPasswordButton() {
        driver.findElement(recoveryPasswordButton).click();
    }

    /**
     * Метод обнаружения на странице надписи "Вход"
     */
    public String getTitleLogin() {
        return driver.findElement(titleLogin).getText();
    }

    /**
     * Метод ожидания загрузки страницы логина
     */
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(titleLogin));
    }
}
