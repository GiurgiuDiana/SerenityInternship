package steps;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.ProductListPage;

import java.util.List;

public class ProductListSteps {

    ProductListPage productListPage;

    @Step
    public void openPage() {
        productListPage.open();
    }

    @Step
    public void getAllProducts() {
        List<WebElementFacade> products = productListPage.getProductsLinksList();
        System.out.println("this is the number of products found:" + products.size());
        Assert.assertTrue("there were no products found", products.size() > 0);
    }

    @Step
    public void navigateToRandomProduct() {
        productListPage.goToChosenProductPage();
    }

    @Step
    public void saveChosenProduct(){
        productListPage.saveChosenProduct();
    }

    @Step
    public void chooseRandomProduct(){
        productListPage.chooseRandomProduct();
    }

}
