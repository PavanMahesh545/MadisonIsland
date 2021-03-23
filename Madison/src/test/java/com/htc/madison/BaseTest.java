package com.htc.madison;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.htc.madison.pages.BasePage;
import com.htc.madison.pages.CheckOutPage;
import com.htc.madison.pages.DashBoardPage;
import com.htc.madison.pages.IndexPage;
import com.htc.madison.pages.LoginPage;
import com.htc.madison.pages.OrderPlacedPage;
import com.htc.madison.pages.ProductPage;
import com.htc.madison.pages.RegistrationPage;
import com.htc.madison.pages.ShoppingCartPage;
import com.htc.madison.utility.ScreenShot;


public class BaseTest {

	public Properties prop;
   protected WebDriver driver;
	protected IndexPage indexPage;
	protected RegistrationPage registrationPage;
	protected LoginPage loginPage;
	protected DashBoardPage dashBoardPage;
	protected ProductPage productPage;
	protected ShoppingCartPage addToCartPage;
	protected CheckOutPage checkOutPage;
	protected OrderPlacedPage orderPlacedPage;
	protected ScreenShot utils;
	protected BasePage basePage;
	
//	@BeforeSuite
	public Properties loadProperties() {
		prop = new Properties();
		FileInputStream fis;
		try {
			
			fis = new FileInputStream("C:\\Users\\myi35000\\git\\MadisonIsland\\Madison\\src\\test\\resources\\props.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void setUp() {

		loadProperties();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		indexPage = new IndexPage(driver);
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
		productPage = new ProductPage(driver);
		addToCartPage = new ShoppingCartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		orderPlacedPage = new OrderPlacedPage(driver);
		utils = new ScreenShot(driver);
		basePage = new BasePage(driver);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
		
}
