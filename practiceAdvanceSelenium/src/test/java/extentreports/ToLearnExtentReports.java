package extentreports;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void reports() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/DemoReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest("Demo report");
		test.log(Status.PASS, "Added log status inside extent report");
		report.flush();
	}
}