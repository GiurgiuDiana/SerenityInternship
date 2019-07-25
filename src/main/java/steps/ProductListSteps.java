package steps;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.HeaderPage;
import pages.ProductListPage;

import java.util.List;

public class ProductListSteps {

    ProductListPage productListPage;

    HeaderPage headerPage;

    public String searchKeyword,productName,productPrice;

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

    @Step
    public void searchForProduct(String keyword){
        headerPage.typeInSearchField(keyword);
    }

    @Step
    public void checkIfProductWasFound(){
        Assert.assertTrue(productListPage.checkIfProductWasFound(productName,productPrice));
    }

    @StepGroup
    public void performProductSearchAndVerification(){
        searchForProduct(searchKeyword);
        checkIfProductWasFound();
    }

}
