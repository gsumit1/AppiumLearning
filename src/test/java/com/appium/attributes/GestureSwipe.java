package com.appium.attributes;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GestureSwipe {

	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver driver = new AppiumDriver(url, caps);

		By Views = MobileBy.AccessibilityId("Views");

		driver.findElement(Views).click();
		Thread.sleep(3000);

		TouchAction t = new TouchAction(driver);

		Dimension size = driver.manage().window().getSize();

		int startx = size.width / 2;

		int startY = (int) (size.height * 0.8);

		int endY = (int) (size.height * 0.2);

		By WebView = MobileBy.AccessibilityId("WebView");

		for (int i = 0; i < 10; i++) {

			System.out.println(i);
			try {

				if (driver.findElement(WebView).isDisplayed()) {
					break;
				}

			} catch (Exception e) {

				t.press(PointOption.point(startx, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
						.moveTo(PointOption.point(startx, endY)).release().perform();

			}

		}

		// 523, 1877 ---> 415, 422
		
		
		
		//t.press(ElementOption.element("")).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		//.moveTo(ElementOption.element("")).release().perform();
		
		
		
		

	}
}
