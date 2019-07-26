package steps;


import models.Product;
import net.thucydides.core.annotations.Step;
import pages.*;
import tools.Utils;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckoutAsUserSteps {
    BillingPage billingPage;
    ShippingPage shippingPage;
    ShippingMethodPage shippingMethodPage;
    PaymentInformationPage paymentInformationPage;
    OrderReviewPage orderReviewPage;


    @Step
    public void userIsOnCheckoutPage() {
        billingPage.open();
    }

    @Step
    public void fillBillingInformation() {
        billingPage.fillInBillingInfo(0, 1);

    }

    @Step
    public void fillShippingInformation() {
        shippingPage.pressContinue(1);

    }


    @Step
    public void chooseShippingMethod(boolean sameBillingAndShippingAddress) throws Exception {
        shippingMethodPage.fillInShippingMethod(1);
        String billingInformation = billingPage.getAddress().toLowerCase().replace(",", "");
        System.out.println(billingInformation);
        String addressInput = shippingMethodPage.getShippingMessage().toLowerCase().replace(",", "");
        System.out.println(addressInput);
        if (sameBillingAndShippingAddress) {
            assertTrue(addressInput.trim().contains(billingInformation.trim()));
        } else
        {
            assertFalse(addressInput.trim().contains(billingInformation.trim()));
        }
    }

    @Step
    public void paymentInformation() throws InterruptedException {
        paymentInformationPage.pressContinue();
    }

    @Step
    public void orderReviewPage() throws InterruptedException {
        List<Product> prod = orderReviewPage.productOrderReviewList();
        assertTrue(shippingMethodPage.getShippingPrice() == Utils.convertPriceToDouble(orderReviewPage.getShippingPriceCheck().getText().replace("$", "").replace(".", "")));
        orderReviewPage.pressPlaceOrder();
    }


}
