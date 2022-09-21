package com.myecom.testcases;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.ProductListingPom;
import com.myecom.pom.SignInPagePom;
import com.myecom.utility.UtilityP;

public class IndexPageTest extends BaseClass {
	
	IndexPagePom indexPagePom;
	SignInPagePom signinpagepom;
	ProductListingPom productlistingpom;
	SoftAssert softassert=new SoftAssert();   //soft Assert
	ExtentReports extentReports;
	ExtentTest logger;
	@BeforeMethod
	public void setUp() 
	{
		loadAppliction();
	}
	
	@BeforeTest
public void generateExtentReport()
{
		// create html file here	
		ExtentSparkReporter generateReport=new ExtentSparkReporter(projectPath+"//extentreport/extentReport.html");
	extentReports =new ExtentReports();
	extentReports.attachReporter(generateReport);
}
	@AfterTest
	public void flushReport() 
	{
		extentReports.flush();  //same like driver.quit..it starts with new test case execution every time
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception  //after executing all method this method executes
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, result.getName()+" Test Case FAIL");
			logger.log(Status.FAIL, result.getThrowable());
			logger.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(UtilityP.getScreenShot(driver, result.getName())).build());
		}
		

		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.FAIL, result.getName()+" Test Case SKIPPED");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, result.getName()+" Test case PASS");
		}
	}
	@Test
	public void validateLogo() 
	{  
		logger = extentReports.createTest("validateLogo");  //createTest()-it will create test report 
		// extentReports.createTest("validateLogo") if not use then it not create reports
		indexPagePom = new IndexPagePom();
		boolean res = indexPagePom.validateLogo();
		Assert.assertTrue(res);  
	}
	
	/*
	 * @Test public void sendkeysToEmailBox() //after signin--sendkey to email {
	 * indexPagePom = new IndexPagePom(); indexPagePom.signInClick();
	 * signinpagepom=new SignInPagePom(); signinpagepom.sendkeysToEmailBox(); }
	 */
	
	/*
	 * @Test public void signInClick() { indexPagePom = new IndexPagePom(); boolean
	 * res = indexPagePom.signInClick(); Assert.assertTrue(res); }
	 */	
	@Test
	public void signInClick()    //for SignInPom class
	{
		logger = extentReports.createTest("SignIn Click");
		indexPagePom = new IndexPagePom();
		 indexPagePom.signInClick();	
	}
	/*
	 * @Test public void ClickOnSearch() { indexPagePom = new IndexPagePom();
	 * indexPagePom.ClickOnSearch(); //method of IndexPagePom class--ClickOnSearch()
	 * productlistingpom=new ProductListingPom(); productlistingpom.ClickOnSearch();
	 * // method of ProductListingPom class--ClickOnSearch() 
	 * }
	 */
	/*
	 * @Test public void searchproductBox() { indexPagePom = new IndexPagePom();
	 * indexPagePom.searchproductBox(); //boolean res = indexPagePom.signInClick();
	 * //Assert.assertTrue(res); }
	 */
	@Test
	public void test()
	{
		logger = extentReports.createTest("test");	
		System.out.println("open webpage");
		//Assert.assertEquals(false, true);   //hard assert-if test case fails-then doesnt execute all statements after assert
		softassert.assertEquals(false, true);  //soft assert  it executes all statements even if testcase fails.										
		System.out.println("logo check ");
		System.out.println("title check");
		System.out.println("click on signin");
		softassert.assertAll();   // for soft assert at last write-softassert.assertAll(),it executes all but shows where test case fails
	}
	@Test
	public void validateTitle()
	{
		logger = extentReports.createTest("validateTitle");
		indexPagePom = new IndexPagePom();
		String title=indexPagePom.getTitleOfPage();
		Assert.assertEquals(title, "My Store");
	}
	@Test
	public void serachBoxValidate() //when search for tshirts and after click serach button click validation 

	{
		logger = extentReports.createTest("validateSearchBox");
		indexPagePom = new IndexPagePom();
		//Assert.assertEquals(product, "abc");
		//Assert.assertTrue(product); 
		boolean search = indexPagePom.searchproductBox();
		Assert.assertEquals(search, true);	
	}
	@Test
	public void sendkeys1()  //use this method for validate text of search textbox
	{
		logger = extentReports.createTest("Sendkeys");
		indexPagePom = new IndexPagePom();
		String value=indexPagePom.sendkeys1();
		Assert.assertEquals(value, "Tshirts");
	}
	
}
