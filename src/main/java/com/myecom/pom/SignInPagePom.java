package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;

public class SignInPagePom extends BaseClass
{
	
	public SignInPagePom()
	{
		PageFactory.initElements(driver, this);  //init methhod initialize when object created i.e. in constructor
	}
	@FindBy(xpath="//input[@id='email_create']")
	WebElement email ;
	@FindBy(xpath="//*[@class='icon-user left']")
	WebElement CreateAccBtn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement loginEmailId;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signInButton;
	
	public String sendkeysToEmailBox() 
	{
		//Actions mouseAction=new  Actions(driver);
		//mouseAction.scrollToElement(email).perform();
		email.sendKeys("priya@gmail.com");
		//searchButton.click();
		String typeValue=email.getAttribute("value");
		return typeValue;
	}
	public String ValidatecreateAcBtn()
	{
		email.sendKeys("priyachougule10@gmail.com");
		CreateAccBtn.click();
		String url=driver.getCurrentUrl();
		return url;
	}
	public void setSignInText(String username,String password)
	{
		
		loginEmailId.sendKeys(username);
		loginPassword.sendKeys(password);
		//String name=(String)loginData.get("username");
		signInButton.click();
		//String url1=driver.getCurrentUrl();
		//return url1;
		
		
	}
}
