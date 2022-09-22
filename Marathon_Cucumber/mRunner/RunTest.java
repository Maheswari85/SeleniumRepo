package mRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/mfeatures",glue = "mStepDefinition")
public class RunTest extends AbstractTestNGCucumberTests{

}
