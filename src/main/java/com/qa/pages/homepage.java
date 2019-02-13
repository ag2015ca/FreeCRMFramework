package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

//import com.qa.util.TestBase;

public class homepage extends com.qa.base.TestBase{
	ContactsPage contactsPage;
	TestUtil testUtil = new TestUtil();
	
	

	//define page factory or object repository of home page
	
		//define elements- 
		@FindBy(xpath="//td[contains(text(),'User: tim gary')]")
		WebElement userNameLabel;
		
		//password
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactButton;
		
		@FindBy(xpath="//a[contains(text(),'Deals')]")
		WebElement DealsButton;
		

		@FindBy(xpath="//a[contains(text(),'Tasks')]")
		WebElement TaskButton;
		
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		WebElement newContactLink;
		
		
		//create contructor of this class- to initialize page object
		public homepage()
		{
			PageFactory.initElements(driver, this);//initElement initializes the current class objects
			
			
		}
		
		public String validateHomePageTitle()
		{
			String s =driver.getTitle();
			System.out.println(s);
			return s;
			
		}
		public ContactsPage clickOnContactLink()
		{
			contactButton.click();
			return new ContactsPage();
		}
		
		
		public DealsPage clickOnDealsLink()
		{
			contactButton.click();
			return new DealsPage();
		}
	
		public TasksPage clickOnTasksLink()
		{
			contactButton.click();
			return new TasksPage();
		}
	
	
		public boolean verifyCorrectUserName(){
			
			testUtil.switchToFrame();System.out.println("user name"+ userNameLabel);
		Assert.assertEquals(userNameLabel, "tim gary");	
			
				return userNameLabel.isDisplayed();
			}
		
		
		
		public void clickOnNewContactLink(){
			Actions action = new Actions(driver);
			action.moveToElement(contactButton).build().perform();
			newContactLink.click();
			
		}
		}
	
	/*
	@Test
	public void login()
	{
		
		
		
		
		
		
	}
		login
				driver.findElement(By.name("username")).sendKeys("hellotry");
						driver.findElement(By.name("password")).sendKeys("try123");
								//driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
								//*[@id="loginForm"]/div/div/input
								//JavaScriptExecutor  =
						WebElement loginBtn =
							 driver.findElement(By.xpath("//input[@type='submit']"));
								 JavascriptExecutor js = (JavascriptExecutor)driver;
								 js.executeScript("arguments[0].click();", loginBtn);
								 
								 //Alert a = driver.switchTo().alert();
								 
					//handle file upload popup
								 //driver.findElement(By.xpath(xpathExpression).sendkeys("/user/ag/extent.html.");
								 
	}
*/

