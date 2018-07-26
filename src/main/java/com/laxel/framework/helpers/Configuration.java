/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.helpers;

import java.io.FileInputStream;
import java.util.Properties;

import com.laxel.framework.testreports.ReportManager;

public class Configuration {
	
	private static Properties prop; 
	
	public static String getProperty(String key)
	{
		try{
			if (prop == null)
			{
				prop = new Properties();
				FileInputStream fis = new FileInputStream("./resources/project.properties");
				prop.load(fis); //.loadFromXML(fis);
			}
			return prop.getProperty(key);
		}
		catch (Exception ex){
			ReportManager.LogFailure("Load Configuration", "Loading test automation configuration file", "test automation configuration file should be loaded", ex.getMessage() + ": Exception occured while loading script configuration", false);
			return null;
		}
	}
}
