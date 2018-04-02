package com.cucumber.framework.PageObject;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.PageObjectLocators.LoginPageLocators;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class LoginPage{
	
	public WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	LoginPageLocators loginLocators;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.loginLocators=new LoginPageLocators();
		PageFactory.initElements(driver, loginLocators);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver,loginLocators.signin ,ObjectRepo.reader.getExplicitWait());
	}
	
	public void clickOnSignInLink(){
		log.info("clicked on sign in link...");
		loginLocators.signin.click();
	}
	
	public void enterEmailAddress(String emailAddress){
		log.info("entering email address...."+emailAddress);
		loginLocators.registration.clear();
		loginLocators.registration.sendKeys(emailAddress);
		//registration.sendKeys("amit.s@gmail.com");
	}
	
	
	public HomePage clickOnSubmitButton(){
		log.info("clicking on submit button...");
		loginLocators.submitLogin.click();
		return new HomePage(driver);
	}
	
	
	public void  clickOnCreateAnAccount(){
		loginLocators.createAnAccount.click();
		log.info("Click on create an account");
		//return new RegistrationPage(driver);
	}
	
	public void verifyInvalidEmail(String email){
		String actualText=loginLocators.errorMsg.getText();
		System.out.println("actual "+actualText+"exp"+email);
		 log.info("Error message verified successfully");
	    Assert.assertEquals(email, actualText);
	   
	}

}
