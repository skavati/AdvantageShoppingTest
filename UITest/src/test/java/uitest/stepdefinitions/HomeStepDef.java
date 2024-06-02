package uitest.stepdefinitions;

import io.cucumber.java.en.Given;
import uitest.steps.HomeSteps;

public class HomeStepDef {
HomeSteps homeSteps = new HomeSteps();

@Given("I navigate to User")
public void i_navigate_to_user() throws Exception {
   homeSteps.clickUsermenu();
}

@Given("I click on CREATE NEW ACCOUNT")
public void i_click_on_create_new_account() throws Exception {
   homeSteps.clickCreateNewAccount();
}

}
