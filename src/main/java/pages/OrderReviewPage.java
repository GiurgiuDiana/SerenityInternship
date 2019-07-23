package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class OrderReviewPage extends PageObject {

    @FindBy(css = "#payment-progress-opcheckout .subtitle")
    private WebElementFacade checkPaymentInformation;

    @FindBy(css = "[title='Place Order']")
    private WebElementFacade buttonPlaceOrder;


    public WebElementFacade getCheckPaymentInformation() {
        return checkPaymentInformation;
    }

    public void pressPlaceOrder()
    {
        buttonPlaceOrder.click();
    }
}
