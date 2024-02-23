package com.ABS.ataf.common.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/featurefilesCAS/" }, glue = {
		"classpath:com.EE.ataf.stepdef.CAS","classpath:com.EE.ataf.stepdef.common", "classpath:com.EE.ataf.TestBase" }, plugin = { "pretty",
				"html:target/cucumber-html-report", "json:target/cucumber-report/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml" },

		monochrome = true,

		dryRun = false
//tags= {"@test0,@test1"}
)
public class CommonRunner extends AbstractTestNGCucumberTests {

}
