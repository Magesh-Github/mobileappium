package com.qa.utils;

public class JenkinsVariables {
	// Access parameters passed from Jenkins as system properties
	static   String androidTestDevice = System.getProperty("androidTestDevice");
	static  String iosTestDevice = System.getProperty("iosTestDevice");
	static  String stageEnv = System.getProperty("stage");
	static   String devEnv = System.getProperty("dev");
}
