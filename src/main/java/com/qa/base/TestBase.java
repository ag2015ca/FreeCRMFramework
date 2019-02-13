package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase()
	{
		//read property file
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/ag/workspace/FreeCRMFramework/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{e.printStackTrace();
		}
		
		
			catch(IOException e)
			{
				e.printStackTrace();
			}
}
public static void initialization(){
	String browsername = prop.getProperty("browser");
	
	if(browsername.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		//driver.get("http://www.freecrm.com");
		}


	
else if(browsername.equals("FF"))
{
		System.setProperty("webdriver.gecko.driver", "C:/gecko/geckodriver.exe");
		driver= new FirefoxDriver();
		//driver.get("http://www.freecrm.com");
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	driver.get(prop.getProperty("url"));
}
	
	@AfterTest
	public void TearDown()
	{
		
		driver.quit();
		
	}
}
