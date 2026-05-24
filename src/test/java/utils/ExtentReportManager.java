package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setDocumentTitle("QA Automation Test Report");
            sparkReporter.config().setReportName("Final Project Test Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Project", "Final QA Automation Project");
            extentReports.setSystemInfo("Tester", "Raluca");
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extentReports.setSystemInfo("Test Framework", "TestNG");
            extentReports.setSystemInfo("API Tool", "RestAssured");
        }

        return extentReports;
    }
}