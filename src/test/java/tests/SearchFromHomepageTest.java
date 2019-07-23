package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SearchPageSteps;

@RunWith(SerenityRunner.class)
public class SearchFromHomepageTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public SearchPageSteps searchPageSteps;

    @Test
    public void searchingForAGivenProduct(){
        searchPageSteps.isOnHomepage();
        searchPageSteps.fillingSearchField();
        searchPageSteps.shouldBeOnSearchResultsPage();
    }
}
