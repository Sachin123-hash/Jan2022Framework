package com.qa.OpenCart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.OpenCart.Util.Constants;
import com.qa.OpenCart.Util.ElementUtil;
import com.qa.OpenCart.Util.Errors;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	// 1.private by locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@value='Login']");
	private By forgotpwd = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 2.public page constr...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3.public page actions:

	@Step("getting login page title.....")
	public String getLoginPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

	@Step("getting login page URL.....")
	public String getLoginPageUrl() {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);

	}

	@Step("checking forgot passwrodlink.....")
	public boolean isForgotPwdLinkExist() {
		return eleutil.doIsDisplayed(forgotpwd);
	}

	@Step("login to application with username{0} and password{1}")
	public AccountsPage doLogin(String un, String pwd) {
		eleutil.waitForElementToBeVisible(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(login);
		return new AccountsPage(driver);
	}
	@Step("login to application with correct username {0} and password {1}")
	public boolean doInvalidLogin(String un, String pwd) {
		WebElement email_ele = eleutil.waitForElementToBeVisible(emailId, Constants.DEFAULT_TIME_OUT);
		email_ele.clear();
		email_ele.sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(login);
		String actualErrorMesg = eleutil.doElementGetText(loginErrorMessg);
		System.out.println(actualErrorMesg);
			if(actualErrorMesg.contains(Errors.LOGIN_PAGE_ERROR_MESSG)) {
				return true;
			}
			return false;
	}
	@Step("checking RegisterLink Exist or not.....")

	public boolean isRegisterLinkExist() {
		return eleutil.waitForElementToBeVisible(registerLink, Constants.DEFAULT_TIME_OUT).isDisplayed();
	}

	@Step("checking registration naviagtion .....")
	public RegstrationPage navigateToRegister() {
		if (isRegisterLinkExist()) {
			eleutil.doClick(registerLink);
			return new RegstrationPage(driver);
		}

		return null;
	}

}
