import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.prestashop.BasePage;
import org.prestashop.BrowserFactory;
import org.prestashop.BrowserTypes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    @BeforeMethod
    public synchronized void setUp() {
        int width = Integer.parseInt(System.getProperty("browser.width"));
        int height = Integer.parseInt(System.getProperty("browser.height"));
        String browser = System.getProperty("browser.type");
        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserTypes.valueOf(browser));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void quite() {
        BasePage.getDriver().quit();
    }
}