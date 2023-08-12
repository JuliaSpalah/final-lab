package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

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
        Utils.waitSeconds(seconds);
        return this;
    }

    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .collect(Collectors.toList());
    }

    public boolean checkTotalSum() {
        double sumOfOrderedProducts = productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .reduce(0.0, Double::sum);
        double totalSum = StringUtils.extractPriceValue(total.getText());
        return sumOfOrderedProducts == totalSum;
    }

    public PersonalInformationPage clickOnProceedToCheckOut() {
        proceedToCheckout.click();
        return new PersonalInformationPage();
    }

}
