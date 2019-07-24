package steps;

import models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.ProductDetailsPage;
import tools.RandomElementClicker;
import tools.Utils;

import java.util.List;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;

    //private WebElementFacade price;
    private Double price;
    private String name;

    @Step
    public void openPage(){
        productDetailsPage.open();
    }

    @Step
    public void clickRandomColor(){
        List<WebElementFacade> colors= productDetailsPage.getColors();
        RandomElementClicker.clickRandomElement(colors);

    }

    @Step
    public void clickRandomSize(){
        List<WebElementFacade> sizes = productDetailsPage.getSizes();
        RandomElementClicker.clickRandomElement(sizes);
    }

    @Step
    public void getProductPrice(){
        price = Utils.convertPriceToDouble(productDetailsPage.getProductPrice().getText());
        System.out.println(price);
    }

    @Step
    public void getProductName(){
        name = productDetailsPage.getProductName().getText();
        System.out.println(name);
    }

    @Step
    public void clickAddToCart(){
        Product productInCart = productDetailsPage.addToCart();
        Product productInList = Utils.getProductInList();
        System.out.println(productInCart.toString());
        System.out.println("========================================");
        System.out.println(productInList.toString());
        Assert.assertTrue(productInCart.getName().equals(productInList.getName()));
        Assert.assertTrue(productInCart.getPrice() .equals(productInList.getPrice()));

    }

    @Step
    public void setRandomQuantity(){
        productDetailsPage.setRandomQuantity();
    }

}
