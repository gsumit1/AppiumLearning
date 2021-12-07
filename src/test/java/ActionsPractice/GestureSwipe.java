package ActionsPractice;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GestureSwipe {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AppiumDriver driver = new AppiumDriver(url, caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By views = MobileBy.AccessibilityId("Views");

		driver.findElement(views).click();


		By animationBy = MobileBy.AccessibilityId("Animation");
		By Grid = MobileBy.AccessibilityId("Grid");

		By WebView = MobileBy.AccessibilityId("WebView");

		TouchAction t = new TouchAction(driver);
		/*
		 * t.press(ElementOption.element(driver.findElement(Grid))).waitAction(
		 * WaitOptions.waitOptions(Duration.ofMillis(2000)))
		 * .moveTo(ElementOption.element(driver.findElement(animationBy))).release().
		 * perform();
		 */

		/*
		 * t.press(PointOption.point(474,
		 * 2050)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		 * .moveTo(PointOption.point(474, 286)).release().perform();
		 */

		/*
		for (int i = 0; i < 5; i++) {

			System.out.println(i);
			try {
				if (driver.findElement(WebView).isDisplayed()) {
					break;
				}

			} catch (Exception e) {
				t.press(PointOption.point(474, 2050)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
						.moveTo(PointOption.point(474, 286)).release().perform();

			}

		}
		*/
		
		

		/*
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);

		
		 * t.press(PointOption.point(startX,
		 * startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		 * .moveTo(PointOption.point(startX, endY)).release().perform();
		 * 
		 */

	}

}

//474, 286

//520, 2050
