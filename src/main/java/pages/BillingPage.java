package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.FindBy;
import tools.Constants;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class BillingPage extends PageObject {

    @FindBy(css = "#billing-address-select")
    private List<WebElementFacade> selectBillingAddress;

    @FindBy(css=".sp-methods > dd")
    List<WebElementFacade>shippingMethods;

    @FindBy(css = "[title='Ship to this address']")
    private WebElementFacade radioShipToThisAddress;

    @FindBy(css = "[title='Ship to different address']")
    private WebElementFacade radioShipToDifferentAddress;

    @FindBy(css = "#billing-buttons-container >button")
    private WebElementFacade continueBillingButton;

    @FindBy(css = "#opc-shipping .step-title a")
    private WebElementFacade toShippingButton;

    private String address;
    private int shippTo = 0;


    /////in momentul inj care dau continue retin adresa ca sa o pot verifica ca se noteaza cum trebuie

    public void setSelectBillingAddress(int index) {
        selectBillingAddress.get(index).click();
        List<String>saddress=selectBillingAddress.get(index).getSelectOptions();
        address=saddress.get(2);
        System.out.println(address);
    }

    public void selectShippingAddress(int index) {
        if (index == 1) {
            radioShipToThisAddress.click();
            shippTo = 1;
        } else {
            radioShipToDifferentAddress.click();
            shippTo = 2;
        }
    }

    public void pressContinueBilling() {
        continueBillingButton.click();
    }

    public String getAddress() {
        return address;
    }

    public void fillInBillingInfo(int selectShippingAddress, int selectShippingChoice) {
        setSelectBillingAddress(selectShippingAddress);
        selectShippingAddress(selectShippingChoice);
        pressContinueBilling();

   for(int i=0; i<20; i++){
    try{
        toShippingButton.click();
        break;
    } catch (
    ElementNotInteractableException e)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    }
    }


}
