package AppiumCommandsDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LockUnlockScenario {
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		
		caps.setCapability("unlockType", "pattern");
		caps.setCapability("unlockKey", "729854163");
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver driver= new AndroidDriver(url,caps);

		((AndroidDriver)driver).lockDevice();
		
		System.out.println(((AndroidDriver)driver).isDeviceLocked());
		
		((AndroidDriver)driver).unlockDevice();
		
		
	}

}
