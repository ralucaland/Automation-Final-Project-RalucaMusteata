package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extentReports.createTest(result.getMethod().getMethodName());

        extentTest.set(test);

        extentTest.get().info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().pass("Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail("Test failed.");

        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test skipped.");

        extentTest.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

        System.out.println("Test execution finished. Extent Report generated.");
    }
}