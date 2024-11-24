package Stepdef;

import com.qa.utils.Globalvariables;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Globalvariables{


	@Given("user is on login page")
	public void user_is_on_login_page() {
	System.out.println("test");
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("test");
	}

	@And("click the login button")
	public void click_the_login_button() {
		System.out.println("test");
	}

	@Then("user is navigate to the home page")
	public void user_is_navigate_to_the_home_page() {
		System.out.println("test");
	}
}