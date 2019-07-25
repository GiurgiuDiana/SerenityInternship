package pages;

import models.Product;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import tools.Utils;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://qa1.dev.evozon.com/checkout/onepage/")
public class OrderReviewPage extends PageObject {

    @FindBy(css = "#shipping_method-progress-opcheckout .complete:nth-child(2) .price")
    private WebElementFacade shippingPriceCheck;

    @FindBy(css = "#payment-progress-opcheckout .subtitle")
    private WebElementFacade checkPaymentInformation;

    @FindBy(css = "[title='Place Order']")
    private WebElementFacade buttonPlaceOrder;

    @FindBy(css="#checkout-review-table .product-name")
    List<WebElementFacade> productNameList;

    @FindBy(css="td[data-rwd-label=\"Price\"]")
    List<WebElementFacade>productPriceList;

    @FindBy(css="td[data-rwd-label=\"Qty\"]")
    List<WebElementFacade>productQtylist;

    public WebElementFacade getShippingPriceCheck() {
        return shippingPriceCheck;
    }

    public WebElementFacade getCheckPaymentInformation() {
        return checkPaymentInformation;
    }

    public void pressPlaceOrder() {
        buttonPlaceOrder.click();
    }

    public List<Product>productOrderReviewList()
    {
        List<Product>productList = new ArrayList<>();
        Product pr= new Product();
        for(int i=0; i<productNameList.size();i++)
        {
            pr.setName(productNameList.get(i).getText());
            pr.setPrice(Utils.convertPriceToDouble(productPriceList.get(i).getText().replace("$","").replace(".","")));
            pr.setQuantity( Integer.parseInt(productQtylist.get(i).getText()));
            System.out.println((productQtylist.get(i).getText()));
//            System.out.println(pr.getName()+pr.getPrice()+pr.getQuantity());
            productList.add(pr);
        }
        return productList;
    }

    public List<String> getProductNameList() {
        List<String>productNames= new ArrayList<>();
        for(WebElementFacade iterate:  productNameList)
        {
            productNames.add(iterate.getText());
        }
        return productNames;
    }

    public List<Double> getProductPriceList() {
        List<Double>productPrices=new ArrayList<>();
        for(WebElementFacade iterate : productPriceList)
        {
            productPrices.add(Utils.convertPriceToDouble(iterate.getText().replace("$","").replace(".","")));
        }
        return productPrices;
    }

    public List<Integer> getProductQtylist() {
        List<Integer>productQuantity= new ArrayList<>();
        for(WebElementFacade iterate: productQtylist)
        {
            productQuantity.add(Integer.parseInt(iterate.getText()));
        }
        return productQuantity;
    }
}
