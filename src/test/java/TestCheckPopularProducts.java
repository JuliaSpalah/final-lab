import org.prestashop.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCheckPopularProducts extends BaseTest {

    @Test
    public void testCheckPopularProducts() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();

        int actualQuantityInPopularProducts = mainPage.getQuantityInPopularProducts();
        assertEquals(actualQuantityInPopularProducts, 8, "Quantity in Popular products is incorrect");

        int actualNamesQuantityInPopularProducts = mainPage.getQuantityOfProductNamesInPopularProducts();
        assertEquals(actualNamesQuantityInPopularProducts, 8, "Names quantity in Popular products is incorrect");

        int actualPricesQuantityInPopularProducts = mainPage.getPricesQuantityInPopularProducts();
        assertEquals(actualPricesQuantityInPopularProducts, 8, "The quantity of prices in Popular products is incorrect");

        boolean actualPricesAreBiggerThenZero = mainPage.checkProductPricesAreBiggerThenZero();
        assertTrue(actualPricesAreBiggerThenZero, "The prices are incorrect");
    }
}
