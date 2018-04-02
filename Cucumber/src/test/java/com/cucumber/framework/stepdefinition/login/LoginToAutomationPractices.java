package com.cucumber.framework.stepdefinition.login;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.cucumber.framework.PageObject.LoginPage;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToAutomationPractices {
	private final Logger log = LoggerHelper.getLogger(LoginToAutomationPractices.class);

	LoginPage loginpage;

	@Given("^navigate to application$")
	public void navigate_to_application() throws Throwable {
		TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@When("^user click on sign in link$")
	public void user_click_on_sign_in_link() throws Throwable {
		loginpage = new LoginPage(TestBase.driver);
		loginpage.clickOnSignInLink();
	}

	@When("^enter incorrect email address \"([^\"]*)\"$")
	public void enter_incorrect_email_address(String arg1) {

		loginpage.enterEmailAddress(arg1);
		loginpage.clickOnCreateAnAccount();
	}

	@Then("^appropriate error message should display \"([^\"]*)\"$")
	public void appropriate_error_message_should_display(String arg1) {
		loginpage.verifyInvalidEmail(arg1);
	}

	@When("^enter correct email address as \"([^\"]*)\"$")
	public void enter_email_address_as(String email) throws Throwable {

		log.info("Email address is entered in textbox");
		loginpage.enterEmailAddress(email);
	}

	@When("^click on create an account$")
	public void click_on_create_an_account() throws Throwable {
		loginpage.clickOnCreateAnAccount();
		log.info("Clicked on create account link successfully");
	}

}
