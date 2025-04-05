package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerImplementation extends webdriverUtility implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed");
		takeScreenShot(result.getTestContext().getName() + "-" + result.getMethod().getMethodName() + ".png");
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
