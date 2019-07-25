package tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.ProductListSteps;
import steps.SearchPageSteps;

import java.io.IOException;

import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;

@RunWith(SerenityRunner.class)
//@UseTestDataFrom(value = "src/test/resources/CSVfiles/product_search.csv")
public class SearchFromHomepageTest extends BaseTest {

    @Steps
    public SearchPageSteps searchPageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public ProductListSteps productListSteps;


    @Ignore
    public void searchingForAGivenProduct(){
        loginSteps.performLogin();
        searchPageSteps.isOnHomepage();
        searchPageSteps.fillingSearchField();
        searchPageSteps.shouldBeOnSearchResultsPage();
    }

    @Test
    public void searchForMultipleProducts() throws IOException {
        loginSteps.performLogin();
        searchPageSteps.isOnHomepage();
        withTestDataFrom("src/test/resources/CSVfiles/product_search.csv")
                .run(productListSteps).performProductSearchAndVerification();
    }
}
