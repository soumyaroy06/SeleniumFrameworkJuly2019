package com.seleniumeasy.RunnerClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seleniumeasy.BrowserHandling.BrowserHandling;
import com.seleniumeasy.BusinessLib.BusinessFunctionalities;
import com.seleniumeasy.DataCollection.DataCollections;

public class DriverScript extends BrowserHandling
{
	BusinessFunctionalities business;
	@BeforeClass
	public void initObject()
	{
		business = new BusinessFunctionalities(driver);
	}
	
	@Test(dataProvider="DataCollection_SubmitForm", dataProviderClass = DataCollections.class)
	public void submitFormTest(String scenario, String firstName, String lastName, String email, String state) throws InterruptedException
	{
		//Browser Launching code moved to Browser Handling class
		//Business Logic moved to Business Functionalities class
		System.out.println(scenario+"\t"+firstName+"\t"+lastName+"\t"+email+"\t"+state);
		business.submitFormFlow(scenario, firstName, lastName, email, state);
		
		//Browser Closing code moved to Browser Handling class
	}
}