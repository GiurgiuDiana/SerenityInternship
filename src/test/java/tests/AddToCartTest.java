package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import steps.*;

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
        searchPageSteps.shouldBeOnSearchResultsPage();
        productListSteps.navigateToRandomProduct();
        productDetailsSteps.clickRandomColor();
        productDetailsSteps.clickRandomSize();
        productDetailsSteps.setRandomQuantity();
        productDetailsSteps.clickAddToCart();

    }

//    @Test
//    public void validateProductDataFromDetailsPageAndCart(){
//        searchPageSteps.performProductSearch();
//        productListSteps.navigateToRandomProduct();
//        productDetailsSteps.performProductDetailsSelection();
//        shoppingCartSteps.validateProductsAreConsistent();
//    }
}
