import org.prestashop.CreateAnAccountPage;
import org.prestashop.MainPage;
import org.prestashop.SignInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRegistrationWithInvalidData extends BaseTest {
    @Test
    public void registrationWithInvalidData() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        SignInPage signInPage = new SignInPage();
        CreateAnAccountPage createAnAccountPage = mainPage.clickOnSignInButton()
                .clickOnNoAccountLink()
                .clickOnCheckBoxMr()
                .setInvalidNameToNameField()
                .setLastNameToLastNameField2()
                .setEmail2()
                .setPasswordToPasswordField()
                .setBirthday()
                .clickOnCheckBoxTermsAnsConditions()
                .clickOnCustomerPrivacy();

        createAnAccountPage.clickOnSaveButton().waitSeconds(1);

        assertTrue(createAnAccountPage.isNameOutlineColorRed(), "Name outline color should be red");

        String actualPopUpText = createAnAccountPage.getPopUpInvalidFormatText();
        assertEquals(actualPopUpText, "Invalid format.", "The popUp text is incorrect");
    }
}
