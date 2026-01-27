package ndrajit.selenium_aws.tests;

import ndrajit.selenium_aws.driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestApp {

    @Test(groups = "smoke")
    public void clickProduct(){

        DriverFactory.getDriver().
                findElement(By.xpath("(//div[@class='shop-menu pull-right']//li)[2]")).click();
        System.out.println("Click on Product successfully..");
    }

    @Test(groups = "regression")
    public void clickHome(){

        DriverFactory.getDriver().
                findElement(By.xpath("(//div[@class='shop-menu pull-right']//li)[1]")).click();
        System.out.println("Click on Home successfully..");
    }
}
