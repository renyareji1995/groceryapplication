package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	
public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility page=new PageUtility();
	
	@FindBy(xpath="//a[text()=' New' and @class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//a[text()=' Search' and @class='btn btn-rounded btn-primary']") WebElement searchBoxButton;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	//select field
	@FindBy(id="user_type") WebElement usertype;
	@FindBy(name="Create") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement isAlertSuccess;
	@FindBy(xpath="//button[@name='Search']") WebElement searchButton;
	@FindBy(id="un") WebElement searchUsername;
	@FindBy(name="ut") WebElement searchUserType;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement assertActual;
	
	
	public AdminUsersPage clickNewButton() {
		
		newButton.click();
		
		return this;
	}
	
    public AdminUsersPage enterUserName(String usernamevalue) {
		
		username.sendKeys(usernamevalue);
		
		return this;
	}
	
	public AdminUsersPage enterPassword(String passwordvalue) {
		
		password.sendKeys(passwordvalue);
		
		return this;
	}
	
	
	public AdminUsersPage selectUserType() {
		
		page.selectDragDropWithValue(usertype,"admin"); //page utility applied
	//	Select s=new Select(usertype);
		//s.selectByValue("admin");
		
		return this;
	}
	
	public AdminUsersPage clickSaveButton() {
		
		saveButton.click();
		
		return this;
	}

	
    public boolean isAlertDisplayed() {
		
		return isAlertSuccess.isDisplayed();
	}
	
	public AdminUsersPage enterSearchUsername(String usernamevalue) {
		
		searchUsername.sendKeys(usernamevalue);
		
		return this;
	}
	
    public AdminUsersPage selectSearchUserType() {
		
    	page.selectDragDropWithValue(searchUserType,"admin");  //page utility applied
		//Select s=new Select(searchUserType);
		//s.selectByValue("admin");
    	
    	return this;
	}
	public AdminUsersPage clickSearchBoxButton() {
		
		searchBoxButton.click();
		
		return this;
	}
	
	public AdminUsersPage clickSearchButton() {
		
		searchButton.click();
		
		return this;
	}
	
	public String getActualValue() {
		
		return assertActual.getText();
	}
}
