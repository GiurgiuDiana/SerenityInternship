package tests;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.LoginSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/csvfiles/LogInData.csv")
public class LogInFromHomepageTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;

    private String userMail, password, fullUserName;

    @Test
    public void completingLoginFromHomepage() {
        loginSteps.isOnHomepage();
        loginSteps.reachLoginFromHomepage();
        loginSteps.shouldBeOnTheLoginPage();
        loginSteps.fillingLoginRequiredFields(userMail, password);
        loginSteps.shouldBeOnTheAccountPage(fullUserName);
    }
}