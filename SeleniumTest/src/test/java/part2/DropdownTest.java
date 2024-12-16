package part2;

import java.time.Duration;
import java.util.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static ExtentReport.BaseSetup.extent;

public class DropdownTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
    }
    @Test
    public void testDropdownCases () throws InterruptedException{
        ExtentTest test = extent.createTest("Dropdown Functionality Test");
        test.log(Status.INFO, "Inside Dropdown Class");
        try{
            driver.get("https://leafground.com/select.xhtml");

            WebElement firstDropDown = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/div/div/select"));
            Select select1 = new Select(firstDropDown);
            select1.selectByIndex(1);

            List<WebElement> optionList = select1.getOptions();
            System.out.println(optionList.size());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }catch (Exception e){
            test.fail("Test failed: "+e.getMessage());
        }

        test.pass("Dropdown Functionality Test Passed!");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
