package com.ecommerce.miraggio;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.baseClass;
import genericUtility.webdriverUtility;
import pomScripts.homepage;
import pomScripts.pdp;
import pomScripts.plp;

public class homepageTest extends baseClass {

	@Test(priority = 0)
	// 1: Verify the logo
	public void logo() {
		driver.get(url);
		homepage h = new homepage(driver);
		boolean logo = h.getLogoHomepage().isDisplayed();
		Assert.assertTrue(logo, "Logo is missing");
	}

	@Test(priority = 1)
	// 2: Verify the megamenu redirection
	public void newarrivals() {
		homepage h = new homepage(driver);
		plp p = new plp(driver);
		h.getNewArrivals().click();
		String title = p.getTitle().getText();
		String expTitle = "NEW ARRIVALS";
		Assert.assertEquals(title, expTitle, "Incorrect tile is displayed");
	}

	@Test(priority = 2)
	// 3: Verify the megamnu drop down redirection
	public void shopByCatogory() throws InterruptedException {
		homepage h = new homepage(driver);
		plp p = new plp(driver);
		driver.navigate().back();
		toMouseHover(driver, h.getShopByCatagory());
		List<WebElement> a = h.getMegamenuDropdown();
		String option = "LAPTOP BAGS";
		for (WebElement b : a) {
			if (b.getText().equalsIgnoreCase(option)) {
				b.click();
				break;
			}
		}
		toScrollToElement(p.getTitle());
		String expectedTitle = p.getTitle().getText();
		Assert.assertEquals(option, expectedTitle, "Incorrect Collection");
		driver.navigate().back();

	}

	@Test(priority = 3)
	// 4: Verify the search iocn
	public void serachIcon() throws InterruptedException {
		homepage h = new homepage(driver);
		h.getSearchIcon().click();
		boolean search = h.getSearchField().isDisplayed();
		Assert.assertTrue(search);
		Thread.sleep(1000);
		h.getCloseSearchField().click();
	}

	@Test(priority = 4)
	// 5: Verify account icon
	public void accountIcon() throws InterruptedException {
		Thread.sleep(1000);
		homepage h = new homepage(driver);
		h.getAccountIcon().click();
		String actualUrl = toGetCurrentUrl(driver);
		String expectedUrl = "https://miraggiolife.com/account/login";
		Assert.assertEquals(actualUrl, expectedUrl, "Incorrect Url is displayed");
		driver.navigate().back();
	}

	@Test(priority = 5)
	// 6: Verify wishlist icon
	public void wishlistIcon() throws InterruptedException {
		Thread.sleep(1000);
		homepage h = new homepage(driver);
		h.getWishlistIcon().click();
		boolean wishlist = h.getWishlistPopup().isDisplayed();
		Assert.assertTrue(wishlist);
		h.getCloseWeishlistPopup().click();
	}

	@Test(priority = 6)
	// 7: Verify cart icon
	public void cartIcon() throws InterruptedException {
		Thread.sleep(1000);
		homepage h = new homepage(driver);
		h.getCartIcon().click();
		// shadowroot
		boolean cart = driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer']")).getShadowRoot()
				.findElement(By.cssSelector("[part='header']")).isDisplayed();
		Assert.assertTrue(cart, "Cart drawer fails to open");
		driver.findElement(By.xpath("//cart-drawer[@id='cart-drawer']")).getShadowRoot()
				.findElement(By.cssSelector("[type='button']")).click();
	}

	@Test(priority = 7)
	// 8: Verify Hero banner
	public void heroBanner() throws InterruptedException {

		homepage h = new homepage(driver);
		h.getHerobannerSlider3().click();
		Thread.sleep(1000);
		h.getHerBanner().click();
		boolean page = h.getBreadcrumb().isDisplayed();
		Assert.assertTrue(page);
		driver.navigate().back();
	}

	@Test(priority = 8)
	// 9: Verify the section with product cards
	public void productcard() throws InterruptedException {
		homepage h = new homepage(driver);
		toScrollToElement(h.getBestSellers1());
		h.getNewArrivals1().click();
		toScrollToElement(h.getSection2slider2());
		// h.getRightNavigationButton().click();
		List<WebElement> allTitle = h.getProductTitle();
		String title = "MILO CLUTCH";
		Thread.sleep(1000);

		for (WebElement a : allTitle) {
			if (a.getText().equalsIgnoreCase(title)) {
				a.click();
				break;
			}
		}
		pdp p = new pdp(driver);
		String actualTitle = p.getProductTitle().getText();
		Assert.assertEquals(title, actualTitle, "Title not matching");
		Thread.sleep(1000);
		driver.navigate().back();
	}

