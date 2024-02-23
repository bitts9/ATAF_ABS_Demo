package com.ABS.ataf.common.runner;

import org.testng.annotations.AfterSuite;

import com.ABS.ataf.utility.ReportHistorySave;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/featurefilesNonPegaApp/" , "src/test/resources/featurefilesPegaApp/" }, glue = {
		"classpath:com.ABS.ataf.stepdef", "classpath:com.ABS.ataf.TestBase" }, plugin = { "pretty",
				"html:target/cucumber-html-report", "json:target/cucumber-report/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml" },

		monochrome = true,

		dryRun = false
//tags = { "@testnonpega1" }
)

public class LoginRunner extends AbstractTestNGCucumberTests {

//	@AfterSuite
//	private void ReportHistorySave() {
//		// TODO Auto-generated method stub
//		ReportHistorySave.copyReport();
//	}

}
