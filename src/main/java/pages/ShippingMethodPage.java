package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.exceptions.ElementNotVisibleAfterTimeoutError;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.Constants;
import tools.Utils;

import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class ShippingMethodPage extends PageObject {

    @FindBy(css = "label[for='s_method_freeshipping_freeshipping']")
    private WebElementFacade radioButtonFreeShipping;

    @FindBy(css = "#s_method_flatrate_flatrate")
    private WebElementFacade radioButtonFlateRateShipping;

    @FindBy(css = "#checkout-step-shipping_method")
    private WebElementFacade shippingMethod;

    @FindBy(css = ".gift-messages h3")
    private WebElementFacade giftMessage;

    @FindBy(css = "#allow_gift_messages")
    private WebElementFacade buttonEnableGiftOption;

    @FindBy(css = ".complete:nth-child(2)")
    private WebElementFacade shippingMessage;

    @FindBy(css = "#allow_gift_messages_for_order")
    private WebElementFacade giftOptionForOrder;

    @FindBy(css = "#allow_gift_messages_for_items")
    private WebElementFacade giftOptionForItems;

    @FindBy(css = "#shipping-method-buttons-container >button")
    private WebElementFacade continueButtonShippingMethod;

    @FindBy(css=".sp-methods > dd")
    private List<WebElementFacade> shippingMethods;

    @FindBy(css="label[for='s_method_flatrate_flatrate'] .price")
    private WebElementFacade flatrateShippingPrice;

    private int shippingChoice;
    private double shippingPrice=0;

    public String getShippingMessage() {
        shippingMessage.waitUntilVisible();
        String message=shippingMessage.getText().replace("\n",", ");
        //String[] mess=message.split("\n");
        //String endMessage=mess[0]+","+mess[1];
        return message;
    }
    public void selectShippingType() throws Exception {

        for(int i=0; i<20; i++) {
            try {
                shippingMethod.isVisible();
                break;
            } catch (
                    ElementNotVisibleException e) {
                    Thread.sleep(1000);
            }
        }
            for (int i = 0; i <= 20; i++) {
                try {
                    if(radioButtonFreeShipping.isDisplayed()){
                    radioButtonFreeShipping.click();
                        shippingChoice = Constants.FREE_SHIPPINNG_CHOICE;
                    break;}
                    else {
                        radioButtonFlateRateShipping.click();
                        shippingChoice = Constants.FLATRATE_SHIPPINNG_CHOICE;
                        shippingPrice= Utils.convertPriceToDouble(flatrateShippingPrice.getText().replace("$","").replace(".",""));
                        break;
                    }
                } catch (ElementNotInteractableException e) {
                    Thread.sleep(1000);
                }
            }
    }

    public int getShippingChoice() {
        return shippingChoice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void selectGiftOption() {
        buttonEnableGiftOption.click();
    }

    public void enableGiftOptionForEntireOrder()
    {
        if(giftOptionForOrder.isDisplayed())
        {
           giftOptionForOrder.click();
        }
    }

    public void pressContinue() {
        continueButtonShippingMethod.waitUntilClickable();
        continueButtonShippingMethod.click();
    }

    public void fillInShippingMethod(int index) throws Exception {
        selectShippingType();
        selectGiftOption();
        enableGiftOptionForEntireOrder();
        pressContinue();
    }


}
