package uitest.pages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.toolbox.selenium.Action;
import common.toolbox.selenium.Waits;

public class HomePage {	
		static WebDriver driver;
		private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
		private static HashMap<Object, HomePage> hMap = new HashMap<Object, HomePage>();

		public HomePage(WebDriver driver) {
			// init
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, CommonPage.getElementWait()), this);
		}

		public static HomePage getInstance(WebDriver driver) {
			// for threadsafe (during multi threading\parallel testing) use
			// 'synchronized hashmap' as shown below
			synchronized (hMap) {
				HomePage instance = hMap.get(driver);
				if (instance == null) {
					instance = new HomePage(driver);
					hMap.put(driver, instance);
				}
				return instance;
			}
		}
		
		// *************************** page objects ************************************
						
			@FindBy(id = "menuUser")
			public static WebElement mnuUser;	
			
			@FindBy(xpath = "//a[@data-ng-click='createNewAccount()']")
			public static WebElement lnkCreateNewAccount;	
			
			public boolean clickUsermenu() {
				try {
					mnuUser.click();
					Waits.waitInSeconds(1);
					return true;
				} catch (Exception e) {
					LOGGER.error("Step: Navigation || click on 'User' || Fail\n" + e.getMessage());
					CommonPage.setException(e.toString());
					return false;
				}
			}
			
			public boolean clickCreateNewAccount() {
				try {
                  //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-ng-click='createNewAccount()']"))).click();
					//lnkCreateNewAccount.click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-ng-click='createNewAccount()']"))); 
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
					Waits.waitInSeconds(1);
					return true;
				} catch (Exception e) {
					LOGGER.error("Step: Navigation || click on 'Create New Account' || Fail\n" + e.getMessage());
					CommonPage.setException(e.toString());
					return false;
				}
			}
}
