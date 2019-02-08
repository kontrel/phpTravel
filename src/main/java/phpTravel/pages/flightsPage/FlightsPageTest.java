package phpTravel.pages.flightsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import phpTravel.ExcelRaport;
import phpTravel.SingletonWebDriver;
import pl.b2b.testfactory.annotations.TestFactoryMethod;

public class FlightsPageTest {
    private SingletonWebDriver singletonWebDriver;
    private WebDriver driver;
    private WebDriverWait wait;
    private FlightsPageObjects flightsPageObjects;
    private ExcelRaport excelRaport = new ExcelRaport();

    @BeforeTest
    public void beforeTest(){
        singletonWebDriver = SingletonWebDriver.getInstance();
        driver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        flightsPageObjects = new FlightsPageObjects(driver,wait);
    }

    @Test
    @TestFactoryMethod(description = "booking flight for user",value = "Book Flight",group = "phpTravel")
    public void bookFlight() {
            flightsPageObjects.bookFlight();
            excelRaport.writeToExcelPositive(flightsPageObjects.dataList);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
