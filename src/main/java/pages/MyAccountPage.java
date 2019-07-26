package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DefaultUrl("http://qa1.dev.evozon.com/customer/account/")
public class MyAccountPage extends PageObject {
    @FindBy(css = ".box-account.box-info .box > .box-content > address")
    private List<WebElementFacade> allTheDefaultAddressesForCheckout;

    @FindBy(css=".col-1 .box > .box-content > address")
    private WebElementFacade defaultBillingInformation;

    @FindBy(css=".col-2 .box > .box-content > address")
    private WebElementFacade defaultShippingInnformation;

    public String defaultBillingInformationFromMyAccount()
    {
        //System.out.println(allTheDefaultAddressesForCheckout.get(0).toString());
       if(defaultBillingInformation.isDisplayed()){
           String billingInformation=defaultBillingInformation.getText().replace("\n",", ");
           return billingInformation;
       }
       else
       {
           defaultBillingInformation.waitUntilVisible();
           String billingInformation=defaultBillingInformation.getText().replace("\n",", ");
           return billingInformation;
       }
    }

    public String defaultShippingInformationFromMyAccount()
    {
        String shippingInformation=defaultShippingInnformation.getText().replace("\n",", ");
        return shippingInformation;
    }

}
