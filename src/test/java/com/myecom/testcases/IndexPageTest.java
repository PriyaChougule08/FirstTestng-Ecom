package com.myecom.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;
import com.myecom.pom.ProductListingPom;
import com.myecom.pom.SignInPagePom;

public class IndexPageTest extends BaseClass {
	
	IndexPagePom indexPagePom;
	SignInPagePom signinpagepom;
	ProductListingPom productlistingpom;
	SoftAssert softassert=new SoftAssert();   //soft Assert
	
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

	/*
	 * @Test public void sendkeysToEmailBox() //after signin--sendkey to email {
	 * indexPagePom = new IndexPagePom(); indexPagePom.signInClick();
	 * signinpagepom=new SignInPagePom(); signinpagepom.sendkeysToEmailBox(); }
	 */
	@Test
	public void validateLogo() 
	{
		indexPagePom = new IndexPagePom();
		boolean res = indexPagePom.validateLogo();
		Assert.assertTrue(res);  
	}
	/*
	 * @Test public void signInClick() { indexPagePom = new IndexPagePom(); boolean
	 * res = indexPagePom.signInClick(); Assert.assertTrue(res); }
	 */	
	@Test
	public void signInClick()    //for SignInPom class
	{
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
		indexPagePom = new IndexPagePom();
		String title=indexPagePom.getTitleOfPage();
		Assert.assertEquals(title, "My Store");
	}
	@Test
	public void serachBoxValidate() //when search for tshirts and after click serach button click validation 

	{
		indexPagePom = new IndexPagePom();
		//Assert.assertEquals(product, "abc");
		//Assert.assertTrue(product); 
		boolean search = indexPagePom.searchproductBox();
		Assert.assertEquals(search, true);	
	}
	@Test
	public void sendkeys1()  //use this method for validate text of search textbox
	{
		indexPagePom = new IndexPagePom();
		String value=indexPagePom.sendkeys1();
		Assert.assertEquals(value, "Tshirts");
	}
	
}
