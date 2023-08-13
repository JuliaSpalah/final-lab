package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

import static org.apache.commons.math3.util.Precision.round;
import static utils.StringUtils.extractPriceValue;

@Slf4j

public class PricesDropPage extends BasePage {

    @FindBy(xpath = "//span[@class='price']")
    private List<WebElement> newPrices;

    @FindBy(xpath = "//span[@class='regular-price']")
    private List<WebElement> oldPrices;

    public PricesDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public int getOldPrices() {
        log.info("Get old prices");
        return oldPrices.size();
    }

    public int getNewPrices() {
        log.info("Get new prices");
        return newPrices.size();
    }

    public PricesDropPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public boolean checkIfAllDiscountsCalculatedCorrectly() {
        log.info("Check if all discounts calculated correctly");
        double multiplier = 0.8;
        for (int i = 0; i < oldPrices.size(); i++) {
            double discountPrice = extractPriceValue(oldPrices.get(i).getText()) * multiplier;
            double actualDiscountPrice = extractPriceValue(newPrices.get(i).getText());
            if (round(actualDiscountPrice, 2) != round(discountPrice, 2)) {
                return false;
            }
        }
        return true;
    }
}
