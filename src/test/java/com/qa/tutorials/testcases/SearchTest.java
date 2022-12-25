package com.qa.tutorials.testcases;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ninjatutorials.base.TestBase;

public class SearchTest extends TestBase  {
	public SearchTest() throws Exception {
		super();
		
	}
	WebDriver driver;
	@BeforeMethod
		public void startup(){
		driver = initializeBrowser(prop.getProperty("BrowserName"));
			
		}
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("samsung");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue( driver.findElement(By.linkText("Samsung SyncMaster 941BW")).isDisplayed());
		
	}
	@Test(priority = 2)
	public void verifySearchWithInValidProduct() {
		driver.findElement(By.name("search")).sendKeys("Dell");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualInvalidSearchmassege = driver.findElement(By.xpath("//p[contains (text(),'There is no product that matches the search criteria.')]")).getText();
		Assert.assertEquals(actualInvalidSearchmassege,"There is no product that matches the search criteria.","This search message is not displayed");
		
	}
	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualNoProductmassege = driver.findElement(By.xpath("//p[contains (text(),'There is no product that matches the search criteria.')]")).getText();
		Assert.assertEquals(actualNoProductmassege,"There is no product that matches the search criteria.","This search message is not displayed");
		
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}
	
}


