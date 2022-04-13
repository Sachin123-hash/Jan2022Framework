package com.qa.OpenCart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.OpenCart.Factory.DriverFactory;
import com.qa.OpenCart.Pages.AccountsPage;
import com.qa.OpenCart.Pages.LoginPage;
import com.qa.OpenCart.Pages.ProductInfoPage;
import com.qa.OpenCart.Pages.RegstrationPage;
import com.qa.OpenCart.Pages.SearchResultsPage;

public class BaseTest {
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountsPage accPage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage  productInfoPage; 
	public RegstrationPage registrationPage;

	public SoftAssert softAssert;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
