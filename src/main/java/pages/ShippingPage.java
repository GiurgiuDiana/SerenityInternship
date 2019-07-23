package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class ShippingPage extends PageObject {

    @FindBy(css = "#shipping-buttons-container [title='Continue']")
    private WebElementFacade continueShippingButton;


    public void pressContinue(int shippingChoice) {
        if (shippingChoice == 1) {
            continueShippingButton.click();
        }
    }
}
