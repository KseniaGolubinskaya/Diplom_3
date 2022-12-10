package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private final WebDriver driver;

    // локатор поля ввода "Email"
    private final By emailField = By.xpath(".//label[@value='Email']//input");

    // локатор поля ввода "Пароль"
    private final By passwordField = By.xpath(".//label[@value='Пароль']//input");

    // локатор кнопки "Войти"
    private final By signInButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");

    // локатор кнопки "Зарегистрироваться"
    private final By registerButton = By.xpath(".//a[@href='/register']");

    // локатор кнопки "Восстановить пароль"
    private final By recoveryPasswordButton = By.xpath(".//a[@href='/forgot-password']");

    // локатор надписи "Вход"
    private final By titleLogin = By.className("Auth_login__3hAey");

    // конструктор класса LoginFromPersonalAccountPage
    public SignInPage(WebDriver driver) {
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
    public void login(String email, String password){
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
    public WebElement isTitleLogin() {
        return driver.findElement(titleLogin);
    }
}
