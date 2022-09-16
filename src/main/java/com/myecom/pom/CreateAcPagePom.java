package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myecom.base.BaseClass;

public class CreateAcPagePom extends BaseClass
{
	public CreateAcPagePom()
	{
		PageFactory.initElements(driver, this);  
	}
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	@FindBy(xpath="//select[@id='years']")
	WebElement years;
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname1;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastname1;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailid;
	public void createAcc()
	{
		Select day=new Select(days);
		Select month=new Select(months);
		Select year=new Select(years);
		
		day.selectByVisibleText("15");
		month.selectByVisibleText("September");
		day.selectByVisibleText("2022");
	}
	
	public void setCreateAcText(String email,String fname,String lname,String password1,String address1,String city1,String state1,int zip,int mobile1)
	{
		emailid.sendKeys(email);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(password1);
		address.sendKeys(address1);
		city.sendKeys(city1);
		state.sendKeys(state1);
		
		String zipConvert=Integer.toString(zip);
		zipcode.sendKeys(zipConvert);
		
		String mobileConvert=Integer.toString(mobile1);
		mobile.sendKeys(mobileConvert);
		//signInButton.click();
		
		
		
	}
	
	
	
	
}
