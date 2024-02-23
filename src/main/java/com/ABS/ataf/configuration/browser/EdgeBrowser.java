
package com.ABS.ataf.configuration.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ABS.ataf.utility.ResourceHelper;


public class EdgeBrowser {
	
	public WebDriver getEdgeDriver() {
		System.setProperty("webdriver.edge.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/msedgedriver.exe"))
		;
		return new EdgeDriver();
	}

}
