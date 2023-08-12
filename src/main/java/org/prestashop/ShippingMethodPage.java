package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class ShippingMethodPage extends BasePage {

    @FindBy(xpath = "//input[@id='delivery_option_2']")
    private WebElement myCarrier;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement buttonContinue;

    public ShippingMethodPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShippingMethodPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public ShippingMethodPage clickOnMyCarrier() {
        myCarrier.click();
        return this;
    }

    public PaymentPage clickOnContinueButton() {
        buttonContinue.click();
        return new PaymentPage();
    }


}
