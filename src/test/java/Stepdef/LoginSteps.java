package Stepdef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import com.qa.pages.LoginPage;
import com.qa.utils.Globalvariables;
import io.cucumber.java.en.*;


public class LoginSteps extends Globalvariables {
	LoginPage loginpage=new LoginPage(driver);
	Alert alert = driver.switchTo().alert();

	@Given("navigate to login screen")
	public void navigate_to_login_screen() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		String ActualTxt= alert.getText();
		Assert.assertEquals(ActualTxt, "“CommandIQ” Would Like to Send You Notifications\n"
				+ "Notifications may include alerts, sounds and icon badges. These can be configured in Settings.");
        alert.accept();
		System.out.println("Alerts");
		loginpage.clickLetGetStartedbtn();
		//driver.quit();

	}

	@When("enter the vaild username and password")
	public void enter_the_vaild_username_and_password() {

	}

	@When("click the login button")
	public void click_the_login_button() {

	}
}