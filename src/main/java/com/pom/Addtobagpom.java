package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtobagpom {
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//div/section/ul/li[1]")
	private WebElement item1;
	
	@FindBy(xpath = "//div[@class='pdp-description-container']/div[1]/h1[2]")
	private WebElement itemheader;
	
	@FindBy(xpath = "//div[@id='sizeButtonsContainer']/div[2]/div[1]")
	private WebElement selectage;
	
	@FindBy(xpath = "//div[text()='ADD TO BAG']")
	private WebElement addtobagbutton;
	
	public Addtobagpom(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getItem1() {
		return item1;
	}

	public WebElement getItemheader() {
		return itemheader;
	}

	public WebElement getSelectage() {
		return selectage;
	}

	public WebElement getAddtobagbutton() {
		return addtobagbutton;
	}

}
