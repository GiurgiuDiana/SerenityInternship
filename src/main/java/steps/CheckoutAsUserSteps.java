package steps;


import models.Product;
import net.thucydides.core.annotations.Step;
import pages.*;

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
    public void chooseShippingMethod() throws Exception {
        shippingMethodPage.fillInShippingMethod(1);
        String billingInfor=billingPage.getAddress().toLowerCase().replace(",","");
        String addressInput= shippingMethodPage.getShippingMessage().toLowerCase().replace(",","");
        System.out.println(billingInfor);
        System.out.println(addressInput);
        assertTrue(addressInput.trim().contains(billingInfor.trim()));
    }

    @Step
    public void paymentInformation() {
        paymentInformationPage.pressContinue();
    }

    @Step
    public void orderReviewPage() {
        List<Product> prod=orderReviewPage.productOrderReviewList();
        orderReviewPage.pressPlaceOrder();
    }

}
