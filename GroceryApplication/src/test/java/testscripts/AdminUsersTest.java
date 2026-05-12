package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	
	AdminUsersPage adminusers;
	HomePage home;
	@Test(description="user is trying to add a new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();
		HomePage home=new HomePage(driver);
		adminusers=home.clickAdminUsersMoreInfo();
		RandomDataUtility randomdata=new RandomDataUtility();
		String adminusername=randomdata.randomUsername();
		String adminpassword=randomdata.randomPassword();
		System.out.println(adminusername);
		System.out.println(adminpassword);
		adminusers.clickNewButton().enterUserName(adminusername).enterPassword(adminpassword).selectUserType().clickSaveButton();
		boolean alertDisplayed=adminusers.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.UNABLETOADDADMINUSERERROR);
		
	}
	
	@Test(description="user is trying to search a user")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();
		adminusers=home.clickAdminUsersMoreInfo();
		String username=ExcelUtility.readStringData(0, 0, "AdminPage");
		adminusers.clickSearchBoxButton().enterSearchUsername(username).selectSearchUserType().clickSearchButton();
		String actual=adminusers.getActualValue();
		String expected=username;
		Assert.assertEquals(actual, expected,Constant.UNABLETOSEARCHUSERERROR);	
	}

}
