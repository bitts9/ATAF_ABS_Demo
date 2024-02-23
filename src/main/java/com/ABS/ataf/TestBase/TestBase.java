package com.ABS.ataf.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.configreader.PropertyFileReader;
import com.ABS.ataf.configuration.browser.BrowserType;
import com.ABS.ataf.configuration.browser.ChromeBrowser;
import com.ABS.ataf.configuration.browser.EdgeBrowser;
import com.ABS.ataf.configuration.browser.FirefoxBrowser;
import com.ABS.ataf.configuration.browser.HtmlUnitBrowser;
import com.ABS.ataf.configuration.browser.IExploreBrowser;
import com.ABS.ataf.helper.Logger.LoggerHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;

public class TestBase {

	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	private WebDriver driver = null;
	public static String scenarioname = StringUtils.EMPTY;

	public WebDriver getBrowserObject(BrowserType bType) throws Exception {

		try {

			log.info(bType);

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			case HtmlUnitDriver:
				HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
				return htmlUnit.getHtmlUnitDriver(htmlUnit.getHtmlUnitDriverCapabilities());

			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore.getIExplorerCapabilities());
			case Edge:
				EdgeBrowser edge = EdgeBrowser.class.newInstance();
				return edge.getEdgeDriver();
			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}

		} catch (Exception e) {
			log.equals(e);
			throw e;
		}

	}

	public void setUpDriver(BrowserType bType) throws Exception {

		System.out.println("Driver Before instantiation is: " + driver);
		driver = getBrowserObject(bType);

		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		setWebDriver(driver);
		System.out.println("Driver After instantiation is: " + driver);
		log.debug("InitializeWebDrive : " + driver.hashCode());
	}

	@Before
	public void before() throws Exception {

		ObjectRepo.reader = new PropertyFileReader();

		// Run from Jenkins code
		// String browser=System.getProperty("Browser");
		// setUpDriver(BrowserType.valueOf(browser)); //Run from jenkins

		// Run from Local code
		// setUpDriver(ObjectRepo.reader.getBrowser()); //Run from Local
		// log.info(ObjectRepo.reader.getBrowser()); //Run from Local

		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			System.out.println(ObjectRepo.reader.getRun());
			String browser1 = System.getenv("Browser");
			setUpDriver(BrowserType.valueOf(browser1));
//			setUpDriver(ObjectRepo.reader.getBrowser());
		} else {
			System.out.println(ObjectRepo.reader.getRun());
			setUpDriver(ObjectRepo.reader.getBrowser());
			log.info(ObjectRepo.reader.getBrowser());
		}
	}

	@After
	public void after(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		System.out.println("Driver in After Method is: " + driver);
		// driver.quit();
		log.info("Browser closed");
	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

	@BeforeStep
	public static void beforeStep(Scenario scenario) {
		scenarioname = scenario.getName();
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}

}
