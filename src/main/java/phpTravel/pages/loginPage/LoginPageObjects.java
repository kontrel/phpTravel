package phpTravel.pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPageObjects(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = LoginPageData.USERNAME)
    private  WebElement inputUsername;

    @FindBy(xpath = LoginPageData.PASSWORD)
    private WebElement inputPassword;

    @FindBy(xpath = LoginPageData.LOGIN_BTN)
    private WebElement btnLogin;

    public String logIn(String username,String password){
        String url = driver.getCurrentUrl();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"username\"]")));
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        return url;
    }
}
