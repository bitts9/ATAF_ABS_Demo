
package com.ABS.ataf.configuration.browser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ABS.ataf.utility.ResourceHelper;



public class ChromeBrowser {

	public ChromeOptions getChromeCapabilities() {
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		//options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.merge(chrome);
		//chrome.setCapability(ChromeOptions.CAPABILITY, options);
		return options;
	}

	public WebDriver getChromeDriver(ChromeOptions cap) {
		if (System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
			//WebDriverManager.chromedriver().setup();
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			//WebDriverManager.chromedriver().setup();
			return new ChromeDriver(cap);
		}
		return null;
	}
}
