package apptest.pages;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;

import common.baselib.BaseMethods;
import common.constants.GlobalConstants;
import common.toolbox.appium.Driver;
import common.toolbox.appium.Gestures;
import common.toolbox.selenium.Action;
import common.toolbox.selenium.Alerts;
import common.toolbox.selenium.Element;
import common.toolbox.selenium.JavaScript;
import common.toolbox.selenium.Waits;
import common.utilities.CSVUtils;
import common.utilities.ExcelUtils;
import common.utilities.StringUtils;
import common.utilities.WordUtils;
import common.utilities.XMLUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;



public class Common_Page {
	private static final Logger LOGGER = LogManager.getLogger(Common_Page.class);
	static AppiumDriver mobileDriver;
	static String sheet = "";
	public static String feature = "";
	static String firstScenario;// y
	public static String scenario = "";
	static String repeat;
	private static boolean isBeforeRun = false;// y
	static Integer scenarioNo;// y
	static Integer scenarioCount;
	public static ExtentReports extentReport;
	static ExtentTest test;
	static ExtentTest testChild;
	static ExtentTest extentFeature;
	static ExtentTest extentScenario;
	static ExtentTest extentScenarioNo;// y
	static boolean stepFail;
	static String testDataFile;
	static String stepInfo = "";
	static boolean isLoggerOnSkip;
	static String exception;
	static boolean scenarioResult;
	static String testSummaryDoc;
	static Integer totalPass;
	static Integer totalScenarios;
	static Integer testSummaryRowNo;
	static String testSummaryException;
	static String imgPathOnFail;
	static String exceptions;
	public static String configPath;
	static String testSuiteNo;
	static boolean sameDataRepeat;
	static Integer repeatNo;
	public static String Currentdate = "";
	static String launchType;
	static Session session;
	static Channel channel;
	public static String testDataDir;
	static String csvFileName = "";
	/*
	 * private static HashMap<Object, Common_Page> hMap = new HashMap<Object,
	 * Common_Page>(); static AppiumDriver driver;
	 *
	 * public Common_Page(AppiumDriver driver) { Common_Page.driver = driver;
	 * PageFactory.initElements(new AppiumFieldDecorator(driver, new
	 * TimeOutDuration(15, TimeUnit.SECONDS)), this); }
	 */

	@FindBy(id = "searchBox")
	public static RemoteWebElement txtbox_propertyAddress;
	// Click on Done button:
	@AndroidFindBy(xpath = "//*[@text='Done']")
	// native UI
	@iOSXCUITFindBy(accessibility = "Done") // for iOS native UI
	public static MobileElement btn_Done;

	// $x("//*[text()='BOM iPhone Banking CI Test']")
	@FindBy(id = "searchBox")
	public static RemoteWebElement link_AppName;
	// Singleton pattern
	private static Common_Page instance = null;

	public static Common_Page getInstance() {
		if (instance == null) {
			instance = new Common_Page();
		}
		return instance;
	}

	/*
	 * public static Common_Page getInstance(AppiumDriver driver) { // for
	 * threadsafe (during multi threading\parallel testing) use // 'synchronized
	 * hashmap' as shown below synchronized (hMap) { Common_Page instance =
	 * hMap.get(driver); if (instance == null) { instance = new Common_Page(driver);
	 * hMap.put(driver, instance); } return instance; } }
	 */
	// Return Value from Excel sheet
	public static String get_Excel_cell_data(String values) throws Exception {
		String scenario = Common_Page.getScenario();
		Integer scenarioNo = Common_Page.getScenarioNo();
		String sheet = Common_Page.getSheet();
		String valuess = ExcelUtils.getRepeatedCellData(Common_Page.getTestDataFile(), sheet, scenario, scenarioNo,
				values);
		return valuess;

	}

	public static boolean isLoggerOnSkip() {
		return isLoggerOnSkip;
	}

	public static void setLoggerOnSkip(boolean isLoggerOnSkip) {
		Common_Page.isLoggerOnSkip = isLoggerOnSkip;
	}

	public static String getTestDataFile() {
		return testDataFile;
	}

	public static void setTestDataFile(String testDataFile) {
		Common_Page.testDataFile = testDataFile;
	}

