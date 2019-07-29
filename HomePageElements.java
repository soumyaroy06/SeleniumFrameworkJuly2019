package com.seleniumeasy.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {
	@FindBy(xpath = "//a[contains(text(),'Demo Website!')]")
	private WebElement demoSiteLink;

	public WebElement getDemoSiteLink() {
		return demoSiteLink;
	}

}
