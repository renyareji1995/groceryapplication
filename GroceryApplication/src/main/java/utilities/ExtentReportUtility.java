package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static final ExtentReports extentReports= new ExtentReports(); //static instance of extentreports
	//be shared across the application
	//synchronized means at a time we have one thread
	public synchronized static ExtentReports createExtentReports() {
		
		ExtentSparkReporter reporter= new ExtentSparkReporter("./extent-reports/extent-report.html");//./ to fetch local path of project.
		reporter.config().setReportName("7RMartSupermarketProject");//name of the file
		extentReports.attachReporter(reporter);
		
		
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Renya");  //provide context of the report
		return extentReports;
		
	}

}
