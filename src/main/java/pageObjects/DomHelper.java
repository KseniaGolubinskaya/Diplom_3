package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class DomHelper {
    public static void findAndClick(By by, WebDriver driver) {
        StaleElementReferenceException lastException = null;
        int attempts = 0;
        while(attempts < 4) {
            try {
                driver.findElement(by).click();
                break;
            } catch(StaleElementReferenceException e) {
                lastException = e;
            }
            attempts++;
        }

        if(lastException != null) {
            throw lastException;
        }
    }
}
