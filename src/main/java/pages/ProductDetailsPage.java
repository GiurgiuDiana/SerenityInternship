package pages;


import models.ConfigurableProduct;
import models.Product;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import tools.Utils;


import java.util.List;

//@DefaultUrl("http://qa1.dev.evozon.com/slim-fit-dobby-oxford-shirt-575.html")
//@DefaultUrl("http://qa1.dev.evozon.com/jingle-dress.html")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = "#msrp-popup-553oWeJzVVjR2rtBHnvB8Di")
    private WebElementFacade clickForPriceButton;

    @FindBy(css = "#map-popup")
    private WebElementFacade hiddenPriceBox;

    @FindBy(css = ".product-shop .product-name")
    private WebElementFacade productName;

    @FindBy(css = "#qty")
    private WebElementFacade quantityInput;

    private List<WebElementFacade> colorsList;

    private List<WebElementFacade> sizeList;

    private List<WebElementFacade> shoeSizeList;

    private WebElementFacade colorName;

    private WebElementFacade sizeName;

    private WebElementFacade shoeSizeName;

    //@FindBy(css = ".price-info")
    private WebElementFacade productPrice;

    //@FindBy(css = ".product-shop")
    @FindBy(css = ".main-container")
    private WebElementFacade productDetailsContainer;

    @FindBy(css = ".add-to-cart button")
    private WebElementFacade addToCartButton;

    private Boolean isShoe;

    private int quantity = Utils.getRandomQuantity();


    public WebElementFacade getColorName() {
        try {
            colorName = productDetailsContainer.findBy(By.cssSelector("#select_label_color"));
        } catch (NoSuchElementException e) {
            System.out.println("product does not have colors");
        }
        return colorName;
    }

    public WebElementFacade getProductPrice() {

        try{
            productPrice = productDetailsContainer.findBy(By.cssSelector(".price-info"));
        }
        catch (NoSuchElementException e){
            System.out.println("no regular price found");
        }

        try {
            productPrice = productDetailsContainer.findBy(By.cssSelector(".price-info .special-price"));
        }
        catch (NoSuchElementException e){
            System.out.println("no discounted price found");
        }
        System.out.println(productPrice.getText());
        return productPrice;
    }

    public WebElementFacade getSizeName() {
        if (isShoe) {
            try {
                shoeSizeName = productDetailsContainer.findBy(By.cssSelector("#select_label_shoe_size"));
            } catch (NoSuchElementException e) {
                System.out.println("No different sizes available");
            }
            return shoeSizeName;
        } else {
            try {
                sizeName = productDetailsContainer.findBy(By.cssSelector("#select_label_size"));
            } catch (NoSuchElementException e) {
                System.out.println("No different sizes available");
            }
            //sizeName = productDetailsContainer.findBy(By.cssSelector("#select_label_size"));
            return sizeName;
        }
    }

    public WebElementFacade getProductName() {
        return productName;
    }


    public List<WebElementFacade> getColors() {
        try {
            colorsList = productDetailsContainer.thenFindAll(By.cssSelector("#configurable_swatch_color>li:not(.not-available)"));
        } catch (NoSuchElementException e) {
            System.out.println("product does not have different colors");
        }
        return colorsList;
    }

    public List<WebElementFacade> getSizes() {
        try {
            sizeList = productDetailsContainer.thenFindAll(By.cssSelector("#configurable_swatch_size>:not(.not-available)"));
            //System.out.println("finding the size list for clothes");
            if (sizeList.size() > 0) {
                isShoe = false;
                return sizeList;
            }
        } catch (NoSuchElementException e) {
            System.out.println("no sizes or it's a shoe");
        }

        try {
            sizeList = productDetailsContainer.thenFindAll(By.cssSelector("#configurable_swatch_shoe_size>li:not(.not-available)"));
            //System.out.println("finding the size list for shoes");
            //System.out.println(sizeList.size());
            if (sizeList.size() > 0) {
                isShoe = true;
            }
            //return sizeList;
        } catch (NoSuchElementException e) {
            System.out.println("no sizes or not a shoe");
        }
        return sizeList;
    }

    public void setRandomQuantity() {
        quantityInput.clear();
        quantityInput.sendKeys(Integer.toString(quantity));
    }

    public void saveProductObject(){

    }

    public Product addToCart(){
        //System.out.println(colorsList.size());
        //System.out.println(sizeList.size());
        Product product;
        if(colorsList.size()==0 && sizeList.size()==0){ //if the product does not have colors or sizes options it means it's not configurable
            product = new Product(productName.getText(), Utils.convertPriceToDouble(getProductPrice().getText()), quantity);
        }
        else {
            product = new ConfigurableProduct(productName.getText(), Utils.convertPriceToDouble(getProductPrice().getText()), getColorName().getText(), getSizeName().getText(), quantity);
        }
        //System.out.println(product.toString());
        addToCartButton.click();
        return product;
    }

}