	public static AppiumDriver getMobileDriver() {
		return mobileDriver;
	}

	public static void setMobileDriver(AppiumDriver mobileDriver) {
		Common_Page.mobileDriver = mobileDriver;
	}

	public static String getSheet() {
		return sheet;
	}

	public static void setSheet(String sheet) {
		Common_Page.sheet = sheet;
	}

	public static ExtentTest getExtentFeature() {
		return extentFeature;
	}

	public static void setExtentFeature(ExtentTest extentFeature) {
		Common_Page.extentFeature = extentFeature;
	}

	public static ExtentTest getExtentScenario() {
		return extentScenario;
	}

	public static void setExtentScenario(ExtentTest extentScenario) {
		Common_Page.extentScenario = extentScenario;
	}

	public static ExtentTest getExtentScenarioNo() {
		return extentScenarioNo;
	}

	public static void setExtentScenarioNo(ExtentTest extentScenarioNo) {
		Common_Page.extentScenarioNo = extentScenarioNo;
	}

	public static void setFeature(String feature) {
		Common_Page.feature = feature;
	}

	public static String getFirstScenario() {
		return firstScenario;
	}

	public static void setFirstScenario(String firstScenario) {
		Common_Page.firstScenario = firstScenario;
	}

	public static String getScenario() {
		return scenario;
	}

	public static void setScenario(String scenario) {
		Common_Page.scenario = scenario;
	}

	public static String getRepeat() {
		return repeat;
	}

	public static void setRepeat(String repeat) {
		Common_Page.repeat = repeat;
	}

	public static com.aventstack.extentreports.ExtentTest getTestChild() {
		return testChild;
	}

	public static void setTestChild(com.aventstack.extentreports.ExtentTest testChild) {
		Common_Page.testChild = testChild;
	}

	public static String getFeature() {
		return feature;
	}

	/*
	 * public static void setFeature(String feature) { Common_Page.feature =
	 * feature; }
	 */

	public static com.aventstack.extentreports.ExtentReports getExtentReport() {
		return extentReport;
	}

	public static void setExtentReport(com.aventstack.extentreports.ExtentReports report) {
		Common_Page.extentReport = report;
	}

	public static com.aventstack.extentreports.ExtentTest getTest() {
		return test;
	}

	public static void setTest(com.aventstack.extentreports.ExtentTest test) {
		Common_Page.test = test;
	}

	public static Integer getScenarioCount() {
		return scenarioCount;
	}

	public static void setScenarioCount(Integer scenarioCount) {
		Common_Page.scenarioCount = scenarioCount;
	}

	public static Integer getScenarioNo() {
		return scenarioNo;
	}

	public static void setScenarioNo(Integer scenarioNo) {
		Common_Page.scenarioNo = scenarioNo;
	}

	public static boolean isStepFail() {
		return Common_Page.stepFail;
	}

	public static void setStepFail(boolean stepFail) {
		Common_Page.stepFail = stepFail;
	}

	public static String getStepInfo() {
		return stepInfo;
	}

	public static void setStepInfo(String stepInfo) {
		Common_Page.stepInfo = stepInfo;
	}

	public static String getException() {
		return exception;
	}

	public static void setException(String exception) {
		Common_Page.exception = exception;
	}

	public static boolean isScenarioResult() {
		return scenarioResult;
	}

	public static void setScenarioResult(boolean scenarioResult) {
		Common_Page.scenarioResult = scenarioResult;
	}

	// Test Summary implementation
	public static String getTestSummaryDoc() {
		return testSummaryDoc;
	}

	public static void setTestSummaryDoc(String testSummaryDoc) {
		Common_Page.testSummaryDoc = testSummaryDoc;
	}

	public static Integer getTotalPass() {
		return totalPass;
	}

	public static void setTotalPass(Integer totalPass) {
		Common_Page.totalPass = totalPass;
	}

	public static Integer getTotalScenarios() {
		return totalScenarios;
	}

	public static void setTotalScenarios(Integer totalScenarios) {
		Common_Page.totalScenarios = totalScenarios;
	}

	public static Integer getTestSummaryRowNo() {
		return testSummaryRowNo;
	}

	public static void setTestSummaryRowNo(Integer testSummaryRowNo) {
		Common_Page.testSummaryRowNo = testSummaryRowNo;
	}

