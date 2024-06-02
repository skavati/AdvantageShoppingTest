package uitest.steps;

import uitest.pages.CommonPage;
import uitest.pages.HomePage;


public class HomeSteps {
	HomePage homePage = HomePage.getInstance(CommonPage.getWebDriver());
	boolean stepPass = true;
	
	
	public void clickUsermenu() throws Exception {
		String step = "I navigate to User";
		String keyword = "And";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!homePage.clickUsermenu()) {
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
	
	public void clickCreateNewAccount() throws Exception {
		String step = "I click on CREATE NEW ACCOUNT";
		String keyword = "And";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!homePage.clickCreateNewAccount()) {
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
