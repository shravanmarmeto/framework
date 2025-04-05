package com.ecommerce.miraggio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.baseClass;
import genericUtility.propertyFileUtility;
import pomScripts.cart;
import pomScripts.homepage;
import pomScripts.pdp;
import pomScripts.plp;

public class cartTest extends baseClass {

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
	}

	@Test(priority = 2)
	// 3: Verify the ATC button
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
	}

	@Test(priority = 3)
	// 4: Verify the quantity selector and remove the product from cart
	public void quantitySelector() throws InterruptedException {
		cart c = new cart(driver);
		Thread.sleep(2000);
		c.getQuantityIncrease().click();
		c.getQuantityIncrease().click();
		Thread.sleep(2000);
		c.getQuantityDecrease().click();
		c.getRemoveButton().click();
		c.getMoveToWishlistButton().click();
		c.getRemovePopup().click();
		boolean cartEmpty = c.getCartEmptyText().isDisplayed();
		Assert.assertTrue(cartEmpty, "Cart is not empty");

	}

	@Test(priority = 4)
	// 5: Verify the continue shopping button
	public void continueShopping() throws InterruptedException {
		cart c = new cart(driver);
		c.getContinueShopping().click();
		plp p = new plp(driver);
		boolean plp = p.getTitle().isDisplayed();
		Assert.assertTrue(plp, "Unable to redirect to collection page");
		Thread.sleep(1000);
		driver.navigate().back();
	}

	@Test(priority = 5)
	// 6: Verify the place order button
	public void coupoTextFiedl() throws InterruptedException {
		pdp p = new pdp(driver);
		p.getAddToCartButton().click();
		cart c = new cart(driver);
		Thread.sleep(2000);
		toScrollToElement(c.getTextfield());
		c.getTextfield().sendKeys("Dummy");
		c.getCheckButton().click();
		Thread.sleep(2000);
		c.getPlaceOrderButton().click();
		boolean checkout = c.getGokwik().isDisplayed();
		Assert.assertTrue(checkout);
	}

}
