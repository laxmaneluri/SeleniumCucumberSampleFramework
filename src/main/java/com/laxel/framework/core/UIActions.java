/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.laxel.framework.testreports.ReportManager;

public class UIActions {
	
	public static void clickObject(WebElement webElement)
	{
		
		try {
			if ((webElement != null) && (webElement.isDisplayed()) && (webElement.isEnabled())) {
				webElement.click();
				ReportManager.LogInfo("Click Object", "Clicking on webelement " + webElement.toString(), "Click Successful", "Click webelement is successful", false);
			}
		} catch (Exception exp) {
			ReportManager.LogFailure("Click Object", "Clicking on webelement " + webElement.toString(), "Click Successful", "Not able to click on the element as element is not present or enabled. Please check the screenshot", true);
		}
		if (webElement.isEnabled())
		{
			webElement.click();
		}
		else
		{
			//ReportManager.LogFailure(, description, expected_result, actual_result, ScreenShot);
		}
	}
	
	public static void enterText()
	{
		
	}
	
	public static void selectItem()
	{
		
	}
	
	public static boolean waitForExistance(By byProperty, Long waitTimeInMilliSec)
	{
		
		return false;
	}
	
	public static void waitForProperty()
	{
	}
}
