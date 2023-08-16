package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
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

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    private WebElement buttonContinueAddresses;
   // @FindBy(xpath = "//footer[@class='form-footer clearfix']//button[@class='continue btn btn-primary float-xs-right']")

    public AddressesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public AddressesPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public AddressesPage setNameOfCompanyToCompanyField() {
        log.info("Set name company to Company field");
        disableAutocomplete(companyField);
        companyField.sendKeys("King of North");
        return this;
    }

    public AddressesPage setAddressToAddressField() {
        log.info("Set address to address field");
        disableAutocomplete(addressField);
        addressField.sendKeys("30 Rue Joseph Vernet");
        return this;
    }

    public AddressesPage setCity() {
        log.info("Set city");
        disableAutocomplete(cityField);
        cityField.sendKeys("Winterfell");
        return this;
    }

    public AddressesPage setPostCode() {
        log.info("Set post code");
        disableAutocomplete(postCodeField);
        postCodeField.sendKeys("84000");
        return this;
    }

    public AddressesPage clickOnSelectCountryDropdown() {
        log.info("Click on select country dropdown");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", selectCountry);
        return new AddressesPage();
    }

    public AddressesPage selectCountryFromDropdown() {
        log.info("Select country from dropdown");
        countryFranceInDropdown.click();
        return this;
    }

    public AddressesPage setPhoneNumber() {
        log.info("Set phone number");
        disableAutocomplete(phoneField);
        phoneField.sendKeys("+33195874562");
        return this;
    }

    public ShippingMethodPage clickOnContinueButtonOnAddressesPage() {
        log.info("Click on Continue button on Addresses page");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", buttonContinueAddresses);
        return new ShippingMethodPage();
    }


}
