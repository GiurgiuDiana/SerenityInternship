package steps;


import net.thucydides.core.annotations.Step;
import pages.*;

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
    public void chooseShippingMethod() throws Exception {
        shippingMethodPage.fillInShippingMethod(1);
        System.out.println("shipping meth "+shippingMethodPage.getShippingMessage().toLowerCase().trim());
        System.out.println("address "+billingPage.getAddress().toLowerCase().trim());
        assertTrue(shippingMethodPage.getShippingMessage().toLowerCase().trim().contains(billingPage.getAddress().toLowerCase().trim()));
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
