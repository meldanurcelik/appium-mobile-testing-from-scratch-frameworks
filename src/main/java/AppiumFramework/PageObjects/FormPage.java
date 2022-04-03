package AppiumFramework.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    public FormPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    //driver.findElement(By.xpath("")).click();
    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleOption;

    //driver.findElement(By.id("android:id/text1")).click();
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;

    public WebElement getNameField() {
        System.out.println("trying to find the name field");
        return nameField;
    }

    public WebElement getCountrySelection() {
        System.out.println("selecting the option from dropdown");
        return countrySelection;
    }

}