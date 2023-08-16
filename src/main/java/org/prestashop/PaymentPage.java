package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;

@Slf4j
public class PaymentPage extends BasePage {

    @FindBy(xpath = "//input[@id='payment-option-3']")
    private WebElement payByCheckOption;
    @FindBy(xpath = "//div[@class='card-block cart-summary-subtotals-container js-cart-summary-subtotals-container']//span[@class='value']")
    private List<WebElement> subtotalAndShippingValues;

    @FindBy(xpath = "//section/dl[dt[text()='Amount']]/dd[1]")
    private WebElement amountValue;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement iAgree;

    @FindBy(xpath = "//div[@class='ps-shown-by-js']//button[@type='submit']")
    private WebElement placeOrderButton;

    public PaymentPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public PaymentPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public PaymentPage selectOptionPayByCheck() {
        log.info("Select option Pay by check");
        payByCheckOption.click();
        return this;
    }

    public boolean checkIfAmountEqualsToSubtotalAndShipping() {
        log.info("Check if amount equals to Subtotal+Shipping");
        double sumOfSubtotalAndShipping = subtotalAndShippingValues.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .reduce(0.0, Utils::sumPrice);
        double amount = StringUtils.extractPriceValue(amountValue.getText());
        return sumOfSubtotalAndShipping == amount;
    }

    public PaymentPage clickOnIAgree() {
        log.info("Click on I agree");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", iAgree);
        return this;
    }

    public OrderConfirmedPage clickOnPlaceOrderButton() {
        log.info("Click on Place order button");
        placeOrderButton.click();
        return new OrderConfirmedPage();
    }


}
