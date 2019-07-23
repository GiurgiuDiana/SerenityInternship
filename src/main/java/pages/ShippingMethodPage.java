package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class ShippingMethodPage extends PageObject {

    @FindBy(css = "#s_method_freeshipping_freeshipping")
    private WebElementFacade radioButtonFreeShipping;

    @FindBy(css = "#s_method_flatrate_flatrate")
    private WebElementFacade radioButtonFlateRateShipping;

    @FindBy(css = ".gift-messages h3")
    private WebElementFacade giftMessage;

    @FindBy(css = "#allow_gift_messages")
    private WebElementFacade buttonEnableGiftOption;

    @FindBy(css=".complete:nth-child(2)")
    private WebElementFacade shippingMessage;

    @FindBy(css="#allow_gift_messages_for_order")
    private WebElementFacade giftOptionForOrder;

    @FindBy(css="#allow_gift_messages_for_items")
    private WebElementFacade giftOptionForItems;

    @FindBy(css="#shipping-method-buttons-container >button")
    private WebElementFacade continueButtonShippingMethod;

    private int shiipingChoice;

    public WebElementFacade getShippingMessage() {
        return shippingMessage;
    }

    public void selectShippingType(int index)
    {
        if(index==1)
        {
            radioButtonFreeShipping.click();
            shiipingChoice=1;
        }
        else
        {
            radioButtonFlateRateShipping.click();
            shiipingChoice=2;
        }
    }

    public void selectGiftOption()
    {
        buttonEnableGiftOption.click();
    }

    public void pressContinue()
    {
        continueButtonShippingMethod.click();
    }

    public void fillInShippingMethod(int index)
    {
        selectShippingType(index);
        pressContinue();
    }


}
