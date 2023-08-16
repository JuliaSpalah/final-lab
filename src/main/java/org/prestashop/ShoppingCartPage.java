package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;

@Slf4j
public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']//span[@class='value']")
    private WebElement total;

    @FindBy(xpath = "//ul[@class='cart-items']//span[@class='product-price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    private WebElement proceedToCheckout;

    public ShoppingCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShoppingCartPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public boolean checkTotalSum() {
        log.info("Check total sum");
        double sumOfOrderedProducts = productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .reduce(0.0, Utils::sumPrice);
        double totalSum = StringUtils.extractPriceValue(total.getText());
        return sumOfOrderedProducts == totalSum;
    }

    public PersonalInformationPage clickOnProceedToCheckOut() {
        log.info("Click on Proceed to checkout");
        proceedToCheckout.click();
        return new PersonalInformationPage();
    }

}
