package com.qa.OpenCart.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.OpenCart.Util.Constants;
import com.qa.OpenCart.Util.ElementUtil;

public class SearchResultsPage {

	
	private ElementUtil eleutil;
	private WebDriver driver;
	private By seacrhHeader = By.cssSelector("div#content h1");
	private By products = By.cssSelector("div.caption a");

	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		eleutil = new ElementUtil(driver);
	}

	public String getResultsPageHeaderValue() {
		if (eleutil.doIsDisplayed(seacrhHeader)) {
			return eleutil.doElementGetText(seacrhHeader);
		}
		return null;
	}
	
	public int getProductSearchCount() {
		return eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT).size();
	}

	public List<String> getProductResultsList() {
		List<WebElement> productList = eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT);
		List<String> productValList = new ArrayList<String>();

		for (WebElement e : productList) {
			String text = e.getText();
			productValList.add(text);
		}

		return productValList;

	}
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("main product name"+mainProductName);
		List<WebElement> productList = eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT);
		for(WebElement e:productList) {
			String text=e.getText();
			if(text.equals(mainProductName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}

}
