package steps;

import models.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.ProductDetailsPage;
import tools.Constants;
import tools.RandomElementClicker;
import tools.Utils;

import java.util.List;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;

    //private WebElementFacade price;
    private Double price;
    private String name;

    @Step
    public void openPage() {
        productDetailsPage.open();
    }

    @Step
    public void clickRandomColor() {
        List<WebElementFacade> colors = productDetailsPage.getColors();
        RandomElementClicker.clickRandomElement(colors);

    }

    @Step
    public void clickRandomSize() {
        List<WebElementFacade> sizes = productDetailsPage.getSizes();
        RandomElementClicker.clickRandomElement(sizes);
    }

    @Step
    public void getProductPrice() {
        price = Utils.convertPriceToDouble(productDetailsPage.getProductPrice().getText());
        System.out.println(price);
    }

    @Step
    public void getProductName() {
        name = productDetailsPage.getProductName().getText();
        System.out.println(name);
    }

    @Step
    public void saveProductAsObject() {
        productDetailsPage.saveProductObject();
    }

    @Step
    public void clickAddToCart() {
        productDetailsPage.clickAddToCart();
    }

    @Step
    public void verifyProductAdded(){
        Product productAddedToCart = Serenity.sessionVariableCalled(Constants.ADDED_PROD_FROM_DETAILS_PAGE_VAR_NAME);
        Product productInList = Serenity.sessionVariableCalled(Constants.PROD_FROM_LIST_PAGE_VAR_NAME);
        System.out.println(productAddedToCart.toString());
        System.out.println("========================================");
        System.out.println(productInList.toString());
        Assert.assertTrue(productAddedToCart.getName().equals(productInList.getName()));
        Assert.assertTrue(productAddedToCart.getPrice().equals(productInList.getPrice()));
    }

    @Step
    public void setRandomQuantity() {
        productDetailsPage.setRandomQuantity();
    }

    @StepGroup
    public void performProductDetailsSelection() {
        clickRandomColor();
        clickRandomSize();
        setRandomQuantity();
    }

}
