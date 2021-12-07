package com.appium.setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ByClassDemo {
	
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
		
		
		By myByXpath=By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
		
		
		By id=MobileBy.AccessibilityId("Animation");
		 
		
		MobileElement myElement3= (MobileElement)driver.findElement(myByXpath);
		System.out.println(myElement3.getText());
		
		
		MobileElement myElementID= (MobileElement)driver.findElement(id);
		System.out.println(myElementID.getText());
		
	
	}


}
