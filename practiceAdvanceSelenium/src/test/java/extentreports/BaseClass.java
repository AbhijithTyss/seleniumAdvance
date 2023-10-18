package extentreports;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void configReports() {
		String time = LocalDateTime.now().toString().replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/extent_"+time+".html");
		reports=new ExtentReports();
		reports.attachReporter(spark);
	}
	
	@BeforeClass
	public void browserSetup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@BeforeMethod
	public void createtest(Method method) {
		test=reports.createTest(method.getName());
	}
	
	@AfterClass
	public void browserClose() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		reports.flush();
	}
}
