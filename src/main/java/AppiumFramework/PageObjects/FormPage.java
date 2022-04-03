package AppiumFramework.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    public FormPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    //driver.findElement(By.xpath("")).click();
    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleOption;

    //driver.findElement(By.id("android:id/text1")).click();
    @AndroidFindBy(id = "android:id/text1")
    public WebElement countrySelectiion;

}