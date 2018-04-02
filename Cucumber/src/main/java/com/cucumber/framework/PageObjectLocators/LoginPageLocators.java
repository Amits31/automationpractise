package com.cucumber.framework.PageObjectLocators;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class LoginPageLocators{
	
	 WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPageLocators.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	public WebElement signin;
	
	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailAddress;
	
	
	@FindBy(xpath=".//*[@id='create_account_error']/ol/li")
	public WebElement errorMsg;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	public WebElement submitLogin;
	
	
	@FindBy(xpath="//*[@id='email_create']")
	public WebElement registration;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	public WebElement createAnAccount;
	

}
