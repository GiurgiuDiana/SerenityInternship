package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.HeaderPage;
import tools.Constants;


public class SearchPageSteps {

    public SearchPageSteps() {
    }

    public String searchKeyword,productName,productPrice;

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
    public void fillSearchField(String keyword){
        headerPage.typeInSearchField(keyword);
    }

    @StepGroup
    public void performMultipleSearches(){
        fillSearchField(searchKeyword);
        System.out.println(productName + " " + productPrice);
        shouldBeOnSearchResultsPage();
    }

    @Step
    public void shouldBeOnSearchResultsPage() {
        Assert.assertTrue(headerPage.containsText("SEARCH RESULTS FOR '" + searchKeyword.toUpperCase() + "'"));
    }

    @StepGroup
    public void performProductSearch() {
        isOnHomepage();
        fillingSearchField();
    }
}
