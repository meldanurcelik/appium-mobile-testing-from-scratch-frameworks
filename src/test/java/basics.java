import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Preference\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]").click();
		driver.findElementById("android:id/checkbox").click();

		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

		System.out.println();

	}

}