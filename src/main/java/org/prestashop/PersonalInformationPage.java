package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

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
        Utils.waitSeconds(seconds);
        return this;
    }

    public PersonalInformationPage clickOnMrCheckBox() {
        checkBoxMr.click();
        return this;
    }

    public PersonalInformationPage setNameToFirstNameField() {
        firstNameField.sendKeys("John");
        return this;
    }

    public PersonalInformationPage setLastNameToLastNameField() {
        lastNameField.sendKeys("Snow");
        return this;
    }

    public PersonalInformationPage setEmailToEmailField() {
        emailField.sendKeys("john.snow@mail.com");
        return this;
    }

    public PersonalInformationPage setBirthdayToBirthdayField() {
        birthdayField.sendKeys("10/10/2020");
        return this;
    }

    public PersonalInformationPage clickOnTermsAndConditions() {
        checkBoxTermsAndConditions.click();
        return this;
    }

    public PersonalInformationPage clickOnDataPrivacy() {
        checkBoxDataPrivacy.click();
        return this;
    }

    public AddressesPage clickOnContinueButton() {
        buttonContinue.click();
        return new AddressesPage();
    }
}
