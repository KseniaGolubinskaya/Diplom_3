package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    // локатор поля ввода "Имя"
    private final By selectNameField = By.xpath(".//label[(@class='input__placeholder text noselect text_type_main-default' and text() = «Имя»)]");

    // локатор поля ввода "Email"
    private final By selectEmailField = By.xpath(".//label[@value='Email']//input");

    // локатор поля ввода "Пароль"
    private final By selectPasswordField = By.xpath(".//label[@value='Пароль']//input");

    // локатор кнопки "Зарегистрироваться"
    private final By selectRegisterButton = By.linkText("Зарегистрироваться");

    // локатор кнопки "Войти"
    private final By selectLoginButtonOnRegisterPage = By.linkText("Войти");

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
    public void register(String username, String email, String password){
        setUsername(username);
        setUserEmail(email);
        setUserPassword(password);
        clickRegisterButton();
    }
}
