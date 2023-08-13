package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
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
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public CustomizableMugPage setBestMugEverToTextField() {
        log.info("Set [Best mug ever] to text field");
        productCustomizationTextField.sendKeys("Best mug ever");
        return this;
    }

    public CustomizableMugPage clickOnSaveCustomization() {
        log.info("Click on Save customization");
        buttonSaveCustomization.click();
        return this;
    }

    public CustomizableMugPage clearQuantityField() {
        log.info("Clear quantity field");
        quantity.clear();
        return this;
    }

    public CustomizableMugPage setValueToQuantityField() {
        log.info("Set value to quantity field");
        quantity.sendKeys("1");
        return this;
    }

    public CustomizableMugPage clickOnAddToCart() {
        log.info("Click on Add to cart");
        buttonAddToCart.click();
        return this;
    }

    public CustomizableMugPage clickOnContinueShopping() {
        log.info("Click on Continue shopping");
        continueShopping.click();
        return this;
    }

    public CustomizableMugPage setTShirtToSearchField() {
        log.info("Set T-shirt to search field");
        searchField.sendKeys("T-shirt");
        return this;
    }

    public SearchResultPage pressEnter() {
        log.info("Press enter");
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }

}
