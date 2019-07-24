package tests;

import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Before
    public void setup(){
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
