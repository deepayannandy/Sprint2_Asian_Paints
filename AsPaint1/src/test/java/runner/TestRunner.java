package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Appfeatures",glue={"stepDefinition"},dryRun=false,monochrome=true)
public class TestRunner {

}
// todo
// testNG Done
// base class and extend
// properties file Done
// assert statements Done
// Apache poi done
// TestNg xml done
// data provider done 
// extent report
//extent spark report 
//cucumber io
