package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class ShippingMethodPage extends BasePage {

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

    private int shippingChoice;

    public String getShippingMessage() {
        shippingMessage.waitUntilVisible();
        String message=shippingMessage.getText().replace("\n ,","");
        //String[] mess=message.split("\n");
        //String endMessage=mess[0]+","+mess[1];
        return message;
    }
    public void selectShippingType(int index) throws Exception {
        for (int i = 0; i <= 20; i++) {
            if (index == 1) {
                try {
//                    radioButtonFreeShipping.waitUntilClickable();
                    radioButtonFreeShipping.click();
                    break;
                } catch (ElementNotInteractableException e) {
                    Thread.sleep(1000);
                }

            } else {
                radioButtonFlateRateShipping.click();
                shippingChoice = 2;
            }
        }

    }

    public void selectGiftOption() {
        buttonEnableGiftOption.click();
    }

    public void pressContinue() {
        continueButtonShippingMethod.waitUntilClickable();
        continueButtonShippingMethod.click();
    }

    public void fillInShippingMethod(int index) throws Exception {

        selectShippingType(index);
        pressContinue();
    }


}
