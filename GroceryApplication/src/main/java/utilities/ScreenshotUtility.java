package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {//variable failedTestCase -stored the method name of the failed testcase

		TakesScreenshot scrShot = (TakesScreenshot) driver;//screenshot captured//casting is applied TakesScreenshot interface// TakesScreenshot is an interface to capturethe screenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//copy screenshot to a file temporary

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//get current date and time and stored in the timestamp variable

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//system fetch the local path using System.getProperty("user.dir")// and created a folder named OutputScreenShot 
		if (!f1.exists()) {

		f1.mkdirs();//folder created
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";//naming of the screenshot  //timestamp is added because we know the time of the captured screenshot..file is asaved in .png format
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		}

}
