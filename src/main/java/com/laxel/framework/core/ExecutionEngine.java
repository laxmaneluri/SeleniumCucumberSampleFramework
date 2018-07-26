/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.core;

import java.io.File;

import com.laxel.framework.helpers.Configuration;
import com.laxel.framework.helpers.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.laxel.framework.testreports.ReportManager;

public class ExecutionEngine {
	
	private static WebDriver driver;
	
	public static WebDriver getSeleniumWebDriver()
	{
		if (driver == null)
		{
			ReportManager.LogFailure("Get Selenium Driver", "Get Selenium Driver", "Selenium Driver instance", "Selenium driver instance is not created", false);
			return null;
		}
		return driver;
	}
	
	public static WebDriver CreateSeleniumWebDriver()
	{
		String browser = Configuration.getProperty("Browser");
		
		if (driver!=null)
			return driver;
		
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internet explorer")) {
			File file = new File("./Resource/Drivers/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability("IE.binary", "C:/Program Files/Internet Explorer/iexplore.exe");
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver(caps);
		} 
		else if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("./Resource/Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addExcludedArgument("ignore-certifcate-errors");
            chromeOptions.addArguments("test-type");
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
           	caps.setCapability("ignoreProtectedModeSettings", true);
			driver = new ChromeDriver(caps);
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		Utilities.delayFor(1000);
		((JavascriptExecutor) driver).executeScript("window.focus();");
		return driver;
	}
	
}
