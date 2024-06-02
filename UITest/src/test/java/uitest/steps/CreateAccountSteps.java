package uitest.steps;


import uitest.pages.CommonPage;
import uitest.pages.CreateAccountPage;

public class CreateAccountSteps {
	CreateAccountPage createAcctPage = CreateAccountPage.getInstance(CommonPage.getWebDriver());
	boolean stepPass = true;
	
	public void clickAccountDetails() throws Exception {
		String step = "I click into and out of the Username, Email, Password and Confirm Password fields";
		String keyword = "When";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!createAcctPage.clickAccountDetails()) {
					stepPass = false;
					throw new Exception(CommonPage.getException());
				}
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setException(e.toString());
			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass(keyword, step);
				} else {
					CommonPage.setStepFail(true);
					CommonPage.setScenarioResult(false);
					CommonPage.LOGGEROnFail(keyword, step, CommonPage.getException());
				}
			}
		}
	}
	
	
	public void verifyErrorDisplay() throws Exception {
		String step = "I should verify that errors display and contain the correct content ";
		String keyword = "Then";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!createAcctPage.verifyErrorDisplay()) {
					stepPass = false;
					throw new Exception(CommonPage.getException());
				}
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setException(e.toString());
			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass(keyword, step);
				} else {
					CommonPage.setStepFail(true);
					CommonPage.setScenarioResult(false);
					CommonPage.LOGGEROnFail(keyword, step, CommonPage.getException());
				}
			}
		}
	}
	
	public void enterAccountDetails() throws Exception {
		String step = "I enter valid data for Username, Email, Password and Confirm Password field";
		String keyword = "When";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!createAcctPage.enterAccountDetails()) {
					stepPass = false;
					throw new Exception(CommonPage.getException());
				}
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setException(e.toString());
			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass(keyword, step);
				} else {
					CommonPage.setStepFail(true);
					CommonPage.setScenarioResult(false);
					CommonPage.LOGGEROnFail(keyword, step, CommonPage.getException());
				}
			}
		}
	}
	
	public void verifyAllErrorsClear() throws Exception {
		String step = "I should verify all errors are cleared";
		String keyword = "Then";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!createAcctPage.verifyAllErrorsClear()) {
					stepPass = false;
					throw new Exception(CommonPage.getException());
				}
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setException(e.toString());
			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass(keyword, step);
				} else {
					CommonPage.setStepFail(true);
					CommonPage.setScenarioResult(false);
					CommonPage.LOGGEROnFail(keyword, step, CommonPage.getException());
				}
			}
		}
	}
	
}
