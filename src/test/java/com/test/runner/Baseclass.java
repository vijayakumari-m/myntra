package com.test.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	
	 protected WebDriver driver;
		
	
	public void browserLaunch() throws Exception {

		

		System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver3\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

	}
	
	
	
	
}
