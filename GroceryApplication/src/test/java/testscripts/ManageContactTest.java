package testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageContactTest extends Base{
	
	HomePage home;
	ManageContactPage contact;
	
	@Test(description="user is trying to update contacts")
	public void verifyWhetherUserIsAbleToUpdateContact() throws IOException {
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage"); 
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");	
		LoginPage login=new LoginPage(driver);//object of LoginPage
		login.enterUserName(usernamevalue).enterPassword(passwordvalue);
		home=login.clickSigninButton();
		contact=home.clickManageContactMoreInfo();		
		RandomDataUtility randomdata=new RandomDataUtility();
		String phoneNum=randomdata.randomMobileNumber();
		String contactAddress=ExcelUtility.readStringData(0, 1, "AddressPage");
		contact.clickEditButton().enterPhoneNumber(phoneNum).enterAddress(contactAddress).clickUpdateButton();
		boolean alertDisplayed=contact.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.UNABLETOUPDATECONTACTERROR);
		
	}

}
