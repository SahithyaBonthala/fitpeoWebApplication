package com.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
public WebDriver driver;
	
	String applicationUrlAddress = "https://fitpeo.com/";
	
	@BeforeTest
	public void setUp()
	{
		
		//System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
