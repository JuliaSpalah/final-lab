import org.prestashop.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestCheckOutEndToEnd extends BaseTest {
    @Test
    public void testCheckOutEndToEnd() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        SearchResultPage searchResultPage = new SearchResultPage();
        CustomizableMugPage customizableMugPage = new CustomizableMugPage();
        HummingbirdPrintedTShirtPage hummingbirdPrintedTShirtPage = new HummingbirdPrintedTShirtPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        AddressesPage addressesPage = new AddressesPage();
        PaymentPage paymentPage = new PaymentPage();
        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage();

        boolean actualTotal = mainPage.setMugToSearchField()
                .pressEnter()
                .waitSeconds(1)
                .clickOnCustomizableMug()
                .waitSeconds(1)
                .setBestMugEverToTextField()
                .clickOnSaveCustomization()
                .waitSeconds(1)
//                .clearQuantityField()
//                .setValueToQuantityField()
                .clickOnAddToCart()
                .waitSeconds(1)
                .clickOnContinueShopping()
                .setTShirtToSearchField()
                .pressEnter()
                .waitSeconds(1)
                .clickOnHummingbirdPrintedTShirt()
                .waitSeconds(1)
                .selectBlackColor()
                .clickOnAddToCart()
                .waitSeconds(1)
                .clickOnProceedToCheckOut()
                .waitSeconds(1)
                .checkTotalSum();

        assertTrue(actualTotal, "Total is incorrect");

        boolean actualAmountOnPaymentPage = shoppingCartPage.clickOnProceedToCheckOut()
                .waitSeconds(1)
                .clickOnMrCheckBox()
                .setNameToFirstNameField()
                .setLastNameToLastNameField()
                .setEmailToEmailField()
                .setBirthdayToBirthdayField()
                .clickOnTermsAndConditions()
                .clickOnDataPrivacy()
                .waitSeconds(1)
                .clickOnContinueButtonOnPersonalInfoPage()
                .waitSeconds(1)
                .setNameOfCompanyToCompanyField()
                .setAddressToAddressField()
                .setCity()
                .setPostCode()
                .clickOnSelectCountryDropdown()
                .selectCountryFromDropdown()
                .setPhoneNumber()
                .waitSeconds(1)
                .clickOnContinueButtonOnAddressesPage()
                .waitSeconds(1)
                .clickOnMyCarrier()
                .clickOnContinueButtonOnShippingPage()
                .waitSeconds(1)
                .selectOptionPayByCheck()
                .checkIfAmountEqualsToSubtotalAndShipping();

        assertTrue(actualAmountOnPaymentPage, "The amount is not equal to subtotal and shipping");

        String actualOrderConfirmation = paymentPage.clickOnIAgree()
                .clickOnPlaceOrderButton()
                .getOrderConfirmationMessage();

        assertTrue(actualOrderConfirmation.toLowerCase().contains("your order is confirmed"),
                "Order confirmation doesn't contain 'your order is confirmed' message");

        boolean actualTotalOnConfirmation = orderConfirmedPage.checkIfTotalCorrect();
        assertTrue(actualTotalOnConfirmation, "The total on confirmation is incorrect");


    }
}
