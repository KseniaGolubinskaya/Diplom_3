import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import static org.junit.Assert.assertEquals;

public class GoToSectionsTests {
    private WebDriver driver;
    private ConstructorPage constructorPage;
    private final String resultBuns = "Булки";
    private final String resultSauces = "Соусы";
    private final String resultFillings = "Начинки";

    @Before
    public void setUp() {
        driver = TestsHelper.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        constructorPage = new ConstructorPage(driver);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    /**
     * Переход к разделу "Булки"
     */
    @Test
    public void goToBunsSuccessTest() {
        constructorPage.goToSectionSauces();
        constructorPage.goToSectionBuns();
        assertEquals(resultBuns, constructorPage.getSectionBunsSelected());
    }

    /**
     * Переход к разделу "Соусы"
     */
    @Test
    public void goToSaucesSuccessTest() {
        constructorPage.goToSectionSauces();
        assertEquals(resultSauces, constructorPage.getSectionSaucesSelected());
    }

    /**
     * Переход к разделу "Начинки"
     */
    @Test
    public void goToFillingsSuccessTest() {
        constructorPage.goToSectionFillings();
        assertEquals(resultFillings, constructorPage.getSectionFillingsSelected());
    }
}
