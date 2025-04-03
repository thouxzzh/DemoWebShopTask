package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty","json:target/cucumber-reports/CucumberHRM.json"},
	   features= "src/test/resources/login.feature",
	    glue="stepDefinitions"
//	    tags=("@ChromeBrowser or @ValidCredentials1"),
//	    monochrome=true, 
//	    dryRun=false
	)

//@CucumberOptions(plugin = {"pretty","json:target/cucumber-reports/CucumberHRM.json"},features="src\\test\\resources\\com\\features\\Login.feature",glue="stepDefinitions",tags=("@ValidCredentials1"))
public class runnerfile extends  AbstractTestNGCucumberTests{
//
}
