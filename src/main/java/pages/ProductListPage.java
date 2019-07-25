package pages;


import models.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import tools.Constants;
import tools.Utils;

import java.util.List;
import java.util.Random;

//@DefaultUrl("http://qa1.dev.evozon.com/catalogsearch/result/?q=necklace")
public class ProductListPage extends PageObject {

    @FindBy(css = ".products-grid .item a>img")
    private List<WebElementFacade> productsImageList;

    @FindBy(css = ".product-info")
    private List<WebElementFacade> productsDetailsList;

    private Integer randomIndex;


    public List<WebElementFacade> getProductsLinksList() {
        return productsImageList;
    }

    public void chooseRandomProduct() {
        if (productsImageList.size() == 1) {
            randomIndex = 0;
        } else {
            randomIndex = new Random().nextInt(productsImageList.size() - 1);
        }
    }

    public void saveChosenProduct() {

        WebElementFacade productChosen = productsDetailsList.get(randomIndex);

        String productName = productChosen.findElement(By.cssSelector(".product-info .product-name")).getText();
        Double productPrice = 0.0;
        System.out.println(productName);
        try {
            productPrice = Utils.convertPriceToDouble(productChosen.findElement(By.cssSelector(".regular-price")).getText());
            System.out.println(productPrice);
        } catch (NoSuchElementException e) {
            System.out.println("no regular price found");
        }

        try {
            productPrice = Utils.convertPriceToDouble(productChosen.findElement(By.cssSelector(".special-price")).getText());
            System.out.println(productPrice);
        } catch (NoSuchElementException e) {
            System.out.println("no discounted price found");
        }

        Product product = new Product(productName, productPrice, 1);
        Serenity.setSessionVariable(Constants.PROD_FROM_LIST_PAGE_VAR_NAME).to(product);

    }

    public void goToChosenProductPage() {
        productsImageList.get(randomIndex).click();
    }


}
