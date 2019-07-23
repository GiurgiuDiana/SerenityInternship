package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/result/?q=necklace")
public class ShoppingCartPage {

    ShoppingCartPage() {
    }

    //configurable products have an item-options class while in the shopping cart

    @FindBy(css = "tr.last.odd h2 > a")
    WebElementFacade nameOfLastProduct;

    @FindBy(css = "tr.last.odd td.product-cart-price .price")
    WebElementFacade pricePerUnitOfLastProduct;

    @FindBy(css = "tr.last.odd .input-text.qty")
    WebElementFacade quantityOfLastProduct;

    @FindBy(css = "tr.last.odd td.product-cart-total .price")
    WebElementFacade totalPriceOfLastProduct;
}
