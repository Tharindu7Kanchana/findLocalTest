import com.inivos.util.AppiumTestSupport;
import com.inivos.util.ElementTestSupport;
import com.thoughtworks.qdox.model.expression.And;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.apache.maven.shared.utils.cli.CommandLineTimeOutException;
import org.example.config.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

//API_DEMOS TEXT tests
public class SearchTests {
    private final String PACKAGE;
    private AndroidDriver<?> driver;

    public SearchTests(AndroidDriver<?> driver, String packageName) {
        this.PACKAGE = packageName;
        this.driver = driver;
    }

    public void PRFL_20_T1() throws InterruptedException, IOException {
        //Search Element
        AndroidElement searchElement = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView", "xpath");
        AppiumTestSupport.tapOnElementPerform(driver, searchElement, 10);

        //Wait till the permission grant dialog
        AppiumTestSupport.waitUntilVisibilityOfElement(driver, 10, By.xpath("//android.view.View[@content-desc=\"Enable geolocation\"]"));
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Enable geolocation\"]")));

        AppiumTestSupport.buttonClick(driver, "Sure, no problem", "AccessibilityId");
        //Give one time location permission
        AppiumTestSupport.buttonClick(AppiumTestSupport.waitUntilVisibilityOfElement(driver, 10, By.id("com.android.permissioncontroller:id/permission_allow_one_time_button")));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/grant_dialog")));

        //AppiumTestSupport.buttonClick(driver, "com.android.permissioncontroller:id/permission_allow_one_time_button", "id");

        //Add Business name
        AndroidElement businessInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Location radius\"]/android.widget.EditText", "xpath");

        AppiumTestSupport.buttonClick(businessInput);
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.sendTextInput(businessInput, "Pop eyes");

        AppiumTestSupport.customWaitAction(driver, 2);

        //Add Location name
        AndroidElement locationInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Location radius\"]/android.widget.ImageView", "xpath");

        AppiumTestSupport.buttonClick(locationInput);
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.sendTextInput(locationInput, "London");

        AppiumTestSupport.hideKeyboard(driver);

        //Swipe the progress bar
        AppiumTestSupport.customWaitAction(driver, 2);
        ElementTestSupport.SeekBar(driver, "//android.widget.SeekBar[@content-desc=\"5.0\"]", "xpath", "Horizontal", 0.99);

        //Search
        AppiumTestSupport.buttonClick(driver, "Search", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 3);
        //Take Screenshot of the result
        AppiumTestSupport.getScreenshot(driver, "./screenshots/result_allowlocation.png");
        AppiumTestSupport.closeApp(driver);
    }

    public void PRFL_20_T2() throws InterruptedException, IOException {
        driver.launchApp();
        //Search Element
        AndroidElement searchElement = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView", "xpath");
        AppiumTestSupport.tapOnElementPerform(driver, searchElement, 10);

        //
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Enable geolocation\"]")));

            AppiumTestSupport.buttonClick(driver, "Sure, no problem", "AccessibilityId");
        } catch (TimeoutException e) {
            System.out.println("Location permission is already granted");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/grant_dialog")));
        AppiumTestSupport.buttonClick(driver, "com.android.permissioncontroller:id/permission_deny_button", "id");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/grant_dialog")));
        AppiumTestSupport.buttonClick(driver, "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button", "id");

        AndroidElement businessInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Location radius\"]/android.widget.EditText", "xpath");

        businessInput.click();
        AppiumTestSupport.customWaitAction(driver, 2);

        businessInput.sendKeys("Pop eyes");

        AppiumTestSupport.customWaitAction(driver, 2);

        AndroidElement locationInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Location radius\"]/android.widget.ImageView", "xpath");

        locationInput.click();
        AppiumTestSupport.customWaitAction(driver, 2);

        locationInput.sendKeys("London");
        AppiumTestSupport.hideKeyboard(driver);

        AppiumTestSupport.customWaitAction(driver, 2);
        ElementTestSupport.SeekBar(driver, "//android.widget.SeekBar[@content-desc=\"5.0\"]", "xpath", "Horizontal", 0.99);

        AppiumTestSupport.buttonClick(driver, "Search", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 5);
        AppiumTestSupport.getScreenshot(driver, "./screenshots/result_denylocation.png");
        AppiumTestSupport.buttonClick(driver, "//android.widget.ImageView[@content-desc=\"Pop eyes\n" +
                "This is the pop eyes business \"]", "xpath");
        AppiumTestSupport.customWaitAction(driver, 7);
        AppiumTestSupport.getScreenshot(driver, "./screenshots/popeyes.png");

        AppiumTestSupport.buttonClick(driver, "Call", "AccessibilityId");

        AppiumTestSupport.customWaitAction(driver, 2);

        System.out.println(AppiumTestSupport.getCurrentActivity(driver));

        AppiumTestSupport.activateApp(driver, "com.findlocal.findlocal");

        AppiumTestSupport.swipeByPercentagePerform(driver, 0.8, 0.3, 0.5, "Vertical", 2000);

        AppiumTestSupport.customWaitAction(driver, 2);
        AppiumTestSupport.swipeByPercentagePerform(driver, 0.55, 0.95, 0.5, "Vertical", 2000);
        AppiumTestSupport.buttonClick(driver, "Get directions", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 3);

        AndroidElement view = (AndroidElement) AppiumTestSupport.locateElement(driver, "com.google.android.apps.maps:id/mainmap_container", "id");

        AppiumTestSupport.buttonMultipleClick(view, 2);
        AppiumTestSupport.customWaitAction(driver, 2);

        AppiumTestSupport.buttonMultipleClick(view, 2);
        AppiumTestSupport.customWaitAction(driver, 2);

        AppiumTestSupport.buttonMultipleClick(view, 2);
        AppiumTestSupport.customWaitAction(driver, 4);

    }

}