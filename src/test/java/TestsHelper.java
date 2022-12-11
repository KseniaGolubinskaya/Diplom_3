import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestsHelper {
    private final static boolean useYandex = false;

    public static String generateEmail() {
        return RandomStringUtils.randomAlphabetic(10) + '@' + RandomStringUtils.randomAlphabetic(5) + '.' + RandomStringUtils.randomAlphabetic(3);
    }

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", /*"--headless",*/ "--disable-dev-shm-usage");
        if (useYandex) {
            System.setProperty("webdriver.chrome.driver", "D:\\ksenia\\Diplom\\QA-java-diplom-3\\yandexdriver.exe");
            options.setBinary("C:\\Users\\denis\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        }
        return new ChromeDriver(options);
    }
}