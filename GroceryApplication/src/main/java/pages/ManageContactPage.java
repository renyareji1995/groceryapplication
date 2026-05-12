package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	public WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	PageUtility page = new PageUtility();
	
	
	@FindBy(xpath="//i[@class='fas fa-edit']") WebElement editButton;
	@FindBy(id="phone") WebElement phoneNumber;
	@FindBy(id="content") WebElement address;
	@FindBy(xpath="//button[@name='Update']") WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	
	
	public ManageContactPage clickEditButton() {
		
		editButton.click();
		
		return this;
	}
	
	public ManageContactPage enterPhoneNumber(String phone) {
		
		phoneNumber.clear();
		phoneNumber.sendKeys(phone);
		return this;
	}
	
	public ManageContactPage enterAddress(String addr) {
		
		address.clear();
		address.sendKeys(addr);
		return this;
	}
	
	public ManageContactPage clickUpdateButton() {
		
		page.clickWithJSexecutor(driver, updateButton);   //page utility applied
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", updateButton);
		return this;
	}
	
	public boolean isAlertDisplayed() {
		
		return alertMessage.isDisplayed();
	}

}
