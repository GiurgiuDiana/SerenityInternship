package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import pages.ProductDetailsPage;

import java.util.List;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;
    @Step
    public void openPage(){
        productDetailsPage.open();
    }

    @Step
    public void clickRandomColor(){
        List<WebElementFacade> colors= productDetailsPage.getColors();
    }
}
