import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class browse extends base_browse {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        driver.findElement(By.cssSelector("a[href*='products']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
        Assert.assertEquals(text, "Devops");

    }
}