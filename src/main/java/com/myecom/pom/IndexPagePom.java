package com.myecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class IndexPagePom extends BaseClass
{
	public IndexPagePom()
	{
		PageFactory.initElements(driver, this);  //init methhod initialize when object created i.e. in constructor
	}
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo ;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinButton; 
	
	@FindBy(id = "search_query_top")
	WebElement searchProductbox;     //search Textbox
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public boolean validateLogo() 
	{
		if(logo.isDisplayed()) 
		{
			System.out.println("logo is available");
			
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/*
	 * public boolean signInClick() { signinButton.click(); return true; }
	 */
	public SignInPagePom signInClick() 
	{
		signinButton.click();
		return new SignInPagePom();
	}
	public CreateAcPagePom signInClick1() 
	{
		signinButton.click();
		return new CreateAcPagePom();
	}
	public String sendkeys1()   /// use this method for validate text of search textbox
	{
		searchProductbox.sendKeys("Tshirts");
		//searchButton.click();
		String typeValue=searchProductbox.getAttribute("value");
		return typeValue;
	}
	public boolean searchproductBox()   //when search for tshirts and after click serach button click validation 
	{
		searchProductbox.sendKeys("Tshirts");
		searchButton.click();
		if(searchButton.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public ProductListingPom ClickOnSearch()
	{
		searchProductbox.sendKeys("Tshirts");
		searchButton.click();
		return new ProductListingPom();
	}
	public String getTitleOfPage() 
	{
		String title=driver.getTitle();
		return title;
		
	}
}
