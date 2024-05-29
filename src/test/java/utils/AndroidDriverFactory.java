package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverFactory {

    private static AndroidDriverFactory instanceOfAndroidDriverFactory = null;
    private AndroidDriver driver;

    private static String appPackage = ConfigFileReader.getConfigPropertyVal("appPackage");
    private static String appActivity = ConfigFileReader.getConfigPropertyVal("appActivity");
    private static String deviceName = ConfigFileReader.getConfigPropertyVal("deviceName");

    private AndroidDriverFactory(){
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", deviceName);
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14.0");
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("newCommandTimeout", 120);

        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    public static AndroidDriverFactory getInstanceOfAndroidDriverFactory(){
        if(instanceOfAndroidDriverFactory == null){
            instanceOfAndroidDriverFactory = new AndroidDriverFactory();
        }
        return instanceOfAndroidDriverFactory;
    }

    public AndroidDriver getDriver(){
        return driver;
    }
}
