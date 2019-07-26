package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import tools.Constants;

public class ShoppingCartSteps {

    public ShoppingCartSteps() {
    }

    private ShoppingCartPage shoppingCartPage;
    private ProductDetailsPage productDetailsPage;

    @Step
    public void isOnProductDetailsPage() {
        productDetailsPage.open();
    }

    @Step
    public void addProductToCart() {
        productDetailsPage.clickAddToCart();
    }

    @Step
    public void shouldBeOnTheShoppingCartPage() {
        Assert.assertTrue(shoppingCartPage.containsText(Constants.CART_PAGE_TITLE));
    }

    @Step
    public void extractingLastProductDetails() {
        boolean isSimple = shoppingCartPage.isSimpleProduct();
        if (isSimple) {
            System.out.println("Simple product");
//            Serenity.setSessionVariable(Constants.PROD_FROM_CART_PAGE_VAR_NAME).to(shoppingCartPage.createSimpleProductFromCart());
        } else {
            System.out.println("Configuarble product");
//            Serenity.setSessionVariable(Constants.PROD_FROM_CART_PAGE_VAR_NAME).to(shoppingCartPage.createConfigurableProductFromCart());
        }
    }

    @Step
    public void compareProductFromCartToDetailsPage() {
        System.out.println(Serenity.sessionVariableCalled(Constants.ADDED_PROD_FROM_DETAILS_PAGE_VAR_NAME).toString());
        System.out.println(Serenity.sessionVariableCalled(Constants.PROD_FROM_CART_PAGE_VAR_NAME).toString());
        Assert.assertTrue(Serenity.sessionVariableCalled(Constants.ADDED_PROD_FROM_DETAILS_PAGE_VAR_NAME).equals(Serenity.sessionVariableCalled(Constants.PROD_FROM_CART_PAGE_VAR_NAME)));
    }

    @StepGroup
    public void validateProductsAreConsistent() {
        shouldBeOnTheShoppingCartPage();
//        extractingLastProductDetails();
        compareProductFromCartToDetailsPage();
    }
}
