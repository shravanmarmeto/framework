package com.ecommerce.miraggio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.baseClass;
import pomScripts.cart;
import pomScripts.homepage;
import pomScripts.pdp;
import pomScripts.plp;

public class pdpTest extends baseClass {

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
		toScrollToElement(p.getBlackColor());
		p.getBlackColor().click();
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

	@Test(priority = 2, enabled = false)
	// 3: Verify whether the user is able to change the variant
	public void variant() throws InterruptedException {
		pdp p = new pdp(driver);
		List<WebElement> allColor = p.getColorSwatches();
		for (WebElement a : allColor) {
			a.click();

			Thread.sleep(1000);
			int i = 10;
			if (!(p.getColor().getText().equalsIgnoreCase("Black"))) {
				driver.findElement(By
						.xpath("(//button[contains(@class,'product-as-variant-button thumbnail-swatch ')])[" + i + "]"))
						.click();
				i++;
			}
			p.getAddToCartButton().click();

		}

	}

	@Test(priority = 3)
	// 4: Verify the ATC button
	public void addToCart() {
		pdp p = new pdp(driver);
		p.getAddToCartButton().click();
		cart c = new cart(driver);
		List<WebElement> allProduct = c.getProductTitle();
		for (WebElement a : allProduct) {
			if (a.getText().equalsIgnoreCase(product)) {
				String productTitle = a.getText();
				Assert.assertEquals(product, productTitle, "Improper product is added to cart");

			}
		}
		driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer']")).getShadowRoot()
				.findElement(By.cssSelector("[type='button']")).click();
	}

	@Test(priority = 4)
	// 5: Verfy the description
	public void description() throws InterruptedException {
		pdp p = new pdp(driver);
		toScrollToElement(p.getDescription());
		p.getDescription().click();
		Thread.sleep(1000);
		p.getDescription().click();
		boolean decription = p.getDescription().isDisplayed();
		Assert.assertTrue(decription);
	}

	@Test(priority = 5)
	// 6: Verify the bestsellers
	public void bestsellers() {
		pdp p = new pdp(driver);
		toScrollToElement(p.getBestsellers());
		boolean best = p.getBestsellers().isDisplayed();
		Assert.assertTrue(best);
	}

}
