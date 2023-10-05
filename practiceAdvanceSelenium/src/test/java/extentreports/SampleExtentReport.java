package extentreports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.basetest.BaseClass;
import com.crm.generic.listenerutility.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class SampleExtentReport extends BaseClass {

	@Test
	public void test() {
		driver.get("https://www.instagram.com/");
		ListenerImplementation.test.log(Status.INFO,"open browser");
		ListenerImplementation.test.log(Status.INFO,"navigate to url");
		ListenerImplementation.test.log(Status.INFO,"login to application");
		ListenerImplementation.test.log(Status.PASS,"user successfully logged in");
		Assert.fail();
	}
}
