package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	HomePage home;
	ManageNewsPage managenews;
	@Test(description="user is trying to add new news")
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();
		managenews=home.clickManageNewsMoreInfo();
		String newNews=ExcelUtility.readStringData(0, 0, "NewsSheet");
		managenews.clickNewsNewButton().addNews(newNews).clickSaveNewsButton();
		boolean alertDisplayed=managenews.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed, Constant.UNABLETOADDNEWSERROR);		
	}
	
	
	
	@Test(description="user is trying to search newly added news")
	public void verifyWhetherTheUserIsAbleToSearchNewlyAddedNews() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();
		managenews=home.clickManageNewsMoreInfo();
		String news=ExcelUtility.readStringData(0, 0, "NewsSheet");
		managenews.clickSearchNewsButton().enterSearchNews(news).clickSearchButton();
		String expectedResult=news;
		String actualResult=managenews.getSearchResult();
		Assert.assertEquals(actualResult, expectedResult,Constant.UNABLETOSEARCHNEWS);
		
		
	}
	

}
