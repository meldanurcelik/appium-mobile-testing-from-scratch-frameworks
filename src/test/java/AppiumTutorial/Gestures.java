package AppiumTutorial;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Gestures extends Base {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text=\"Views\"]").click();

        //Tap
        TouchAction action = new TouchAction(driver);

        WebElement expandList = driver.findElementByAccessibilityId("Expandable Lists");
        action.tap(tapOptions().withElement(element(expandList))).perform();

        driver.findElementByXPath("//android.widget.TextView[@text=\"1. Custom Adapter\"]").click();

        WebElement peoplename = driver.findElementByXPath("//android.widget.TextView[@text=\"People Names\"]");
        action.longPress(longPressOptions().withElement(element(peoplename)).withDuration(ofSeconds(2))).release().perform();

        System.out.println(driver.findElementById("android:id/title").isDisplayed());

    }

}