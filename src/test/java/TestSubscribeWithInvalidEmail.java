import org.prestashop.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestSubscribeWithInvalidEmail extends BaseTest {

    @Test
    public void testSubscribeWithInvalidEmail() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        String actualTextNearEmailField = mainPage.getTextNearEmailField();

        assertEquals(actualTextNearEmailField,
                "Get our latest news and special sales",
                "The text near email field is incorrect");

        String actualTextUnderEmailField = mainPage.getTextUnderEmailField();

        assertEquals(actualTextUnderEmailField,
                "You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.",
                "The text under email field is incorrect");

        String actualTextOfSubscribeButton = mainPage.getTextOfSubscribeButton();

        assertEquals(actualTextOfSubscribeButton,"SUBSCRIBE", "The text on Subscribe button is incorrect");

    }


}
