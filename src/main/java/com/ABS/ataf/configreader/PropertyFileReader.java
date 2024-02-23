
package com.ABS.ataf.configreader;

import java.util.Properties;

import org.apache.log4j.Level;

import com.ABS.ataf.configuration.browser.BrowserType;
import com.ABS.ataf.utility.ResourceHelper;

public class PropertyFileReader implements ConfigReader{

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getPegaWebsite() {
		return prop.getProperty("PegaWebsite");
	}
	
	public String getNonPegaWebsite() {
		return prop.getProperty("NonPegaWebsite");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DataBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	
	public String getRun() {
		return prop.getProperty("Run");
	}
	
	public String getCASDataFile() {
		return prop.getProperty("CASDataFile");
	}
	
	public String getCDUDataFile() {
		return prop.getProperty("CDUDataFile");
	}
	
	public String getTempCaseId() {
		return prop.getProperty("tempcaseid");
	}
	
	public void setTempCaseId(String caseData) {
		prop.setProperty("tempcaseid", caseData);
	}
	
}
