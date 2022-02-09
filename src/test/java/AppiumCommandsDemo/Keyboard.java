package AppiumCommandsDemo;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Keyboard {
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP, "/Users/riyaanghosh/Downloads/ApiDemos-debug.apk");
		caps.setCapability("unlockType", "pattern");
		caps.setCapability("unlockKey", "12369");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver driver = new AndroidDriver(url, caps);

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for(int i=0;i<3;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(textFields).click();
        driver.findElement(editText).click();
        Thread.sleep(3000);
        
        
        System.out.println(((AndroidDriver)driver).isKeyboardShown());
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        //((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.CALCULATOR));
        
	}

}
