import org.prestashop.BrownBearNoteBookPage;
import org.prestashop.MainPage;
import org.prestashop.SearchResultPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAddingToCart extends BaseTest {

    @Test
    public void testAddingToCart() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();
        BrownBearNoteBookPage brownBearNoteBookPage = new BrownBearNoteBookPage();

        SearchResultPage searchResult = mainPage.setBearToSearchField()
                .pressEnter();
        searchResult.waitSeconds(1)
                .clickOnBrownBearNoteBook()
                .waitSeconds(1)
                .clickOnPaperType()
                .clickOnDoted()
                .clickOnQuantity()
                .deleteQuantityValue()
                .setValueToQuantityField()
                .clickOnAddToCart()
                .waitSeconds(1);
        boolean actualMessageAfterAddingToCart = brownBearNoteBookPage.getMessageProductSuccessfullyAddedToCart();
        assertTrue(actualMessageAfterAddingToCart, "The message after adding to cart is absent");

        String actualOrderedPaperType = brownBearNoteBookPage.getOrderedPaperType();
        assertEquals(actualOrderedPaperType, "Doted", "The paper type is incorrect");

        String actualOrderedQuantity = brownBearNoteBookPage.getOrderedQuantity();
        assertEquals(actualOrderedQuantity, "5", "The ordered quantity is incorrect");
    }
}
