package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import tools.Constants;

public class LoginSteps {

    public LoginSteps() {
    }

    private HeaderPage headerPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void isOnHomepage() {
        headerPage.open();
    }

    @Step
    public void reachLoginFromHomepage() {
        headerPage.clickOnAccountButton();
        headerPage.clickOnLoginFromAccountSublist();
    }

    @Step
    public void shouldBeOnTheLoginPage() {
        Assert.assertTrue(headerPage.containsText(Constants.LOGIN_PAGE_TITLE));
    }

    @Step
    public void fillingLoginRequiredFields(String email, String password) {
        loginPage.inputEmailValueInField(email);
        loginPage.inputPasswordValueInField(password);
        loginPage.pressLoginButton();
    }

    @Step
    public void fillingLoginRequiredFields() {
        loginPage.inputEmailValueInField(Constants.USER_EMAIL);
        loginPage.inputPasswordValueInField(Constants.USER_PASS);
        loginPage.pressLoginButton();
    }

    @Step
    public void shouldBeOnTheAccountPage(String fullUserName) {
        Assert.assertTrue(loginPage.containsText(fullUserName));
//        Assert.assertTrue(loginPage.containsText(Constants.USER_NAME));
    }

    @StepGroup
    public void performLogin(String email, String password) {
        isOnHomepage();
        reachLoginFromHomepage();
        fillingLoginRequiredFields(email, password);
    }

    @StepGroup
    public void performLogin() {
        isOnHomepage();
        reachLoginFromHomepage();
        fillingLoginRequiredFields();
    }

    @Step
    public void goToCheckoutPage() {
        headerPage.goToCheckoutPage();
    }

    @Step
    public boolean checkTheBillingInfoEqualsShippingInfo() {
        return myAccountPage.defaultBillingInformationFromMyAccount().equalsIgnoreCase(myAccountPage.defaultShippingInformationFromMyAccount());
    }


}