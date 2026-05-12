package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']") WebElement newsNewButton;
	@FindBy(name="news") WebElement addNewsText;
	@FindBy(xpath="//button[@name='create']") WebElement saveNewsButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement isAlertSuccess;
	@FindBy(xpath="//a[text()=' Search' and @class='btn btn-rounded btn-primary']") WebElement searchNewsButton;
	@FindBy(xpath="//input[@name='un']") WebElement searchNewsInput;
	@FindBy(xpath="//button[@name='Search']") WebElement searchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchResult;
	
	
	
	public ManageNewsPage clickNewsNewButton() {
		
		newsNewButton.click();
		
		return this;
	}
	
	public ManageNewsPage addNews(String news) {
		
		//addNewsText.clear();
		addNewsText.sendKeys(news);	
		
		return this;
	}
	
	public ManageNewsPage clickSaveNewsButton() {
		
		saveNewsButton.click();
		
		return this;
	}

	
	public boolean isAlertDisplayed() {
		
		return isAlertSuccess.isDisplayed();
	}
	
	public ManageNewsPage clickSearchNewsButton() {
		
		searchNewsButton.click();
		
		return this;
	}
	
	public ManageNewsPage enterSearchNews(String searchNews) {
		
		searchNewsInput.sendKeys(searchNews);
		
		return this;
	}
	
	public ManageNewsPage clickSearchButton() {
		
		searchButton.click();
		
		return this;
	}
	
	public String getSearchResult() {
		
		return searchResult.getText();
	}
}
