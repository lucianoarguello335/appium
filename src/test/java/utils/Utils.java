package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import java.util.Random;

public class Utils {

    private AppiumDriver driver;

    public Utils(AppiumDriver driver){
        this.driver = driver;
    }

    public void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean objectExists(By by) {
        try {
            if (driver.findElements(by).size() == 0) {
                return false;
            } else {
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean inputValueInTextBox(String text, By by) {
        boolean flag = false;
        try {
            if (driver.findElement(by).isDisplayed()) {
                driver.findElement(by).click();
                driver.findElement(by).clear();
                driver.findElement(by).sendKeys(text);
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public String getElementText(By by) {
        if (driver.findElement(by).isDisplayed()) {
            return driver.findElement(by).getText();
        } else {
            throw new ElementNotInteractableException("Element Not Found");
        }
    }

    public String getRandomName() {
        String[] names = {"John", "Steve", "Jack", "Tom", "Tomas", "Luciano", "Latch", "Pamela"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
