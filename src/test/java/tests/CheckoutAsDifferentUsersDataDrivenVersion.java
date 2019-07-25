package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.u;
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/CSVfiles/Checkout.csv")
public class CheckoutAsDifferentUsersDataDrivenVersion{
    @Managed(uniqueSession = true)
    private WebDriver webDriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public SearchPageSteps searchPageSteps;

    @Steps
    public ProductListSteps productListSteps;

    @Steps
    public ProductDetailsSteps productDetailsSteps;
    @Steps
    private CheckoutAsUserSteps checkoutAsUserSteps;


    private String userEmail;
    private String password;

    @Test
    public void checkoutAsLoggedInUser() throws Exception {
        webDriver.manage().window().maximize();
        loginSteps.performLogin(userEmail,password);
        searchPageSteps.fillingSearchField();
        productListSteps.chooseRandomProduct();
        productListSteps.navigateToRandomProduct();
        productDetailsSteps.performProductDetailsSelection();
        productDetailsSteps.clickAddToCart();
        loginSteps.goToCheckoutPage();
        checkoutAsUserSteps.fillBillingInformation();
        checkoutAsUserSteps.fillShippingInformation();
        checkoutAsUserSteps.chooseShippingMethod();
        checkoutAsUserSteps.paymentInformation();
        checkoutAsUserSteps.orderReviewPage();
    }

}
