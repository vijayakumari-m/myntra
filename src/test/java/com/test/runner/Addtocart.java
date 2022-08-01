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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Addtocart extends Baseclass{

	@BeforeTest
	public void launchBrowser() throws Exception {
		browserLaunch();
	}
	static String itemname;
	
	

	@Test
	public void addToCart() throws Exception {
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

		// ----Search for Kids T-shirt---
		WebElement searchfield = driver
				.findElement(By.xpath("//input[contains(@placeholder,'Search for products, brands and more')]"));
		searchfield.sendKeys("kids tshirts girls");

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		// ---Adding a product to the Bag---
		WebElement item1 = driver.findElement(By.xpath("//div/section/ul/li[1]"));
		item1.click();
		Thread.sleep(2000);

		Set<String> alltabs = driver.getWindowHandles();
		int tabssize = alltabs.size();
		List<String> tabslist = new ArrayList<String>(tabssize);
		for (String pages : alltabs) {
			String title = driver.switchTo().window(pages).getTitle();
			tabslist.add(title);

		}
		
		String newwindow =tabslist.get(1);
		System.out.println(newwindow);
		for (String pages : alltabs) {
			if (driver.switchTo().window(pages).getTitle().equals(newwindow))
				break;

		}

		WebElement itemheader = driver.findElement(By.xpath("//div[@class='pdp-description-container']/div[1]/h1[2]"));
		itemname = itemheader.getText();
		WebElement selectage = driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[1]"));
		selectage.click();
		WebElement addtobagbutton = driver.findElement(By.xpath("//div[text()='ADD TO BAG']"));
		addtobagbutton.click();

	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
