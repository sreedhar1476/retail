package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.TestBase;
import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {

	TestBase testbase;
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value="failure screenshot",type="image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
	
//	@Attachment(value="{0}",type="text/html")
//	public static String attachHtml(String html) {
//		return html;
//	}
	
	@Override
	public void onTestFailure(ITestResult ITestResult) {
		ITestResult.getInstance();
		WebDriver driver = TestBase.getdriver();
		if(driver instanceof WebDriver) {
			System.out.println("screenshot captured for testcase:"+getTestMethodName(ITestResult)+"Failed");
			saveScreenshotPNG(driver);
			}
	}

}
