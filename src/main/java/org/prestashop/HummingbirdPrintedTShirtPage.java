package org.prestashop;

import io.cucumber.java.zh_cn.假如;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class HummingbirdPrintedTShirtPage extends BasePage {

    @FindBy(xpath = "//label[@aria-label='Black']")
    private WebElement colorBlack;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    private WebElement buttonProceedToCheckOut;

    public HummingbirdPrintedTShirtPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public HummingbirdPrintedTShirtPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public HummingbirdPrintedTShirtPage selectBlackColor() {
        log.info("Select black color");
        colorBlack.click();
        return this;
    }

    public HummingbirdPrintedTShirtPage clickOnAddToCart() {
        log.info("Click on Add to cart");
        buttonAddToCart.click();
        return this;
    }

    public ShoppingCartPage clickOnProceedToCheckOut() {
        log.info("Click on Proceed to checkout");
        buttonProceedToCheckOut.click();
        return new ShoppingCartPage();
    }

}
