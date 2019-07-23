package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.SearchPageSteps;

@RunWith(SerenityRunner.class)
public class SearchFromHomepageTest extends BaseTest{

    @Steps
    public SearchPageSteps searchPageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void searchingForAGivenProduct() {
        loginSteps.performLogin();
        searchPageSteps.isOnHomepage();
        searchPageSteps.fillingSearchField();
        searchPageSteps.shouldBeOnSearchResultsPage();
    }
}
