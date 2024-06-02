package uitest;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(publish=true,features="src/test/resources/UITestResource/features",tags="@log001")
public class UITestSuiteIT {
} 
