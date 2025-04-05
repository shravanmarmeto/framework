package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.listenerImplementation;
import genericUtility.webdriverUtility;

public class plp {

	public plp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "collection-title")
	private WebElement title;
	// sort
	@FindBy(xpath = "//div[@class='collection-toolbar__button-container']")
	private WebElement sortButton;
	@FindBy(xpath = "//span[@class='reversed-link']")
	private List<WebElement> sortOptions;
	@FindBy(xpath = "(//label[@class=\"input-prefix text-sm\"])[4]")
	private WebElement lastPrice;
	@FindBy(xpath = "(//label[@class=\"input-prefix text-sm\"])[3]")
	private WebElement firstPrice;
	// filter
	@FindBy(xpath = "//button[@class='collection-filter__button heading text-xxs w-full filter-button']")
	private WebElement filterButton;
	@FindBy(xpath = "//label[@for='facets-sidebar-filter.v.availability']")
	private WebElement inStockButton;
	@FindBy(xpath = "//span[@class='color-swatch-name']")
	private List<WebElement> colorButton;
	@FindBy(xpath = "//span[@class='color-swatch-name']/ancestor::div[@class='facets-options-conatiner']//input[@class='sr-only filters-input-element']")
	private List<WebElement> checkbox;
	@FindBy(xpath = "(//input[@value='Black'])[2]")
	private WebElement blackColor;
	public WebElement getBlackColor() {
		return blackColor;
	}

	public List<WebElement> getCheckbox() {
		return checkbox;
	}

	public WebElement getColorHeading() {
		return colorHeading;
	}

	@FindBy(xpath = "(//span[text()='Color'])[2]")
	private WebElement colorHeading;
	@FindBy(xpath = "(//input[@aria-label='To price'])[4]")
	private WebElement toPrice;
	@FindBy(xpath = "(//input[@aria-label='from price'])[4]")
	private WebElement fromPrice;
	@FindBy(xpath = "//a[@class='product-title h6 ']")
	private List<WebElement> productTitle;
	
	

	

	public WebElement getLastPrice() {
		return lastPrice;
	}

	public WebElement getFirstPrice() {
		return firstPrice;
	}

	public WebElement getSortButton() {
		return sortButton;
	}

	public List<WebElement> getSortOptions() {
		return sortOptions;
	}

	public WebElement getFilterButton() {
		return filterButton;
	}

	public WebElement getInStockButton() {
		return inStockButton;
	}

	public List<WebElement> getColorButton() {
		return colorButton;
	}

	public WebElement getToPrice() {
		return toPrice;
	}

	public WebElement getFromPrice() {
		return fromPrice;
	}

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	public WebElement getTitle() {
		return title;
	}

}
