package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


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

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTextNearEmailField() {
        return textNearEmailField.getText();
    }

    public String getTextUnderEmailField() {
        return textUnderEmailField.getText();
    }

    public String getTextOfSubscribeButton() {
        return subscribeButton.getDomProperty("value");
    }

    public MainPage clickOnLanguageButton() {
        languageButton.click();
        return this;
    }

    public int getQuantityOfLanguages() {
        return listOfLanguages.size();
    }

    public boolean checkUkrainianLanguagePresence() {
        return listOfLanguages.stream().anyMatch(
                webElement -> webElement.getText().equals("Українська")
        );
    }

    public SignInPage clickOnSignInButton() {
        signInButton.click();
        return new SignInPage();
    }

    public String getUserNameNearCart() {
        return nameNearCart.getText();
    }

    public MainPage hoverOverClothes() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(clothes).perform();
        return this;
    }

    public String getSubmenuMen() {
        return submenuMen.getText();
    }

    public String getSubmenuWomen() {
        return submenuWomen.getText();
    }

    public MainPage hoverOverAccessories() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(accessories).perform();
        return this;
    }

    public String getSubmenuStationery() {
        return stationery.getText();
    }

    public String getSubmenuHomeAccessories() {
        return homeAccessories.getText();
    }

    public MainPage hoverOverArts() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(arts).perform();
        return this;
    }

    public boolean isClothesSubmenuShown() {
        return clothesSubmenu.getCssValue("visibility").equals("visible");
    }

    public boolean isAccessoriesSubmenuShown() {
        return accessoriesSubmenu.getCssValue("visibility").equals("visible");
    }

    public boolean isArtsSubmenuShown() {
        return artsSubmenu.getCssValue("visibility").equals("visible");
    }
}