package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public AllProductsPage clickOnSortByDropdown() {
        log.info("Click on Sort by dropdown");
        sortByDropdown.click();
        return this;
    }

    public AllProductsPage selectNameOrderAtoZ() {
        log.info("Select name order A to Z");
        nameAtoZ.click();
        return this;
    }

    public List<String> getProductNames() {
        log.info("Get product names");
        return productNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public AllProductsPage clickOnButtonNext() {
        log.info("Click on button next");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", buttonNext);
        return this;
    }

    public AllProductsPage clickOnButtonPrevious() {
        log.info("Click on button Previous");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", buttonPrevious);
        return this;
    }

    public AllProductsPage selectNameOrderZtoA() {
        log.info("Select name order Z to A");
        nameZtoA.click();
        return this;
    }

    public AllProductsPage selectPriceLowToHigh() {
        log.info("Select price low to high");
        priceLowToHigh.click();
        return this;
    }

    public List<Double> getProductPrices() {
        log.info("Get product prices");
        return productPrices.stream()
                .map(WebElement::getText)
                .map(StringUtils::extractPriceValue)
                .collect(Collectors.toList());
    }

    public AllProductsPage selectPriceHighToLow() {
        log.info("Select price high to low");
        priceHighToLow.click();
        return this;
    }


}
