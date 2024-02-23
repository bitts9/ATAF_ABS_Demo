package com.ABS.ataf.configreader;

import com.ABS.ataf.configuration.browser.BrowserType;

public interface ConfigReader {
	public String getUserName();
	public String getPassword();
	public String getPegaWebsite();
	public String getNonPegaWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
	public String getRun();
	public String getCASDataFile();
	public String getCDUDataFile();
	public String getTempCaseId();
	public void setTempCaseId(String caseId);
	
}
