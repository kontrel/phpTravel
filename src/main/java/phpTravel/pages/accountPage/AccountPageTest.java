package phpTravel.pages.accountPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phpTravel.SingletonWebDriver;

public class AccountPageTest {
    private SingletonWebDriver singletonWebDriver;
    private WebDriver driver;
    private WebDriverWait wait;
    private AccountPageObjects accountPageObjects;

    @BeforeTest
    public void beforeTest(){
        singletonWebDriver = SingletonWebDriver.getInstance();
        driver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        accountPageObjects = new AccountPageObjects(driver,wait);
    }

    @Test
    public void goToFlights(){
        accountPageObjects.goToFlights();
    }
}
