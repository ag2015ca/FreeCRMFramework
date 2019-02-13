package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
//loginpage is child of testbase
	
	
	//define page factory or object repository of login page
	
	//define elements
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement sighupButton;
	
		//image
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	//create contructor of this class- to initialize page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//initElement initializes the current class objects
		
		
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	public boolean validateCRMLogo()
	{
		return crmlogo.isDisplayed();
		
		
		
	}
	
	/*public homepage login(String un, String psw)
	{
		username.sendKeys(un);
		password.sendKeys(psw);
		
		login.click();
		//login page should return homepage
		
		return new homepage();
		
	}*/
	public homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new homepage();
	}
	
	

}
