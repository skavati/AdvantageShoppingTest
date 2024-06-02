package uitest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.aventstack.extentreports.ExtentReports;
import common.baselib.BaseMethods;
import common.toolbox.report.ExtentReport;
import common.utilities.FileUtils;
import common.utilities.StringUtils;
import common.utilities.XMLUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import uitest.pages.CommonPage;

public class Hooks {
	private static boolean isBeforeRun = false;
	private static final Logger LOGGER = LogManager.getLogger(CommonPage.class);

	@Before("@uitest") // cucumber "before annotation"
	public void beforeAll() throws Exception {
		// LOGGER.debug("LOGGER msg: Before all");
		// to initialize scenario no to "1" before every cucumber scenario
		CommonPage.setScenarioNo(1);
		// to initialize step fail to false before every cucumber scenario
		CommonPage.setStepFail(false);
		// to intialize LoggerOnSkip
		CommonPage.setLoggerOnSkip(true);
		CommonPage.setException(null);
		CommonPage.setScenarioResult(true);

		if (!isBeforeRun) {
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					// to close extent report
					// this will run only once for whole jvm process
					CommonPage.getExtentReport().flush();
					LOGGER.info("Extent report generated");
					//CommonPage.getChromeDriverService().stop();
					//LOGGER.info("ChromeDriverSerivice stopped");

					// To replace absolute path with relative in test report html file String
					String extentReportPath = XMLUtils.getNodeText(CommonPage.getConfigPath(), "ExtentReportFile");
					if (extentReportPath.contains("{")) {
						// to replace {user_home} or {user_dir} with absolute path
						try {
							extentReportPath= StringUtils.replaceWithReflection(extentReportPath,
									"common.utilities.SystemUtils", "{", "}");							
						} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
							
						}						
						
					}
					String target = StringUtils.getStringBetweenTwoCharsInAFile(extentReportPath,
							"<img data-featherlight='", "\\ScreenShots");
					FileUtils.replaceFileText(extentReportPath, target, ".");
					// to delete temporary folder (which gets created during
					// test run from jar file)
					try {
						FileUtils.DeleteFileFolder(System.getProperty("user.dir") + "\\temp4Auto");
					} catch (IOException e) {
						LOGGER.debug(e);
					}
				}
			}));

			isBeforeRun = true;
			// setting test data file from project variables
			String configPath = FileUtils.findFullPath(System.getProperty("user.dir"), "config.xml");
			CommonPage.setConfigPath(configPath);
			String extentReportPath = XMLUtils.getNodeText(configPath, "ExtentReportFile");
			if (extentReportPath.contains("{")) {
				// to replace {user_home} with C:\Users\C70032
				String newPath = StringUtils.replaceWithReflection(extentReportPath, "common.utilities.SystemUtils",
						"{", "}");
				extentReportPath = newPath;
			}
			// to set elementWait (implicit wait for all page objects)
			CommonPage.setElementWait(Integer.valueOf(XMLUtils.getNodeText(configPath, "ElementWait")));
			// To get "TestReport" directory path
			String testReportPath = FileUtils.getParentDirectoryFullPath(extentReportPath, "TestReport");
			CommonPage.setTestReportDirPath(testReportPath);
			ExtentReport.setConfigPath(configPath);
			LOGGER.info("Config file path:" + configPath);

			String testDataDir = XMLUtils.getNodeText(configPath, "TestDataDir");
			if (testDataDir.contains("{")) {
				testDataDir = StringUtils.replaceWithReflection(testDataDir, "common.utilities.SystemUtils", "{", "}");
			}
			CommonPage.setTestDataDir(testDataDir);
			// starting extent report
			ExtentReports report = ExtentReport.getExtentReport();
			CommonPage.setExtentReport(report);
			LOGGER.info("Extent report started");
			// start ChromeDriver Service
			ChromeDriverService service = BaseMethods.getChromeDriverService();
			CommonPage.setChromeDriverService(service);
			LOGGER.info("ChromeDriverSerivice started");
		}
	}

	@After("@tearDown and @uitest")
	public void tearDown() throws Exception {
		if (!(CommonPage.getWebDriver() == null)) { 
			// to close chrome\ie browser window
			CommonPage.getWebDriver().close();
			LOGGER.info("********* || Closing WebDriver || *********");
		}
	}
}
