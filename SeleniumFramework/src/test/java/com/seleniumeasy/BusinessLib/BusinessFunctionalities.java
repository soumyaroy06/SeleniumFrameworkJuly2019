package com.seleniumeasy.BusinessLib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.seleniumeasy.ObjectRepository.DemoPageElements;
import com.seleniumeasy.ObjectRepository.HomePageElements;
import com.seleniumeasy.ObjectRepository.SubmitFormPageElements;

public class BusinessFunctionalities {
	WebDriver driver;
	HomePageElements homePageElement;
	DemoPageElements demoPageElement;
	SubmitFormPageElements submitFormPageElement;
	public BusinessFunctionalities(WebDriver driver)
	{
		this.driver=driver;
	}
	private void initPages()
	{
		homePageElement = PageFactory.initElements(driver, HomePageElements.class);
		demoPageElement = PageFactory.initElements(driver, DemoPageElements.class);
		submitFormPageElement = PageFactory.initElements(driver, SubmitFormPageElements.class);
	}

	public void submitFormFlow(String scenario, String firstName, String lastName, String email, String state) 
	{
		initPages();
		// Home Page Element
		homePageElement.getDemoSiteLink().click();

		// Demo Page Elements 
		demoPageElement.getInputFormLabel().click();
		demoPageElement.getInputFormSubmitLink().click();

		// Submit Form Page Elements
		submitFormPageElement.getFirstNameField().sendKeys(firstName);
		submitFormPageElement.getLastNameField().sendKeys(lastName);
		submitFormPageElement.getEmailField().sendKeys(email);
		Select sel = new Select(submitFormPageElement.getStateDropdown());
		sel.selectByVisibleText(state);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", submitFormPageElement.getYesRadioBtn());
		submitFormPageElement.getYesRadioBtn().click();
	}

}
