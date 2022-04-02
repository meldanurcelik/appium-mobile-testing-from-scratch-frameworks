package AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws MalformedURLException {

        File appDir = new File("src");
        File app = new File(appDir, appName);

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_XL_API_30");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);

        return driver;
    }

}