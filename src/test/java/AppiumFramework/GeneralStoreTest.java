package AppiumFramework;

import AppiumFramework.PageObjects.CheckoutPage;
import AppiumFramework.PageObjects.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GeneralStoreTest extends Base {

    @Test
    public void totalValidation() throws IOException, InterruptedException {

        //service = startServer();

        AndroidDriver<AndroidElement> driver = runCapabilities("GeneralStoreApp", true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FormPage formPage = new FormPage(driver);
        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        formPage.getNameField().sendKeys("Hello");
        driver.hideKeyboard();

        //driver.findElement(By.xpath("//*[@text='Female']")).click();
        formPage.femaleOption.click();

        //driver.findElement(By.id("android:id/text1")).click();
        formPage.getCountrySelection().click();

        Utilities utilities = new Utilities(driver);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        utilities.scrollTotText("Argentina");

        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(4000);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        for (int i = 0; i < count; i++) {
            String amount1 = checkoutPage.productList.get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount; //280.97+116.97
        }

        System.out.println(sum + " sum of products");

        //total = checkoutPage.totalAmount.getText();
        String total = checkoutPage.totalAmount.getText();
        total = total.substring(1);

        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + " Total value of products");
        Assert.assertEquals(sum, totalValue);

        //service.stop();
    }

    //@BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2value = Double.parseDouble(value);

        return amount2value;
    }

}