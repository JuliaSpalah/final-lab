package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;

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
        Utils.waitSeconds(seconds);
        return this;
    }

    public PaymentPage selectOptionPayByCheck() {
        payByCheckOption.click();
        return this;
    }

    public boolean checkIfAmountEqualsToSubtotalAndShipping(){
        double sumOfSubtotalAndShipping = subtotalAndShippingValues.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .reduce(0.0, Double::sum);
        double amount = StringUtils.extractPriceValue(amountValue.getText());
        return sumOfSubtotalAndShipping == amount;
    }


}
