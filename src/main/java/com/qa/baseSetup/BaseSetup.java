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
		if (deviceType=="IOS") {
			try {
				DesiredCapabilities caps =new DesiredCapabilities();
				caps.setCapability("platformname", "IOS");
				caps.setCapability("platformnameVersion", "17.5");
				caps.setCapability("Devicename", "iPhone 15");
				caps.setCapability("App", "/Users/elite/Desktop/CommandIQ.app");
				caps.setCapability("AutomationName", "xcitest");
				caps.setCapability("udid", "626F724D-98E6-47C7-A170-F57256A4498C");
				caps.setCapability(CapabilityType.TIMEOUTS, 30);
				URL url= new URL("http://127.0.0.1:4723");
				driver=new AppiumDriver (url,caps);
				driver=new IOSDriver(url, caps);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {

		}
	}

}
