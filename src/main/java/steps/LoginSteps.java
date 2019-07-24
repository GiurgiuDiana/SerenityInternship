package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.HeaderPage;
import pages.LoginPage;
import tools.Constants;

public class LoginSteps {

    public LoginSteps() {
    }

    private HeaderPage headerPage;
    private LoginPage loginPage;

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
    public void fillingLoginRequiredFields() {
        loginPage.inputEmailValueInField();
        loginPage.inputPasswordValueInField();
        loginPage.pressLoginButton();
    }

    @Step
    public void shouldBeOnTheAccountPage() {
        Assert.assertTrue(loginPage.containsText(Constants.USER_NAME));
    }

    @StepGroup
    public void performLogin(){
        isOnHomepage();
        reachLoginFromHomepage();
        fillingLoginRequiredFields();
    }

    @Step
    public void goToCheckoutPage()
    {
        headerPage.goToCheckoutPage();
    }
}