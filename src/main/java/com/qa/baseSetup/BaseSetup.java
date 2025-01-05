package com.qa.baseSetup;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.utils.Globalvariables;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseSetup extends Globalvariables{
	
	public void lanuchApp() throws MalformedURLException{
		System.out.println("Device"+deviceType);
		if (deviceType.equals("IOS")) {
			try {
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			    desiredCapabilities.setCapability("platformName", "iOS");
			    desiredCapabilities.setCapability("appium:platformVersion", "17.5");
			    desiredCapabilities.setCapability("appium:deviceName", "iPhone 15");
			    desiredCapabilities.setCapability("appium:app", "/Users/elite/Desktop/CommandIQ.app");
			    desiredCapabilities.setCapability("appium:noRest", true);
			    desiredCapabilities.setCapability("appium:automationName", "XCUITest");
			    desiredCapabilities.setCapability("appium:wdaLaunchTimeout", "120000");
			    desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
			    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
			    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
			    desiredCapabilities.setCapability(CapabilityType.TIMEOUTS, 180);
				driver=new AppiumDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (deviceType.equals("Android")) {
			try {
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.setCapability("appium:deviceName", "Pixel_3_API_27");
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("appium:platformVersion", "14.0");
				desiredCapabilities.setCapability("appium:appPackage", "com.calix.smarthome");
				desiredCapabilities.setCapability("appium:appActivity", "com.calix.smarthome.ui.loginregconfig.Splash");
				desiredCapabilities.setCapability("appium:noRest", true);
				desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
				desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
				desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
				desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
				desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
				desiredCapabilities.setCapability(CapabilityType.TIMEOUTS, 180);
				driver=new AppiumDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}
