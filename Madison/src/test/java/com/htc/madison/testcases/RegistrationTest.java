package com.htc.madison.testcases;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.htc.madison.BaseTest;


public class RegistrationTest extends BaseTest {
		
	@Test(dataProvider = "Data", dataProviderClass = com.htc.madison.utility.DataProviderManager.class)
	
	public void registrationTest(Map<String, String> mapData) {
		
		System.out.println("Registration Page Test");
	
		indexPage.navigateToRegisterPage();
		registrationPage.createNewAccount( mapData.get("FirstName"), mapData.get("LastName"), mapData.get("Email"), 
										   mapData.get("Password"),  mapData.get("ConfirmPassword"));
		Assert.assertEquals(registrationPage.getWelcomeMessage(), "Thank you for registering with Madison Island.");
		basePage.signOff();
	}

}





















//indexPage.signOff();
//indexPage.isLogin();
