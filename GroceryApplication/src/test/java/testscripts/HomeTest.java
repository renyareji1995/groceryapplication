package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	
	HomePage home;

	@Test(description="user is trying to logout")
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();	
		home.clickAdminButton();
		login=home.clickLogoutButton();
		String expected="7rmart supermarket";
		String actual=login.getHeadingText();
		Assert.assertEquals(actual, expected,Constant.LOGOUTERROR);
		
	}
}
