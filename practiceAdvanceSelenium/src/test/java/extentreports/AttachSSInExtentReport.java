package extentreports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttachSSInExtentReport {
	@Test
	public void screenshot() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		TakesScreenshot ts=(TakesScreenshot) driver;
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/DemoReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest("Demo report");
		test.log(Status.PASS, "Added log status into extent report");
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),"Captured image");
		report.flush();
	}
}