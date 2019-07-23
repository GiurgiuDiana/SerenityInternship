package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.ProductListSteps;

@RunWith(SerenityRunner.class)
public class AddToCartTest extends BaseTest{



    @Steps
    public ProductListSteps productListSteps;
    @Steps
    public LoginSteps loginSteps;

    @Test
    public void displayProductsFoundTest(){
        productListSteps.openPage();
        productListSteps.getAllProducts();
        productListSteps.navigateToRandomProduct();
    }
}
