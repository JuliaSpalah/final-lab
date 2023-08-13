package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringUtils;
import utils.Utils;

import java.util.List;

@Slf4j
public class MainPage extends BasePage {

    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement textNearEmailField;

    @FindBy(xpath = "//form//div[@class='col-xs-12']/p")
    private WebElement textUnderEmailField;

    @FindBy(xpath = "//form//input[@name='submitNewsletter'][1]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//span[@class='expand-more']")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']/li/a[@class='dropdown-item']")
    private List<WebElement> listOfLanguages;

    @FindBy(xpath = "//a/span[@class='hidden-sm-down']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='account']/span[@class='hidden-sm-down']")
    private WebElement nameNearCart;

    @FindBy(xpath = "//li[@id='category-3']/a[@class='dropdown-item']")
    private WebElement clothes;

    @FindBy(xpath = "//li[@id='category-4']/a[@class='dropdown-item dropdown-submenu']")
    private WebElement submenuMen;

    @FindBy(xpath = "//li[@id='category-5']/a[@class='dropdown-item dropdown-submenu']")
    private WebElement submenuWomen;

    @FindBy(xpath = "//li[@id='category-6']/a[@class='dropdown-item']")
    private WebElement accessories;

    @FindBy(xpath = "//li[@id='category-7']/a[@class='dropdown-item dropdown-submenu']")
    private WebElement stationery;

    @FindBy(xpath = "//li[@id='category-8']/a[@class='dropdown-item dropdown-submenu']")
    private WebElement homeAccessories;

    @FindBy(xpath = "//li[@id='category-9']/a[@class='dropdown-item']")
    private WebElement arts;

    @FindBy(xpath = "//li[@id='category-3']/div[@class='popover sub-menu js-sub-menu collapse']")
    private WebElement clothesSubmenu;

    @FindBy(xpath = "//li[@id='category-6']/div[@class='popover sub-menu js-sub-menu collapse']")
    private WebElement accessoriesSubmenu;

    @FindBy(xpath = "//li[@id='category-9']/div[@class='popover sub-menu js-sub-menu collapse']")
    private WebElement artsSubmenu;

    @FindBy(xpath = "//div[@class='products row']//article[@class='product-miniature js-product-miniature']")
    private List<WebElement> productsInPopularProducts;

    @FindBy(xpath = "//div[@class='products row']//h3[@class='h3 product-title']")
    private List<WebElement> productNamesInPopularProducts;

    @FindBy(xpath = "//div[@class='products row']//span[@class='price']")
    private List<WebElement> productPricesInPopularProducts;

    @FindBy(xpath = "//a[@id='link-product-page-prices-drop-1']")
    private WebElement pricesDrop;

    @FindBy(xpath = "//section[@class='featured-products clearfix']//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProducts;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    private WebElement searchField;


    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public String getTextNearEmailField() {
        log.info("Get text near email field");
        return textNearEmailField.getText();
    }

    public String getTextUnderEmailField() {
        log.info("Get text under email field");
        return textUnderEmailField.getText();
    }

    public String getTextOfSubscribeButton() {
        log.info("Get text Subscribe button");
        return subscribeButton.getDomProperty("value");
    }

    public MainPage clickOnLanguageButton() {
        log.info("Click on language button");
        languageButton.click();
        return this;
    }

    public int getQuantityOfLanguages() {
        log.info("Get quantity of languages");
        return listOfLanguages.size();
    }

    public boolean checkUkrainianLanguagePresence() {
        log.info("Check ukrainian language presence");
        return listOfLanguages.stream().anyMatch(
                webElement -> webElement.getText().equals("Українська")
        );
    }

    public SignInPage clickOnSignInButton() {
        log.info("Click on sign in button");
        signInButton.click();
        return new SignInPage();
    }

    public String getUserNameNearCart() {
        log.info("Get user name near cart");
        return nameNearCart.getText();
    }

    public MainPage hoverOverClothes() {
        log.info("Hover over clothes");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(clothes).perform();
        return this;
    }

    public String getSubmenuMen() {
        log.info("Get submenu Men");
        return submenuMen.getText();
    }

    public String getSubmenuWomen() {
        log.info("Get submenu Women");
        return submenuWomen.getText();
    }

    public MainPage hoverOverAccessories() {
        log.info("Hover over Accessories");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(accessories).perform();
        return this;
    }

    public String getSubmenuStationery() {
        log.info("Get submenu Stationery");
        return stationery.getText();
    }

    public String getSubmenuHomeAccessories() {
        log.info("Get Submenu Home Accessories");
        return homeAccessories.getText();
    }

    public MainPage hoverOverArts() {
        log.info("Hover over Arts");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(arts).perform();
        return this;
    }

    public boolean isClothesSubmenuShown() {
        log.info("Is clothes submenu shown");
        return clothesSubmenu.getCssValue("visibility").equals("visible");
    }

    public boolean isAccessoriesSubmenuShown() {
        log.info("Is accessories submenu shown");
        return accessoriesSubmenu.getCssValue("visibility").equals("visible");
    }

    public boolean isArtsSubmenuShown() {
        log.info("Is arts submenu shown");
        return artsSubmenu.getCssValue("visibility").equals("visible");
    }

    public int getQuantityInPopularProducts() {
        log.info("Get quantity in Popular products");
        return productsInPopularProducts.size();
    }

    public int getQuantityOfProductNamesInPopularProducts() {
        log.info("Get quantity of product names in Popular products");
        return productNamesInPopularProducts.size();
    }

    public int getPricesQuantityInPopularProducts() {
        log.info("Get prices quantity in popular products");
        return productPricesInPopularProducts.size();
    }

    public boolean checkProductPricesAreBiggerThenZero() {
        log.info("Check product prices are bigger then zero");
        return productPricesInPopularProducts.stream().allMatch(
                webElement -> StringUtils.extractPriceValue(webElement.getText()) > 0.0);
    }

    public PricesDropPage clickOnPricesDrop() {
        log.info("Click on prices drop");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", pricesDrop);
        return new PricesDropPage();
    }

    public AllProductsPage clickOnAllProducts() {
        log.info("Click on All products");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", allProducts);
        return new AllProductsPage();
    }

    public MainPage setBearToSearchField() {
        log.info("Set Bear to search field");
        searchField.sendKeys("Bear");
        return this;
    }

    public SearchResultPage pressEnter() {
        log.info("Press enter");
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }

    public MainPage setMugToSearchField() {
        log.info("Set Mug to search field");
        searchField.sendKeys("Mug");
        return this;
    }


}

