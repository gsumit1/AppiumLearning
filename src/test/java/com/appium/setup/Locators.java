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

/*

**MobileElement** and **WebElement** are both used in Appium for interacting with elements in mobile applications, but they have some differences:

1. **MobileElement**:
   - **Specialization**: It is a subclass of `WebElement` specifically designed for mobile applications.
   - **Additional Methods**: Provides additional methods tailored for mobile interactions, such as gestures (tap, swipe, etc.).
   - **Platform-Specific**: Used in conjunction with `AppiumDriver` for mobile-specific actions and capabilities.

2. **WebElement**:
   - **General Use**: It is a standard interface in Selenium WebDriver used for interacting with web elements.
   - **Limited Methods**: Does not include mobile-specific methods; primarily used for web automation.
   - **Cross-Platform**: Can be used for both web and mobile automation, but lacks the specialized methods of `MobileElement`.

In summary, **MobileElement** extends the functionality of **WebElement** to include mobile-specific actions, making it more suitable for mobile automation tasks [1](https://stackoverflow.com/questions/35286135/difference-between-appiumdrivermobileelement-and-androiddriver) [2](https://www.testingdocs.com/changes-in-drivers-and-classes/). 

Would you like to know more about how to use these elements in your tests?

*/
