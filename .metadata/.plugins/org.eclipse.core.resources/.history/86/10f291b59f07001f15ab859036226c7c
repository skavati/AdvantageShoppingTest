package apptest.steps;


import org.apache.log4j.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Scenario;
import apptest.pages.Common_Page;
import common.toolbox.appium.*;
import common.utilities.CSVUtils;
import common.utilities.ExcelUtils;
import common.utilities.FileUtils;
import common.utilities.StringUtils;
import common.utilities.XMLUtils;

public class Common_Steps {
	private static final Logger LOGGER = LogManager.getLogger(Common_Steps.class);
	Common_Page commonPage = Common_Page.getInstance();
	boolean stepPass = true;

	public void printDeviceInfo() throws Exception {
		String configPath = FileUtils.findFullPath(System.getProperty("user.dir"), "config.xml");
		String testDataDir = XMLUtils.getNodeText(configPath, "TestDataDir");
		if (testDataDir.contains("{")) {
			testDataDir = StringUtils.replaceWithReflection(testDataDir, "common.utilities.SystemUtils", "{", "}");
		}
		String deviceListFile = testDataDir + "\\DeviceList.csv";
		Integer deviceList = CSVUtils.getRowNumber(deviceListFile);
		String deviceName;	
		if (deviceList == 1) {
			deviceName = CSVUtils.getCSVData(deviceListFile,Common_Page.getScenario(), 1,"DeviceName");
		} else {
			deviceName = CSVUtils.getCSVData(deviceListFile,Common_Page.getScenario(),Integer.valueOf(Common_Page.getTestSuiteNo()) ,"DeviceName");
			
		}
		
		String step = "below tests are currently running on " + "\"" + deviceName ;
	    Common_Page.getExtentScenario().createNode(new GherkinKeyword("Given"), step, "").pass("step passed");
		
	}

	public void setupScenario(String excelsheet, String feature, String scenario) throws Exception {
		// set report for feature
		if (!Common_Page.feature.contentEquals(feature)) {
			ExtentTest extentFeature = Common_Page.getExtentReport().createTest(feature);
			Common_Page.setExtentFeature(extentFeature);
		}
		// set report for scenario
		if (!Common_Page.scenario.contentEquals(scenario)) {
			ExtentTest extentScenario = Common_Page.getExtentFeature().createNode(Scenario.class, scenario);
			Common_Page.setExtentScenario(extentScenario);
		}
		// set feature and scenario variables
		commonPage.setupScenario(excelsheet, feature, scenario);
		String RunTest = ExcelUtils.getRepeatedCellData(Common_Page.getTestDataFile(), Common_Page.getSheet(),
				Common_Page.getScenario(), Common_Page.getScenarioNo(), "RunTest");
		if (RunTest.equalsIgnoreCase("n")) {
			Common_Page.getExtentScenario().createNode(Scenario.class, scenario + ":     No:1",
					"Scenario ignored as per Excel sheet '" + Common_Page.getSheet() + "' entry 'RunTest=N'");
			// .("Scenario ignored as per Excel sheet '" +
			// Common_Page.getSheet() + "' entry 'RunTest=N'");
			Common_Page.setStepFail(true);
			// to stop pushing skip logs to reprot
			Common_Page.setLoggerOnSkip(false);
		} else {
			ExtentTest extentScenarioNo = Common_Page.getExtentScenario().createNode(Scenario.class,
					scenario + ":     No: " + Common_Page.getScenarioNo() + " repeatNo :" + Common_Page.getRepeatNo());
			Common_Page.setExtentScenarioNo(extentScenarioNo);
			if (Common_Page.isSameDataRepeat()) {
				LOGGER.info(scenario + ":     No: " + Common_Page.getScenarioNo() + " repeatNo :"
						+ Common_Page.getRepeatNo());
			} else {
				LOGGER.info(scenario + ": No: " + Common_Page.getScenarioNo() + " Running...");
			}
		}
	}

	public void launchApp() throws Exception {
		String step = "Given I launch Credabl app on device";
		String keyword = "Given";
		stepPass = true;
		if (Common_Page.isStepFail()) {
			Common_Page.LOGGEROnSkip(keyword, step);
		} else {
			try {
				if (!(commonPage.launchApp())) {
					stepPass = false;
					throw new Exception(Common_Page.getException());
				}
			} catch (Exception e) {
				stepPass = false;
				Common_Page.setException(e.toString());
			} finally {
				if (stepPass == true) {
					Common_Page.LOGGEROnPass(keyword, step);
				} else {
					Common_Page.setStepFail(true);
					Common_Page.setScenarioResult(false);
					Common_Page.LOGGEROnFail(keyword, step, Common_Page.getException());
				}
			}
		}
	}

	
	
	
	
}
