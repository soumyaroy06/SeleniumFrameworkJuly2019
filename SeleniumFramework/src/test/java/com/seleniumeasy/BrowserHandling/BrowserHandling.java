package com.seleniumeasy.BrowserHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserHandling {
	
	public WebDriver driver;
	@BeforeTest
	public void browserLaunch()
	{
		//Browser Handling
		String chromePath = System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/");
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		//Browser Close
		Thread.sleep(3000);
		driver.close();
	}

}
