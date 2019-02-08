package phpTravel.pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phpTravel.SingletonWebDriver;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class LoginPageTest {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPageObjects loginPageObjects;

    @BeforeTest
    public void beforeTest(){
        singletonWebDriver = SingletonWebDriver.getInstance();
        driver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        loginPageObjects = new LoginPageObjects(driver,wait);
    }

    @Test
    @TestFactoryMethod(description = "account login", value = "Login", group = "phpTravel")
    public void loginTest(){
        loginPageObjects.logIn("user@phptravels.com","demouser");

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
