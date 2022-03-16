package AppiumTutorial;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class swipe extends base {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text=\"Views\"]").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Date Widgets\"]").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc=\"9\"]").click();

        TouchAction action = new TouchAction(driver);

        driver.findElementByXPath("//*[@content-desc=\"25\"]").click();




    }
}