package com.qa.baseSetup;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.utils.Globalvariables;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseSetup extends Globalvariables{
	
	AppiumDriver driver;
	public void lanuchApp(){
		deviceType = System.getProperty("iosTestDevice");
		System.out.println("Test"+ deviceType);
		if (System.getProperty("iosTestDevice")=="IOS") {
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
				driver=new IOSDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {

		}
	}

}
