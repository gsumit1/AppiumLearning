package WebView;

import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ChromeDriverSettings {
	
	//chromedriverExecutableDir
	 public static void main(String[] args) throws Exception {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
			caps.setCapability("unlockType", "pattern");
			caps.setCapability("unlockKey", "12369");
			
			caps.setCapability("chromedriverExecutable", "path");
			
			
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			AppiumDriver driver = new AndroidDriver(url, caps);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.findElement(MobileBy.AccessibilityId("Views")).click();

	        Dimension size = driver.manage().window().getSize();

	        for(int i=0;i<4;i++){
	            TouchAction t = new TouchAction(driver);
	            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
	                    .release()
	                    .perform();
	        }

	        driver.findElement(MobileBy.AccessibilityId("WebView")).click();

	        Set<String> contextHandles = driver.getContextHandles();
	        for(String contextHandle : contextHandles){
	            System.out.println(contextHandle);
	        }

	   //     driver.context("WEBVIEW");
	        driver.context(contextHandles.toArray()[1].toString());
	        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
	        System.out.println(driver.findElement(By.xpath("//*[@id=\"i_am_a_textbox\"]")).getText());

	        driver.context("NATIVE_APP");
	    }

}
