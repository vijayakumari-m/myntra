package com.test.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginScenario extends com.test.runner.Baseclass {
	
	@BeforeTest
	public void launchBrowser() throws Exception {
		browserLaunch();
	}
	
	@Test
	public void loginPage() throws Exception {

		
		
		driver.get("https://www.myntra.com");
		
		
		// Login to the Application

		WebElement profile = driver.findElement(By.xpath("//span[text()='Profile']"));

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		WebElement login = driver.findElement(By.xpath("//a[text()='login / Signup']"));
		login.click();
		Thread.sleep(2000);
		WebElement mobilenumber = driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']"));
		mobilenumber.sendKeys("9980028877");
		WebElement continuebutton = driver.findElement(By.xpath("//div[@class='submitBottomOption']"));
		continuebutton.click();
		
		

	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
