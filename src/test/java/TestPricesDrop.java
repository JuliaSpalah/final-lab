import org.prestashop.MainPage;
import org.prestashop.PricesDropPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestPricesDrop extends BaseTest {
    @Test
    public void testPriceDrop() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        PricesDropPage pricesDropPage = mainPage
                .clickOnPricesDrop()
                .waitSeconds(1);

        int actualOldPrice = pricesDropPage.getOldPrices();
        assertEquals(actualOldPrice, 2, "Old prices are absent");

        int actualNewPrices = pricesDropPage.getNewPrices();
        assertEquals(actualNewPrices, 2, "New prices are absent");

        boolean actualIfAllDiscountsCalculateCorrectly = pricesDropPage.checkIfAllDiscountsCalculatedCorrectly();
        assertTrue(actualIfAllDiscountsCalculateCorrectly,"Discounts are incorrect");

    }


}
