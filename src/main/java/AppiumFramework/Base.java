package AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class Base {

    public static AppiumDriverLocalService service;

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

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/AppiumFramework/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        prop.get(appName);

        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));

        DesiredCapabilities cap = new DesiredCapabilities();

        String device = (String) prop.get("deviceName");
        if (device.contains("Pixel")) {
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

}