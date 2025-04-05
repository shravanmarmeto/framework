package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webdriverUtility;

public class homepage {

	public homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='header__logo-image header__logo-image--transparent']")
	private WebElement logoHomepage;
	@FindBy(xpath = "//li[@data-title='New Arrivals']")
	private WebElement newArrivals;
	@FindBy(xpath = "//li[@data-title='Shop by Category']")
	private WebElement shopByCatagory;
	@FindBy(xpath = "//summary[text()='Featured Collection']")
	private WebElement featuredCollection;
	@FindBy(xpath = "//li[@class='header__search-link sm-max:hidden']")
	private WebElement searchIcon;
	@FindBy(xpath = "//li[@class='header__account-link sm-max:hidden']")
	private WebElement accountIcon;
	@FindBy(xpath = "//li[@class='header__wishlist']")
	private WebElement wishlistIcon;
	@FindBy(xpath = "//li[@class='relative header__cart-link']")
	private WebElement cartIcon;
	@FindBy(xpath = "(//span[text()='Go to item 3']//parent::button[@class='tap-area'])[1]")
	private WebElement herobannerSlider3;
	@FindBy(xpath = "(//span[text()='Go to item 2']//parent::button[@class='tap-area'])[1]")
	private WebElement herobannerSlider2;
	@FindBy(xpath = "(//span[text()='Go to item 1']//parent::button[@class='tap-area'])[1]")
	private WebElement herobannerSlider1;
	@FindBy(className = "slideshow")
	private WebElement herBanner;
	@FindBy(xpath = "//button[text()='Bestsellers']")
	private WebElement bestSellers1;
	@FindBy(xpath = "//button[text()='New Arrivals']")
	private WebElement newArrivals1;
	@FindBy(xpath = "//a[text()='View all']")
	private WebElement viewAll;
	@FindBy(xpath = "//button[@class='prev-next-button prev-next-button--prev circle-button hover:animate-icon-inline']")
	private WebElement leftNavigationButton;
	@FindBy(xpath = "//button[@class='prev-next-button prev-next-button--next circle-button hover:animate-icon-inline']")
	private WebElement rightNavigationButton;
	@FindBy(xpath = "//a[@class='link-faded-reverse submenu-list-item']")
	private List<WebElement> megamenuDropdown;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	@FindBy(xpath = "//div[@class='header-search__form-control']//button")
	private WebElement closeSearchField;
	@FindBy(xpath = "//h2[@id='swym-modal-wishlist-title']")
	private WebElement wishlistPopup;
	@FindBy(xpath = "//button[@class='swym-close-btn swym-bg-1 swym-is-button']")
	private WebElement closeWeishlistPopup;
	@FindBy(css = "[class='h4 heading']")
	private WebElement cartDrawerHeading;
	@FindBy(xpath = "//cart-drawer[@id='cart-drawer']")
	private WebElement cartMainShadow;
	@FindBy(css = "[type='button']")
	private WebElement cartCLosButton;
	@FindBy(xpath = "//a[@title='Home']")
	private WebElement breadcrumb;
	@FindBy(xpath = "//a[@class='product-title h6 ']")
	private List<WebElement> productTitle;
	@FindBy(xpath = "(//span[text()='Go to item 1']//parent::button[@class='tap-area'])[2]")
	private WebElement section2slider1;
	@FindBy(xpath = "(//span[text()='Go to item 2']//parent::button[@class='tap-area'])[2]")
	private WebElement section2slider2;
	@FindBy(xpath = "(//span[text()='Go to item 3']//parent::button[@class='tap-area'])[2]")
	private WebElement section2slider3;
	@FindBy(xpath = "//div[@class='product-card__figure']")
	private WebElement prodcutImage;
	// shopByStyle
	@FindBy(xpath = "//p[text()='SHOP BY STYLE']")
	private WebElement shopByStyleHeading;
	@FindBy(xpath = "//button[@class='h2 featured-collection__tabs mobile-font-medium desktop-font-small']")
	private List<WebElement> shopByStyleMainOptions;

	@FindBy(xpath = "(//a[text()='View all'])[7]")
	private WebElement viewAll2;
	// videp section
	@FindBy(xpath = "//p[text()='TAKE A CLOSER LOOK']")
	private WebElement videoSectionHeading;
	@FindBy(xpath = "//video[@class='whatmore-video-player-muted']")
	private WebElement videoSection;
	@FindBy(xpath = "//p[@class='chakra-text whatmore-css-sv-31cg5y']")
	private WebElement shopNowButton;
	@FindBy(xpath = "//div[@class=\"whatmore-shopping-close-button\"]")
	private WebElement closeButton;
	//Choose your style section
	@FindBy(xpath = "//h2[text()=\"CHOOSE YOUR Style\"]")
	private WebElement chooseYourStyleHeading;
	@FindBy(xpath = "//p[@class='h6 sm:h5']")
	private List<WebElement> products;
	@FindBy(xpath = "//a[text()='Shop Now']")
	private WebElement shopNowButton1;
	//Footer
	@FindBy(xpath = "//p[text()='Shop']")
	private WebElement shopFooter;
	@FindBy(xpath = "(//a[text()='Under 1999'])[4]")
	private WebElement under1999;
	@FindBy(xpath = "//p[text()='Customer Care']")
	private WebElement customerCareFooter;
	@FindBy(xpath = "(//a[text()='Privacy Policy'])[2]")
	private WebElement privacyPolicy;
	@FindBy(xpath = "//p[text()='Know us']")
	private WebElement knowUsFooter;
	@FindBy(xpath = "(//a[text()='About Us'])[2]")
	private WebElement aboutUs;
	@FindBy(xpath = "//p[text()='Newsletter']")
	private WebElement newsLetterFooter;
	@FindBy(xpath = "//input[@class='input']")
	private WebElement newsLetterTextfield;
	@FindBy(xpath = "//button[text()='Subscribe']")
	private WebElement subscribeButton;
	@FindBy(xpath = "(//a[@aria-label='Follow on Facebook'])[2]")
	private WebElement facebookIcon;
	@FindBy(xpath = "//div[@class='banner banner--success text-start']")
	private WebElement newsLetterSuccessMessage;
	

	public WebElement getFeaturedCollection() {
		return featuredCollection;
	}

	public WebElement getNewsLetterSuccessMessage() {
		return newsLetterSuccessMessage;
	}

	public WebElement getShopFooter() {
		return shopFooter;
	}

	public WebElement getUnder1999() {
		return under1999;
	}

	public WebElement getCustomerCareFooter() {
		return customerCareFooter;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getKnowUsFooter() {
		return knowUsFooter;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public WebElement getNewsLetterFooter() {
		return newsLetterFooter;
	}

	public WebElement getNewsLetterTextfield() {
		return newsLetterTextfield;
	}

	public WebElement getSubscribeButton() {
		return subscribeButton;
	}

	public WebElement getFacebookIcon() {
		return facebookIcon;
	}

	public WebElement getChooseYourStyleHeading() {
		return chooseYourStyleHeading;
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public WebElement getShopNowButton1() {
		return shopNowButton1;
	}

	public WebElement getVideoSectionHeading() {
		return videoSectionHeading;
	}

	public WebElement getShopByStyleHeading() {
		return shopByStyleHeading;
	}

	public List<WebElement> getShopByStyleMainOptions() {
		return shopByStyleMainOptions;
	}

	public WebElement getViewAll2() {
		return viewAll2;
	}

	public WebElement getVideoSection() {
		return videoSection;
	}

	public WebElement getShopNowButton() {
		return shopNowButton;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getProdcutImage() {
		return prodcutImage;
	}

	public WebElement getSection2slider1() {
		return section2slider1;
	}

	public WebElement getSection2slider2() {
		return section2slider2;
	}

	public WebElement getSection2slider3() {
		return section2slider3;
	}

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	public WebElement getHerobannerSlider3() {
		return herobannerSlider3;
	}

	public WebElement getHerobannerSlider2() {
		return herobannerSlider2;
	}

	public WebElement getHerobannerSlider1() {
		return herobannerSlider1;
	}

	public WebElement getBreadcrumb() {
		return breadcrumb;
	}

	public WebElement getCartMainShadow() {
		return cartMainShadow;
	}

	public WebElement getCartCLosButton() {
		return cartCLosButton;
	}

	public WebElement getCartDrawerHeading() {
		return cartDrawerHeading;
	}

	public WebElement getCloseWeishlistPopup() {
		return closeWeishlistPopup;
	}

	public WebElement getWishlistPopup() {
		return wishlistPopup;
	}

	public WebElement getCloseSearchField() {
		return closeSearchField;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public List<WebElement> getMegamenuDropdown() {
		return megamenuDropdown;
	}

	public WebElement getLogoHomepage() {
		return logoHomepage;
	}

	public WebElement getNewArrivals() {
		return newArrivals;
	}

	public WebElement getShopByCatagory() {
		return shopByCatagory;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getAccountIcon() {
		return accountIcon;
	}

	public WebElement getWishlistIcon() {
		return wishlistIcon;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getHerBanner() {
		return herBanner;
	}

	public WebElement getBestSellers1() {
		return bestSellers1;
	}

	public WebElement getNewArrivals1() {
		return newArrivals1;
	}

	public WebElement getViewAll() {
		return viewAll;
	}

	public WebElement getLeftNavigationButton() {
		return leftNavigationButton;
	}

	public WebElement getRightNavigationButton() {
		return rightNavigationButton;
	}

}
