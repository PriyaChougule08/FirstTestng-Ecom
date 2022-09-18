package com.myecom.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.pom.CreateAcPagePom;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.SignInPagePom;
import com.myecom.utility.ExcelSheetHandle;

public class CreateAcPageTest extends BaseClass
{
	IndexPagePom indexPagePom1;
	SignInPagePom signinpagepom1;
	ExcelSheetHandle data=new ExcelSheetHandle();
	CreateAcPagePom createAcPagePom;
	@BeforeMethod
	public void setUp() 
	{
		loadAppliction();
	} 
	
	@Test
	public void createAc() throws FileNotFoundException
	{	//data.getSheet(fis,"login")  here we get excel file and sheet
		
		indexPagePom1 = new IndexPagePom();
		createAcPagePom=new CreateAcPagePom();
		 signinpagepom1=new SignInPagePom();
		// createAcPagePom
		
		 createAcPagePom=indexPagePom1.signInClick1();
		 signinpagepom1.ValidatecreateAcBtn();
		
		 Sheet sh=data.getSheet(data.getExcelFile(),"signup");
		Map<String,Object>loginData=data.getExcelSheetData(sh);
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		createAcPagePom.setCreateAcText((String)loginData.get("email"),(String)loginData.get("fname"),(String)loginData.get("lname"),(String)loginData.get("password"),(String)loginData.get("address"),(String)loginData.get("city"),
				(String)loginData.get("state"),(String)loginData.get("zip"),(String)loginData.get("mobile"));
		//(String)loginData.get("zip"),(String)loginData.get("mobile")
		//String name=(String)loginData.get("fname");
		//String password=(String)loginData.get("password");
		
	}
}
