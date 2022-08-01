package com.test.runner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SearchItem extends Baseclass {

	@BeforeTest
	public void launchBrowser() throws Exception {
		browserLaunch();
	}
	
	
	@Test
	public void searchProduct() throws Exception {
		
		driver.get("https://www.myntra.com");
		
		//Login to the Application
		
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
		//Explict wait for user to enter the OTP
		//WebDriverWait wait=new WebDriverWait(driver, 60);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search for products, brands and more')]")));
		
		
		
		//----Search for Kids T-shirt---
		WebElement searchfield = driver.findElement(By.xpath("//input[contains(@placeholder,'Search for products, brands and more')]"));
		searchfield.sendKeys("kids tshirts girls");
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//driver.close();

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