	@Test(priority = 9)
	// 10: Verify shop by style
	public void shopByStyle() throws InterruptedException {
		Thread.sleep(1000);
		homepage h = new homepage(driver);
		toScrollToElement(h.getShopByStyleHeading());
		// shop by style to click on main options
		List<WebElement> allOptions = h.getShopByStyleMainOptions();
		String title = "TOTE BAGS";
		for (WebElement a : allOptions) {
			if (a.getText().equalsIgnoreCase(title)) {
				a.click();
				break;
			}
		}
		Thread.sleep(1000);
		// to select product
		List<WebElement> allTitle = h.getProductTitle();
		String productTitle = "MIRANDA TOTE BAG";
		for (WebElement a : allTitle) {
			if (a.getText().equalsIgnoreCase(productTitle)) {
				a.click();
				break;
			}
		}
		Thread.sleep(1000);
		pdp p = new pdp(driver);
		String actualTitle = p.getProductTitle().getText();
		Assert.assertEquals(productTitle, actualTitle, "Title not matching");
	}

	@Test(priority = 10)
	// 11: Verify ChooseYourStyle section
	public void chooseYourStyle() throws InterruptedException {
		driver.navigate().back();
		driver.navigate().refresh();
		homepage h = new homepage(driver);
		pdp p = new pdp(driver);
		toScrollToElement(h.getChooseYourStyleHeading());
		boolean heading = h.getChooseYourStyleHeading().isDisplayed();
		Assert.assertTrue(heading);

	}

	@Test(priority = 11)
	// 12: Verify footer redirections - shop
	public void shopFooter() {
		homepage h = new homepage(driver);
		toScrollToElement(h.getShopFooter());
		h.getUnder1999().click();
		plp p = new plp(driver);
		boolean title = p.getTitle().isDisplayed();
		Assert.assertTrue(title);
		driver.navigate().back();
	}

	@Test(priority = 12)
	// 13: Verify footer redirections - customercare
	public void customerCare() {
		homepage h = new homepage(driver);
		toScrollToElement(h.getCustomerCareFooter());
		h.getPrivacyPolicy().click();
		String expecetdUrl = "https://miraggiolife.com/policies/privacy-policy";
		String actualUrl = toGetCurrentUrl(driver);
		assertEquals(expecetdUrl, actualUrl, "Webpage fails to redirect to relevant page");
		driver.navigate().back();
	}

	@Test(priority = 13)
	// 14: Verify footer redirections - knowus
	public void knowUs() {
		homepage h = new homepage(driver);
		toScrollToElement(h.getKnowUsFooter());
		h.getAboutUs().click();
		String expecetdUrl = "https://miraggiolife.com/pages/about-us";
		String actualUrl = toGetCurrentUrl(driver);
		assertEquals(expecetdUrl, actualUrl, "Webpage fails to redirect to relevant page");
		driver.navigate().back();

	}

	@Test(priority = 14)
	// 15: Verify footer redirections - Newsletter
	public void newsLetter() throws InterruptedException, Exception {
		homepage h = new homepage(driver);
		toScrollToElement(h.getNewsLetterFooter());
		int a = toGetRandomNumber();
		String email = "tester" + a + "@gmail.com";
		h.getNewsLetterTextfield().sendKeys(email);
//		h.getSubscribeButton().click();
//		Robot r = new Robot();
//		r.delay(1000);
//		r.keyPress(KeyEvent.VK_ESCAPE);
//		r.keyRelease(KeyEvent.VK_ESCAPE);
//		boolean message = h.getNewsLetterSuccessMessage().isDisplayed();
//		Assert.assertTrue(message);
//		Cant automate because of chrome captcha verification
		

	}

	@Test(priority = 15)
	// 16: Verify footer redirections - social icons
	public void social() throws InterruptedException {
		homepage h = new homepage(driver);
		toScrollToElement(h.getFacebookIcon());
		h.getFacebookIcon().click();
		Set<String> allWindows = tohandleMultipleWindows(driver);
		String parentWindow = tohandleWindows(driver);
		for (String id : allWindows) {
			if (!(parentWindow.equals(id))) {
				driver.switchTo().window(id);
			}
		}
		String actual = driver.getCurrentUrl();
		String expected = "https://www.facebook.com/miraggiolife";
		Assert.assertEquals(actual, expected, "URL not matching");
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);
	}
}
