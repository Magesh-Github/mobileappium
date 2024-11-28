package com.qa.utils;

import io.appium.java_client.AppiumDriver;

public class Globalvariables extends JenkinsVariables{
	public static AppiumDriver driver;
    static String iosTestDevice = System.getProperty("iosTestDevice");
	public static String deviceType = iosTestDevice;
	
}
