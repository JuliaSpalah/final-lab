package org.prestashop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class AllProductsPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//h2[@class='h3 product-title']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//li/a[@rel='next']")
    private WebElement buttonNext;

    @FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='select-list js-search-link'][2]")
    private WebElement nameAtoZ;

    @FindBy(xpath = "//li/a[@rel='prev']")
    private WebElement buttonPrevious;

    @FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='select-list js-search-link'][3]")
    private WebElement nameZtoA;

    @FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='select-list js-search-link'][4]")
    private WebElement priceLowToHigh;

    @FindBy(xpath = "//div[@class='product-price-and-shipping']/span[1]")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='select-list js-search-link'][5]")
    private WebElement priceHighToLow;


    public AllProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public AllProductsPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public AllProductsPage clickOnSortByDropdown() {
        sortByDropdown.click();
        return this;
    }

    public AllProductsPage selectNameOrderAtoZ() {
        nameAtoZ.click();
        return this;
    }

    public List<String> getProductNames() {
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public AllProductsPage clickOnButtonNext() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", buttonNext);
        return this;
    }

    public AllProductsPage clickOnButtonPrevious() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", buttonPrevious);
        return this;
    }

    public AllProductsPage selectNameOrderZtoA() {
        nameZtoA.click();
        return this;
    }

    public AllProductsPage selectPriceLowToHigh() {
        priceLowToHigh.click();
        return this;
    }

    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .collect(Collectors.toList());
    }

    public AllProductsPage selectPriceHighToLow() {
        priceHighToLow.click();
        return this;
    }


}
