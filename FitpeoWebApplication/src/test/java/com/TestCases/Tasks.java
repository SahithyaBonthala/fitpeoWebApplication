package com.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Tasks {
	
	WebDriver driver ;
	String applicationUrlAddress = "https://fitpeo.com/";
	
	@BeforeTest
	public void setUp()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1,description="Navigating to the fitpeo homepage")
	public void navigateToFitpeoHomePage() {
		
		driver.get(applicationUrlAddress);

	}
	
	@Test(priority=2,description="Navigating to the revenue calculator page")
	public void navigateToTheRevenueCalculatorPage() throws InterruptedException  {
		
		driver.findElement(By.xpath("//*[text()='Revenue Calculator']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=3,description="Scroll down to the Slider section")
	public void scrollDownToTheSliderSection()  {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("window.scrollBy(0,500)");
		 
		
	}
	
	@Test(priority=4,description="Adjusting slider value to 816")
	public void adjustingSliderValueTo816()  {
		
		Actions actions = new Actions(driver);
		WebElement dragMeToMyTarget = driver.findElement(By.xpath("//*[@style='left: 10%;']"));
        actions.clickAndHold(dragMeToMyTarget).moveByOffset(93, 0).release().perform();
		
        String textBoxValue = driver.findElement(By.id(":r0:")).getAttribute("value");
        
        System.out.println("The Text field value according to the slider is : " + textBoxValue);
	}
	
	@Test(priority=5,description="Updating Text Field Value To 560")
	public void upadatingTextFieldValueTo560() {
		
		 WebElement textBoxProperty = driver.findElement(By.id(":r0:"));
		 textBoxProperty.click();
		 for(int i=0;i<3;i++) {
			 
		 textBoxProperty.sendKeys(Keys.BACK_SPACE);
		 
		 }
		 
		 textBoxProperty.sendKeys("560");
		 String sliderValue = driver.findElement(By.xpath("//*[@aria-valuenow=\"560\"]")).getAttribute("value");	        
	     System.out.println("The Slider Value after updating text field : " + sliderValue);
	}
	
	@Test(priority=6,description="Validating the slider value according to text field value")
	public void validatingTheSliderValue() {
		
		String givenTextValue = "560";
		 String sliderValue = driver.findElement(By.xpath("//*[@aria-valuenow=\"560\"]")).getAttribute("value");	        

		if(givenTextValue.equals(sliderValue)) {
			System.out.println("Both the values of text field and slider are SAME");
		}
		else{
			System.out.println("Both the values of text field and slider are NOT SAME");
			
		}
		
	}
	
	@Test(priority=7,description="Selecting the CPT codes")

	public void selectingTheCPTCodes() {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;		
		 js.executeScript("window.scrollBy(0,300)");
		 
		 List<WebElement> checkBoxProperty = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
		 for(int i=0;i<3;i++) {
			 checkBoxProperty.get(i).click();
		 }
		 checkBoxProperty.get(7).click();
	}
	
	@Test(priority=8,description="Validating total recurring reimbursement")
	public void validateTotalRecurringReimbursement() {
		
		String recurringReimbursement = driver.findElements(By.tagName("p")).get(6).getText();
		System.out.println( recurringReimbursement );
		
	}
	
	@Test(priority=8,description="Verifying total recurring reimbursement is $110700")

	public void verifyingTotalRecurringReimbursementis$110700() {
		
		String expectedRecurringReimbursement = "$110700";
		String actualRecurringReimbursement = driver.findElements(By.tagName("p")).get(6).getText();
		if(expectedRecurringReimbursement.equals(actualRecurringReimbursement)) {
			System.out.println("Total Recurring Reimbursement for all patients per month : $110700");
		}else {
			System.out.println(actualRecurringReimbursement);
		}
		
		
	}
	
	  // @AfterTest
		public void teardown()
		{
			driver.quit();
		}
	
	

}
