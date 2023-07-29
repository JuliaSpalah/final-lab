package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//div[@class='no-account']")
    private WebElement noAccountLink;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CreateAnAccountPage clickOnNoAccountLink(){
        noAccountLink.click();
        return new CreateAnAccountPage();
    }
}
