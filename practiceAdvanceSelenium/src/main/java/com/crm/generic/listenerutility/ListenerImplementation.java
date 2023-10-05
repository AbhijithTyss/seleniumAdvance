package com.crm.generic.listenerutility;
import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.basetest.BaseClass;

public class ListenerImplementation extends BaseClass implements ITestListener,ISuiteListener{
	public static ExtentReports reports;
	public static ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		String time = LocalDateTime.now().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/extentReports_"+time+".html");
		spark.config().setDocumentTitle("CRM report");
		spark.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getName());	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot) eDriver;
		 String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(srcFile);
	}
	
}
