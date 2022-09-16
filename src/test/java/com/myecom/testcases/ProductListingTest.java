package com.myecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.ProductListingPom;
import com.myecom.pom.SignInPagePom;

public class ProductListingTest extends BaseClass
{
	IndexPagePom indexPagePom2;
	//SignInPagePom signinpagepom1;
	ProductListingPom productlistingpom;
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
	public void getTitleProduct()
	{
		indexPagePom2 = new IndexPagePom();
		indexPagePom2.ClickOnSearch();
		productlistingpom=new ProductListingPom();
		String titleProduct=productlistingpom.getTitleOfProduct();  //validate button click using title of page
		 Assert.assertEquals(titleProduct, "T-shirts - My Store");
	}
}
