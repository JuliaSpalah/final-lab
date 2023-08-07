import org.prestashop.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCheckCategories extends BaseTest {
    @Test
    public void testCheckCategories() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();

        boolean isClothesSubmenuShown = mainPage
                .hoverOverClothes()
                .waitSeconds(1)
                .isClothesSubmenuShown();
        assertTrue(isClothesSubmenuShown, "Clothes submenu is not shown");

        String actualSubmenuMen = mainPage.getSubmenuMen();
        assertEquals(actualSubmenuMen, "MEN", "Submenu Men is incorrect");

        String actualSubmenuWomen = mainPage.getSubmenuWomen();
        assertEquals(actualSubmenuWomen, "WOMEN", "Submenu Women is incorrect");

        boolean isAccessoriesSubmenuSubmenuShown = mainPage
                .hoverOverAccessories()
                .waitSeconds(1)
                .isAccessoriesSubmenuShown();
        assertTrue(isAccessoriesSubmenuSubmenuShown, "Accessories submenu is not shown");

        String actualSubmenuStationery = mainPage.getSubmenuStationery();
        assertEquals(actualSubmenuStationery, "STATIONERY", "Submenu Stationery is incorrect");

        String actualSubmenuHomeAccessories = mainPage.getSubmenuHomeAccessories();
        assertEquals(actualSubmenuHomeAccessories, "HOME ACCESSORIES", "Submenu Home Accessories is incorrect");

        mainPage.hoverOverArts().waitSeconds(1);
        assertThrows(mainPage::isArtsSubmenuShown);
    }


}
