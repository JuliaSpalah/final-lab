package org.prestashop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getBrowserInstance(BrowserTypes browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*", "--incognito");
                return new ChromeDriver(chromeOptions);
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }
}
