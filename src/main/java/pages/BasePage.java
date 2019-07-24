package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject {


    public void waitForElementToBeVisible(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
