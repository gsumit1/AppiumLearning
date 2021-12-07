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
