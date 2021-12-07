package com.appium.setup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Locators {
	
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
		
		
		MobileElement myElement= (MobileElement)driver.findElementByAccessibilityId("Accessibility");
		System.out.println(myElement.getText());
		
		
		
		MobileElement myElement1= (MobileElement)driver.findElementsById("android:id/text1").get(1);
		System.out.println(myElement1.getText());
		
		
		MobileElement myElement2= (MobileElement)driver.findElementsByClassName("android.widget.TextView").get(2);
		System.out.println(myElement2.getText());
		
		MobileElement myElement3= (MobileElement)driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
		System.out.println(myElement3.getText());
		
		
		MobileElement myElement4= (MobileElement)driver.findElementByXPath("//*[@text=\"Accessibility\"]");
		System.out.println(myElement4.getText());
		
	
		MobileElement myElement5= (MobileElement)driver.findElementByTagName("input");
		System.out.println(myElement5.getText());
	
	}

}
