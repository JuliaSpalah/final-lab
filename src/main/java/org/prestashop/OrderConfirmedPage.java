package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

@Slf4j
public class OrderConfirmedPage extends BasePage {

    @FindBy(xpath = "//h3[@class='h1 card-title']")
    private WebElement orderConfirmation;

    @FindBy(xpath = "//tr[td[text()='Subtotal']]/td[2]")
    private WebElement subtotalOnPaymentPage;

    @FindBy(xpath = "//tr[td[text()='Shipping and handling']]/td[2]")
    private WebElement shippingAndHandling;

    @FindBy(xpath = "//tr[@class='total-value font-weight-bold']")
    private WebElement totalOnConfirmationPage;

    public OrderConfirmedPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmedPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public String getOrderConfirmationMessage() {
        log.info("Get order confirmation message");
        return orderConfirmation.getText();
    }

    public boolean checkIfTotalCorrect() {
        log.info("Check if Total is correct");
        double subtotalNumber = StringUtils.extractPriceValue(subtotalOnPaymentPage.getText());
        double shippingAndHandlingNumber = StringUtils.extractPriceValue(shippingAndHandling.getText());
        double totalNumber = StringUtils.extractPriceValue(totalOnConfirmationPage.getText());
        double sumOfSubtotalAndShippingAndHandling = Utils.sanitizePrice(subtotalNumber + shippingAndHandlingNumber);
        return sumOfSubtotalAndShippingAndHandling == totalNumber;
    }


}
