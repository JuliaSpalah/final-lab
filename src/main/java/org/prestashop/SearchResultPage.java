package org.prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SearchResultPage extends BasePage {

   // @FindBy(xpath = "//a[text()='Brown bear notebook']")
    //private WebElement brownBearNoteBook;

   // @FindBy(xpath = "//h2[@class='h3 product-title']//a[text()='Brown bear notebook']")
    //private WebElement brownBearNoteBook;

    @FindBy(xpath = "//article[@class='product-miniature js-product-miniature']//a[text()='Brown bear notebook']")
    private WebElement brownBearNoteBook;
    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public SearchResultPage waitSeconds(long seconds) {
        Utils.waitSeconds(seconds);
        return this;
    }

    public BrownBearNoteBookPage clickOnBrownBearNoteBook() {
        brownBearNoteBook.click();
        return new BrownBearNoteBookPage();
    }
}
