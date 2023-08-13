package org.prestashop;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Slf4j
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//article[@class='product-miniature js-product-miniature']//a[text()='Brown bear notebook']")
    private WebElement brownBearNoteBook;

    @FindBy(xpath = "//a[text()='Customizable mug']")
    private WebElement customizableMug;

    @FindBy(xpath = "//a[text()='Hummingbird printed t-shirt']")
    private WebElement hummingbirdPrintedTShirt;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public SearchResultPage waitSeconds(long seconds) {
        log.info("Wait seconds");
        Utils.waitSeconds(seconds);
        return this;
    }

    public BrownBearNoteBookPage clickOnBrownBearNoteBook() {
        log.info("Click on Brown bear note book");
        brownBearNoteBook.click();
        return new BrownBearNoteBookPage();
    }

    public CustomizableMugPage clickOnCustomizableMug() {
        log.info("Click on Customize mug");
        customizableMug.click();
        return new CustomizableMugPage();
    }

    public HummingbirdPrintedTShirtPage clickOnHummingbirdPrintedTShirt() {
        log.info("Click on Hummingbird printed t-shirt");
        hummingbirdPrintedTShirt.click();
        return new HummingbirdPrintedTShirtPage();
    }
}
