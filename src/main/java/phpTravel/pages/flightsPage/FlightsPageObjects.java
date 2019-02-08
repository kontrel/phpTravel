package phpTravel.pages.flightsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FlightsPageObjects {
    private WebDriver driver;
    private WebDriverWait wait;
    int i;
    List<String> dataList;


    public FlightsPageObjects(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindAll(@FindBy(xpath = FlightsPageData.FLIGHTS_PRICE_LIST))
    private List<WebElement> listFlightsPrice;

    @FindBy(xpath = FlightsPageData.CONFIRM_BOOKING)
    private WebElement btnConfirmBooking;

    @FindAll(@FindBy(xpath = FlightsPageData.RAPORT_TABLE))
    private List<WebElement> raportTable;

    @FindBy(xpath = FlightsPageData.MONEY_TYPE)
    private WebElement moneyType;

    @FindBy(xpath = FlightsPageData.USD_TYPE)
    private WebElement usdType;

    private int pickCheapestFlight(){
        i = 1000;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"strong\"]")));
        for (WebElement webElement : listFlightsPrice) {
            String price = webElement.getAttribute("innerHTML");
            price = price.substring(0,price.length()-1);
            int j = Integer.parseInt(price);
            if(i>j){
                i=j;
            }
        }
        return i;
    }

    public void bookFlight(){
        wait.until(ExpectedConditions.titleIs("Flights List"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class=\"icon-money-2 go-right\"])[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(moneyType).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'USD')])[2]")));
        usdType.click();
        int lowestPrice = pickCheapestFlight();
        String s = String.format("//span[contains(text(),'%d')]/parent::p/button",lowestPrice);
        WebElement element = driver.findElement(By.xpath(String.format("//span[contains(text(),'%d')]/parent::p/button",lowestPrice)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"btn btn-success btn-lg btn-block completebook\"]")));
        btnConfirmBooking.click();
        prepareDataForReport();
    }

    public void prepareDataForReport(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id=\"invoiceTable\"]/tbody/tr[4]/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td/p")));
        dataList = new ArrayList<String>();
        for (WebElement webElement : raportTable) {
            String data = webElement.getAttribute("innerHTML");
            dataList.add(data);
        }
    }
    }
