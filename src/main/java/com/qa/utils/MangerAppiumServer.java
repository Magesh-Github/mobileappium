package com.qa.utils;

import java.io.File;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class MangerAppiumServer extends Globalvariables{

	public static AppiumServiceBuilder appiumServiceBuilder;
	public static AppiumDriverLocalService appiumDriverLocalService;
	public static String deviceType;
	
	public static void startAppiumServer() {
		killAppiumSession();

		// Build Appium Server
		appiumServiceBuilder = new AppiumServiceBuilder();
		appiumServiceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
		appiumServiceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
		appiumServiceBuilder.withIPAddress("0.0.0.0");
		appiumServiceBuilder.usingPort(4723);
		appiumServiceBuilder.withTimeout(Duration.ofSeconds(60));
		appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");
		appiumServiceBuilder.withLogFile(new  File("target/Appiumlog.txt"));
//		appiumServiceBuilder.withArgument(GeneralServerFlag.DEBUG_LOG_SPACING, "wd/hub");

		// Start the server with bulider
		appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
		appiumDriverLocalService.start();
		System.out.println("Appium server start");
        deviceType = System.getProperty("iosTestDevice");
		System.out.println(deviceType);
	}

	public static void stopAppiumserver() {
		if (appiumDriverLocalService.isRunning() && appiumDriverLocalService != null) {
			// stop the server
			appiumDriverLocalService.stop();
			System.out.println("test");
		}

	}

	private static void killAppiumSession() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
