package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ProductDetailsSteps;
import steps.ProductListSteps;
import steps.SearchPageSteps;
import steps.ShoppingCartSteps;

@RunWith(SerenityRunner.class)
public class AddToCartTest extends BaseTest{


    @Steps
    public ProductListSteps productListSteps;
    @Steps
    public SearchPageSteps searchPageSteps;
    @Steps
    ProductDetailsSteps productDetailsSteps;
    @Steps
    ShoppingCartSteps shoppingCartSteps;

    /*@Test
    public void displayProductsFoundTest() {
        productListSteps.openPage();
        productListSteps.getAllProducts();
        productListSteps.navigateToRandomProduct();
    }*/

   /* @Test
    public void configurationsTest(){
        productDetailsSteps.openPage();
        productDetailsSteps.clickRandomColor();
        productDetailsSteps.clickRandomSize();
        productDetailsSteps.setRandomQuantity();
        productDetailsSteps.clickAddToCart();
    }*/

    @Test
    public void addProductToCartTest(){
        searchPageSteps.isOnHomepage();
        searchPageSteps.fillingSearchField();
        productListSteps.chooseRandomProduct();
        productListSteps.saveChosenProduct();
        productListSteps.navigateToRandomProduct();
        productDetailsSteps.clickRandomColor();
        productDetailsSteps.clickRandomSize();
        productDetailsSteps.setRandomQuantity();
        productDetailsSteps.saveProductAsObject();
        productDetailsSteps.clickAddToCart();
        productDetailsSteps.verifyProductAdded();

    }

    @Test
    public void validateProductDataFromDetailsPageAndCart(){
        searchPageSteps.performProductSearch();
        productListSteps.chooseRandomProduct();
        productListSteps.navigateToRandomProduct();
        productDetailsSteps.performProductDetailsSelection();
        productDetailsSteps.clickAddToCart();
        shoppingCartSteps.extractingLastProductDetails();
//        shoppingCartSteps.validateProductsAreConsistent();
    }
}
