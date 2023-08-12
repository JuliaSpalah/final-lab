package org.prestashop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class AddressesPage extends BasePage {

    @FindBy(xpath = "//input[@id='field-company']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@id='field-address1']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='field-city']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@id='field-id_country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//select[@id='field-id_country']//option[@value='8']")
    private WebElement countryFranceInDropdown;

    @FindBy(xpath = "//input[@id='field-postcode']")
    private WebElement postCodeField;

    @FindBy(xpath = "//input[@id='field-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//footer[input[@name='submitAddress']]/button[@class='continue btn btn-primary float-xs-right']")
    private WebElement buttonContinue;

    public AddressesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public AddressesPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public AddressesPage setNameOfCompanyToCompanyField() {
        disableAutocomplete(companyField);
        companyField.sendKeys("King of North");
        return this;
    }

    public AddressesPage setAddressToAddressField() {
        disableAutocomplete(addressField);
        addressField.sendKeys("30 Rue Joseph Vernet");
        return this;
    }

    public AddressesPage setCity() {
        disableAutocomplete(cityField);
        cityField.sendKeys("Winterfell");
        return this;
    }

    public AddressesPage setPostCode() {
        disableAutocomplete(postCodeField);
        postCodeField.sendKeys("84000");
        return this;
    }

    public AddressesPage clickOnSelectCountryDropdown() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", selectCountry);
        return new AddressesPage();
    }

    public AddressesPage selectCountryFromDropdown() {
        countryFranceInDropdown.click();
        return this;
    }

    public AddressesPage setPhoneNumber() {
        disableAutocomplete(phoneField);
        phoneField.sendKeys("+33195874562");
        return this;
    }

    public ShippingMethodPage clickOnContinueButton() {
        buttonContinue.click();
        return new ShippingMethodPage();
    }


}
