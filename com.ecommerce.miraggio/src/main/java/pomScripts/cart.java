package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webdriverUtility;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class cart {

	public cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='h6 line-item-heading']")
	private List<WebElement> productTitle;
	@FindBy(xpath = "//sale-price[@class='h6 text-subdued']")
	private WebElement productPrice;
	@FindBy(xpath = "//*[name()='svg' and @class='icon icon-quantity-plus']")
	private WebElement quantityIncrease;
	@FindBy(xpath = "//*[name()='svg' and @class='icon icon-quantity-minus']")
	private WebElement quantityDecrease;
	@FindBy(xpath = "//button[@class='line-item-remove-button']")
	private WebElement removeButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement textfield;
	@FindBy(xpath = "//input[@id='sc-discount__submit']")
	private WebElement checkButton;
	@FindBy(xpath = "//span[@class='money mw-price']")
	private WebElement totalPrice;
	@FindBy(xpath = "//span[text()='Place Order']")
	private WebElement placeOrderButton;
	@FindBy(xpath = "//input[@class='quantity-selector__input text-sm']")
	private WebElement quantity;
	@FindBy(xpath = "//a[@class='popup-button remove-button']")
	private WebElement removePopup;
	@FindBy(xpath = "//button[text()='Move to Wishlist']")
	private WebElement moveToWishlistButton;
	@FindBy(xpath = "//p[text()='Your cart is empty']")
	private WebElement cartEmptyText;
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement continueShopping;
	@FindBy(xpath = "//div[@class='gokwik-modal gokwik-modal-content']")
	private WebElement gokwik;

	public WebElement getGokwik() {
		return gokwik;
	}

	public WebElement getCartEmptyText() {
		return cartEmptyText;
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public WebElement getRemovePopup() {
		return removePopup;
	}

	public WebElement getMoveToWishlistButton() {
		return moveToWishlistButton;
	}

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getQuantityIncrease() {
		return quantityIncrease;
	}

	public WebElement getQuantityDecrease() {
		return quantityDecrease;
	}

	public WebElement getRemoveButton() {
		return removeButton;
	}

	public WebElement getTextfield() {
		return textfield;
	}

	public WebElement getCheckButton() {
		return checkButton;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}

	public WebElement getQuantity() {
		return quantity;
	}

}
