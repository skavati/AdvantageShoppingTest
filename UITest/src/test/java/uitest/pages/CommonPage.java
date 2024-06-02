package uitest.pages;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

import atu.testrecorder.ATUTestRecorder;
import common.baselib.BaseMethods;
import common.constants.GlobalConstants;
import common.toolbox.report.ExtentReport;
import common.toolbox.selenium.Element;
import common.toolbox.selenium.Waits;
import common.toolbox.sikuli.Sikuli;
import common.toolbox.winium.Winium;
import common.utilities.CSVUtils;
import common.utilities.ExcelUtils;
import common.utilities.FileUtils;
import common.utilities.StringUtils;
import common.utilities.SystemUtils;
import common.utilities.VideoUtils;
import common.utilities.WordUtils;
import common.utilities.XMLUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class CommonPage {

	static /*
			 * public Common_Page(WebDriver webDriver) { super(webDriver); }
			 */
	VideoUtils videoUtils = new VideoUtils();
	public static String feature = "";
	static WebDriver webDriver;
	static String sheet = "";
	// static String feature;
	static String firstScenario;
	// static String scenario;
	public static String scenario = "";
	static String repeat;	
	static Integer scenarioNo;
	static Integer scenarioCount;
	public static ExtentReports extentReport;
	static ExtentTest extentFeature;
	static ExtentTest extentScenario;
	static ExtentTest extentScenarioNo;
	static boolean stepFail;
	static String testDataFile;
	static String stepInfo = "";
	static boolean isLoggerOnSkip;
	static ChromeDriverService chromeDriverService;
	static String exception;
	static boolean scenarioResult;
	static String testSummaryDoc;
	static Integer totalPass;
	static Integer totalScenarios;
	static Integer testSummaryRowNo;
	static String testSummaryException;
	static String imgPathOnFail;
	static String configPath;
	public static boolean finalResult;
	static String testReportDirPath;
	public static int elementWait;
	static boolean sameDataRepeat;
	static Integer repeatNo;
	static String csvFileName = "";
	static String testDataDir;
	

	public static ChromeDriverService getChromeDriverService() {
		return chromeDriverService;
	}

	public static void setChromeDriverService(ChromeDriverService chromeDriverService) {
		CommonPage.chromeDriverService = chromeDriverService;
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}

	public static void setWebDriver(WebDriver webDriver) {
		CommonPage.webDriver = webDriver;
	}

	public static String getSheet() {
		return sheet;
	}

	public static void setSheet(String sheet) {
		CommonPage.sheet = sheet;
	}

	public static String getScenario() {
		return scenario;
	}

	public static void setScenario(String scenario) {
		CommonPage.scenario = scenario;
	}

	public static String getRepeat() {
		return repeat;
	}

	public static void setRepeat(String repeat) {
		CommonPage.repeat = repeat;
	}

	public static String getFeature() {
		return feature;
	}

	public static void setFeature(String feature) {
		CommonPage.feature = feature;
	}

	public static String getFirstScenario() {
		return firstScenario;
	}

	public static void setFirstScenario(String firstScenario) {
		CommonPage.firstScenario = firstScenario;
	}

	
	public static Integer getScenarioNo() {
		return scenarioNo;
	}

	public static void setScenarioNo(Integer scenarioNo) {
		CommonPage.scenarioNo = scenarioNo;
	}

	public static Integer getScenarioCount() {
		return scenarioCount;
	}

	public static void setScenarioCount(Integer scenarioCount) {
		CommonPage.scenarioCount = scenarioCount;
	}

	public static ExtentReports getExtentReport() {
		return extentReport;
	}

	public static void setExtentReport(ExtentReports extentReport) {
		CommonPage.extentReport = extentReport;
	}

	public static ExtentTest getExtentFeature() {
		return extentFeature;
	}

	public static void setExtentFeature(ExtentTest extentFeature) {
		CommonPage.extentFeature = extentFeature;
	}

	public static ExtentTest getExtentScenario() {
		return extentScenario;
	}

	public static void setExtentScenario(ExtentTest extentScenario) {
		CommonPage.extentScenario = extentScenario;
	}

	public static ExtentTest getExtentScenarioNo() {
		return extentScenarioNo;
	}

	public static void setExtentScenarioNo(ExtentTest extentScenarioNo) {
		CommonPage.extentScenarioNo = extentScenarioNo;
	}

	public static boolean isStepFail() {
		return stepFail;
	}

	public static void setStepFail(boolean stepFail) {
		CommonPage.stepFail = stepFail;
	}

	public static String getTestDataFile() {
		return testDataFile;
	}

	public static void setTestDataFile(String testDataFile) {
		CommonPage.testDataFile = testDataFile;
	}

	public static String getStepInfo() {
		return stepInfo;
	}

	public static void setStepInfo(String stepInfo) {
		CommonPage.stepInfo = stepInfo;
	}

	public static boolean isLoggerOnSkip() {
		return isLoggerOnSkip;
	}

	public static void setLoggerOnSkip(boolean isLoggerOnSkip) {
		CommonPage.isLoggerOnSkip = isLoggerOnSkip;
	}

	public static String getException() {
		return exception;
	}

	public static void setException(String exception) {
		CommonPage.exception = exception;
	}

	public static boolean isScenarioResult() {
		return scenarioResult;
	}

	public static void setScenarioResult(boolean scenarioResult) {
		CommonPage.scenarioResult = scenarioResult;
	}

	// Test Summary implementation
	public static String getTestSummaryDoc() {
		return testSummaryDoc;
	}

	public static void setTestSummaryDoc(String testSummaryDoc) {
		CommonPage.testSummaryDoc = testSummaryDoc;
	}

	public static Integer getTotalPass() {
		return totalPass;
	}

	public static void setTotalPass(Integer totalPass) {
		CommonPage.totalPass = totalPass;
	}

	public static Integer getTotalScenarios() {
		return totalScenarios;
	}

	public static void setTotalScenarios(Integer totalScenarios) {
		CommonPage.totalScenarios = totalScenarios;
	}

	public static Integer getTestSummaryRowNo() {
		return testSummaryRowNo;
	}

	public static void setTestSummaryRowNo(Integer testSummaryRowNo) {
		CommonPage.testSummaryRowNo = testSummaryRowNo;
	}

	public static String getTestSummaryException() {
		return testSummaryException;
	}

	public static void setTestSummaryException(String testSummaryException) {
		CommonPage.testSummaryException = testSummaryException;
	}

	public static String getImgPathOnFail() {
		return imgPathOnFail;
	}

	public static void setImgPathOnFail(String imgPathOnFail) {
		CommonPage.imgPathOnFail = imgPathOnFail;
	}

	public static String getConfigPath() {
		return configPath;
	}

	public static void setConfigPath(String configPath) {
		CommonPage.configPath = configPath;
	}

	public static boolean isFinalResult() {
		return finalResult;
	}

	public static void setFinalResult(boolean finalResult) {
		CommonPage.finalResult = finalResult;
	}

	public static String getTestReportDirPath() {
		return testReportDirPath;
	}

	public static void setTestReportDirPath(String testReportDirPath) {
		CommonPage.testReportDirPath = testReportDirPath;
	}

	public static int getElementWait() {
		return elementWait;
	}

	public static void setElementWait(int elementWait) {
		CommonPage.elementWait = elementWait;
	}

	// @Before imgPathOnFail
	public void setup() throws Throwable {
		// Video.startRecording();
	}

	public static boolean isSameDataRepeat() {
		return sameDataRepeat;
	}

	public static void setSameDataRepeat(boolean sameDataRepeat) {
		CommonPage.sameDataRepeat = sameDataRepeat;
	}

	public static Integer getRepeatNo() {
		return repeatNo;
	}

	public static void setRepeatNo(Integer repeatNo) {
		CommonPage.repeatNo = repeatNo;
	}

	
	public static String getCsvFileName() {
		return csvFileName;
	}

	public static void setCsvFileName(String csvFileName) {
		CommonPage.csvFileName = csvFileName;
	}


	public static String getTestDataDir() {
		return testDataDir;
	}

	public static void setTestDataDir(String testDataDir) {
		CommonPage.testDataDir = testDataDir;
	}


	private static final Logger LOGGER = LogManager.getLogger(CommonPage.class);

	private static String get_Excel_cell_data(String columnName) throws Exception {
		// Get cell value
		scenario = CommonPage.getScenario();
		Integer scenarioNo = CommonPage.getScenarioNo();
		String sheet = CommonPage.getSheet();
		String cell_value = ExcelUtils.getRepeatedCellData(CommonPage.getTestDataFile(), sheet, scenario, scenarioNo,
				columnName);
		return cell_value;
	}

	

	public static boolean close_the_browser() {
		try {
			if (!(CommonPage.getWebDriver() == null)) {
				// Common_Page.getWebDriver().close();
				CommonPage.getWebDriver().quit();
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("Step: Navigation|| Close the browser || Fail\n" + e);
			CommonPage.setException(e.toString());
			return false;
		}
	}

	public void setupScenario(String csvFile, String feature, String scenario) throws Exception {
		LOGGER.info(
				"CSV file is :" + csvFile + "******Feature Name***" + feature + "******Scenario Name***" + scenario);		
		//if (!(CommonPage.csvFileName == null) && !CommonPage.csvFileName.contentEquals(csvFileName)) {
			setCsvFileName(csvFile);
			setTestDataFile(testDataDir + "\\" + csvFileName + ".csv");
		//}
		if (!CommonPage.feature.contentEquals(feature)) {
			setFeature(feature);
		}
		if (!CommonPage.scenario.contentEquals(scenario)) {
			setScenario(scenario);
		}
	}

	
	// launch url for repeated_scenario
	public void launchURL() {
		try {		
			String url = getCSVData("URL");
			String browser = getCSVData("Browser");

			switch (browser.toLowerCase()) {
			case "ie":
				WebDriver driver = BaseMethods.getDriver("ie");
				setWebDriver(driver);
				break;
			case "firefox":
				driver = BaseMethods.getDriver("firefox");
				setWebDriver(driver);
				break;
			case "chrome":
				driver = BaseMethods.getChromeDriver(chromeDriverService);
				setWebDriver(driver);
				break;
			default:
				// if browser not mentioned in excel then use firefox
				driver = BaseMethods.getDriver("chrome");
				setWebDriver(driver);
				break;
			}
				webDriver.get(url);
				webDriver.manage().window().maximize();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Error occured while getting the URL\n" + e);

		}
	}

	

	public static void ChangeProxySettings(WebElement element) throws FindFailed {
		try {
			String path = System.getProperty("user.dir") + "\\SikuliImages\\";
			// to simulate 'Alt+t' and 'o' to get "internet options"
			String press = Keys.chord(Keys.ALT, Keys.chord("t"));
			element.sendKeys(press);
			element.sendKeys(Keys.chord("o"));
			// To simulate button clicks using Sikuli image icons
			Sikuli.clickElement(path + "tab_Connections.PNG");
			Sikuli.clickElement(path + "btn_LANSettings.PNG");
			Sikuli.clickElement(path + "chk_UseAutomaticConfig.PNG");
			Sikuli.clickElement(path + "chk_UseAProxyServer.PNG");
			Sikuli.clickElement(path + "btn_Ok_LANSettings.PNG");
			Sikuli.clickElement(path + "btn_Ok_LANSettings.PNG");
			Waits.waitInSeconds(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Error occured while changing proxy\n" + e);

		}
	}

	public static String TakeScreenShot() throws GeneralLeanFtException, InterruptedException, Exception {
		String imgPath = null;
		// take screen shot of browser window
		// and save image file in imgPath
		imgPath = BaseMethods.getSnap(getWebDriver());

		return imgPath;

	}
	
	public static String TakeScreenShot(WebDriver driver) throws GeneralLeanFtException, InterruptedException, Exception {
		String imgPath = null;
		// take screen shot of browser window
		// and save image file in imgPath
		imgPath = BaseMethods.getSnap(driver);

		return imgPath;

	}

	public static String TakeScreenShotOnFail() throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnFail");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			setImgPathOnFail(TakeScreenShot());
			return TakeScreenShot();
		}
		return "";
	}
	
	public static String TakeScreenShotOnFail(WebDriver driver) throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnFail");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			setImgPathOnFail(TakeScreenShot(driver));
			return TakeScreenShot(driver);
		}
		return "";
	}

	public static String TakeScreenShotOnPass() throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnPass");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			return TakeScreenShot();
		}
		return "";
	}
	
	public static String TakeScreenShotOnPass(WebDriver driver) throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnPass");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			return TakeScreenShot(driver);
		}
		return "";
	}

	// to send cucumber scenario step to Extent report when step pass
	public static void LOGGEROnPass(String gherkinKeyword, String step)
			throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		try {
			String screenShot = CommonPage.TakeScreenShotOnPass();
			if (screenShot.contentEquals("")) {
				if (stepInfo.contentEquals("")) {
					CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
							.pass("step passed");
				} else {
					CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
							.pass("step passed").pass(stepInfo);
				}
			} else {
				if (stepInfo.contentEquals("")) {
					CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
							.pass("step passed").addScreenCaptureFromPath(screenShot);
				} else {
					CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
							.pass("step passed").pass(stepInfo).addScreenCaptureFromPath(screenShot);
				}

			}
		} catch (Exception e2) {

		} finally {
			// to clear step additional Info
			CommonPage.setStepInfo("");
		}
	}
	
	// to send cucumber scenario step to Extent report when step pass
		public static void LOGGEROnPass(String gherkinKeyword, String step, WebDriver driver)
				throws IOException, GeneralLeanFtException, InterruptedException, Exception {
			try {
				String screenShot = CommonPage.TakeScreenShotOnPass(driver);
				if (screenShot.contentEquals("")) {
					if (stepInfo.contentEquals("")) {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed");
					} else {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").pass(stepInfo);
					}
				} else {
					if (stepInfo.contentEquals("")) {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").addScreenCaptureFromPath(screenShot);
					} else {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").pass(stepInfo).addScreenCaptureFromPath(screenShot);
					}

				}
			} catch (Exception e2) {

			} finally {
				// to clear step additional Info
				CommonPage.setStepInfo("");
			}
		}


	
	

	public static void LOGGEROnFail(String gherkinKeyword, String step, String e, WebDriver driver)
			throws IOException, InterruptedException, Exception {
		try {
			setTestSummaryException(e);
			String screenShot = CommonPage.TakeScreenShotOnFail(driver);
			if (screenShot.contentEquals("")) {
				CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e);
			} else {
				CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e)
						.addScreenCaptureFromPath(CommonPage.TakeScreenShotOnFail());
			}
		} catch (Exception e2) {
		} finally {
			// to clear step additional Info
			CommonPage.setStepInfo("");
		}
	}
	
	public static void LOGGEROnFail(String gherkinKeyword, String step, String e)
			throws IOException, InterruptedException, Exception {
		try {
			setTestSummaryException(e);
			String screenShot = CommonPage.TakeScreenShotOnFail();
			if (screenShot.contentEquals("")) {
				CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e);
			} else {
				CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e)
						.addScreenCaptureFromPath(CommonPage.TakeScreenShotOnFail());
			}
		} catch (Exception e2) {
		} finally {
			// to clear step additional Info
			CommonPage.setStepInfo("");
		}
	}
	
	// to send cucumber scenario step to Extent report when step fail
		public static void LOGGEROnFail(String gherkinKeyword, String step, Exception e)
				throws IOException, GeneralLeanFtException, InterruptedException, Exception {
			try {
				String screenShot = CommonPage.TakeScreenShotOnFail();
				if (screenShot.contentEquals("")) {
					if (stepInfo.contentEquals("")) {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).fail(e);
					} else {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).fail(e)
								.fail(stepInfo);
					}

				} else {
					if (stepInfo.contentEquals("")) {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).fail(e)
						.addScreenCaptureFromPath(CommonPage.TakeScreenShotOnFail());
					}else {
						CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).fail(e)
						.fail(stepInfo).addScreenCaptureFromPath(CommonPage.TakeScreenShotOnFail());
					}
					
				}
			} catch (Exception e2) {

			} finally {
				// to clear step additional Info
				CommonPage.setStepInfo("");
			}
		}

	// new GherkinKeyword("Scenario")
	// to send cucumber scenario step to Extent report when step skipped
	public static void LOGGEROnSkip(String gherkinKeyword, String step)
			throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		if (isLoggerOnSkip) {
			CommonPage.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).skip("SKIPPED");
		}
	}

	

	// to setup testSummary
	public static void setupTestSummary(String feature) {
		try {
			int rowNo = WordUtils.getRowNo(testSummaryDoc, feature);
			setTestSummaryRowNo(rowNo);
			// to initialize total no.of tests passed
			// based on no.of scenarios specified for this feature
			setTotalPass(WordUtils.getParagraphLength(testSummaryDoc, rowNo, 2));
			// to get total no. of scenarios with in current feature
			setTotalScenarios(totalPass);
			// to set text example: "3 out of 3 passed"
			String text = totalScenarios + " out of " + totalScenarios + " passed";
			// Ignoring header row
			if (rowNo > 0) {
				WordUtils.updateTableWithText(testSummaryDoc, rowNo, 3, "Pass", "Arial", 10, "00CC00", true, false,
						null);
				WordUtils.updateTableWithText(testSummaryDoc, rowNo, 4, text, "Arial", 10, "000000", true, false, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// to update test summary (word document) when test fail
	public static void updateTestSummaryOnFail() {
		try {
			CommonPage.setTotalPass(CommonPage.getTotalPass() - 1);
			// to set red text "Fail" under the column Result
			WordUtils.updateTableWithText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 3, "Fail",
					"Arial", 10, "FF0000", true, false, null);
			String txt = WordUtils.getCellText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4);
			String firstParagraph = WordUtils
					.getCell(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4).getParagraphs()
					.get(0).getText();
			String newParagraph = CommonPage.getTotalPass() + " out of " + CommonPage.getTotalScenarios() + " passed";
			String newtxt = txt.replace(firstParagraph, newParagraph);
			if (txt.contains("Reason:")) {
				WordUtils.updateTableWithText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4,
						newtxt, "Arial", 10, "000000", true, false, null);
			} else {
				WordUtils.updateTableWithText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4,
						newtxt, "Arial", 10, "000000", true, false, null);
				WordUtils.updateTableWithText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4,
						"Reason:", "Arial", 10, "000000", false, true, null);
				// Truncating exception message to allow only 250 characters
				String exception = CommonPage.getTestSummaryException();
				String excep = common.utilities.StringUtils.addLinebreaks(exception, 50);
				WordUtils.updateTableWithText(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4,
						excep, "Arial", 10, "800000", false, false, 250);
			}

			WordUtils.updateTableWithImage(CommonPage.getTestSummaryDoc(), CommonPage.getTestSummaryRowNo(), 4,
					imgPathOnFail.replace("file:///", ""), "PNG", 250, 150, false);

		} catch (Exception e) {
			LOGGER.warn("error in code update summary");
		}
	}
	// Start video
		public static boolean Startvideo() throws InterruptedException {
			try {
				videoUtils.startRecording();
				LOGGER.info("Step: start video capture PASS");
				return true;

			} catch (Exception e) {

				LOGGER.error("Step: start video capture Fail\n" + e);
				CommonPage.setException(e.toString());
				return false;
			}
		}

		// Stop video
		public static boolean Stopvideo() throws InterruptedException {
			try {
				videoUtils.stopRecording();
				LOGGER.info("Step: stop video capture PASS");
				return true;

			} catch (Exception e) {

				LOGGER.error("Step: stop video capture Fail\n" + e);
				CommonPage.setException(e.toString());
				return false;
			}
		}
	
	// get csv cell data
	public static String getCSVData(String column) throws Exception {
		String csvFileName = CommonPage.getCsvFileName();
		String scenario = CommonPage.getScenario();
		Integer scenarioNo = CommonPage.getScenarioNo();
		String cellValue = CSVUtils.getCSVData(CommonPage.getTestDataDir() + "\\" + csvFileName + ".csv", scenario,
				scenarioNo, column);
		return cellValue;
	}

	// .................. below are testing purpose only ..............

	// @Test
	public void test_killDriver() throws Exception {
		String pid = SystemUtils.getCurrentProcessId("chromedriver.exe");
		LOGGER.info("current crhome pid: " + pid);
		SystemUtils.killProcessById(pid);
	}

	

	

	// ****************** testing purpose only *****************
	//@Test
	public void getnodevalue() {
		String winAppDriverPath = FileUtils.findFullPath(GlobalConstants.USER_DIR, "WinAppDriver.exe");
		String docPath = FileUtils.findFullPath(GlobalConstants.USER_DIR, "Certified - Drivers Licence.pdf");
		System.out.println("Win app driver: " + winAppDriverPath);
		System.out.println("Doc path: " + docPath);	
		System.out.println("Parent path: " + FileUtils.getParentDirectoryPath(docPath));	
		//assertTrue(true);
	}
	
	@Test
	public void test_AzureTables() {
		try {

			String connectionString = "DefaultEndpointsProtocol=https;AccountName=creuatdocspipelineblob;AccountKey=3znXIgkm6qWolaZSfRqm5ytNdj4NMiNl/NGEXGdAEJfhR6qYs26vgrqRzkkZNerDtm3PjZv61o+rhY+vNLEx4Q==;EndpointSuffix=core.windows.net";
			// Create a TableServiceClient with a connection string.
			TableServiceClient tableServiceClient = new TableServiceClientBuilder().connectionString(connectionString)
					.buildClient();

			// Loop through a collection of table names.
			tableServiceClient.listTables().forEach(tableItem -> System.out.printf(tableItem.getName()));
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}
	}

}
