package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage home;    //reference variable created globally
	
	@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentails() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home = login.clickSigninButton();  //create the reference variable to which page is to be navigated
		boolean dashboardDisplayed=login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed,Constant.VALIDCREDENTIALERROR);
	}
	
	
	@Test(priority=2,description="user is trying to login with invalid credentails", retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWIthInvalidCredentials() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(1, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(1, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSigninButton();
		String expected="7rmart supermarket";
		String actual=login.getHeadingText();
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);
		
	}
	
	
	@Test(priority=3,description="user is trying to login with valid username and invalid password")
	public void verifyUserLoginWithInvalidPassword() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(2, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(2, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSigninButton();
		String expected="7rmart supermarket";
		String actual=login.getHeadingText();
		Assert.assertEquals(actual, expected,Constant.INVALIDPASSWORDERROR);
		
	}
	
	
	@Test(priority=4,description="user is trying to login with valid password and invalid username",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyUserLoginWithInvalidUsername(String usernamevalue, String passwordvalue) throws IOException {
		
		//String usernamevalue=ExcelUtility.readStringData(3, 0, "LoginPage"); 
		//String passwordvalue=ExcelUtility.readStringData(3, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue).clickSigninButton();
		String expected="7rmart supermarket";
		String actual=login.getHeadingText();
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAMEERROR);
		
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}
