
package ibank;



import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, jsonUsageReport = "target/cucumber-usage.json", usageReport = true, toPDF = true,		
		outputFolder = "target",
	     reportPrefix = "IBank")
@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml" }, features = { "D:/CompassTestAutomation/FeatureOrder_IBank_Akamai" }, tags = {})
       // "junit:target/cucumber-results.xml" }, features = { "C:\\Users\\c70032.CLIENT\\temp\\CompassTestAutomation\\FeatureOrder_IBank" }, tags = {"@Message_centre_view_details_ib" })
public class IBankTestSuite {
} 
