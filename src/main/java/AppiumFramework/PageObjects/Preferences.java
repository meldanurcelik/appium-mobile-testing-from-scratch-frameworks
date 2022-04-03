package AppiumFramework.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Preferences {

    public Preferences(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    public WebElement preferenceDependencies;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> buttons;

}