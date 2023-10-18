package listener;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerImplementation.class)
public class TestScript {
	@Test
	public void login() {
		Reporter.log("Open browser", true);
		Reporter.log("Navigate to url", true);
		Reporter.log("Enter valid credentials", true);
		Reporter.log("Click on login button", true);
		Assert.fail();
	}
}