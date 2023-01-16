package cucumberlat;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features="src/test/resources/Features/cucumber.feature",
		glue="cucumberlat",	
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty","html:target/cucumber-reports/cucumber.html",
		        "json:target/cucumber-reports/cucumber.json"},
//		dryRun=false,
		monochrome=true
		
		 
		)



public class testRunner {

	 
}
