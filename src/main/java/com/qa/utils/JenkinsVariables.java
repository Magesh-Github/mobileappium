package com.qa.utils;

public class JenkinsVariables {
	

    public static void main(String[] args) {
        // Access parameters passed from Jenkins as system properties
        String androidTestDevice = System.getProperty("androidTestDevice");
        String iosTestDevice = System.getProperty("iosTestDevice");
        String stageEnv = System.getProperty("stage");
        String devEnv = System.getProperty("dev");
        
        
        // Print out the received values
        System.out.println("Android Test Device: " + androidTestDevice);
        System.out.println("iOS Test Device: " + iosTestDevice);
        System.out.println("Stage Environment: " + stageEnv);
        System.out.println("Dev Environment: " + devEnv);
    }
}
