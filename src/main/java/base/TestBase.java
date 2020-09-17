package base;


import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listeners.AllureListener;


@Listeners({ AllureListener.class })
public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	public static Properties prop;


	
	public void initialization() {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "ANDROID");
			caps.setCapability("platformVersion", "7.1.1");
			caps.setCapability("deviceName", "Moto E4 Plus");
			caps.setCapability("UDID", "ZH33L356C2");
			caps.setCapability("appPackage", "com.jumia.android");
			caps.setCapability("appActivity", "com.mobile.view.SplashScreenActivity");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


			

		} catch (Exception e) {
			System.out.println("cause is : " + e.getCause());
			System.out.println("error message is" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static AppiumDriver<MobileElement> getdriver() {
		return driver;
	}

}
