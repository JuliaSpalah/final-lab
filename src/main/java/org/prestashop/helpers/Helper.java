package org.prestashop.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.prestashop.BasePage;

public class Helper {
    @Attachment(value = "{filename}", type = "image/png")
    public static byte[] makeScreenshot(String fileName){
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