	public static String getTestSummaryException() {
		return testSummaryException;
	}

	public static void setTestSummaryException(String testSummaryException) {
		Common_Page.testSummaryException = testSummaryException;
	}

	public static String getImgPathOnFail() {
		return imgPathOnFail;
	}

	public static void setImgPathOnFail(String imgPathOnFail) {
		Common_Page.imgPathOnFail = imgPathOnFail;
	}

	public static String getConfigPath() {
		return configPath;
	}

	public static void setConfigPath(String configPath) {
		Common_Page.configPath = configPath;
	}

	public static String getTestSuiteNo() {
		return testSuiteNo;
	}

	public static void setTestSuiteNo(String testSuiteNo) {
		Common_Page.testSuiteNo = testSuiteNo;
	}

	public static boolean isSameDataRepeat() {
		return sameDataRepeat;
	}

	public static void setSameDataRepeat(boolean sameDataRepeat) {
		Common_Page.sameDataRepeat = sameDataRepeat;
	}

	public static Integer getRepeatNo() {
		return repeatNo;
	}

	public static void setRepeatNo(Integer repeatNo) {
		Common_Page.repeatNo = repeatNo;
	}

	// --------------------copature date from ibank ----------------------//
	public static void set_currentdate(String date) {
		Currentdate = date;
	}

	public static String get_currentdate() {
		return Currentdate;
	}

	public static String getLaunchType() {
		return launchType;
	}

	public static void setLaunchType(String launchType) {
		Common_Page.launchType = launchType;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		Common_Page.session = session;
	}

	public static Channel getChannel() {
		return channel;
	}

	public static void setChannel(Channel channel) {
		Common_Page.channel = channel;
	}

	public static String getTestDataDir() {
		return testDataDir;
	}

	public static void setTestDataDir(String testDataDir) {
		Common_Page.testDataDir = testDataDir;
	}

	
	public static String getCsvFileName() {
		return csvFileName;
	}

	public static void setCsvFileName(String csvFileName) {
		Common_Page.csvFileName = csvFileName;
	}



	// ******************** Page objects **************************************
	// "x" button (close button)
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Close']")
	public static MobileElement btn_X;

	// ******************** Page methods **************************************

	public static boolean click_X_btn() throws Exception {
		try {
			Driver.switchToNativeView(mobileDriver);
			Waits.waitInSeconds(3);
			String pageSource  = mobileDriver.getPageSource();
			System.out.println("PageSource: " + pageSource);
			btn_X.click();			
			
			return true;
		} catch (Exception e) {

			LOGGER.info("Step: Navigation || click on X btn || Fail");
			Common_Page.setException(e.toString());
			return false;
		}
	}

	public void setupScenario(String csvFile, String feature, String scenario) {
		setCsvFileName(csvFile);
		setTestDataFile(testDataDir + "\\" + csvFileName + ".csv");
		
		if (!Common_Page.feature.contentEquals(feature)) {
			setFeature(feature);
		}
		if (!Common_Page.scenario.contentEquals(scenario)) {
			setScenario(scenario);
		}
	}

	// to launch application
	public static boolean launchApp() {
		try {			
			AppiumDriver driver = Driver.getMobileDriver(sheet, scenario);
			if (driver == null) {
				throw new Exception("Mobile driver not found.");
			}
			Common_Page.setMobileDriver(driver);
			return true;
		} catch (Exception e) {
			LOGGER.info("Step: Navigation || Launch app || Fail");
			Common_Page.setException(e.toString());
			return false;
		}

	}

