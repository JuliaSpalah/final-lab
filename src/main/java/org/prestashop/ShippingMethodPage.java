package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;
@Slf4j

public class ShippingMethodPage extends BasePage {

    @FindBy(xpath = "//input[@id='delivery_option_2']")
    private WebElement myCarrier;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement buttonContinue;

    public ShippingMethodPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShippingMethodPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public ShippingMethodPage clickOnMyCarrier() {
        log.info("Click on My carrier");
        myCarrier.click();
        return this;
    }

    public PaymentPage clickOnContinueButtonOnShippingPage() {
        log.info("Click on Continue button on Shipping page");
        buttonContinue.click();
        return new PaymentPage();
    }


}
