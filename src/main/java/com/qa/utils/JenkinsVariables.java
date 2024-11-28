package com.qa.utils;

public class JenkinsVariables {
	// Access parameters passed from Jenkins as system properties
	String androidTestDevice = System.getProperty("androidTestDevice");
	static String iosTestDevice = System.getProperty("iosTestDevice");
	String stageEnv = System.getProperty("stage");
	String devEnv = System.getProperty("dev");
}
