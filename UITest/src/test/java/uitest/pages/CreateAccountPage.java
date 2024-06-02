package uitest.pages;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import common.toolbox.selenium.Element;
import common.toolbox.selenium.Waits;

public class CreateAccountPage {
	static WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(CreateAccountPage.class);
	private static HashMap<Object, CreateAccountPage> hMap = new HashMap<Object, CreateAccountPage>();

	public CreateAccountPage(WebDriver driver) {
		// init
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, CommonPage.getElementWait()), this);
	}

	public static CreateAccountPage getInstance(WebDriver driver) {
		// for threadsafe (during multi threading\parallel testing) use
		// 'synchronized hashmap' as shown below
		synchronized (hMap) {
			CreateAccountPage instance = hMap.get(driver);
			if (instance == null) {
				instance = new CreateAccountPage(driver);
				hMap.put(driver, instance);
			}
			return instance;
		}
	}
	
	// *************************** page objects ************************************	
		@FindBy(xpath = "//input[@name='usernameRegisterPage']")
		public static WebElement txtUserName;
		
		@FindBy(xpath = "//input[@name='emailRegisterPage']")
		public static WebElement txtEmail;
		
		@FindBy(xpath = "//input[@name='passwordRegisterPage']")
		public static WebElement txtPassword;
		
		@FindBy(xpath = "//input[@name='confirm_passwordRegisterPage']")
		public static WebElement txtConfirmPassword;
		
		@FindBy(xpath = "//input[@name='first_nameRegisterPage']")
		public static WebElement txtFirstName;
		// *************************** page  methods ************************************		
		public boolean clickAccountDetails() {
			try {				
				txtUserName.click();
				txtEmail.click();
				txtPassword.click();
				txtConfirmPassword.click();
				txtFirstName.click();
				return true;
			} catch (Exception e) {
				LOGGER.error("Step: Navigation || click on 'Account Details' || Fail\n" + e.getMessage());
				CommonPage.setException(e.toString());
				return false;
			}
		}		
		
		
		public boolean verifyErrorDisplay() {
			try {
				if (!Element.isElementPresent(driver, By.xpath("//*[contains(text(),'Username field is required')]"), 3)) {
					throw new Exception("UserName field is required");
				}
				if (!Element.isElementPresent(driver, By.xpath("//*[contains(text(),'Email field is required')]"), 3)) {
					throw new Exception("Email field is required");
				}
				if (!Element.isElementPresent(driver, By.xpath("//*[contains(text(),'Password field is required')]"), 3)) {
					throw new Exception("Password field is required");
				}
				if (!Element.isElementPresent(driver, By.xpath("//*[contains(text(),'Confirm password field is required')]"), 3)) {
					throw new Exception("Confirm password field is required");
				}
				return true;
			} catch (Exception e) {
				LOGGER.error("Step: Verification || Errors display || Fail\n" + e.getMessage());
				CommonPage.setException(e.toString());
				return false;
			}
		}
		
		public boolean enterAccountDetails() {
			try {
				String userName = CommonPage.getCSVData("UserName");
				txtUserName.sendKeys(userName);
				String email = CommonPage.getCSVData("Email");
				txtEmail.sendKeys(email);				
				txtPassword.sendKeys("Sk1256");
				txtConfirmPassword.sendKeys("Sk1256");
				txtFirstName.click();
				return true;
			} catch (Exception e) {
				LOGGER.error("Step: Navigation || enter 'Account Details' || Fail\n" + e.getMessage());
				CommonPage.setException(e.toString());
				return false;
			}
		}
		
		public boolean verifyAllErrorsClear() {
			try {
				if (Element.isElementPresent(driver, By.xpath("//*[contains(@text,'Username field is required')]"), 3)) {
					throw new Exception("UserName field is required");
				}
				if (Element.isElementPresent(driver, By.xpath("//*[contains(@text,'Email field is required')]"), 3)) {
					throw new Exception("Email field is required");
				}
				if (Element.isElementPresent(driver, By.xpath("//*[contains(@text,'Password field is required')]"), 3)) {
					throw new Exception("Password field is required");
				}
				if (Element.isElementPresent(driver, By.xpath("//*[contains(@text,'Confirm password field is required')]"), 3)) {
					throw new Exception("Confirm password field is required");
				}
				return true;
			} catch (Exception e) {
				LOGGER.error("Step: Verification || All errors clear || Fail\n" + e.getMessage());
				CommonPage.setException(e.toString());
				return false;
			}
		}
		
	
}