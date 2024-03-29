import org.prestashop.AllProductsPage;
import org.prestashop.MainPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSortingCheck extends BaseTest {
    @Test
    public void testSortingCheck() {
        MainPage mainPage = new MainPage();
        mainPage.switchToDemoShopIFrame();

        AllProductsPage allProductsPage = mainPage.clickOnAllProducts();
        allProductsPage.waitSeconds(1)
                .clickOnSortByDropdown()
                .selectNameOrderAtoZ()
                .waitSeconds(1);

        List<String> actualOrderByNameAtoZ = allProductsPage.getProductNames();
        actualOrderByNameAtoZ.addAll(allProductsPage
                .clickOnButtonNext()
                .waitSeconds(1)
                .getProductNames());

        List<String> sortedProductNames = new ArrayList<>(actualOrderByNameAtoZ);
        sortedProductNames.sort(String::compareToIgnoreCase);
        assertEquals(actualOrderByNameAtoZ, sortedProductNames, "Product names are not sorted in alphabetic order");

        List<String> actualOrderByNameZtoA = allProductsPage
                .clickOnButtonPrevious()
                .waitSeconds(1)
                .clickOnSortByDropdown()
                .selectNameOrderZtoA()
                .waitSeconds(1)
                .getProductNames();

        actualOrderByNameZtoA.addAll(allProductsPage
                .clickOnButtonNext()
                .waitSeconds(1)
                .getProductNames());


        List<String> sortedProductNamesZtoA = new ArrayList<>(actualOrderByNameZtoA);
        sortedProductNamesZtoA.sort(String::compareToIgnoreCase);
        Collections.reverse(sortedProductNamesZtoA);
        assertEquals(actualOrderByNameZtoA, sortedProductNamesZtoA, "Product names are in incorrect order");

        List<Double> actualOrderPriceLowToHigh = allProductsPage
                .clickOnButtonPrevious()
                .waitSeconds(1)
                .clickOnSortByDropdown()
                .selectPriceLowToHigh()
                .waitSeconds(1)
                .getProductPrices();
        actualOrderPriceLowToHigh.addAll(allProductsPage
                .clickOnButtonNext()
                .waitSeconds(1)
                .getProductPrices());

        List<Double> sortedPricesLowToHigh = new ArrayList<>(actualOrderPriceLowToHigh);
        sortedPricesLowToHigh.sort(Double::compare);
        assertEquals(actualOrderPriceLowToHigh, sortedPricesLowToHigh, "The order is not low to high");

        List<Double> actualOrderPriceHighToLow = allProductsPage
                .clickOnButtonPrevious()
                .waitSeconds(1)
                .clickOnSortByDropdown()
                .selectPriceHighToLow()
                .waitSeconds(1)
                .getProductPrices();
        List<Double> sortedPricesHighToLow = new ArrayList<>(actualOrderPriceHighToLow);
        sortedPricesHighToLow.sort(Double::compare);
        Collections.reverse(sortedPricesHighToLow);
        assertEquals(actualOrderPriceHighToLow, sortedPricesHighToLow, "The order is not high to low");
    }
}
