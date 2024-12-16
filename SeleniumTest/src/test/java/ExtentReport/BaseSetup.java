package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static pageObjects.webDriverManager.webDriverInitializer;

public class BaseSetup {
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;

    @BeforeSuite
    public void setup(){
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("report.html");
        extent.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
