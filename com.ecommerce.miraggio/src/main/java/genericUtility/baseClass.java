package genericUtility;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class baseClass extends webdriverUtility implements iConstantUtility {

	public static ExtentReports er;
	public static ExtentSparkReporter esp;
	public static ExtentTest et;

	@BeforeSuite
	public void extentreport() {
		er = new ExtentReports();
		Date d = new Date();
		String filename = d.toString().replace(" ", "-").replace(":", "-");
		esp = new ExtentSparkReporter(filename + "-extentreport.html");
		er.attachReporter(esp);
	}

	@Parameters("browser")
	@BeforeTest
	public void browser(String br, ITestContext context) {
		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else {
			System.out.println("Incorrect broswer");
		}
		et = er.createTest(context.getName());
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String device = cap.getBrowserName() + "-" + cap.getBrowserVersion();
		String author = context.getCurrentXmlTest().getParameter("author");
		et.assignAuthor(author);
		et.assignDevice(device);

	}

	@BeforeClass
	public void openBrowser() {

	}

	@BeforeMethod
	public void methods() {

	}

	@AfterMethod
	public void closing(ITestResult result, Method m) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scrneenshotpath = null;
			scrneenshotpath = result.getTestContext().getName() + "-" + result.getMethod().getMethodName() + ".png";
			et.addScreenCaptureFromPath(scrneenshotpath);
			et.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			et.pass(m.getName() + " is passed");
		}
		er.flush();
	}
}
