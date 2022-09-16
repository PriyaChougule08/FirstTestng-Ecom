package com.myecom.testcases;

import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.ProductListingPom;
import com.myecom.pom.SignInPagePom;
import com.myecom.utility.ExcelSheetHandle;

public class SignInPageTest extends BaseClass
{
	IndexPagePom indexPagePom1;
	SignInPagePom signinpagepom1;
	ExcelSheetHandle data=new ExcelSheetHandle();
	//ProductListingPom productlistingpom;
	@BeforeMethod
	public void setUp() 
	{
		loadAppliction();
	} 
	
	@AfterMethod
	public void tearDown()  //after executing all method this method executes
	{
		//driver.quit();
	}
	@Test
	public void sendkeysToEmailBox()    //after signin--sendkey to email
	{
		indexPagePom1 = new IndexPagePom();
		indexPagePom1.signInClick();
		signinpagepom1=new SignInPagePom();
		String email=signinpagepom1.sendkeysToEmailBox();
		Assert.assertEquals(email, "priya@gmail.com");
	}
	@Test
	public void ValidatecreateAcBtn()
	{	indexPagePom1 = new IndexPagePom();
	indexPagePom1.signInClick();
	signinpagepom1=new SignInPagePom();
	String url=signinpagepom1.ValidatecreateAcBtn();
	Assert.assertEquals(url, "http://automationpractice.com/index.php?controller=authentication&back=my-account");	
	}
	@Test
	public void login() throws FileNotFoundException
	{	//data.getSheet(fis,"login")  here we get excel file and sheet
		Sheet sh=data.getSheet(data.getExcelFile(),"login");
		
		Map<String,Object>loginData=data.getExcelSheetData(sh);
		
		indexPagePom1 = new IndexPagePom();
		signinpagepom1=indexPagePom1.signInClick();
		signinpagepom1.setSignInText((String)loginData.get("username"), (String)loginData.get("password"));
		String name=(String)loginData.get("username");
		String password=(String)loginData.get("password");
		
		
	}
}
