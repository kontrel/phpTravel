package phpTravel.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import phpTravel.SingletonWebDriver;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class HomePageTest {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver driver;
    private WebDriverWait wait;
    HomePageObjects homePageObjects;

    @BeforeTest
    public void beforeTest(){
        singletonWebDriver = SingletonWebDriver.getInstance();
        driver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        homePageObjects = new HomePageObjects(driver,wait);
    }

    @Test
    @TestFactoryMethod(description = "user login", value = "Open login page", group = "phpTravel")
    public void loginTest(){
        driver.get(HomePageData.URL);
        Assert.assertEquals(homePageObjects.goToLoginPage(),"https://www.phptravels.net/login");
    }

    @Test
    @TestFactoryMethod(description = "searching flights", value = "Search Flight", group = "phpTravel")
    @Parameters({"flightFrom","flightTo","fromAirportCode","toAirportCode","departDate","returnDate"})
    public void searchFlights(String flightFrom, String flightTo, String fromAirportCode, String toAirportCode, String departDate, String returnDate){
        homePageObjects.searchFlights(flightFrom,flightTo, fromAirportCode,toAirportCode,departDate,returnDate);
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
