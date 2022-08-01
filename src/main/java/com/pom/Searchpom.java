package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpom {
	
public WebDriver driver;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for products, brands and more')]")
	private WebElement searchfield;
	
	

	public Searchpom(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getSearchfield() {
		return searchfield;
	}
	

}
