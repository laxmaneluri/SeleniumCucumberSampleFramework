package com.laxel.pageobjects.sugarCRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesAccounts {
	
	@FindBy(xpath = "//div[@id='shortcuts']//span[text()='Create Account']")
	public WebElement lnk_createAccount;
	
	@FindBy(xpath = "//div[@id='shortcuts']//span[text()='View Accounts']")
	public WebElement lnk_viewAccounts;
	
	@FindBy(xpath = "//div[@id='shortcuts']//span[text()='Import Accounts']")
	public WebElement lnk_importAccounts;
	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement txt_name;
	
	@FindBy(xpath = "//input[@id='phone_office']")
	public WebElement txt_officePhone;
	
	@FindBy(xpath = "//input[@id='website']")
	public WebElement txt_website;
	
	@FindBy(xpath = "//input[@id='phone_fax']")
	public WebElement txt_fax;
	
	@FindBy(xpath = "//input[@id='shipping_address_street']")
	public WebElement txt_ShippingAddrStr;
	
	@FindBy(xpath = "//input[@id='shipping_address_city']")
	public WebElement txt_shipppingAddrCity;
	
	@FindBy(xpath = "//input[@id='shipping_address_state']")
	public WebElement txt_shippingAddrState;
	
	@FindBy(xpath = "//input[@id='shipping_address_postalcode']")
	public WebElement txt_shippingAddrZip;
	
	@FindBy(xpath = "//input[@id='shipping_address_country']")
	public WebElement txt_shippingAddrCountry;
	
	@FindBy(xpath = "//input[@id='billing_address_street']")
	public WebElement txt_billingAddrStr;
	
	@FindBy(xpath = "//input[@id='billing_address_city']")
	public WebElement txt_billingAddrCity;
	
	@FindBy(xpath = "//input[@id='billing_address_state']")
	public WebElement txt_billingAddrState;
	
	@FindBy(xpath = "//input[@id='billing_address_postalcode']")
	public WebElement txt_billingAddrZip;
	
	@FindBy(xpath = "//input[@id='billing_address_country']")
	public WebElement txt_billingAddrCountry;
	
	
	@FindBy(xpath = "//input[@id='Accounts0emailAddress0']")
	public WebElement txt_primaryMailId;
	
	@FindBy(xpath = "//input[@id='SAVE_HEADER']")
	public WebElement btn_save;
	
	@FindBy(xpath = "//a[@id='edit_button']")
	public WebElement lnk_edit;
	
	@FindBy(xpath = "//table[@class='list view']")
	public WebElement tbl_accountsList;
	
	public void createAccount (String name, String mailId)
	{
		this.txt_name.sendKeys(name);
		this.txt_primaryMailId.sendKeys(mailId);
		this.btn_save.click();
	}
		
}
