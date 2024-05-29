package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.AndroidDriverFactory;
import utils.Utils;

public class RidesPage {
    AndroidDriver driver = null;
    AndroidDriverFactory androidDriverFactory = AndroidDriverFactory.getInstanceOfAndroidDriverFactory();
    Utils utils;

    // Page Objects
    private static final By ridesLabel = By.xpath("//android.widget.TextView[@text=\"Rides\"]");
    private static final By optionsButton = By.id("com.hdw.james.rider:id/MAIN_MENU_ID");

    public void launchPage(){
        driver = androidDriverFactory.getDriver();
        utils = new Utils(driver);
        checkRidesOpened();
    }

    public void checkRidesOpened(){
        if(utils.objectExists(ridesLabel)){
            Assert.assertTrue(true,"Correctly located on 'Rides' Screen");
        } else{
            Assert.fail("Not on 'Rides' Screen");
        }
    }

    public void clickOptionsButton(){
        System.out.println("Clicking 'Options' Button");
        utils.clickElement(optionsButton);
    }
}
