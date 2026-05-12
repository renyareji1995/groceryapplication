package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements ITestListener {// ITestListener is an interface
	
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();//configured extentReportUtility Class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {//method execute first before the testcase executed//fetch the methodname of the testcase

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {//executed automatically when a test case is passed

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {//executed automatically when a testcase is failed

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {

	e.printStackTrace();//log the error to the report in the case of a testcase is failed
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace();
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (Exception e) {
	}
	}

	public void onTestSkipped(ITestResult result) {  //invoked automatically when a testcase is skipped due to netwrok failure or any.

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);//testcase is failed befor eth esuccess percentage
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	ITestListener.super.onTestFailedWithTimeout(result);  //testcase failed with timeout
	}

	public void onStart(ITestContext context) {

	ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
	extent.flush();  //flush() is used to log the fetched data from the test run of the above methods 
	}

}
