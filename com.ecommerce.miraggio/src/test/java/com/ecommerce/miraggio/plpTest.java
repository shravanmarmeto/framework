package com.ecommerce.miraggio;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.baseClass;
import genericUtility.webdriverUtility;
import pomScripts.homepage;
import pomScripts.pdp;
import pomScripts.plp;

public class plpTest extends baseClass {

	@Test(priority = 0)
	// 1: Verify whethere user is able to naviagtion to PLP
	public void featuredCollection() throws InterruptedException {
		driver.get(url);
		homepage h = new homepage(driver);
		plp p = new plp(driver);
		toMouseHover(driver, h.getFeaturedCollection());
		List<WebElement> a = h.getMegamenuDropdown();
		String option = "CAPSULE COLLECTION";
		for (WebElement b : a) {
			if (b.getText().equalsIgnoreCase(option)) {
				b.click();
				break;
			}
		}
		toScrollToElement(p.getTitle());
		String expectedTitle = p.getTitle().getText();
		Assert.assertEquals(option, expectedTitle, "Incorrect Collection");
	}

	@Test(priority = 1)
	// 2: Verify sort options
	public void sort() throws InterruptedException {
		plp p = new plp(driver);
		p.getSortButton().click();

		List<WebElement> allOptions = p.getSortOptions();
		String option = "Price, low to high";
		for (WebElement a : allOptions) {
			if (a.getText().equalsIgnoreCase(option)) {
				a.click();
				break;
			}
		}
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	// 3: Apply filters
	public void filter() throws InterruptedException {
		plp p = new plp(driver);
		p.getFilterButton().click();
		Thread.sleep(1000);
		p.getInStockButton().click();
		Thread.sleep(1000);
		toScrollToElement(p.getBlackColor());
		p.getBlackColor().click();
		//toScrollToElement(p.getLastPrice());
		p.getFirstPrice().sendKeys("1000");
		p.getLastPrice().sendKeys("4000");
		Thread.sleep(1000);
		toScrollToElement(p.getInStockButton());
		String product = "MOLLY MICRO BAG";
		try {
		List<WebElement> allProduct = p.getProductTitle();
		for (WebElement x : allProduct) {
			if (x.getText().equalsIgnoreCase(product)) {
				Thread.sleep(1000);
				x.click();
			}
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
		pdp pdp=new pdp(driver);
		String actualTitle=pdp.getProductTitle().getText();
		Assert.assertEquals(product, actualTitle, "Title not matching");
		//driver.navigate().back();
	}
}
