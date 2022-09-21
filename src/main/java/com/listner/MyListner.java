package com.listner;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.myecom.base.BaseClass;
import com.myecom.utility.ExtentReportHandle;
import com.myecom.utility.UtilityP;

public class MyListner extends BaseClass  implements ITestListener
{  
	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentReportHandle extentReportHandle=new ExtentReportHandle();
		extentReportHandle.generateExtentReport();
		extentReportHandle.flushReport();
	}
	
	@Override 
	public void onTestSuccess(ITestResult result)
	{
		try 
		{
			UtilityP.getScreenShot(driver, result.getName());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result)
	{
		try 
		{
			UtilityP.getScreenShot(driver, result.getName());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
