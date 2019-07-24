package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa1.dev.evozon.com/")
public class HeaderPage extends PageObject {

    public HeaderPage() {
        super();
    }

    @FindBy(css = ".skip-link.skip-account .label")
    private WebElementFacade accountButton;

    @FindBy(css = "a[title = 'Log In']")
    private WebElementFacade logInButton;

    @FindBy(css = "a[title = 'Register']")
    private WebElementFacade registerButton;

    @FindBy(css = "#search")
    private WebElementFacade searchField;

    @FindBy(css=".header-minicart >a")
    private WebElementFacade minicartButton;

    @FindBy(css=".button.checkout-button")
    private WebElementFacade minicartCheckoutButton;

    @FindBy(css=".minicart-wrapper")
    private WebElementFacade minicartMenu;

    public void clickOnAccountButton() {
        accountButton.waitUntilClickable().click();
    }

    public void clickOnLoginFromAccountSublist() {
        logInButton.waitUntilClickable().click();
    }

    public void clickOnRegisterFromAccountSublist() {
        registerButton.waitUntilClickable().click();
    }

    public void typeInSearchField(String message) {
        searchField.clear();
        searchField.sendKeys(message + "\n");
    }

    public  void clickOnMinicartButton()
    {
        minicartButton.click();
    }
    public void waitForMinicartMenuToAppear()
    {
        minicartMenu.waitUntilVisible();
    }
    public void clickMinicartCheckout()
    {
        minicartCheckoutButton.click();
    }
    public void goToCheckoutPage()
    {
        clickOnMinicartButton();
        waitForMinicartMenuToAppear();
        clickMinicartCheckout();
    }
}