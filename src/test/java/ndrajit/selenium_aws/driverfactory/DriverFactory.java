package ndrajit.selenium_aws.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    @BeforeTest
    public void setupBrowser(){

        try {
            String browser = System.getProperty("browser", "chrome");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(browser);
            WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"),cap);
            setDriver(driver);
            getDriver().get("https://automationexercise.com/");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setDriver(WebDriver driver){

        tdriver.set(driver);

    }

    public static WebDriver getDriver(){

        return tdriver.get();
    }


}
