package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementActions {

    public static void Wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void clickElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].click();", element);
    }
}
