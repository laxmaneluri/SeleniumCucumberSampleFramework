package com.laxel.pageobjects.sugarCRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name = "user_name")
	public WebElement txt_username;
	
	@FindBy(name = "user_password")
	public WebElement txt_password;
	
	@FindBy(name = "Login")
	public WebElement btn_login;
	
	public void LoginToSugarCRM(String userName, String password)
	{
		txt_username.click();
		txt_username.sendKeys(userName); 
		txt_password.sendKeys(password);
		btn_login.click();
	}
}