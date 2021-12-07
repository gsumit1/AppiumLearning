package com.appium.setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Setup {
	
	
	@Test
	public void test1() throws MalformedURLException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		//caps.setCapability("avd", "Pixel_4");
		//caps.setCapability("avdLaunchedTimeout", "180000");
		//caps.setCapability("deviceReadyTimeout", "180000");
		
		caps.setCapability("newCommandTimeout", 360);
		
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		
		
		//caps.setCapability("appPackage", "io.appium.android.apis");
		//caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		
		AppiumDriver driver= new AppiumDriver(url,caps);
		
		System.out.println(driver.getSessionId());
		
		
		
	}
	
	
	

}
