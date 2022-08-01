package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpom {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profile;
	
	@FindBy(xpath="//a[text()='login / Signup']")
	private WebElement login;
	
	@FindBy(xpath = "//input[@class='form-control mobileNumberInput']")
	private WebElement mobilenumber;
	
	@FindBy(xpath = "//div[@class='submitBottomOption']")
	private WebElement continuebutton;

	public Loginpom(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}

}
