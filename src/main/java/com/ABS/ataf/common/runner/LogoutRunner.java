package com.ABS.ataf.common.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/featurefilesCAS/LoginEE.feature" }, glue = {
		"classpath:com.EE.ataf.CAS.stepDef", "classpath:com.EE.ataf.TestBase" }, plugin = { "pretty",
				"html:FeaturesReport", "html:target/site/cucumber-pretty", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, dryRun = false
//tags= {"@Smoke"}

)

public class LogoutRunner extends AbstractTestNGCucumberTests {

}
