package com.qa.OpenCart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenCart.Util.Constants;
import com.qa.OpenCart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

@Epic("Eoic 100-Desgin login page for open cart application")
@Story("US 101--desgin login page features")

public class LoginPageTest extends BaseTest {

	@Test
	@Description("loginPageTitleTest")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title:" + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	@Description("loginPageUrlTest")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("login page url:" + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test
	@Description("forgotPwdLinkTest")
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());

	}

	@Test
	@Description("login Test with correct username and correct password...")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {

		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}

	@Test
	@Description("isRegiterLinkExist")
	@Severity(SeverityLevel.CRITICAL)
	public void isRegiterLinkExist() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
}
