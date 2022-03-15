import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecommerce_testcase_2 extends base_hybrid {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities("real");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Turkey\").instance(0))"));
        driver.findElement(By.xpath("//*[@text='Turkey']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals("Please enter your name", toastMessage); //Actual validation

    }
}