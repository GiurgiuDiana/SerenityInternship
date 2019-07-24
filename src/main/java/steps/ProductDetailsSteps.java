package steps;

import models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import pages.ProductDetailsPage;
import tools.RandomElementClicker;

import java.util.List;
import java.util.Random;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;
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
        WebElementFacade price = productDetailsPage.getProductPrice();
    }

    @Step
    public void clickAddToCart(){
        Product product = productDetailsPage.addToCart();
    }

    @Step
    public void setRandomQuantity(){
        productDetailsPage.setRandomQuantity();
    }

}
