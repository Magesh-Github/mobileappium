package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.Globalvariables;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends Globalvariables {
	AppiumDriver driver;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public void clickLetGetStartedbtn() throws InterruptedException {
		System.out.println("*******************************"+welcomeTotxt.isDisplayed());
		letGetStartedBtn.click();
	}

	@iOSXCUITFindBy(accessibility = "welcomToLabel")
	private WebElement welcomeTotxt;

	
	@iOSXCUITFindBy(accessibility = "splash_button")
	@AndroidFindBy(id="test")
	private WebElement letGetStartedBtn;

}
