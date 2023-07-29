import org.prestashop.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCheckLanguages extends BaseTest {

    @Test
    public void testCheckLanguages() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        int actualQuantityOfLanguages = mainPage.clickOnLanguageButton().getQuantityOfLanguages();

        assertEquals(actualQuantityOfLanguages, 44, "Incorrect quantity of Languages");

        boolean actualUkrainianLanguagePresence = mainPage.checkUkrainianLanguagePresence();
        assertTrue(actualUkrainianLanguagePresence, "Ukrainian language is absent in dropdown");
    }
}
