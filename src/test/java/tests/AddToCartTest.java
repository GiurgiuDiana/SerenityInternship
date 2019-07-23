package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import steps.ProductDetailsSteps;
import steps.LoginSteps;
import steps.ProductListSteps;

@RunWith(SerenityRunner.class)
public class AddToCartTest extends BaseTest{



    @Steps
    public ProductListSteps productListSteps;
    @Steps
    public LoginSteps loginSteps;

    @Steps
    ProductDetailsSteps productDetailsSteps;

    @Test
    public void displayProductsFoundTest() {
        productListSteps.openPage();
        productListSteps.getAllProducts();
        productListSteps.navigateToRandomProduct();
    }

    @Test
    public void configurationsTest(){
        productDetailsSteps.openPage();
        productDetailsSteps.clickRandomColor();
    }
}
