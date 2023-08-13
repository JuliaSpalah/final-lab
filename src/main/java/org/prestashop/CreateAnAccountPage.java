package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class CreateAnAccountPage extends BasePage {

    @FindBy(xpath = "//span/input[@id='field-id_gender-1']")
    private WebElement checkBoxMr;

    @FindBy(xpath = "//div/input[@id='field-firstname']")
    private WebElement fieldName;

    @FindBy(xpath = "//div/input[@id='field-lastname']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//div/input[@id='field-email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//div/input[@id='field-password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//div/input[@id='field-birthday']")
    private WebElement fieldBirthday;

    @FindBy(xpath = "//label/input[@name='psgdpr']")
    private WebElement checkBoxTermsAndConditions;

    @FindBy(xpath = "//label/input[@name='customer_privacy']")
    private WebElement checkBoxCustomerPrivacy;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
    private WebElement buttonSave;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement popUpInvalidFormat;


    public CreateAnAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CreateAnAccountPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public CreateAnAccountPage clickOnCheckBoxMr() {
        log.info("Click on Mr");
        checkBoxMr.click();
        return this;
    }

    public CreateAnAccountPage setNameToNameField() {
        log.info("Set name to name field");
        fieldName.sendKeys("John");
        return this;
    }

    public CreateAnAccountPage setLastNameToLastNameField() {
        log.info("Set last name to last name field");
        fieldLastName.sendKeys("Snow");
        return this;
    }

    public CreateAnAccountPage setAnEmailToEmailField() {
        log.info("Set an email to email field");
        fieldEmail.sendKeys("john.snow@mail.com");
        return this;
    }

    public CreateAnAccountPage setPasswordToPasswordField() {
        log.info("Set password to password field");
        fieldPassword.sendKeys("K0vbasaKrasa");
        return this;
    }

    public CreateAnAccountPage setBirthday() {
        log.info("Set birthday to birthday field");
        fieldBirthday.sendKeys("10/10/2020");
        return this;
    }

    public CreateAnAccountPage clickOnCheckBoxTermsAnsConditions() {
        log.info("Click on terms and conditions");
        checkBoxTermsAndConditions.click();
        return this;
    }

    public CreateAnAccountPage clickOnCustomerPrivacy() {
        log.info("Click on Customer privacy");
        checkBoxCustomerPrivacy.click();
        return this;
    }

    public MainPage clickOnSaveButton() {
        log.info("Click on Save button");
        buttonSave.click();
        return new MainPage();
    }

    public CreateAnAccountPage setInvalidNameToNameField() {
        log.info("Set invalid name to name field");
        fieldName.sendKeys("James8");
        return this;
    }

    public CreateAnAccountPage setLastNameToLastNameField2() {
        log.info("Set last name to last name field");
        fieldLastName.sendKeys("Blond");
        return this;
    }

    public CreateAnAccountPage setEmail2() {
        log.info("Set email 2");
        fieldEmail.sendKeys("james.blond@mail.com");
        return this;
    }

    public boolean isNameOutlineColorRed() {
        log.info("Is name outline color red");
        return fieldName.getCssValue("outline-color").equals("rgba(255, 76, 76, 1)");
    }

    public String getPopUpInvalidFormatText() {
        log.info("Get pop up Invalid format text");
        return popUpInvalidFormat.getText();
    }
}
