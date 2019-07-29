package com.seleniumeasy.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPageElements {
	@FindBy(xpath="//li[@class='dropdown']/a[contains(text(),'Input Forms')]")
	private WebElement inputFormLabel;
	@FindBy(xpath="//ul[@class='dropdown-menu']//a[contains(text(),'Input Form Submit')]")
	private WebElement inputFormSubmitLink;
	public WebElement getInputFormLabel() {
		return inputFormLabel;
	}
	public WebElement getInputFormSubmitLink() {
		return inputFormSubmitLink;
	}
	

}
