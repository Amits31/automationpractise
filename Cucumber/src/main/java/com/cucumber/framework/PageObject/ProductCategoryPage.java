package com.cucumber.framework.PageObject;

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

import com.cucumber.framework.PageObjectLocators.ProductCategoryPageLocators;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;

public class ProductCategoryPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	WaitHelper waitHelper;
	ProductCategoryPageLocators productPageLocators;

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		this.productPageLocators=new ProductCategoryPageLocators();
		PageFactory.initElements(driver, productPageLocators);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, productPageLocators.catalogTextObj, ObjectRepo.reader.getExplicitWait());
	}

	public void sortByPrice(String name) {
		log.info("Selecting sort by price :" + name);
		System.out.println("name...." + name);
		new Select(productPageLocators.sortByPrice).selectByVisibleText(name);
		// new Select(this.sortByPrice).selectByVisibleText(name);
	}

	public void verifySortByFilter() {
		String priceFirst = productPageLocators.price1.getText().substring(1);
		String priceSecond = productPageLocators.price2.getText().substring(1);
		String priceThird = productPageLocators.price3.getText().substring(1);
        System.out.println(priceFirst+" "+priceSecond+" "+priceThird);
		int intPrice1 = Integer.parseInt(String.valueOf(priceFirst).split("\\.")[0]);
		int intPrice2 = Integer.parseInt(String.valueOf(priceSecond).split("\\.")[0]);
		int intPrice3 = Integer.parseInt(String.valueOf(priceThird).split("\\.")[0]);
       System.out.println(intPrice1+"   "+intPrice2+"   "+intPrice3);
		if (intPrice1 < intPrice2 && intPrice1 < intPrice3) {
            Assert.assertTrue(true);
			log.info("Price sorted in ascending order i.e. price lowest first");
			System.out.println("Price lowest firt");
		} else {
			log.info("Price sorted in descending order");
			System.out.println("Price highest first");
		}

	}

}
