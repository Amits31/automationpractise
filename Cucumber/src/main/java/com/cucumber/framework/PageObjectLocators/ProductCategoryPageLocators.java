package com.cucumber.framework.PageObjectLocators;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;

public class ProductCategoryPageLocators {

	

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ProductCategoryPageLocators.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='selectProductSort']")
	public WebElement sortByPrice;

	@FindAll(@FindBy(xpath = "//*[contains(@class,'price product-price')]"))
	public List<WebElement> listProdPrice;

	@FindBy(xpath = "//*[@id='layered_block_left']/p")
	public WebElement catalogTextObj;

	@FindBy(xpath = "html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[1]/span[1]")
	public WebElement price2;

	@FindBy(xpath = "html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[1]/span[1]")
	public WebElement price3;

	@FindBy(xpath = "html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[1]/span[1]")
	public WebElement price1;


}
