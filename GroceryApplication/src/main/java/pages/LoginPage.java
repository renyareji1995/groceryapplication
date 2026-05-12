package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	WaitUtility wait=new WaitUtility();
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(tagName="button") WebElement signinButton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardDisplayed;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement headingText;
	
	
		
	public LoginPage enterUserName(String usernamevalue) {
		
		username.sendKeys(usernamevalue);
		
		return this;//after entering the username page is navigated to the same page
	}
	
	public LoginPage enterPassword(String passwordvalue) {
		
		password.sendKeys(passwordvalue);
		
		return this;
	}
	
	public HomePage clickSigninButton() {
		
		wait.waitUntilElementToBeClickable(driver,signinButton); //wait applied
		signinButton.click();
		return new HomePage(driver);  //after clicking signin button navigated to the homepage,and pass driver 
	}

	//applying assertion
	public boolean isDashboardDisplayed() {
		
		return dashboardDisplayed.isDisplayed();
	}
	
	public String getHeadingText() {
		
		return headingText.getText();
	}
}
