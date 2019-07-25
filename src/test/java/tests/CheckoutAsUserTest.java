package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.CheckoutAsUserSteps;
import steps.LoginSteps;


@RunWith(SerenityRunner.class)
public class CheckoutAsUserTest extends BaseTest {
    @Steps
    public CheckoutAsUserSteps checkoutAsUserSteps;
    @Steps
    public LoginSteps loginSteps;

    @Test
    public void completeCheckout() throws Exception {
        loginSteps.isOnHomepage();
        loginSteps.reachLoginFromHomepage();
        loginSteps.fillingLoginRequiredFields();
        loginSteps.goToCheckoutPage();
        //   checkoutAsUserSteps.userIsOnCheckoutPage();
        checkoutAsUserSteps.fillBillingInformation();
        checkoutAsUserSteps.fillShippingInformation();
        checkoutAsUserSteps.chooseShippingMethod(loginSteps.checkTheBillingInfoEqualsShippingInfo());
        checkoutAsUserSteps.paymentInformation();
        checkoutAsUserSteps.orderReviewPage();
    }
}
