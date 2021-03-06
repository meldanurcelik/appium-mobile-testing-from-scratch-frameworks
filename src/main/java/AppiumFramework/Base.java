package AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class Base {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    public AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunnning(4723);

        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }

        return service;
    }

    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }

        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start startEmulator.bat");
        Thread.sleep(10000);
    }

    public AndroidDriver<AndroidElement> runCapabilities(String appName, Boolean cloud) throws IOException, InterruptedException {
        if (cloud) {
            return cloudCapabilities(appName);
        } else {
            return capabilities(appName);
        }
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/AppiumFramework/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        prop.get(appName);

        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));

        DesiredCapabilities cap = new DesiredCapabilities();

        //String device = (String) prop.get("deviceName");
        String device = System.getProperty("deviceName");
        if (device.contains("emulator")) {
            startEmulator();
        }

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);

        return driver;
    }

    public static AndroidDriver<AndroidElement> cloudCapabilities(String appName) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/AppiumFramework/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        prop.get(appName);

        DesiredCapabilities cap = new DesiredCapabilities();

        // Set your access credentials
        cap.setCapability("browserstack.user", "meldanurelik_NIXbS5"); // for browserstack
        cap.setCapability("browserstack.key", "L3eMJpbjdFGwe2dc9pzn"); // for browserstack

        if (appName.equalsIgnoreCase("GeneralStoreApp")) {
            cap.setCapability("app", "bs://e10543b3ad13f73d05ba451e32b3ebf375590317"); // for browserstack
        } else if (appName.equalsIgnoreCase("ApiDemosApp")) {
            cap.setCapability("app", "bs://4727baba7620468160683c7eab951aba84ea7eac"); // for browserstack
        }

        // Specify device and os_version for testing
        cap.setCapability("device", "Samsung Galaxy S20"); // for browserstack
        cap.setCapability("os_version", "10.0"); // for browserstack

        // Initialise the remote Webdriver using BrowserStack remote URL and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), cap);

        return driver;
    }

    public static void getScreenshot(String s) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/" + s + ".png"));
    }

}