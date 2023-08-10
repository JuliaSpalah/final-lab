package org.prestashop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

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
        Utils.waitSeconds(seconds);
        return this;
    }

    public BrownBearNoteBookPage clickOnPaperType() {
        paperType.click();
        return this;
    }

    public BrownBearNoteBookPage clickOnDoted() {
        dotedPaperTypeInDropDown.click();
        return this;
    }

    public BrownBearNoteBookPage clickOnQuantity() {
        quantity.click();
        return this;
    }

    public BrownBearNoteBookPage deleteQuantityValue() {
        quantity.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public BrownBearNoteBookPage setValueToQuantityField() {
        quantity.sendKeys("5");
        return this;
    }

    public BrownBearNoteBookPage clickOnAddToCart() {
        buttonAddToCart.click();
        return this;
    }

    public boolean getMessageProductSuccessfullyAddedToCart() {
        return messageProductAddedToCart.isDisplayed();
    }

    public String getOrderedPaperType() {
        return doted.getText();
    }

    public String getOrderedQuantity() {
        return orderedQuantity5.getText();
    }

}
