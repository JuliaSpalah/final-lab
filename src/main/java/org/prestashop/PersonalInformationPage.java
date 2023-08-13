package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class PersonalInformationPage extends BasePage {

    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    private WebElement checkBoxMr;

    @FindBy(xpath = "//input[@id='field-firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='field-lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='field-email'][1]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='field-birthday']")
    private WebElement birthdayField;

    @FindBy(xpath = "//label/input[@name='psgdpr']")
    private WebElement checkBoxTermsAndConditions;

    @FindBy(xpath = "//label/input[@name='customer_privacy']")
    private WebElement checkBoxDataPrivacy;

    @FindBy(xpath = "//button[@class='continue btn btn-primary float-xs-right'][1]")
    private WebElement buttonContinue;

    public PersonalInformationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public PersonalInformationPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public PersonalInformationPage clickOnMrCheckBox() {
        log.info("Click on Mr checkbox");
        checkBoxMr.click();
        return this;
    }

    public PersonalInformationPage setNameToFirstNameField() {
        log.info("Set name to first name field");
        firstNameField.sendKeys("John");
        return this;
    }

    public PersonalInformationPage setLastNameToLastNameField() {
        log.info("Set last name to last name field");
        lastNameField.sendKeys("Snow");
        return this;
    }

    public PersonalInformationPage setEmailToEmailField() {
        log.info("Set email to email field");
        emailField.sendKeys("john.snow@mail.com");
        return this;
    }

    public PersonalInformationPage setBirthdayToBirthdayField() {
        log.info("Set birthday to birthday field");
        birthdayField.sendKeys("10/10/2020");
        return this;
    }

    public PersonalInformationPage clickOnTermsAndConditions() {
        log.info("Click on Terms and conditions");
        checkBoxTermsAndConditions.click();
        return this;
    }

    public PersonalInformationPage clickOnDataPrivacy() {
        log.info("Click on Data privacy");
        checkBoxDataPrivacy.click();
        return this;
    }

    public AddressesPage clickOnContinueButtonOnPersonalInfoPage() {
        log.info("Click on Continue button on Personal info page");
        buttonContinue.click();
        return new AddressesPage();
    }
}
