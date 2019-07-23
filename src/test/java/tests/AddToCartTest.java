package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.ProductDetailsSteps;
import steps.ProductListSteps;

@RunWith(SerenityRunner.class)
public class AddToCartTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    ProductListSteps productListSteps;

    @Steps
    ProductDetailsSteps productDetailsSteps;

    @Test
    public void displayProductsFoundTest(){
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
