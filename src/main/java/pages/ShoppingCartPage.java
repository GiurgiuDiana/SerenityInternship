package pages;

import models.ConfigurableProduct;
import models.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;
import tools.Constants;
import tools.Utils;

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

    @FindBy(css = "tr.last > td.product-cart-actions > input")
    private WebElementFacade quantityOfLastProduct;

    @FindBy(css = "tr.last.odd td.product-cart-total .price")
    private WebElementFacade totalPriceOfLastProduct;

    @FindBy(css = "#shopping-cart-table tbody tr.last")
    private WebElementFacade containerForLastProductDetails;

    @FindBy(css = "tr.last.odd > td.a-center.product-cart-remove.last > a")
    private WebElementFacade removeLastProductButton;

    private WebElementFacade colorOfLastProduct;

    private WebElementFacade sizeOfLastProduct;


    public WebElementFacade initColor() {
        try {
            colorOfLastProduct = containerForLastProductDetails.findBy(By.cssSelector("tr.last.odd .item-options > dt:first-of-type"));
        } catch (ElementNotVisibleException e) {
            System.out.println("product does not have colors");
        } catch (NoSuchElementException e) {
            System.out.println("product does not have colors");
        }
        return colorOfLastProduct;
    }

    public WebElementFacade initSize() {
        try {
            sizeOfLastProduct = containerForLastProductDetails.findBy(By.cssSelector("tr.last.odd .item-options > dt:nth-child(3)"));
        } catch (ElementNotVisibleException e) {
            System.out.println("product does not have sizes");
        } catch (NoSuchElementException e) {
            System.out.println("product does not have sizes");
        }
        return sizeOfLastProduct;
    }

    public boolean isSimpleProduct() {
        Product product;
        initColor();
        initSize();
        try {
            product = new ConfigurableProduct(nameOfLastProduct.getText(), Utils.convertPriceToDouble(pricePerUnitOfLastProduct.getText()), colorOfLastProduct.getText(), sizeOfLastProduct.getText(), Integer.parseInt(quantityOfLastProduct.getAttribute("value")));
            Serenity.setSessionVariable(Constants.PROD_FROM_CART_PAGE_VAR_NAME).to(product);
            return false;
        } catch (TimeoutException e) {
            product = new Product(nameOfLastProduct.getText(), Utils.convertPriceToDouble(pricePerUnitOfLastProduct.getText()), Integer.parseInt(quantityOfLastProduct.getAttribute("value")));
            Serenity.setSessionVariable(Constants.PROD_FROM_CART_PAGE_VAR_NAME).to(product);
            return true;
        }
    }

    public Product createSimpleProductFromCart() {
        System.out.println(nameOfLastProduct.getText());
        System.out.println(pricePerUnitOfLastProduct.getText());
        System.out.println(quantityOfLastProduct.getText());
        Product cartProduct = new Product(nameOfLastProduct.getText(), Double.parseDouble(pricePerUnitOfLastProduct.getText().substring(1)), Integer.parseInt(quantityOfLastProduct.getText()));
        System.out.println(cartProduct.toString());
        return cartProduct;
    }

    public Product createConfigurableProductFromCart() {
        System.out.println(nameOfLastProduct.getText());
        System.out.println(pricePerUnitOfLastProduct.getText());
        System.out.println(quantityOfLastProduct.getText());
        ConfigurableProduct cartProduct = new ConfigurableProduct(nameOfLastProduct.getText(), Double.parseDouble(pricePerUnitOfLastProduct.getText().substring(1)), colorOfLastProduct.getText(), sizeOfLastProduct.getText(), Integer.parseInt(quantityOfLastProduct.getText()));
        System.out.println(cartProduct.toString());
        return cartProduct;
    }

}
