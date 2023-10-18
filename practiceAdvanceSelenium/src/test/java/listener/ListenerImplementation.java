package listener;


import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener,ISuiteListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" Test case started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case success", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case fail", true);
		// write code to capture screenshot
	}
}