	public static String TakeScreenShot() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException  {
		String imgPath = null;
		// take screen shot of browser window
		// and save image file in imgPath
		try {
			String timeStamp = StringUtils.getCurrentTimeStamp("ddMMyyHHmmssSSS");
			//imgPath = BaseMethods.getSnap(Common_Page.mobileDriver);
			String newPath;
			String screenShotPath;
			screenShotPath = XMLUtils.getNodeText(Common_Page.getConfigPath(), "ScreenShotPath");
			// if xpath contains {user.home} then use below code
			if (screenShotPath.contains("{")) {
				newPath = StringUtils.replaceWithReflection(screenShotPath, "common.utilities.SystemUtils", "{", "}");
			} else {
				newPath = screenShotPath;
			}			
			 imgPath = newPath + "\\" + timeStamp + ".png";
			File scrFile = ((TakesScreenshot) Common_Page.mobileDriver).getScreenshotAs(OutputType.FILE);			
			FileUtils.copyFile(scrFile, new File(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgPath;
		

	}
	
	public static String TakeScreenShot(WebDriver driver)
			throws GeneralLeanFtException, InterruptedException, Exception {
		String imgPath = null;
		// take screen shot of browser window
		// and save image file in imgPath
		imgPath = BaseMethods.getSnap(driver);

		return imgPath;

	}

	public static void enterDataIosDevice(AppiumDriver driver, RemoteWebElement element, String dataToEnter,
			Boolean isTapOnIOSElement, Boolean isHideKeyboard) throws InterruptedException {
		if (isTapOnIOSElement) {
			Gestures.tapOnElement_TouchAction(driver, element);
		} else {
			element.click();
		}
		Waits.waitInMilliSeconds(500);
		// driver.getKeyboard() will no longer work on latest Appium.It has been
		// removed from protocal
		// driver.getKeyboard().sendKeys(dataToEnter.trim());
		enterUsingiOSKeyboard(driver, dataToEnter, isHideKeyboard);
	}

	public static void enterData(AppiumDriver driver, RemoteWebElement element, String dataToEnter,
			Boolean isTapOnIOSElement, Boolean isHideKeyboard) throws InterruptedException {
		if (Driver.getPlatformName().equalsIgnoreCase("android")) {
			element.clear();
			element.sendKeys(dataToEnter);
		} else {
			enterDataIosDevice(driver, element, dataToEnter, isTapOnIOSElement, isHideKeyboard);
		}
	}

	public static void enterUsingiOSKeyboard(AppiumDriver driver, String dataToEnter, Boolean isHideKeyboard)
			throws InterruptedException {

		if (launchType.equalsIgnoreCase("browser")) {
			Driver.switchToNativeView(driver);
		}

		Waits.waitInMilliSeconds(500);		
		if (Driver.getDeviceType().equalsIgnoreCase("iphone")) {
			for (char c : dataToEnter.toCharArray()) {
				if (c == ' ') {
					driver.findElement(MobileBy.id("space")).click();
				} else {
					if (Element.isElementPresent(driver, By.id(String.valueOf(c)), 0)) {
						driver.findElementById(String.valueOf(c)).click();
					} else {
						driver.findElementById("Return").click();
						if (Element.isElementPresent(driver, By.name(String.valueOf(c)), 0)) {
							driver.findElementById(String.valueOf(c)).click();
						} else {
							driver.findElementById("shift").click();
							if (Element.isElementPresent(driver, By.name(String.valueOf(c)), 0)) {
								driver.findElementById(String.valueOf(c)).click();
							} else {
								driver.findElementById("more").click();
								driver.findElementByName(String.valueOf(c)).click();
							}
						}
					}
				}
			}

		} else {
			// ipad
			for (char c : dataToEnter.toCharArray()) {
				if (c == ' ') {
					driver.findElement(MobileBy.id("space")).click();
				} else {
					driver.findElementById(String.valueOf(c)).click();
				}
			}
		}

		if (isHideKeyboard) {
			driver.findElementById("Done").click();
		}

		if (launchType.equalsIgnoreCase("browser")) {
			Driver.switchToWebView(driver);
		}

	}

	// method overloading for "enterUsingiOSKeyboard"
	public static void enterUsingiOSKeyboard(AppiumDriver driver, String dataToEnter) {
		try {
			enterUsingiOSKeyboard(driver, dataToEnter, false);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void enterData(AppiumDriver driver, RemoteWebElement element, String dataToEnter,
			Boolean isHideKeyboard) throws InterruptedException {
		if (Driver.getPlatformName().equalsIgnoreCase("android")) {
			element.click();
			element.clear();
			element.sendKeys(dataToEnter);
			// Action.sendKeys(Common_Page.getMobileDriver(), element,
			// dataToEnter);
		} else {
			enterDataIosDevice(driver, element, dataToEnter, true, isHideKeyboard);
		}
	}

	public static void click(AppiumDriver driver, RemoteWebElement element) throws InterruptedException {
		if (Driver.getPlatformName().equalsIgnoreCase("android")) {
			Action.moveToElement(driver, element);
			Action.click(driver, element);
		} else {
			Driver.switchToNativeView(driver);
			Gestures.swipeToElement(driver, element, "up");
			Gestures.tapOnElement_TouchAction(driver, element);
		}
	}

	public static String TakeScreenShotOnFail() throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnFail");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			setImgPathOnFail(TakeScreenShot());
			return TakeScreenShot();
		}
		return "";
	}

	public static String TakeScreenShotOnPass() throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnPass = XMLUtils.getNodeText(configPath, "ScreenShotOnPass");
		if (ScreenShotOnPass.toLowerCase().contentEquals("true")) {
			return TakeScreenShot();
		}
		return "";
	}

	// to send cucumber scenario step to Extent report when step pass
	public static void LOGGEROnPass(String gherkinKeyword, String step)
			throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		try {
			String screenShot = Common_Page.TakeScreenShotOnPass();
			if (screenShot.contentEquals("")) {// y
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo)
						.pass("step passed");
			} else {
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo)
						.pass("step passed").addScreenCaptureFromPath(screenShot);
			}
		} catch (Exception e2) {

		} finally {
			// to clear step additional Info
			Common_Page.setStepInfo("");
		}
	}

	// to send cucumber scenario step to Extent report when step fail
	public static void LOGGEROnFail(String gherkinKeyword, String step, Exception e)
			throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		try {
			String screenShot = Common_Page.TakeScreenShotOnFail();
			if (screenShot.contentEquals("")) {
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e);

			} else {
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e)
						.addScreenCaptureFromPath(Common_Page.TakeScreenShotOnFail());
			}
		} catch (Exception e2) {

		} finally {
			// to clear step additional Info
			Common_Page.setStepInfo("");
		}
	}

	public static void LOGGEROnFail(String gherkinKeyword, String step, String e)
			throws IOException, InterruptedException, Exception {
		try {
			setTestSummaryException(e);
			String screenShot = Common_Page.TakeScreenShotOnFail();
			if (screenShot.contentEquals("")) {
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e);
			} else {
				Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e)
						.addScreenCaptureFromPath(Common_Page.TakeScreenShotOnFail());
			}
		} catch (Exception e2) {
		} finally {
			// to clear step additional Info
			Common_Page.setStepInfo("");
		}
	}
	public static String TakeScreenShotOnFailWithDriver(WebDriver driver)
			throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnFail");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			setImgPathOnFail(TakeScreenShot(driver));
			return TakeScreenShot(driver);
		}
		return "";
	}
	
	public static String TakeScreenShotOnPassWithDriver(WebDriver driver)
			throws GeneralLeanFtException, InterruptedException, Exception {
		String ScreenShotOnError = XMLUtils.getNodeText(configPath, "ScreenShotOnPass");
		if (ScreenShotOnError.toLowerCase().contentEquals("true")) {
			return TakeScreenShot(driver);
		}
		return "";
	}
	// to send cucumber scenario step to Extent report when step pass
		public static void LOGGEROnPassWithDriver(String gherkinKeyword, String step, WebDriver driver)
				throws IOException, GeneralLeanFtException, InterruptedException, Exception {
			try {
				String screenShot = Common_Page.TakeScreenShotOnPassWithDriver(driver);
				if (screenShot.contentEquals("")) {
					if (stepInfo.contentEquals("")) {
						Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed");
					} else {
						Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").pass(stepInfo);
					}
				} else {
					if (stepInfo.contentEquals("")) {
						Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").addScreenCaptureFromPath(screenShot);
					} else {
						Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step)
								.pass("step passed").pass(stepInfo).addScreenCaptureFromPath(screenShot);
					}

				}
			} catch (Exception e2) {

			} finally {
				// to clear step additional Info
				Common_Page.setStepInfo("");
			}
		}

		public static void LOGGEROnFailWithDriver(String gherkinKeyword, String step, String e, WebDriver driver)
				throws IOException, InterruptedException, Exception {
			try {
				setTestSummaryException(e);
				String screenShot = Common_Page.TakeScreenShotOnFailWithDriver(driver);
				if (screenShot.contentEquals("")) {
					Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e);
				} else {
					Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step, stepInfo).fail(e)
							.addScreenCaptureFromPath(Common_Page.TakeScreenShotOnFail());
				}
			} catch (Exception e2) {
			} finally {
				// to clear step additional Info
				Common_Page.setStepInfo("");
			}
		}

	// new GherkinKeyword("Scenario")
	// to send cucumber scenario step to Extent report when step skipped
	public static void LOGGEROnSkip(String gherkinKeyword, String step)
			throws IOException, GeneralLeanFtException, InterruptedException, Exception {
		// Common_Page.getExtentScenario().createNode(new
		// GherkinKeyword(gherkinKeyword), step).skip("SKIPPED");

		// ---------- new implementation ------
		if (isLoggerOnSkip) {
			Common_Page.getExtentScenario().createNode(new GherkinKeyword(gherkinKeyword), step).skip("SKIPPED");
		}
	}

	// ********** testing purpose only **********

	

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
			Common_Page.setTotalPass(Common_Page.getTotalPass() - 1);
			// to set red text "Fail" under the column Result
			WordUtils.updateTableWithText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 3, "Fail",
					"Arial", 10, "FF0000", true, false, null);
			String txt = WordUtils.getCellText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4);
			String firstParagraph = WordUtils
					.getCell(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4).getParagraphs()
					.get(0).getText();
			String newParagraph = Common_Page.getTotalPass() + " out of " + Common_Page.getTotalScenarios() + " passed";
			String newtxt = txt.replace(firstParagraph, newParagraph);
			if (txt.contains("Reason:")) {
				WordUtils.updateTableWithText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4,
						newtxt, "Arial", 10, "000000", true, false, null);
			} else {
				WordUtils.updateTableWithText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4,
						newtxt, "Arial", 10, "000000", true, false, null);
				WordUtils.updateTableWithText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4,
						"Reason:", "Arial", 10, "000000", false, true, null);
				// Truncating exception message to allow only 250 characters
				String exception = Common_Page.getTestSummaryException();
				String excep = StringUtils.addLinebreaks(exception, 50);
				WordUtils.updateTableWithText(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4,
						excep, "Arial", 10, "800000", false, false, 250);
			}
			WordUtils.updateTableWithImage(Common_Page.getTestSummaryDoc(), Common_Page.getTestSummaryRowNo(), 4,
					imgPathOnFail.replace("file:///", ""), "PNG", 75, 125, false);

		} catch (Exception e) {

		}
	}

	public static boolean verifyText(String expected, String actual) {
		StringUtils.matches(expected, actual);
		return true;
	}

	// wait for Dashboard page
	// While page is loading Accept "Terms and conditions",click on close button
	// on
	// dark screen etc...until Dashboard page appears on screen
	public static void waitForDashboardPage(Integer timeOutInSec) {
		try {
			LOGGER.info("Waiting for dashboard page...");

			AppiumDriver driver = mobileDriver;

			Boolean IsButtonSkipClicked = false;
			for (int i = 0; i < timeOutInSec; i++) {
				Waits.waitInMilliSeconds(200);
				// LOGGER.info("Time elapsed: " + i + " seconds");
				if (driver.getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("ios")) {
					/*
					 * if (i == 20) { if (Element.isElementPresent(driver,
					 * MobileBy.AccessibilityId("Logon"), 0)) { break; } }
					 */
					// LOGGER.info("eStatements page source\n"+driver.getPageSource());
					// click ok on 'app maintenance pop up'
					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("OK"), 0)) {
						driver.findElement(MobileBy.AccessibilityId("OK")).click();
					}
					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("Skip"), 0)) {
						driver.findElement(MobileBy.AccessibilityId("Skip")).click();
					}
					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("Skip"), 0)) {
						driver.findElement(MobileBy.AccessibilityId("Skip")).click();
					}
					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("Continue"), 0)) {
						LOGGER.info("Terms&Conditions screen appeared");
						driver.findElement(MobileBy.AccessibilityId("I have read and accept the Terms and Conditions"))
								.click();
						driver.findElement(MobileBy.AccessibilityId("Continue")).click();
					}

					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("eStatements"), 0)) {
						LOGGER.info("eStatemetns page appeared");
						RemoteWebElement btn_Next = (RemoteWebElement) driver.findElement(MobileBy.id("Next"));
						Gestures.swipeToElement(driver, btn_Next, "up");
						Waits.waitInMilliSeconds(500);
						btn_Next.click();
					}
					if (Element.isElementPresent(driver, MobileBy.AccessibilityId("Logout"), 0)) {
						WebElement btn_logout = driver.findElement(MobileBy.AccessibilityId("Logout"));
						if (btn_logout.isDisplayed()) {
							LOGGER.info("Dashboard page found in " + i + " seconds");
							break;
						}
					}
				} else {
					// android
					Set<String> availableContexts = driver.getContextHandles();

					for (String context : availableContexts) {
						LOGGER.info("context: " + context);
					}

					if (!IsButtonSkipClicked) {
						if (!driver.getContext().contains("NATIVE")) {
							Driver.switchToNativeView(driver);
						}
						
					}

					

					// LOGGER.info("Page source of terms and conditions" + driver.getPageSource());
					if (Element.isElementPresent(driver, By.xpath(".//button[text()='Continue']"), 0)) {
						driver.findElementByXPath(".//div[@class='checkbox']//label[@for='accept-terms']").click();
						driver.findElementByXPath(".//button[text()='Continue']").click();
					}

					// if (Element.isElementPresent(driver, By.id("btnLogOut"),0)) {
					// if (!(driver.findElements(By.id("btnLogOut")).size() == 0)) {
					if (Element.isElementPresent(driver, By.xpath(".//button[text()='Logout']"), 0)) {
						LOGGER.info("Logout button found");

						WebElement btn_logout = driver.findElementByXPath(".//button[text()='Logout']");

						if (btn_logout.isDisplayed()) {
							LOGGER.info("Dashboard page found");
							break;
						}

					}
					// below code also working
					/*
					 * if (Element.isElementPresent(driver, By.className("customer-name"))) {
					 * WebElement lbl_UserName = driver.findElementByClassName("customer-name"); if
					 * (lbl_UserName.isDisplayed()) { LOGGER.info("Dashboard page found"); break; }
					 * }
					 */
				}
			}

		} catch (

		Exception e) {
			LOGGER.info(e);
		}
	}

	public static boolean selectOptionWithText(String textToSelect) {
		try {
			RemoteWebElement autoOptions = txtbox_propertyAddress;
			List<RemoteWebElement> optionsToSelect = (List<RemoteWebElement>) autoOptions.findElement(By.tagName("li"));
			for (RemoteWebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					LOGGER.info("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}
			return true;
		} catch (Exception e) {
			Common_Page.setException(e.toString());
			LOGGER.info("Step: Navigation || customer select entered address|| fail");
			return false;
		}

	}

	public static boolean retryingFindClick(RemoteWebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static boolean Environment() throws ParserConfigurationException {
		String url = XMLUtils.getNodeText(Common_Page.getConfigPath(), "Url");
		if (url.contains("sit4")) {
			return true;
		}
		return false;
	}

	public static boolean customer_move_to_login_page_mbank_appium() {
		try {

			if (Driver.getPlatformName().equalsIgnoreCase("android")) {
				if (Element.isElementPresent(Common_Page.getMobileDriver(),
						By.xpath(".//span[@class='icon-arrow-a-left']"), 1)) {

					WebElement ele = Common_Page.getMobileDriver()
							.findElementByXPath(".//span[@class='icon-arrow-a-left']");
					LOGGER.info("entering block4.....");
					Action.moveToElement(Common_Page.getMobileDriver(), ele);
					ele.click();
				}

				if (Element.isElementPresent(Common_Page.getMobileDriver(), By.xpath(
						".//button[contains(@class, 'pull-right icon-x') or contains(@class, 'pull-right visible-xs')or @class='pull-right']"),
						1)) {
					LOGGER.info("Inside the close code: ");
					Common_Page.getMobileDriver().findElementByXPath(
							".//button[contains(@class, 'pull-right icon-x') or contains(@class, 'pull-right visible-xs')or @class='pull-right']")
							.click();
				}

				if (Element.isElementPresent(Common_Page.getMobileDriver(), By.xpath("//button[@id='btnLogOut']"), 1)) {

					// JavaScript.clickElement(Common_Page.getMobileDriver(),
					// btn_logout);
					Common_Page.getMobileDriver().findElementByXPath("//button[@id='btnLogOut']").click();
					boolean b = Alerts.isAlertPresent(Common_Page.getMobileDriver(),
							"Navigating away from this page will terminate your session", 3);
					if (b) {
						Alerts alert = new Alerts();
						alert.alertOk(Common_Page.getMobileDriver());
					}
					Driver.switchToNativeView(Common_Page.getMobileDriver());
					LOGGER.info("Switch to Native View:");
				}

				
				// for ios use below
			} else {
				if (Element.isElementPresent(Common_Page.getMobileDriver(), By.id("Logout"), 0)) {
					Common_Page.getMobileDriver().findElementById("Logout").click();
				}
				if (Element.isElementPresent(Common_Page.getMobileDriver(), By.id("Done"), 5)) {
					Common_Page.getMobileDriver().findElementById("Done").click();
				}

			}
			return true;
		} catch (Exception e) {

			LOGGER.info("Step: Navigation || Customer move to Login page if error occured || Fail");
			Common_Page.setException(e.toString());
			return false;
		}
	}

	// below code is to check any error occurred on page.
	public static void error_check_on() throws Exception {

		if (Element.isElementPresent(Common_Page.getMobileDriver(), By.xpath("//div[@class='has-error']"), 1)) {
			WebElement error = Common_Page.getMobileDriver().findElement(By.xpath("//div[@class='has-error']"));
			if (error.isDisplayed()) {
				JavaScript.scrollToView(Common_Page.getMobileDriver(), error);
				throw new Exception("Error occured on Screen.");
			}
		}
		if (Element.isElementPresent(Common_Page.getMobileDriver(), By.id("msg-error"))) {
			throw new Exception("Login failed");
		}
	}

	// Throw Exception on Error on the page
	public static void throwExceptionOnError() throws Exception {
		if (Element.isElementPresent(Common_Page.getMobileDriver(),
				By.xpath("//*[@id='msg-error' or @aria-labelledby='msg-error' or @class='text-danger']"), 2)) {
			if (Common_Page.getMobileDriver()
					.findElement(
							By.xpath("//*[@id='msg-error' or @aria-labelledby='msg-error' or @class='text-danger']"))
					.isDisplayed()) {
				throw new Exception("Error displayed on the page");
			}
		}
	}

	// To get Y coordinate of element to be clicked at
	public static int getYcoordinateForTap(AppiumDriver driver, RemoteWebElement element, Integer x, Integer startingY)
			throws InterruptedException {
		Integer y = startingY;
		for (int i = 0; i <= 200; i++) {
			Gestures.tapOnElement_iOS(driver, element, x, startingY);
			Driver.switchToNativeView(driver);
			if (Element.isElementPresent(driver, By.name("A"), 0)) {
				LOGGER.info("Y coordinate of 'element' tapped:" + y);
				break;
			} else {
				Driver.switchToWebView(driver);
				i = i + 5;
				y = y + i;
			}
		}
		return y;
	}

	
	// get csv cell data
		public static String getCSVData(String column) throws Exception {
			String csvFileName = Common_Page.getCsvFileName();
			String scenario = Common_Page.getScenario();
			Integer scenarioNo = Common_Page.getScenarioNo();
			String cellValue = CSVUtils.getCSVData(Common_Page.getTestDataDir() + "\\" + csvFileName + ".csv", scenario,
					scenarioNo, column);
			return cellValue;
		}
	

		public static boolean clickXbutton() throws ParserConfigurationException {
			String pageSource  = mobileDriver.getPageSource();
			LOGGER.info("PageSource: " + pageSource);
			return false;
		}

	
	

	// ------------------------- Testing purpose only -------------------

	// @Test
	public void test_Masking_pwd() {
		Console console = System.console();
		char[] secNo = console.readPassword("Security Number: ");
		String secNum = String.valueOf(secNo);
		LOGGER.info("Password: " + secNum);
		char[] pw = console.readPassword("Password: ");
		String password = String.valueOf(pw);
		LOGGER.info("Password: " + password);
	}

}
