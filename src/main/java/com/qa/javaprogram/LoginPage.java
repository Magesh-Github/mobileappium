package com.qa.javaprogram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.Globalvariables;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends Globalvariables{

	  public LoginPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	
	@AndroidFindBy(id = "com.example.android:id/password")
	@iOSXCUITFindBy(accessibility = "passwordField")
    private WebElement iosPasswordField;
}
