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

public class LoginPage {
    AndroidDriver driver = null;
    AndroidDriverFactory androidDriverFactory = AndroidDriverFactory.getInstanceOfAndroidDriverFactory();
    Utils utils;

    // Page Objects
    private static final By getStartedButton = By.id("com.hdw.james.rider:id/getStartedButton");
    private static final By spinnerButton = By.id("com.hdw.james.rider:id/spinner");
    private static final By phoneInputText = By.id("com.hdw.james.rider:id/input");
    private static final By continueButton = By.id("com.hdw.james.rider:id/continueButton");
    private static final By continueOTP_id = By.id("com.hdw.james.rider:id/continueButton");
    private static final By permissionsLocationAllowButton = By.id("com.hdw.james.rider:id/permissionsLocationButton");
    private static final By permissionsLocationAllowConfirmButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private static final By permissionsNotificationsAllowButton = By.id("com.hdw.james.rider:id/permissionsNotificationButton");
    private static final By permissionsNotificationsAllowConfirmButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private static final By permissionsContinueButton = By.id("com.hdw.james.rider:id/permissionsContinueButton");

    public void launchApp(){
        driver = androidDriverFactory.getDriver();
        utils = new Utils(driver);
        if(utils.objectExists(getStartedButton)){
            Assert.assertTrue(true,"Application Launched Successfully!");
        }else{
            Assert.fail("Unable to launch application!");
        }
    }

    public By getGetStartedButton() {
        return getStartedButton;
    }

    public By getPhoneInputText(){
        return phoneInputText;
    }

    public void loginApp(String country, String phone, String otp){
        utils.clickElement(getStartedButton);
        utils.clickElement(spinnerButton);
        selectCountryCode(country);
        utils.inputValueInTextBox(phone, phoneInputText);
        utils.clickElement(continueButton);
        insertOTP(otp);
        utils.clickElement(continueOTP_id);
        utils.waitFor(5000);
        utils.clickElement(permissionsLocationAllowButton);
        utils.clickElement(permissionsLocationAllowConfirmButton);
        utils.clickElement(permissionsNotificationsAllowButton);
        utils.clickElement(permissionsNotificationsAllowConfirmButton);
        utils.clickElement(permissionsContinueButton);
    }

    public void selectCountryCode(String country) {
        WebElement selectedDropdownElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" +
                        ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                        ".text(\" " +
                        country +
                        "\").instance(0))"));
        selectedDropdownElement.click();
    }

    public void insertOTP(String otp) {
        utils.waitFor(3000);
        for (char ch : otp.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + ch);
            driver.pressKey(new KeyEvent(key));
        }
    }

    public void checkLoginStatus(By by, String successMessage, String failureMessage){
        if(utils.objectExists(by)){
            Assert.assertTrue(true, successMessage);
        } else{
            Assert.fail(failureMessage);
        }
    }

}
