package uitest.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.*;
import org.junit.AssumptionViolatedException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.hp.lft.sdk.GeneralLeanFtException;

import common.baselib.BaseMethods;
import common.constants.GlobalConstants;
import common.utilities.ExcelUtils;
import common.utilities.SystemUtils;
import common.utilities.VideoUtils;
import common.utilities.XMLUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import uitest.pages.CommonPage;
import uitest.steps.CommonSteps;

public class CommonStepDef {

	CommonSteps commonSteps = new CommonSteps();

	private static final Logger LOGGER = LogManager.getLogger(CommonStepDef.class);

	@Given("I launch advantage online shopping website")
	public void i_launch_advantage_online_shopping_website() throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		commonSteps.launchURL();
	}


	@Given("scenario starts {string} {string} {string} uitest")
	public void scenario_starts(String csvFile, String feature, String scenario) throws Throwable {
		commonSteps.setupScenario(csvFile, feature, scenario);
	}

	
	@Given("^customer close the browser 'ibank'$")
	public void customer_close_the_browser_ibank() throws Throwable {
		commonSteps.close_the_browser();
	}

	@Given("^change amounts on Excel sheet to avoid duplicate amounts during transfer if running on Jenkins machine$")
	public void change_amounts_on_Excel_sheet_to_avoid_duplicate_amounts_during_transfer_if_running_on_Jenkins_machine()
			throws Throwable {

		String cIServer = XMLUtils.getNodeText(CommonPage.getConfigPath(), "CIServer");
		if (SystemUtils.getComputerName().toLowerCase().contentEquals(cIServer)) {
			String amount = ExcelUtils.getRepeatedCellData(CommonPage.getTestDataFile(), CommonPage.getSheet(),
					CommonPage.getScenario(), CommonPage.getScenarioNo(), "Amount");
			LOGGER.info("Original amount :" + amount);
			Double amt = Double.valueOf(amount);
			// Note: below cast "double" is mandatory to get correct amount_today
			Double amt_today = Double.valueOf((double) (SystemUtils.getTodayNo()) / 100);
			LOGGER.info("Amount based on today :" + amt_today);
			Double newAmount = amt + amt_today;
			LOGGER.info("New amount :" + String.format("%.2f", newAmount));
			amount = String.format("%.2f", newAmount);
			ExcelUtils.setRepeatedCellData(CommonPage.getTestDataFile(), CommonPage.getSheet(),
					CommonPage.getScenario(), CommonPage.getScenarioNo(), "Amount", amount);

		}
	}
	
	@Given("I launch apply online website")
	public void i_launch_apply_online_website() throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		commonSteps.launchURL();
	}
	
	@Given("I launch Weave App website")
	public void i_launch_weave_app_website() throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		commonSteps.launchURLWeaveApp();
	}


}
