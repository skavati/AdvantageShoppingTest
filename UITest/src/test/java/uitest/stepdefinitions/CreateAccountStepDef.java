package uitest.stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uitest.steps.CommonSteps;
import uitest.steps.CreateAccountSteps;

public class CreateAccountStepDef {
	CreateAccountSteps createAcctSteps = new CreateAccountSteps();
	
	
	@When("I click into and out of the Username, Email, Password and Confirm Password fields")
	public void i_click_into_and_out_of_the_username_email_password_and_confirm_password_fields() throws Exception {
		createAcctSteps.clickAccountDetails();
	}

	@Then("I should verify that errors display and contain the correct content")
	public void i_should_verify_that_errors_display_and_contain_the_correct_content() throws Exception {
		createAcctSteps.verifyErrorDisplay();
	}

	@When("I enter valid data for Username, Email, Password and Confirm Password field")
	public void i_enter_valid_data_for_username_email_password_and_confirm_password_field() throws Exception {
		createAcctSteps.enterAccountDetails();
	}

	@Then("I should verify all errors are cleared")
	public void i_should_verify_all_errors_are_cleared() throws Exception {
		createAcctSteps.verifyAllErrorsClear();
	}
	
}
