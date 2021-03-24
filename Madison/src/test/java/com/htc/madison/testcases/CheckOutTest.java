package com.htc.madison.testcases;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.htc.madison.BaseTest;


public class CheckOutTest extends BaseTest {
	
	
	@Test(dataProvider = "Data", dataProviderClass = com.htc.madison.utility.DataProviderManager.class)
	public void productPurchaseTest(Map<String, String> mapData) {
	   System.out.println("CheckOutPageTest");
		indexPage.navigateToLoginPage();
		loginPage.performLogin(mapData.get("email"), mapData.get("password"));
		dashBoardPage.selectCategory();
		productPage.enterProductDetails(utils, mapData.get("ShirtQuantity"));
		addToCartPage.clickProceedBtn();
		checkOutPage.checkOutForTheProduct(mapData.get("FirstName"), mapData.get("LastName"), mapData.get("Address"), mapData.get("City"),
										   mapData.get("PostalCode"), mapData.get("Country"), mapData.get("Telephone"));
	
		Assert.assertEquals(orderPlacedPage.getConfirmMessage(), "YOUR ORDER HAS BEEN RECEIVED.");
		basePage.signOff();
	}
}




















//indexPage.isLogin();
//indexPage.signOff();