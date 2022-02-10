package AppiumCommandsDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumCommnadsDemo {
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		
		AppiumDriver driver= new AppiumDriver(url,caps);
		
		System.out.println(driver.getSessionId());
		MobileElement myElement= (MobileElement)driver.findElementByAccessibilityId("Accessibility");
		myElement.click();
		
		Thread.sleep(5000);
		
		driver.runAppInBackground(Duration.ofMillis(5000));
		System.out.println(driver.queryAppState("io.appium.android.apis"));
		
		//driver.terminateApp("io.appium.android.apis");
		
		//Thread.sleep(5000);
		//System.out.println(driver.queryAppState("io.appium.android.apis"));
		
		
		driver.installApp("/Users/riyaanghosh/Downloads/ApiDemos-debug.apk", new AndroidInstallApplicationOptions().withReplaceEnabled());
		
		driver.terminateApp("io.appium.android.apis");
		
		Thread.sleep(5000);
		
		driver.activateApp("com.android.chrome");
		
		System.out.println(driver.queryAppState("io.appium.android.apis"));
	
		Thread.sleep(5000);
		driver.activateApp("io.appium.android.apis");
		
		System.out.println(driver.queryAppState("io.appium.android.apis"));
		
	}
}
