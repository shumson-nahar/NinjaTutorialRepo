package com.qa.tutorials.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ninja.utilities.Utilities;
import com.qa.ninjatutorials.base.TestBase;

public class RegisterTest extends TestBase {
public RegisterTest() throws Exception {
		super();
		
	}
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= initializeBrowser(prop.getProperty("BrowserName"));
		driver.findElement ( By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		

	
		
	}
	@Test(priority = 1)
	public void verifyRegistrationMandatoryField() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium1");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda1");
		driver.findElement(By.id("input-email")).sendKeys( Utilities.generatedTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertEquals(actualHeading,"Your Account Has Been Created!", "Account Success messsage display");
}
	@Test(priority = 2)
	public void verifyRegistrationWithAllField() {
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium1");
		driver.findElement(By.id("input-lastname")).sendKeys("Panda1");
		driver.findElement(By.id("input-email")).sendKeys( Utilities.generatedTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@1234");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertEquals(actualHeading,"Your Account Has Been Created!", "Account Success messsage display");
				
	}
	@Test(priority = 3)
	public void verifyRegestrationWithoutAnyDetails() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		String ActualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(ActualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy policy warning not displaying");
		
		String actualFirstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
	    Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"),
		"First name warning message is not displayed");
	    
	    String actualLastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
	    Assert.assertTrue(actualLastNameWarning.contains("Last Name must be between 1 and 32 characters!"),
		"Last name warning message is not displayed");
	    
	    String emailWarning =  driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
	    Assert.assertTrue(emailWarning .contains("E-Mail Address does not appear to be valid!"),
		"E-Mail warning message is not displayed");
	    
	    String telephoneWarning =  driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
	    Assert.assertTrue(telephoneWarning .contains("Telephone must be between 3 and 32 characters!"),
		"Telephone  warning message is not displayed");
	    
     String passwordWarning =  driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
	    Assert.assertTrue(passwordWarning .contains("Password must be between 4 and 20 characters!"),
		"Password  warning message is not displayed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}
