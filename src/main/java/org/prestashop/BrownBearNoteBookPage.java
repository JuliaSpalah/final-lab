package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class BrownBearNoteBookPage extends BasePage {
    @FindBy(xpath = "//select[@id='group_4']")
    private WebElement paperType;

    @FindBy(xpath = "//option[@value='25']")
    private WebElement dotedPaperTypeInDropDown;

    @FindBy(xpath = "//div[@class='input-group bootstrap-touchspin']//input[@type='number']")
    private WebElement quantity;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//h4[@id='myModalLabel']")
    private WebElement messageProductAddedToCart;

    @FindBy(xpath = "//span[@class='paper type']/strong[text()=' Doted']")
    private WebElement doted;

    @FindBy(xpath = "//span[@class='product-quantity']/strong[text()='5']")
    private WebElement orderedQuantity5;

    public BrownBearNoteBookPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public BrownBearNoteBookPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public BrownBearNoteBookPage clickOnPaperType() {
        log.info("Click on paper type");
        paperType.click();
        return this;
    }

    public BrownBearNoteBookPage clickOnDoted() {
        log.info("Click on Doted");
        dotedPaperTypeInDropDown.click();
        return this;
    }

    public BrownBearNoteBookPage clickOnQuantity() {
        log.info("Click on quantity");
        quantity.click();
        return this;
    }

    public BrownBearNoteBookPage deleteQuantityValue() {
        log.info("Delete quantity value");
        quantity.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public BrownBearNoteBookPage setValueToQuantityField() {
        log.info("Set value to quantity field");
        quantity.sendKeys("5");
        return this;
    }

    public BrownBearNoteBookPage clickOnAddToCart() {
        log.info("Click on add to cart");
        buttonAddToCart.click();
        return this;
    }

    public boolean getMessageProductSuccessfullyAddedToCart() {
        log.info("Get message Product successfully added to cart");
        return messageProductAddedToCart.isDisplayed();
    }

    public String getOrderedPaperType() {
        log.info("Get ordered paper type");
        return doted.getText();
    }

    public String getOrderedQuantity() {
        log.info("Get ordered quantity");
        return orderedQuantity5.getText();
    }

}
