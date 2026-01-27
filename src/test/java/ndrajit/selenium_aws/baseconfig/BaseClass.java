package ndrajit.selenium_aws.baseconfig;

import ndrajit.selenium_aws.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class BaseClass {

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {

        String browser = System.getProperty("browser", "chrome");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);

        WebDriver driver = new RemoteWebDriver(
                new URL("http://selenium-hub:4444/wd/hub"), cap);

        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().get("https://automationexercise.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
