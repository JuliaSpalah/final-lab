package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public CreateAnAccountPage clickOnCheckBoxMr() {
        checkBoxMr.click();
        return this;
    }

    public CreateAnAccountPage setNameToNameField() {
        fieldName.sendKeys("John");
        return this;
    }

    public CreateAnAccountPage setLastNameToLastNameField() {
        fieldLastName.sendKeys("Snow");
        return this;
    }

    public CreateAnAccountPage setAnEmailToEmailField() {
        fieldEmail.sendKeys("john.snow@mail.com");
        return this;
    }

    public CreateAnAccountPage setPasswordToPasswordField() {
        fieldPassword.sendKeys("K0vbasaKrasa");
        return this;
    }

    public CreateAnAccountPage setBirthday() {
        fieldBirthday.sendKeys("10/10/2020");
        return this;
    }

    public CreateAnAccountPage clickOnCheckBoxTermsAnsConditions() {
        checkBoxTermsAndConditions.click();
        return this;
    }

    public CreateAnAccountPage clickOnCustomerPrivacy() {
        checkBoxCustomerPrivacy.click();
        return this;
    }

    public MainPage clickOnSaveButton() {
        buttonSave.click();
        return new MainPage();
    }

    public CreateAnAccountPage setInvalidNameToNameField() {
        fieldName.sendKeys("James8");
        return this;
    }

    public CreateAnAccountPage setLastNameToLastNameField2() {
        fieldLastName.sendKeys("Blond");
        return this;
    }

    public CreateAnAccountPage setEmail2() {
        fieldEmail.sendKeys("james.blond@mail.com");
        return this;
    }

    public boolean isNameOutlineColorRed() {
        return fieldName.getCssValue("outline-color").equals("rgba(255, 76, 76, 1)");
    }

    public String getPopUpInvalidFormatText() {
        return popUpInvalidFormat.getText();
    }
}
