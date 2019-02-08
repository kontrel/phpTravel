package phpTravel.pages.accountPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPageObjects {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPageObjects(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = AccountPageData.FLIGHTS)
    private WebElement btnFlights;

    public void goToFlights(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"https://www.phptravels.net/m-flights\"]")));
        btnFlights.click();
    }
}
