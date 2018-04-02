package com.cucumber.framework.PageObjectLocators;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import com.cucumber.framework.helper.Wait.WaitHelper;

public class HomePageLocators {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtsMenu;
	
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistoryAndDetailsLink;
	
	@FindBy(xpath="//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")
	WebElement myAddresses;

}
