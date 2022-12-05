import com.inivos.util.AppiumTestSupport;
import com.inivos.util.ElementTestSupport;
import com.thoughtworks.qdox.model.expression.And;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

//API_DEMOS TEXT tests
public class LoginTests {
    private final String PACKAGE;
    private AndroidDriver<?> driver;

    public LoginTests(AndroidDriver<?> driver, String packageName) {
        this.PACKAGE = packageName;
        this.driver = driver;
    }

    public void PRFL_21_T1() throws InterruptedException {
        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");

        //Email Verify
        AppiumTestSupport.buttonClick(driver, "Verify", "AccessibilityId");

        //
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Authenticate\"]")));
        AndroidElement input = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.widget.EditText", "xpath");

        AppiumTestSupport.tapOnElementPerform(driver, input, 10);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.H, AndroidKey.A, AndroidKey.R, AndroidKey.I, AndroidKey.N, AndroidKey.D, AndroidKey.U,});
    }

    @Test
    public void PRFL_21_T2() throws InterruptedException, IOException {
        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");

        AndroidElement emailInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Log in\"]/android.view.View/android.widget.EditText[1]", "xpath");
        AppiumTestSupport.tapOnElementPerform(driver, emailInput, 10);
        AppiumTestSupport.customWaitAction(driver, 2);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.K, AndroidKey.X, AndroidKey.AT, AndroidKey.M, AndroidKey.A, AndroidKey.I, AndroidKey.L, AndroidKey.I, AndroidKey.N, AndroidKey.A, AndroidKey.T, AndroidKey.O, AndroidKey.R, AndroidKey.PERIOD, AndroidKey.C, AndroidKey.O, AndroidKey.M});

        AppiumTestSupport.hideKeyboard(driver);
        AndroidElement passInput = (AndroidElement) AppiumTestSupport.locateElement(driver, "//android.view.View[@content-desc=\"Log in\"]/android.view.View/android.widget.EditText[2]", "xpath");
        AppiumTestSupport.tapOnElementPerform(driver, passInput, 10);
        AppiumTestSupport.customWaitAction(driver, 2);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.H, AndroidKey.A, AndroidKey.R, AndroidKey.I, AndroidKey.N, AndroidKey.D, AndroidKey.U,});
        AppiumTestSupport.hideKeyboard(driver);
        AppiumTestSupport.customWaitAction(driver, 2);

        AppiumTestSupport.buttonClick(driver, "Login", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 2);
        AppiumTestSupport.getScreenshot(driver, "./screenshots/login.png");
        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");
        AppiumTestSupport.customWaitAction(driver, 3);
        AppiumTestSupport.getScreenshot(driver, "./screenshots/account.png");

        AppiumTestSupport.swipeByPercentagePerform(driver, 0.01, 0.8, 0.5, "Horizontal", 2000);
        AppiumTestSupport.buttonClick(driver, "Log out", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 2);
        AppiumTestSupport.getScreenshot(driver, "./screenshots/logged_out.png");
    }

    @Test
    public void PRFL_22() throws InterruptedException {
        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");
        //Click on Sign up
        AppiumTestSupport.buttonClick(driver, " Sign up", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 3);

        System.out.println(driver.getPageSource());
        AndroidElement content = (AndroidElement) AppiumTestSupport.locateElement(driver, "android:id/content", "id");
        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.5, 0.2));
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.H, AndroidKey.A, AndroidKey.R, AndroidKey.I, AndroidKey.N, AndroidKey.D, AndroidKey.U,});
        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.5, 0.3));
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.K, AndroidKey.X, AndroidKey.AT, AndroidKey.M, AndroidKey.A, AndroidKey.I, AndroidKey.L, AndroidKey.I, AndroidKey.N, AndroidKey.A, AndroidKey.T, AndroidKey.O, AndroidKey.R, AndroidKey.PERIOD, AndroidKey.C, AndroidKey.O, AndroidKey.M});
        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.5, 0.4));
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.H, AndroidKey.A, AndroidKey.R, AndroidKey.I, AndroidKey.N, AndroidKey.D, AndroidKey.U,});
        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.5, 0.5));
        AppiumTestSupport.customWaitAction(driver, 1);
        AppiumTestSupport.pressMultipleAndroidKey(driver, new AndroidKey[]{AndroidKey.T, AndroidKey.H, AndroidKey.A, AndroidKey.R, AndroidKey.I, AndroidKey.N, AndroidKey.D, AndroidKey.U,});

        AppiumTestSupport.hideKeyboard(driver);
        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.4, 0.6));

        AppiumTestSupport.tapOnCoordinatePerform(driver, AppiumTestSupport.getCoordinateOnElementPerc(content, 0.5, 0.69));
        AppiumTestSupport.customWaitAction(driver, 3);

        AppiumTestSupport.buttonClick(AppiumTestSupport.waitUntilVisibilityOfElement(driver,60,By.xpath("//android.widget.Button[@content-desc=\"Back to Home\"]")));
        AppiumTestSupport.customWaitAction(driver, 2);

        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");
        AppiumTestSupport.customWaitAction(driver, 2);

        AppiumTestSupport.swipeByPercentagePerform(driver, 0.01, 0.8, 0.5, "Horizontal", 2000);
        AppiumTestSupport.buttonClick(driver, "Log out", "AccessibilityId");
        AppiumTestSupport.customWaitAction(driver, 2);
    }

    @Test
    public void PRFL_23() throws InterruptedException{
        //Click account icon
        AppiumTestSupport.buttonClick(driver, "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]", "xpath");

        AppiumTestSupport.buttonClick(driver,"Forgot Password","AccessibilityId");

        AndroidElement reset = (AndroidElement) AppiumTestSupport.locateElement(driver,"//android.view.View[@content-desc=\"Reset password\"]/android.view.View/android.widget.EditText","xpath");
        AppiumTestSupport.buttonClick(reset);
        AppiumTestSupport.customWaitAction(driver,1);
        AppiumTestSupport.sendTextInput(reset,"tkx@mailinator.com");

        AppiumTestSupport.buttonClick(driver,"Reset","AccessibilityId");
        AppiumTestSupport.customWaitAction(driver,5);
    }
}