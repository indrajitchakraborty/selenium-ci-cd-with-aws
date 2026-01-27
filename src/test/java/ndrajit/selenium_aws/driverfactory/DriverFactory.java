package ndrajit.selenium_aws.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        tdriver.set(driver);
    }

    public static WebDriver getDriver(){
        return tdriver.get();
    }

    public static void quitDriver(){
        WebDriver driver = tdriver.get();
        if(driver != null){
            driver.quit();
            tdriver.remove();
        }
    }


}
