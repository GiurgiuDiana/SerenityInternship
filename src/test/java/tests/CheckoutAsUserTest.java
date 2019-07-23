package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.CheckoutAsUserSteps;

@RunWith(SerenityRunner.class)
public class CheckoutAsUserTest
{

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public CheckoutAsUserSteps checkoutAsUserSteps;

    @Test
    public void completeCheckout()
    {
        checkoutAsUserSteps.userIsOnCheckoutPage();
        try {
            wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutAsUserSteps.fillBillingInformation();
        checkoutAsUserSteps.fillShippingInformation();
    }
}
