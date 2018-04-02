package com.cucumber.framework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.PageObjectLocators.HomePageLocators;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	HomePageLocators homeLocators=null;
	ExtentReports extent;
	 ExtentTest logger;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.homeLocators=new HomePageLocators();
		PageFactory.initElements(driver,homeLocators);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, homeLocators.dressesMenu,ObjectRepo.reader.getExplicitWait());
	}
	
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	
	
	public void  clickOnMenu(){
		log.info("clicked on : "+homeLocators.dressesMenu.getText());
		homeLocators.dressesMenu.click();
		Actions action = new Actions(driver);
		action.moveToElement(homeLocators.dressesMenu).build().perform();
		driver.findElement(By.linkText("SUMMER DRESSES")).click();
		//return new ProductCategoryPage(driver);
	}

}
