package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends BasePage {

    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement textNearEmailField;

    @FindBy(xpath = "//form//div[@class='col-xs-12']/p")
    private WebElement textUnderEmailField;

    @FindBy(xpath = "//form//input[@name='submitNewsletter'][1]")
    private WebElement subscribeButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTextNearEmailField() {
        return textNearEmailField.getText();
    }

    public String getTextUnderEmailField(){
        return textUnderEmailField.getText();
    }

    public String getTextOfSubscribeButton(){
        return subscribeButton.getDomProperty("value");
    }

}