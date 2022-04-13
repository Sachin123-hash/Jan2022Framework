package com.qa.OpenCart.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.OpenCart.Util.Constants;
import com.qa.OpenCart.Util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	private By search = By.name("search");
	private By searchBtn = By.cssSelector("div#search button");
	private By header = By.cssSelector("div#logo a");
	private By accountssList = By.cssSelector("div#content h2");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}

	public boolean isAccountPageHeaderExist() {
		return eleutil.doIsDisplayed(header);
	}

	public boolean isSearchExist() {
		return eleutil.doIsDisplayed(search);
	}

	public SearchResultsPage dosearch(String productName) {

		if (isSearchExist()) {
			eleutil.doSendKeys(search, productName);
			eleutil.doClick(searchBtn);
			return new SearchResultsPage(driver);
		}
		return null;

		
	}

	public List<String> getAccountPageSectionList() {
		List<WebElement> secList = eleutil.getElements(accountssList);
		List<String> accSecvalList = new ArrayList<String>();
		for (WebElement e : secList) {
			String text = e.getText();
			accSecvalList.add(text);

		}
		return accSecvalList;

	}
}
