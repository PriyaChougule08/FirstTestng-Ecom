package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class ProductListingPom extends BaseClass
{
	public ProductListingPom()
	{
		PageFactory.initElements(driver, this);  //init methhod initialize when object created i.e. in constructor
	}
	@FindBy(xpath="//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a")
	WebElement TshirtsBtn;
	
	/*
	 * public boolean ClickOnSearch() {
	 * 
	 * TshirtsBtn.click(); if(TshirtsBtn.isEnabled()) //isEnabled is returns true
	 * even if button not clicked { System.out.println("its true"); return true; }
	 * else { System.out.println("its false"); return false; } }
	 */
		//String typeValue=TshirtsBtn.getAttribute("value");
		//return typeValue;
	
	public String getTitleOfProduct() 
	{
		TshirtsBtn.click();
		String title=driver.getTitle();
		return title;
		
	}
}
