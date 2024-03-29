package org.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> getDriverThread() {
        return driverThread;
    }

    public static void setDriver(WebDriver webDriver) {
        driverThread.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public void switchToDemoShopIFrame() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("framelive")));
    }

    public void disableAutocomplete(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('autocomplete', 'off');", element);
    }
}
