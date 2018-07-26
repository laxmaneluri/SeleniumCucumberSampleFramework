package com.laxel.pageobjects.sugarCRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath = "./html/body/div[@id='header']/div[@id='welcome']//a[text()='Log Out']")
	public WebElement lnk_logout;
	
	@FindBy(xpath = "//div[@id='moduleList']//a[text()='Sales']")
	public WebElement tab_sales;
	
	@FindBy(xpath = "//div[@id='subModuleList']/span[@class='selected']//a[text()='Accounts']")
	public WebElement lnk_account;

	public void navigateToSalesAccount() {
		// TODO Auto-generated method stub
		this.tab_sales.click();
		this.lnk_account.click();		
	}
	
	
	
	
}
