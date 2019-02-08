package phpTravel.pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageObjects {
    private WebDriverWait wait;
    private WebDriver driver;

    public HomePageObjects(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = HomePageData.MY_ACCOUNT)
    private WebElement btnMyAccount;

    @FindBy(xpath = HomePageData.LOGIN)
    private WebElement btnLogin;

    @FindBy(xpath = HomePageData.FLIGHT_FROM)
    private WebElement fieldFlightFrom;

    @FindBy(xpath = HomePageData.FLIGHT_INPUT)
    private WebElement inputFlight;

    @FindBy(xpath = HomePageData.FLIGHT_TO)
    private WebElement fieldFlightTo;

    @FindBy(xpath = HomePageData.ROUND_TRIP)
    private WebElement checkboxRoundTrip;

    @FindBy(xpath = HomePageData.DEPART)
    private WebElement inputDepart;

    @FindBy(xpath = HomePageData.RETURN)
    private WebElement inputReturn;

    @FindBy(xpath = HomePageData.PASSANGERS)
    private WebElement inputPassangers;

    @FindBy(xpath = HomePageData.SEARCH_BUTTON)
    private WebElement btnSearch;

    @FindAll(@FindBy(xpath = HomePageData.FLIGHTS_RESULT))
    private List<WebElement> airportList;


    public String goToLoginPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id=\"li_myaccount\"]")));
        btnMyAccount.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"https://www.phptravels.net/login\"]")));
        btnLogin.click();
        wait.until(ExpectedConditions.titleIs("Login"));
        String url = driver.getCurrentUrl();
        return url;
    }

    public void searchFlights(String from, String to, String fromAirportCode, String toAirportCode, String departTime, String returnTime){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"s2id_location_from\"]")));
        fieldFlightFrom.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"select2-drop\"]/div/input")));
        inputFlight.sendKeys(from);
        pickAirport(fromAirportCode);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"s2id_location_to\"]")));
        fieldFlightTo.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"select2-drop\"]/div/input")));
        inputFlight.sendKeys(to);
        pickAirport(toAirportCode);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"round\"]")));
        checkboxRoundTrip.click();
        inputDepart.sendKeys(departTime);
        inputReturn.sendKeys(returnTime);
        btnSearch.click();
    }

    private void pickAirport(String airportCode){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class=\"select2-results\"]/li/div")));
        for (WebElement webElement : airportList) {
            if(webElement.getAttribute("innerHTML").contains(airportCode)){
                webElement.click();
                break;
            }
        }
    }

}
