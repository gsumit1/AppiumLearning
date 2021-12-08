package AppiumLockUnlock;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.android.AndroidDriver;

public class LockUnlock {
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		caps.setCapability("unlockType", "pattern");
		caps.setCapability("unlockKey", "12369");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver driver = new AndroidDriver(url, caps);

		((AndroidDriver) driver).lockDevice(Duration.ofMillis(5000));
		System.out.println(((AndroidDriver) driver).isDeviceLocked());
		((AndroidDriver) driver).unlockDevice();

	}

}//http://appium.io/docs/en/writing-running-appium/caps/#android-only
