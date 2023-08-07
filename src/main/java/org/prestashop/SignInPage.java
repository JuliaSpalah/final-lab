package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='no-account']")
    private WebElement noAccountLink;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public SignInPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public CreateAnAccountPage clickOnNoAccountLink() {
        noAccountLink.click();
        return new CreateAnAccountPage();
    }
}
