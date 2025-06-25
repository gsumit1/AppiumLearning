package AppiumComands;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumConnands {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AppiumDriver driver = new AndroidDriver(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By views = MobileBy.AccessibilityId("Views");
		driver.findElement(views).click();
		
		Thread.sleep(5000);
		
		// driver.terminateApp("io.appium.android.apis");

		// driver.installApp("/Users/riyaanghosh/Downloads/ApiDemos-debug.apk", new
		// AndroidInstallApplicationOptions().withReplaceEnabled());

		// System.out.println(driver.isAppInstalled("io.appium.android.apis"));

		// System.out.println(driver.queryAppState("io.appium.android.apis"));

		// driver.runAppInBackground(Duration.ofMillis(5000));

		driver.terminateApp("io.appium.android.apis");
		Thread.sleep(5000);
		driver.activateApp("com.android.dialer");
		Thread.sleep(5000);
		driver.activateApp("io.appium.android.apis");

	}
}

/*

Here are some common Appium commands related to app management:
1. Install and Uninstall Apps:
    * driver.installApp("path/to/app.apk"): Installs the specified app on the device.
    * driver.removeApp("io.appium.android.apis"): Uninstalls the specified app from the device.
2. Check App Installation:
    * driver.isAppInstalled("io.appium.android.apis"): Checks if the specified app is installed on the device.
3. Launch and Close Apps:
    * driver.launchApp(): Launches the app specified in the desired capabilities.
    * driver.closeApp(): Closes the currently running app.
4. Background and Foreground Apps:
    * driver.runAppInBackground(Duration.ofSeconds(5)): Sends the app to the background for the specified duration.
    * driver.activateApp("io.appium.android.apis"): Brings the specified app to the foreground.
5. Query App State:
    * driver.queryAppState("io.appium.android.apis"): Queries the current state of the specified app.
6. Terminate Apps:
    * driver.terminateApp("io.appium.android.apis"): Terminates the specified app.
These commands help manage the lifecycle and state of mobile applications during testing [1] [2].
Would you like more details or examples on any of these commands?

*/
