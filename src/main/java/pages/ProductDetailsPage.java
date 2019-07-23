package pages;



import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;


import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/plaid-cotton-shirt-577.html")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = "#msrp-popup-553oWeJzVVjR2rtBHnvB8Di")
    private WebElementFacade clickForPriceButton;

    @FindBy(css = "#map-popup")
    private WebElementFacade hiddenPriceBox;

    @FindBy(css = " .product-shop .product-name")
    private WebElementFacade productName;

    @FindBy(css = "#configurable_swatch_color>li")
    private List<WebElementFacade> colorsList;

    @FindBy(css = "#configurable_swatch_size>li")
    private List<WebElementFacade> sizeList;

    public List<WebElementFacade> getColors(){
        return colorsList;
    }

}
