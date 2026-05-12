package mainproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	
	Properties prop;
	FileInputStream file;
	
	
public WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException {
		
		prop=new Properties();
		file=new FileInputStream(Constant.CONFIGFILE);
		prop.load(file);
		if(browsers.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {   //iTestResult is a predefined interface..maintain the lifecycle of the testcase(maintain status like failed ,success,skip)

		if (iTestResult.getStatus() == ITestResult.FAILURE) {//if result from th iTestResult is failed the n we only take screenshot

			ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());  //called the getScreenshot method from the ScreenshotUtility class and fetch the name of the failed testcase using getname() method
		}
		//driver.quit();

		}
}
