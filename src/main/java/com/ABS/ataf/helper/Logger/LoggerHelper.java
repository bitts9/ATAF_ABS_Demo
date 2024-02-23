package com.ABS.ataf.helper.Logger;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ABS.ataf.utility.ResourceHelper;

@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas) {
		if (root) {
			return Logger.getLogger(clas);
		}
		/*--delete existing logger file--*/
		File f = new File(ResourceHelper.getResourcePath("/target/Selenium.log"));
		if (f.exists()) {
			// Show if the file exists
			System.out.println("Exists");
			f.delete();
			System.out.println(f.getName() + " deleted"); // printing the file name
		}
		/*------------------------------*/
		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
