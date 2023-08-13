package org.prestashop;

import lombok.extern.slf4j.Slf4j;
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

    public boolean checkIfAmountEqualsToSubtotalAndShipping(){
        log.info("Check if amount equals to Subtotal+Shipping");
        double sumOfSubtotalAndShipping = subtotalAndShippingValues.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .reduce(0.0, Double::sum);
        double amount = StringUtils.extractPriceValue(amountValue.getText());
        return sumOfSubtotalAndShipping == amount;
    }


}
