package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.HeaderPage;
import tools.Constants;

public class SearchPageSteps {

    public SearchPageSteps() {
    }

    private HeaderPage headerPage;

    @Step
    public void isOnHomepage() {
        headerPage.open();
    }

    @Step
    public void fillingSearchField() {
        headerPage.typeInSearchField(Constants.SEARCH_PROD);
    }

    @Step
    public void shouldBeOnSearchResultsPage() {
        Assert.assertTrue(headerPage.containsText("SEARCH RESULTS FOR '" + Constants.SEARCH_PROD + "'"));
    }

    @StepGroup
    public void performProductSearch() {
        isOnHomepage();
        fillingSearchField();
    }
}
