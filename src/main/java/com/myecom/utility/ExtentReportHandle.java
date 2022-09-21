package com.myecom.utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecom.base.BaseClass;

public class ExtentReportHandle extends BaseClass
{
	ExtentReports extentReports;
	ExtentTest logger;
	@BeforeTest
	public void generateExtentReport()
	{
			// create html file here	
			ExtentSparkReporter generateReport=new ExtentSparkReporter(projectPath+"//extentreport/extentReport.html");
		extentReports =new ExtentReports();
		extentReports.attachReporter(generateReport);
	}
	@AfterTest
	public void loggerMethod(ITestResult result)
	{
		logger.log(Status.FAIL, result.getName()+" Test Case FAIL");
		logger.log(Status.FAIL, result.getThrowable());
	}
	@AfterTest
	public void flushReport() 
	{
		extentReports.flush();  //same like driver.quit..it starts with new test case execution every time
	}
}
