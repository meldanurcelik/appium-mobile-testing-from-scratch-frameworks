package PageObjectModel;

import AppiumTutorial.BaseHybrid;
import PageObjectModel.PageObjects.HomePage;
import PageObjectModel.PageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Basics extends BaseHybrid {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        //Constructor of class will be invoked when you create object for the class
        //default constructor be class
        //constructor can be defined with arguments

        //driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Preference\"]").click();
        //You can call the methods or variables of the class with class object
        homePage.preferences.click();

        Preferences preferences = new Preferences(driver);
        //driver.findElementByXPath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]").click();
        preferences.preferenceDependencies.click();

        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");

        //driver.findElementById("android:id/button1").click();
        //driver.findElementByClassName("android.widget.Button").get(1).click();
        preferences.buttons.get(1).click();

    }

}