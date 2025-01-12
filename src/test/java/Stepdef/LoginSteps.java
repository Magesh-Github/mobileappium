package Stepdef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.pages.LoginPage;
import com.qa.utils.Globalvariables;
import io.cucumber.java.en.*;

public class LoginSteps extends Globalvariables {
	LoginPage loginpage = new LoginPage(driver);

	@Given("navigate to login screen")
	public void navigate_to_login_screen() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Alert alert = driver.switchTo().alert();
		String ActualTxt = alert.getText();
		Assert.assertEquals(ActualTxt, "“CommandIQ” Would Like to Send You Notifications\n"
				+ "Notifications may include alerts, sounds and icon badges. These can be configured in Settings.");
		alert.accept();
		loginpage.clickLetGetStartedbtn();
		// driver.quit();
	}

	@When("^enter the vaild (.*) and (.*)$")
	public void enter_the_vaild_username_and_password(String email, String password) throws InterruptedException {
		loginpage.logInWithVaildcrendtails(email, password);
	}

	@When("click the login button")
	public void click_the_login_button() throws InterruptedException {
		loginpage.clickLoginBtn();
	}

	@When("verify the dashboard screen")
	public void verify_the_dashboard_screen() throws InterruptedException {
		loginpage.clickSettingFooter();
	}

	@Then("verify the log out")
	public void verify_the_log_out() throws InterruptedException {
		loginpage.clicklogoutBtn();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Given("navigate to signup screen")
	public void navigate_to_signup_screen() throws InterruptedException {
	loginpage.navigateToSignUpScr();
	}

	@When("verify the terms&condition popup should be visible when click terms&condition")
	public void verify_the_terms_condition_popup_should_be_visible_when_click_terms_condition() {
     WebElement webElement=driver.findElement(By.xpath("//*[contains(@text='')]"));
	}

	@When("verify the terms&condition popup should be close when click the close button")
	public void verify_the_terms_condition_popup_should_be_close_when_click_the_close_button() {

	}
}