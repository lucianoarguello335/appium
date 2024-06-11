package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.AndroidDriverFactory;
import utils.Utils;
import java.time.Duration;


public class AccountPage {
    AndroidDriver driver = null;
    AndroidDriverFactory androidDriverFactory = AndroidDriverFactory.getInstanceOfAndroidDriverFactory();
    Utils utils = Utils.getInstance(driver);

    // Page Objects
    private static final By profileNameButton = By.id("com.hdw.james.rider:id/profileName");
    private static final By firstNameInput = By.id("com.hdw.james.rider:id/firstNameInput");
    private static final By lastNameInput = By.id("com.hdw.james.rider:id/lastNameInput");
    private static final By doneButton = By.id("com.hdw.james.rider:id/DEFAULT_TEXT_ACTION_MENU_ID");
    private static final By signoutButton = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.hdw.james.rider:id/actionList\"]/android.view.ViewGroup[5]");
    private static final By cameraButton = By.id("com.hdw.james.rider:id/profileCameraButton");
    private static final By pickFromGalleryButton = By.id("com.hdw.james.rider:id/imagePickeGalleryRow");
    private static final By imageGallerySlot1 = By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]");
    private static final By imageGallerySlot2 = By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[2]");
    private static final By imageGallerySlot3 = By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[3]");
    private static final By confirmImageSelectedButton = By.id("com.hdw.james.rider:id/menu_crop");
    private static final By profileUpdatedSuccessfullyMessage = By.id("com.hdw.james.rider:id/snackbar_text");


    public void launchPage(){
        driver = androidDriverFactory.getDriver();
        checkAccountOpened();
    }

    public void checkAccountOpened(){
        if(utils.objectExists(profileNameButton)){
            Assert.assertTrue(true,"Correctly located on 'Account' Screen");
        } else{
            Assert.fail("Not on 'Account' page");
        }
    }

    public void editUserName(){
        String firstName = utils.getRandomName();
        String lastName = utils.getRandomName();
        utils.inputValueInTextBox(firstName, firstNameInput);
        utils.inputValueInTextBox(lastName, lastNameInput);
    }

    public void clickProfileName(){
        System.out.println("Clicking 'Profile Name' Button");
        utils.clickElement(profileNameButton);
    }

    public void clickSignOutButton(){
        System.out.println("Clicking 'Logout' Button");
        utils.clickElement(signoutButton);
    }

    public void clickDoneButton(){
        System.out.println("Clicking 'Done' Button");
        utils.clickElement(doneButton);
    }

    public void changeProfilePic(){
        int randomInt = new java.util.Random().nextInt(3);
        By[] gallerySlotLocators = {imageGallerySlot1, imageGallerySlot2, imageGallerySlot3};

        utils.clickElement(cameraButton);
        utils.clickElement(pickFromGalleryButton);
        utils.clickElement(gallerySlotLocators[randomInt]);
        utils.clickElement(confirmImageSelectedButton);
        utils.clickElement(doneButton);
    }

    public void checkProfileUpdateSuccess(){
        utils.waitFor(1000);
        if (utils.objectExists(profileUpdatedSuccessfullyMessage)) {
            Assert.assertTrue(true, "User info was updated successfully.");
        } else {
            Assert.fail("User info was not updated.");
        }
    }
}