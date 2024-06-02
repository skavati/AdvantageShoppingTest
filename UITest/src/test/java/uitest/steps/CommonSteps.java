package uitest.steps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.hp.lft.sdk.GeneralLeanFtException;

import common.utilities.CSVUtils;
import common.utilities.ExcelUtils;
import common.utilities.WordUtils;
import uitest.pages.CommonPage;

import org.apache.logging.log4j.*;

public class CommonSteps {
	CommonPage commonPage = new CommonPage();
	Boolean stepPass = true;
	String step = "";
	private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);

	public static void ScreenShot(String file) throws IOException {

	}

	// launchUrl_repeated_scenario

	public void launchURL() throws IOException, GeneralLeanFtException, InterruptedException, Exception {

		String step = "I launch advantage online shopping website";
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip("Given", step);
		} else {
			try {
				commonPage.launchURL();
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setStepFail(true);
				CommonPage.LOGGEROnFail("Given", step, e);

			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass("Given", step);
				}
			}
		}
	}
	
	public void launchURLWeaveApp() throws IOException, GeneralLeanFtException, InterruptedException, Exception {

		String step = "Given I launch Weave App website";
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip("Given", step);
		} else {
			try {
				commonPage.launchURL();
			} catch (Exception e) {
				stepPass = false;
				CommonPage.setStepFail(true);
				CommonPage.LOGGEROnFail("Given", step, e);

			} finally {
				if (stepPass == true) {
					CommonPage.LOGGEROnPass("Given", step);
				}
			}
		}
	}

	public void close_the_browser() throws Exception {
		String step = "customer close the browser 'ibank'";
		String keyword = "And";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!CommonPage.close_the_browser()) {
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

	public void setupScenario(String csvFile, String feature, String scenario) throws Exception {
		// set report for feature
		if (!CommonPage.feature.contentEquals(feature)) {
			ExtentTest extentFeature = CommonPage.getExtentReport().createTest(feature);
			CommonPage.setExtentFeature(extentFeature);
			CommonPage.setupTestSummary(feature);
		}
		// set report for scenario
		if (!CommonPage.scenario.contentEquals(scenario)) {
			String code = "\n\t\n\t\tText\n\t\n";
			Markup m = MarkupHelper.createCodeBlock(code);
			ExtentTest extentScenario = CommonPage.getExtentFeature().createNode(Scenario.class, scenario);// .info(m);
			CommonPage.setExtentScenario(extentScenario);
		}
		// set feature and scenario variables
		commonPage.setupScenario(csvFile, feature, scenario);
		String RunTest = CSVUtils.getCSVData(CommonPage.getCsvFileName(), scenario, 1, "RunTest");
		if (RunTest.equalsIgnoreCase("n")) {
			CommonPage.getExtentScenario().createNode(Scenario.class, scenario + ":     No:1",
					"Scenario ignored as per Excel sheet '" + CommonPage.getSheet() + "' entry 'RunTest=N'");
			// .("Scenario ignored as per Excel sheet '" +
			// Common_Page.getSheet() + "' entry 'RunTest=N'");
			CommonPage.setStepFail(true);
			// to stop pushing skip logs to reprot
			CommonPage.setLoggerOnSkip(false);

		} else {
			ExtentTest extentScenarioNo = CommonPage.getExtentScenario().createNode(Scenario.class,
					scenario + ":     No: " + CommonPage.getScenarioNo());
			CommonPage.setExtentScenarioNo(extentScenarioNo);
			LOGGER.info("\n" + scenario + ": No: " + CommonPage.getScenarioNo() + " Running...");
		}
	}

	public void Startvideo() throws Exception {
		String step = "start video capture";
		String keyword = "And";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!CommonPage.Startvideo()) {
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

	public void Stopvideo() throws Exception {
		String step = "stop video capture";
		String keyword = "And";
		stepPass = true;
		if (CommonPage.isStepFail()) {
			CommonPage.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!CommonPage.Stopvideo()) {
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
