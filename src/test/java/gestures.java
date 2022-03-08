import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class gestures extends base {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text=\"Views\"]").click();

        //Tap
        TouchAction action = new TouchAction(driver);
        WebElement expandList =  driver.findElementByXPath("//android.widget.TextView[@text=\"Expandable Lists\n\"]");

        action.tap(TapOptions.tapOptions().withElement(element(expandList))).perform();

    }
}
