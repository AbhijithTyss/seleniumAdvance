package extentreports;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class DemoExtentReportTest extends BaseClass{
	@Test
	public void demoTest() {
		TakesScreenshot ts=(TakesScreenshot) driver;
		driver.get("https://demo.actitime.com/login.do");
		test.log(Status.PASS, "login page is displayed");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		driver.findElement(By.id("loginButton")).click();
		test.log(Status.PASS, "user logged in successfully");
	}
}