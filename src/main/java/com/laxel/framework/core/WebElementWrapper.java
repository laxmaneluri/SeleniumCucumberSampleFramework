/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementWrapper {
	
	public static void selectOption(WebElement webElement, String Option)
	{
		System.out.println(webElement.getTagName());
		Select selectElement = new Select(webElement);
		selectElement.selectByVisibleText(Option);
	}

}
