package pages;

import models.ConfigurableProduct;
import models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/cart/")
public class ShoppingCartPage {

    ShoppingCartPage() {
    }

    //configurable products have an item-options class while in the shopping cart

    //getting the values of the last product added in the shopping cart
    @FindBy(css = "tr.last.odd h2 > a")
    private WebElementFacade nameOfLastProduct;

    @FindBy(css = "tr.last.odd td.product-cart-price .price")
    private WebElementFacade pricePerUnitOfLastProduct;

    @FindBy(css = "tr.last.odd .input-text.qty")
    private WebElementFacade quantityOfLastProduct;

    @FindBy(css = "tr.last.odd td.product-cart-total .price")
    private WebElementFacade totalPriceOfLastProduct;

    @FindBy(css = "tr.last.even .item-options")
    private WebElementFacade configurableProductItemOptions;

    @FindBy(css = "tr.last.even > td.a-center.product-cart-remove.last")
    private WebElementFacade removeLastProductButton;

    public boolean isSimpleProduct() {
        try {
            configurableProductItemOptions.getText();
            return true;
        } catch (NoSuchContextException e) {
            return false;
        }
    }

    public Product createSimpleProductFromCart(){
        String productNameString = nameOfLastProduct.getText();
        Product cartProduct = new Product(productNameString, Double.parseDouble(productNameString.substring(1)), Integer.parseInt(quantityOfLastProduct.getText()));
        return cartProduct;
    }

//    public ConfigurableProduct createConfigurableProductFromCart(){
//
//    }
}
