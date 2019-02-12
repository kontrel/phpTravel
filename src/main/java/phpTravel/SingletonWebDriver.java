package phpTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {

    private static SingletonWebDriver instance;
    private WebDriver webDriver;
    private WebDriverWait wait;

    private SingletonWebDriver() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "src\\main\\resources\\Geckodriver.exe");
        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, 20);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public static SingletonWebDriver getInstance() {
        if (instance == null) {
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
