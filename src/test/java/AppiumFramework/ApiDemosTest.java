package AppiumFramework;

import AppiumFramework.PageObjects.HomePage;
import AppiumFramework.PageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemosTest extends Base {

    @Test
    public void apiDemo() throws IOException, InterruptedException {

        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        homePage.preferences.click();

        Preferences preferences = new Preferences(driver);
        preferences.preferenceDependencies.click();

        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");

        preferences.buttons.get(1).click();

        service.stop();

    }

}