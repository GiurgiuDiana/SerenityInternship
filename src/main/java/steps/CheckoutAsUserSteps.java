package steps;


import net.thucydides.core.annotations.Step;
import pages.*;

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
        billingPage.fillInBillingInfo(1, 1);

    }

    @Step
    public void fillShippingInformation() {
        shippingPage.pressContinue(1);
    }

    @Step
    public void chooseShippingMethod() {
        assertTrue(shippingMethodPage.getShippingMessage().getText().contentEquals(billingPage.getAddress()));
        shippingMethodPage.fillInShippingMethod(1);
    }

    @Step
    public void paymentInformation() {
        paymentInformationPage.pressContinue();
    }

    @Step
    public void orderReviewPage() {
        orderReviewPage.pressPlaceOrder();
    }

}
