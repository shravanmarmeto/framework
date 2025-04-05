package com.ecommerce.miraggio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.baseClass;
import pomScripts.homepage;
import pomScripts.pdp;
import pomScripts.plp;

public class pdpVariantSwitching extends baseClass {

	String product = "EDNA HANDBAG";

	@Test(priority = 0)
	// 1: Verify whether the user is able to navigate to PLP from HP
	public void shopByCatogory() throws InterruptedException {
		driver.get(url);
		homepage h = new homepage(driver);
		plp p = new plp(driver);
		toMouseHover(driver, h.getShopByCatagory());
		List<WebElement> a = h.getMegamenuDropdown();
		String option = "HANDBAGS";
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
	// 2: Verify whether the user is able to navigate to PDP from PLP
	public void plp() throws InterruptedException {
		plp p = new plp(driver);
		p.getFilterButton().click();
		Thread.sleep(1000);
		// toScrollToElement(p.getBlackColor());
		// p.getBlackColor().click();
		Thread.sleep(1000);

		try {
			List<WebElement> allProduct = p.getProductTitle();
			for (WebElement x : allProduct) {
				if (x.getText().equalsIgnoreCase(product)) {
					Thread.sleep(1000);
					x.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pdp pdp = new pdp(driver);
		String actualTitle = pdp.getProductTitle().getText();
		Assert.assertEquals(product, actualTitle, "Title not matching");
		// driver.navigate().back();
	}

	@Test(priority = 2)
	// 3: Verify whether the user is able to change the variant
	public void variant() throws InterruptedException {
		pdp p = new pdp(driver);
		String targetColor = "Wine";
		List<WebElement> allColor = p.getColorSwatches();
		for (int i = 0; i < allColor.size(); i++) {
			allColor = p.getColorSwatches();

			WebElement ele = allColor.get(i);
			ele.click();

			String color = p.getColor().getText();
			if (color.contains(targetColor)) {
				p.getAddToCartButton().click();
				break;
			}
		}
	}
}
