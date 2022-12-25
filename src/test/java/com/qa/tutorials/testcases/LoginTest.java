package com.qa.tutorials.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.ninja.utilities.Utilities;
import com.qa.ninjatutorials.base.TestBase;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();
		
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver =initializeBrowser(prop.getProperty("BrowserName"));
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement ( By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		
	}
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		
	
	driver.findElement(By.id("input-email")).
	sendKeys(prop.getProperty("validEmailId"));
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	//Assert.assertTrue(driver.findElement(By. linkText("Edit your account information")).isDisplayed());

	 
	
	
}
	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {
	
    driver.findElement(By.id("input-email")).sendKeys(Utilities.generatedTimeStamp());
    driver.findElement(By.id("input-password")).sendKeys("Selenium@123456789");
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	String actualWarningMessage = driver.findElement
    (By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
	String expectedWarningMessasage = " Warning: No match for E-Mail Address and/or Password.";
	//Assert.assertTrue((actualWarningMessage.contains( expectedWarningMessasage)),
	// ("Expected warning message is not displayed"));
	
}
	@Test(priority = 3)
	public void VerifyLoginWithInvalidEmailidValidPassword() {
		
	    driver.findElement(By.id("input-email")).sendKeys(Utilities.generatedTimeStamp());
	    driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement
		(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
		String expectedWarningMessasage = " Warning: No match for E-Mail Address and/or Password.";
		//Assert.assertTrue((actualWarningMessage.contains( expectedWarningMessasage)),
		// ("Expected warning message is not displayed"));
		
		
	}
	@Test(priority = 4)
	public void VerifyLoginWithvalidEmailidInValidPassword() {
		
	    driver.findElement(By.id("input-email")).sendKeys(Utilities.generatedTimeStamp());
	    driver.findElement(By.id("input-password")).sendKeys("Selenium@123456789");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement
		(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
		String expectedWarningMessasage = " Warning: No match for E-Mail Address and/or Password.";
		//Assert.assertTrue((actualWarningMessage.contains( expectedWarningMessasage)),
		// ("Expected warning message is not displayed"));
		
		
	
}
	@Test(priority = 5)
	public void VerifyLoginWithNoCredentials() {
	
	    driver.findElement(By.id("input-email")).sendKeys("");
	    driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement
		(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText();
		String expectedWarningMessasage = " Warning: No match for E-Mail Address and/or Password.";
		//Assert.assertTrue((actualWarningMessage.contains( expectedWarningMessasage)),
		// ("Expected warning message is not displayed"));
		
		
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	public String generatedTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_");
			
		
		
	}
}

	
	

