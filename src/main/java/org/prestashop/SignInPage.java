package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='no-account']")
    private WebElement noAccountLink;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public SignInPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public CreateAnAccountPage clickOnNoAccountLink() {
        log.info("Click on no account link");
        noAccountLink.click();
        return new CreateAnAccountPage();
    }
}
