package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pdp {

	public pdp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class=\"product-title h3\"]")
	private WebElement productTitle;
	@FindBy(xpath = "class=\"inventory-text\"")
	private WebElement availabiltyStatus;
	@FindBy(xpath = "//div[@class='variant-picker__option-values h-stack gap-2 wrap']/parent::div[@class='product-as-variant']//span[@class='product-as-variant-value']")
	private WebElement color;
	@FindBy(xpath = "//button[contains(@class,'product-as-variant-button thumbnail-swatch')]")
	private List<WebElement> colorSwatches;
	@FindBy(xpath = "(//button[@aria-label='Add to Wishlist'])[1]")
	private WebElement wishlistIcon;
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//span[text()='Description']")
	private WebElement description;
	@FindBy(xpath = "//h2[text()='Bestsellers']")
	private WebElement bestsellers;
	@FindBy(xpath = "(//button[@class='product-as-variant-button thumbnail-swatch '])[1]")
	private WebElement swatch2;
	@FindBy(xpath = "(//button[@class='product-as-variant-button thumbnail-swatch '])[2]")
	private WebElement swatch3;
	@FindBy(xpath = "(//button[@class='product-as-variant-button thumbnail-swatch '])[3]")
	private WebElement swatch4;
	@FindBy(xpath = "(//button[@class='product-as-variant-button thumbnail-swatch '])[4]")
	private WebElement swatch5;
	@FindBy(xpath = "(//button[@class='product-as-variant-button thumbnail-swatch '])[5]")
	private WebElement swatch6;

	public WebElement getSwatch2() {
		return swatch2;
	}

	public WebElement getSwatch3() {
		return swatch3;
	}

	public WebElement getSwatch4() {
		return swatch4;
	}

	public WebElement getSwatch5() {
		return swatch5;
	}

	public WebElement getSwatch6() {
		return swatch6;
	}

	public WebElement getAvailabiltyStatus() {
		return availabiltyStatus;
	}

	public WebElement getColor() {
		return color;
	}

	public List<WebElement> getColorSwatches() {
		return colorSwatches;
	}

	public WebElement getWishlistIcon() {
		return wishlistIcon;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getBestsellers() {
		return bestsellers;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

}
