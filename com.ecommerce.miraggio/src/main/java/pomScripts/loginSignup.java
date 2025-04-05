package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginSignup {

	public loginSignup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input--template--19077619482836__main--customeremail']")
	private WebElement loginEmailTextField;
	@FindBy(xpath = "//input[@id='input--template--19077619482836__main--customerpassword']")
	private WebElement loginPasswordTextField;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//a[text()='Sign up']")
	private WebElement signupLink;
	@FindBy(xpath = "//input[@name='customer[first_name]']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='customer[last_name]']")
	private WebElement lastName;
	@FindBy(xpath = "(//input[@placeholder='E-mail'])[1]")
	private WebElement signUpEmailTextField;
	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	private WebElement passwordTextField;
	@FindBy(xpath = "//button[text()='Create account']")
	private WebElement createAccountButton;
	
}
