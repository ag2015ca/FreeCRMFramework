package com.qa.tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.homepage;

public class LoginPageTest extends TestBase{
LoginPage loginPage;
homepage homepage;


	public LoginPageTest()
	{
		super();
	}
	
	
@BeforeMethod
public void setUp()
{
	initialization();
	loginPage= new LoginPage();
	
	
}

/*@Test(priority=1)
public void loginPageTitleTest()
{
	String title= loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
}
*/

@Test(priority=2)
public void crmLogoImageTest()
{boolean flag = loginPage.validateCRMLogo();
Assert.assertTrue(flag);

	
}

@Test(priority=3)
public void logintest(){
	homepage= loginPage.login(prop.getProperty("username"),prop.getProperty("password")); 
}
@AfterMethod
public void tearDown(){
	driver.quit();
	
}

}
