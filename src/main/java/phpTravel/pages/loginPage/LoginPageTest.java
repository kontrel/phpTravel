package phpTravel.pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phpTravel.ExcelRaport;
import phpTravel.SingletonWebDriver;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class LoginPageTest {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPageObjects loginPageObjects;
    private ExcelRaport excelRaport = new ExcelRaport();

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

}
