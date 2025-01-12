package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.qa.utils.Globalvariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends Globalvariables {
	AppiumDriver driver;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public void clickLetGetStartedbtn() throws InterruptedException {
		letGetStartedBtn.click();
	}
	
	public void enterTheEmailId() throws InterruptedException {
		emailTxtField.sendKeys(null);
	}
	
	public void enterThePassword() throws InterruptedException {
		passwordTxtfield.sendKeys(null);
	}
	
	public void clickLoginBtn() throws InterruptedException {
		loginbtn.click();
	}
	
	public void logInWithVaildcrendtails(String email,String password) throws InterruptedException {
		emailTxtField.sendKeys(email);
		passwordTxtfield.sendKeys(password);
	}
	
	public void clickSignUpBtn() throws InterruptedException {
		signUpBtn.click();
	}
	
	
	public void clickSettingFooter() throws InterruptedException {
		settingFooter.click();
	}
	
	public void clicklogoutBtn() throws InterruptedException {
		logoutBtn.click();
	}
	
	public void navigateToSignUpScr() throws InterruptedException {
		letGetStartedBtn.click();
		signUpBtn.click();
	}
	
	@iOSXCUITFindBy(accessibility = "logout_btn")
	@AndroidFindBy(id="test")
	private WebElement termsAndConditionLink;
	
	@iOSXCUITFindBy(accessibility = "logout_btn")
	@AndroidFindBy(id="test")
	private WebElement logoutBtn;
	
	@iOSXCUITFindBy(accessibility = "Setting_btn")
	@AndroidFindBy(id="test")
	private WebElement settingFooter;
	
	@iOSXCUITFindBy(accessibility = "login_sign_up_txt")
	@AndroidFindBy(id="test")
	private WebElement signUpBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"emailLabel\"]/following-sibling::XCUIElementTypeTextField")
	@AndroidFindBy(id="test")
	private WebElement emailTxtField;
	
	@iOSXCUITFindBy(accessibility = "password_value_txt")
	@AndroidFindBy(id="test")
	private WebElement passwordTxtfield;
	
	@iOSXCUITFindBy(accessibility = "login_btn")
	@AndroidFindBy(id="test")
	private WebElement loginbtn;
	
	@iOSXCUITFindBy(accessibility = "welcomToLabel")
	@AndroidFindBy(id="test")
	private WebElement welcomeTotxt;
	
	@iOSXCUITFindBy(accessibility = "splash_button")
	@AndroidFindBy(id="test")
	private WebElement letGetStartedBtn;
	


}
