import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ecommerce_testcase_5 extends base_hybrid {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Melda");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkey\"));");
        driver.findElement(By.xpath("//*[@text='Turkey']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);

        //Mobile Gestures
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction action = new TouchAction(driver);
        action.tap(tapOptions().withElement(element(checkbox))).perform();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();

        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        driver.context("NATIVE_APP");
        driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
        driver.findElement(By.className("android.widget.EditText")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

}