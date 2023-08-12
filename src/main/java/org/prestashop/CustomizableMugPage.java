package org.prestashop;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CustomizableMugPage extends BasePage {

    @FindBy(xpath = "//textarea[@class='product-message']")
    private WebElement productCustomizationTextField;

    @FindBy(xpath = "//button[@class='btn btn-primary float-xs-right']")
    private WebElement buttonSaveCustomization;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantity;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    private WebElement continueShopping;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    private WebElement searchField;

    public CustomizableMugPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CustomizableMugPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public CustomizableMugPage setBestMugEverToTextField() {
        productCustomizationTextField.sendKeys("Best mug ever");
        return this;
    }

    public CustomizableMugPage clickOnSaveCustomization() {
        buttonSaveCustomization.click();
        return this;
    }

    public CustomizableMugPage clearQuantityField() {
        quantity.clear();
        return this;
    }

    public CustomizableMugPage setValueToQuantityField() {
        quantity.sendKeys("1");
        return this;
    }

    public CustomizableMugPage clickOnAddToCart() {
        buttonAddToCart.click();
        return this;
    }

    public CustomizableMugPage clickOnContinueShopping() {
        continueShopping.click();
        return this;
    }

    public CustomizableMugPage setTShirtToSearchField() {
        searchField.sendKeys("T-shirt");
        return this;
    }

    public SearchResultPage pressEnter() {
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }

}
