package com.test.runner;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner extends Baseclass {
	
	static String itemname,itemname2;
	
	@BeforeTest
	public void launchBrowser() throws Exception {
		browserLaunch();
	}
	
	@Test(priority =0)
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
	
	@Test(priority =1)
	public void searchProduct() throws Exception {
		
		driver.navigate().to("https://www.myntra.com");
		
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
	
	@Test(priority =2)
	public void addToCart() throws Exception {
		driver.navigate().to("https://www.myntra.com");

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
		
		String newwindow =tabslist.get(tabssize-1);
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
	
	@Test(priority =3)
	public void CheckBag() throws Exception {
		

		driver.navigate().to("https://www.myntra.com");

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

		String newwindow = tabslist.get(tabssize-1);
		System.out.println(newwindow);
		for (String pages : alltabs) {
			if (driver.switchTo().window(pages).getTitle().equals(newwindow))
				break;

		}

		WebElement itemheader = driver.findElement(By.xpath("//div[@class='pdp-description-container']/div[1]/h1[2]"));
		Addtocart.itemname = itemheader.getText();
		WebElement selectage = driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[1]"));
		selectage.click();
		WebElement addtobagbutton = driver.findElement(By.xpath("//div[text()='ADD TO BAG']"));
		addtobagbutton.click();
		// Thread.sleep(2000);
		WebElement bagicon = driver.findElement(By.xpath("//span[text()='Bag']"));
		bagicon.click();
		WebElement itemheaderinbag = driver
				.findElement(By.xpath("//div[@class='itemContainer-base-item ']/div[2]/div/div[1]/a"));
		String itemnameinbag = itemheaderinbag.getText();

		if (itemnameinbag.equals(Addtocart.itemname)) {
			System.out.println("Selected item Present in the Bag!");
		}

	}
	
	@Test(priority =4)

	public void goToPayment() throws Exception {
		
		driver.navigate().to("https://www.myntra.com");
		

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
		
		String newwindow =tabslist.get(tabssize-1);
		System.out.println(newwindow);
		for (String pages : alltabs) {
			if (driver.switchTo().window(pages).getTitle().equals(newwindow))
				break;

		}

		
		WebElement selectage = driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/div[2]/div[1]"));
		selectage.click();
		WebElement addtobagbutton = driver.findElement(By.xpath("//div[text()='ADD TO BAG']"));
		addtobagbutton.click();
		
		//Moving towards Payment
		
		WebElement cartbag = driver.findElement(By.xpath("//span[text()='Bag']"));
		cartbag.click();
		
		WebElement placeorderbutton = driver.findElement(By.xpath("//div[@class='desktop-base-right']/div[3]/button/div"));
		
		act.moveToElement(placeorderbutton).click().build().perform();
		placeorderbutton.click();
		Thread.sleep(2000);
		WebElement mobilenumber2 = driver.findElement(By.xpath("//div[@class='mobileInputContainer']/div[1]/input"));
		mobilenumber2.sendKeys("9980028877");
		WebElement continuebutton2 = driver.findElement(By.xpath("//div[@class='submitBottomOption']"));
		continuebutton2.click();
		
		//Explict wait for user to enter the OTP
		WebDriverWait wait=new WebDriverWait(driver, 60);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='desktop-base-right']/div[3]/button/div")));
		WebElement placeorderbutton2 = driver.findElement(By.xpath("//div[@class='desktop-base-right']/div[3]/button/div"));
		placeorderbutton2.click();
		
		//Enter the Contact Details
		/*WebElement customername = driver.findElement(By.id("name"));
		customername.sendKeys("viji");
		
		WebElement customermobile = driver.findElement(By.id("mobile"));
		customermobile.sendKeys("9980028877");
		
		WebElement customerpincode = driver.findElement(By.id("pincode"));
		customerpincode.sendKeys("560100");
		
		WebElement customerstreetAddress = driver.findElement(By.id("streetAddress"));
		customerstreetAddress.sendKeys("Hosa Road");
		
		WebElement customerlocality = driver.findElement(By.id("locality"));
		customerlocality.sendKeys("Naganathapura");
		
		WebElement addaddressbutton = driver.findElement(By.xpath("//div[text()='ADD ADDRESS']"));
		addaddressbutton.click();*/
		
		WebElement paymentcontinuebutton = driver.findElement(By.xpath("//div[@class='addressDesktop-base-marginLeft']/div"));
		paymentcontinuebutton.click();
		Thread.sleep(2000);
		//Take Screenshot of Payment page
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(
				"C:\\Viji\\eclipse-workspace\\Selenium Project\\Screenshots\\myntrapaymentscreen.png");

		FileUtils.copyFile(src, dest);
	}
	
	@Test(priority =5)
	public void addToCart2() throws Exception {
		driver.navigate().to("https://www.myntra.com");

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
		Thread.sleep(2000);
		WebElement search2 = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		search2.sendKeys("Ethnic wear");
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement item2 = driver.findElement(By.xpath("//div[@class='search-searchProductsContainer row-base']/section/ul/li[2]"));
		item2.click();
		
		alltabs = driver.getWindowHandles();
		tabssize = alltabs.size();
		tabslist = new ArrayList<String>(tabssize);
		for (String pages : alltabs) {
			String title = driver.switchTo().window(pages).getTitle();
			tabslist.add(title);

		}
		
		String newwindow2 =tabslist.get(2);
		System.out.println(newwindow);
		for (String pages : alltabs) {
			if (driver.switchTo().window(pages).getTitle().equals(newwindow))
				break;

		}
		WebElement itemheader2 = driver.findElement(By.xpath("//div[@class='pdp-description-container']/div/h1[2]"));
		itemname2 = itemheader2.getText();
		WebElement selectage2 = driver.findElement(By.xpath("//div[@class='size-buttons-size-container']/div[2]/div[2]"));
		selectage2.click();
		WebElement addtobagbutton2 = driver.findElement(By.xpath("//div[contains(@class,'pdp-action-container pdp-fixed')]/div[1]"));
		addtobagbutton2.click();
	}



}
