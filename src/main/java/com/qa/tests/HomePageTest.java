package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.homepage;
import com.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	homepage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil= new TestUtil();
		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	//
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String t = homePage.validateHomePageTitle();
		System.out.println("Homepage Tile"+t);
		Assert.assertEquals(t,"CRMPRO - CRM software for customer relationship management, sales, and support.");
				
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		
		//System.out.println(t);
		//homePage.verifyCorrectUserName();
				
	}
	@AfterMethod
	public void teardown(){driver.quit();}

}
