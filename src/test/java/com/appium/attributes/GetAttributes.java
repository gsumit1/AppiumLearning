package com.appium.attributes;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetAttributes {
	
		@Test
		public void test1() throws MalformedURLException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");	
		AppiumDriver driver= new AppiumDriver(url,caps);
		
		
		By accessibility= MobileBy.AccessibilityId("Accessibility");
		
		System.out.println(driver.findElement(accessibility).getAttribute("text"));
		System.out.println(driver.findElement(accessibility).getAttribute("checkable"));
		System.out.println(driver.findElement(accessibility).getAttribute("enabled"));
		System.out.println(driver.findElement(accessibility).getAttribute("selected"));
		
		
		System.out.println(driver.findElement(accessibility).isSelected());
		System.out.println(driver.findElement(accessibility).isDisplayed());
		System.out.println(driver.findElement(accessibility).isEnabled());
		
}

}
