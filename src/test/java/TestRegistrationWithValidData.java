import org.prestashop.CreateAnAccountPage;
import org.prestashop.MainPage;
import org.prestashop.SignInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestRegistrationWithValidData extends BaseTest {
    @Test
    public void testRegistrationWithValidData() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        SignInPage signInPage = new SignInPage();
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        String actualUserNameNearCart = mainPage.clickOnSignInButton()
                .clickOnNoAccountLink()
                .clickOnCheckBoxMr()
                .setNameToNameField()
                .setLastNameToLastNameField()
                .setAnEmailToEmailField()
                .setPasswordToPasswordField()
                .setBirthday()
                .clickOnCheckBoxTermsAnsConditions()
                .clickOnCustomerPrivacy()
                .clickOnSaveButton()
               .getUserNameNearCart();

        assertEquals(actualUserNameNearCart, "John Snow", "The name is incorrect or absent");
    }
}
