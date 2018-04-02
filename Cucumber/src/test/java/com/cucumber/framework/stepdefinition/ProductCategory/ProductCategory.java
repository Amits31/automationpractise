package com.cucumber.framework.stepdefinition.ProductCategory;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.framework.PageObject.HomePage;
import com.cucumber.framework.PageObject.ProductCategoryPage;
import com.cucumber.framework.PageObjectLocators.HomePageLocators;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductCategory {
	private final Logger log = LoggerHelper.getLogger(ProductCategory.class);
	HomePage homepage;
	ProductCategoryPage productCategoryPage;
	HomePageLocators homeLocators;
	
	@Given("^navigate to application page$")
	public void navigate_to_application() throws Throwable {
		TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}
	
	@When("^user click on dress navigation menu$")
	public void user_click_on_dress_navigation_menu() throws Throwable {
	   homepage = new HomePage(TestBase.driver);
	   homeLocators=new HomePageLocators();
	   log.info("clicking on dress menu");
	   homepage.clickOnMenu();
	}

	@When("^click on sort by price lowest first filter \"([^\"]*)\"$")
	public void click_on_sort_by_price_lowest_first_filter(String arg1) throws Throwable {
		System.out.println("arg1");
		productCategoryPage=new ProductCategoryPage(TestBase.driver);
		productCategoryPage.sortByPrice(arg1);
		//homepage.clickon();
		
		}
	
	@Then("^verify product is filtered according to price$")
	public void verify_product_is_filtered_according_to_price() throws Throwable {
		productCategoryPage.verifySortByFilter();
		log.info("Verify sort by price successfully");
	}

	

}
