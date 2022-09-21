package com.myecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.listner.MyListner;
import com.myecom.base.BaseClass;

@Listeners(MyListner.class)   ///it takes MyListner class
public class DemoTest extends BaseClass
{	//@Parameters("browser")
	@BeforeMethod
	public void setup()
	//public void setup(String browser)
	{
	loadAppliction();
	}
	@AfterMethod
	public void teardown()
	{
	driver.quit();
	}
	//@Test(invocationCount = 3)  //run test case multiple times
	
	@Test(priority = 3,groups = {"smoke"})
	public void test1()
	{
	System.out.println("In Test 1");
	}
	@Test(priority = 1,groups= {"sanity","regression"})  //when we give same priorities then according to alphabetical order it executes
	public void test2()  
	{
	System.out.println("In Test 2");
	Assert.fail();
	}
	
	@Test(priority = 1,groups = {"sanity"})
	public void test3()
	{
	System.out.println("In Test 3");
	}
}
