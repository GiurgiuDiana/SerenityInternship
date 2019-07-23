package pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/result/?q=necklace")
public class ProductListPage extends PageObject {

    @FindBy(css = ".products-grid .item a>img")
    private List<WebElementFacade> productsImageList;

    @FindBy(css = ".product-info")
    private List<WebElementFacade> productsList;


    public List<WebElementFacade> getProductsLinksList() {
        return productsImageList;
    }

    public void goToRandomProductPage() {
        Integer randomIndex = new Random().nextInt(productsImageList.size() - 1);
        productsImageList.get(randomIndex).click();
    }


}
