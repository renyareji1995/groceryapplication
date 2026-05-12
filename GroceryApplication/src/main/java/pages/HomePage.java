package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Admin") WebElement adminButton;
	@FindBy(linkText="Logout") WebElement logoutButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement manageContactMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement manageNewsMoreInfo;
	
	
	
	public HomePage clickAdminButton() {
		
		adminButton.click();
		
		return this;
	}
	
	public LoginPage clickLogoutButton() {
		
		logoutButton.click();
		
		return new LoginPage(driver);
	}

	public AdminUsersPage clickAdminUsersMoreInfo() {
		
		adminUsersMoreInfo.click();
		
		return new AdminUsersPage(driver);
	}
	
	public ManageContactPage clickManageContactMoreInfo() {
		
		manageContactMoreInfo.click();
		
		return new ManageContactPage(driver);
	}
	
	public ManageNewsPage clickManageNewsMoreInfo() {
		
		manageNewsMoreInfo.click();
		
		return new ManageNewsPage(driver);
	}
}
