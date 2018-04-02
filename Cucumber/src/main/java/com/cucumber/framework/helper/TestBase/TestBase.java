package com.cucumber.framework.helper.TestBase;

import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.configuration.browser.ChromeBrowser;
import com.cucumber.framework.configuration.browser.FirefoxBrowser;
import com.cucumber.framework.helper.Logger.LoggerHelper;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	
	public static WebDriver driver;

	public void waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementNotFoundException.class);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.until(elementLocated(element));
	}

	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				log.debug("Waiting for Element : " + element);
				return element.isDisplayed();
			}
		};
	}



	public WebElement getElementWithNull(By locator) {
		log.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}



	public WebDriver getBrowserObject(BrowserType bType) throws Exception {
		try {
			log.info(bType);

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}
		} catch (Exception e) {
			log.equals(e);
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType bType) throws Exception {
		
		driver = getBrowserObject(bType);
		log.debug("InitializeWebDrive : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Before()
	public void before() throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		setUpDriver(ObjectRepo.reader.getBrowser());
		log.info(ObjectRepo.reader.getBrowser());
	}

	@After()
	public void after(Scenario scenario) throws Exception {
		log.info("driver closed");
		driver.quit();
		
	}
}
