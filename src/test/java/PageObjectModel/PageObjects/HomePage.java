package PageObjectModel.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//All the objects belonging to one page  will be defined in java class
public class HomePage {

    //1. Is to call the driver object from testcase to page object file
    //concatenate driver
    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Preference\"]")
    public WebElement Preferences;

}