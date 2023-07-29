package org.prestashop;

import org.openqa.selenium.WebElement;
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

    public SignInPage clickOnSignInButton(){
        signInButton.click();
        return new SignInPage();
    }

    public String getUserNameNearCart(){
       return nameNearCart.getText();
    }

}