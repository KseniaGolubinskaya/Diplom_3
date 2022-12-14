import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PersonalAccountPage;
import pageObjects.RegisterPage;

import static org.junit.Assert.assertEquals;

public class TestsHelper {
    private final static boolean useYandex = false;

    public static String generateEmail() {
        return RandomStringUtils.randomAlphabetic(10) + '@' + RandomStringUtils.randomAlphabetic(5) + '.' + RandomStringUtils.randomAlphabetic(3);
    }

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        if (useYandex) {
            System.setProperty("webdriver.chrome.driver", "D:\\ksenia\\Diplom\\QA-java-diplom-3\\yandexdriver.exe");
            options.setBinary("C:\\Users\\denis\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        }
        return new ChromeDriver(options);
    }

    /**
     * Регистрация пользователя
     */
    public static EmailAndPassword registerUser(WebDriver driver, RegisterPage registerPage, LoginPage loginPage, String loginLabel){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        String email = generateEmail();
        String password = "qazWSX_12345";
        registerPage.register("Аполлинария", email, password);
        loginPage.waitForLoad();
        assertEquals(loginLabel, loginPage.getTitleLogin());
        return new EmailAndPassword(email, password);
    }

    /**
     * Регистрация и логин пользователя
     */
    public static void registerAndLoginUser(WebDriver driver, RegisterPage registerPage, LoginPage loginPage, HomePage homePage, String loginLabel){
        EmailAndPassword emailAndPassword = registerUser(driver, registerPage, loginPage, loginLabel);
        loginPage.login(emailAndPassword.getEmail(), emailAndPassword.getPassword());
        homePage.waitForLoad();
    }

    /**
     * Переход в Личный кабинет
     */
    public static void goToProfile(HomePage homePage, PersonalAccountPage personalAccountPage, String profileLabel) {
        homePage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertEquals(profileLabel, personalAccountPage.getTitleProfileLabel());
    }


}