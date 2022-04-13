package com.qa.OpenCart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenCart.Util.Constants;
import com.qa.OpenCart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accountsPageTitleTest() {
		String actAccountPageTitle = accPage.getAccountPageTitle();
		System.out.println("Acc page title : " + actAccountPageTitle);
		Assert.assertEquals(actAccountPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test
	public void accSectionsTest() {
		List<String> actSecList = accPage.getAccountPageSectionList();
		System.out.println("Accounts Sections list = " + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}

	@Test
	public void searchHeaderTest() {
		searchResultsPage = accPage.dosearch("Macbook");
		String actSearchHeader = searchResultsPage.getResultsPageHeaderValue();
		Assert.assertTrue(actSearchHeader.contains("Macbook"));
	}

	@Test
	public void searchProductCountTest() {
		searchResultsPage = accPage.dosearch("iMac");
		int actProductCount = searchResultsPage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constants.IMAC_PRODUCT_COUNT);
	}

	@Test
	public void getsearchProductListTest() {
		searchResultsPage = accPage.dosearch("iMac");
		List<String> actProductList = searchResultsPage.getProductResultsList();
		System.out.println(actProductList);
	}

}