import org.prestashop.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCheckCategories extends BaseTest {
    @Test
    public void checkCategories() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();

        mainPage.hoverOverClothes().waitSeconds(1);
        boolean isClothesSubmenuShown = mainPage.isClothesSubmenuShown();
        assertTrue(isClothesSubmenuShown, "Clothes submenu is not shown");

        String actualSubmenuMen = mainPage.getSubmenuMen();
        assertEquals(actualSubmenuMen, "MEN", "Submenu Men is incorrect");

        String actualSubmenuWomen = mainPage.getSubmenuWomen();
        assertEquals(actualSubmenuWomen, "WOMEN", "Submenu Women is incorrect");

        mainPage.hoverOverAccessories().waitSeconds(1);
        boolean isAccessoriesSubmenuSubmenuShown = mainPage.isAccessoriesSubmenuShown();
        assertTrue(isAccessoriesSubmenuSubmenuShown, "Accessories submenu is not shown");

        String actualSubmenuStationery = mainPage.getSubmenuStationery();
        assertEquals(actualSubmenuStationery, "STATIONERY", "Submenu Stationery is incorrect");

        String actualSubmenuHomeAccessories = mainPage.getSubmenuHomeAccessories();
        assertEquals(actualSubmenuHomeAccessories, "HOME ACCESSORIES", "Submenu Home Accessories is incorrect");

        mainPage.hoverOverArts().waitSeconds(1);
        assertThrows(mainPage::isArtsSubmenuShown);
    }


}
