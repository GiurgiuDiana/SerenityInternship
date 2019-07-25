package pages;

import models.ConfigurableProduct;
import models.Product;
import models.ProductsInCart;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/cart/")
public class ShoppingCartPage extends PageObject {

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

    @FindBy(css = "tr.last.odd > td.product-cart-info > dl")
    private WebElementFacade configurableProductItemOptions;

    @FindBy(css = "tr.last.odd > td.a-center.product-cart-remove.last > a")
    private WebElementFacade removeLastProductButton;

    private WebElementFacade colorOfLastProduct;

    private WebElementFacade sizeOfLastProduct;

    public WebElementFacade initColor() {
        try {
            colorOfLastProduct = configurableProductItemOptions.findBy(By.cssSelector("tr.last.odd .item-options > dt:first-of-type"));
        } catch (NoSuchElementException e) {
            System.out.println("product does not have colors");
        }
        return colorOfLastProduct;
    }

    public WebElementFacade initSize(){
        try{
            sizeOfLastProduct = configurableProductItemOptions.findBy(By.cssSelector("tr.last.odd .item-options > dt:nth-child(3)"));
        } catch (NoSuchElementException e) {
            System.out.println("product does not have sizes");
        }
        return sizeOfLastProduct;
    }

    public boolean isSimpleProduct() {
        try {
            configurableProductItemOptions.getText();
            return true;
        } catch (NoSuchContextException e) {
            return false;
        }
    }

    public Product createSimpleProductFromCart() {
        Product cartProduct = new Product(nameOfLastProduct.getText(), Double.parseDouble(pricePerUnitOfLastProduct.getText().substring(1)), Integer.parseInt(quantityOfLastProduct.getText()));
        return cartProduct;
    }

    public Product createConfigurableProductFromCart(){
        ConfigurableProduct cartProduct = new ConfigurableProduct(nameOfLastProduct.getText(), Double.parseDouble(pricePerUnitOfLastProduct.getText().substring(1)), colorOfLastProduct.getText(), sizeOfLastProduct.getText(), Integer.parseInt(quantityOfLastProduct.getText()));
        return cartProduct;
    }

}
