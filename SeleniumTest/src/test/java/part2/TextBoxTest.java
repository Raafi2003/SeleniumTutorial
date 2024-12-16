package part2;

import ExtentReport.BaseSetup;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static pageObjects.webDriverManager.webDriverInitializer;

public class TextBoxTest extends BaseSetup {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = webDriverInitializer("chrome");
    }
    @Test
    public void testTextBoxCases(){

        ExtentTest test = extent.createTest("TextBox Functionality Test");
        test.log(Status.INFO, "Inside TextBox Test");
        try{
            driver.manage().window().maximize();
            driver.get("https://leafground.com/input.xhtml");
            test.pass("Browser launched and navigated to URL");

            WebElement nameBox = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[1]/div/input"));
            nameBox.sendKeys("Raafih");
            test.pass("Name entered successfully");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            WebElement appendBox = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[2]/div/input"));
            appendBox.sendKeys(", India");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            test.pass("Text appended successfully");

            WebElement verifyDisabledBox = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[3]/div/input"));
            boolean isEnabled = verifyDisabledBox.isEnabled();
            if(isEnabled){
                test.fail("Field should be disabled but is enabled");
            }else{
                test.pass("Field is correctly disabled");
            }

            WebElement clearText = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[4]/div/input"));
            clearText.clear();
            clearText.sendKeys("hello");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            test.pass("Text cleared and 'hello' entered");

            WebElement retrieve = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[5]/div/input"));
            String retrieved = retrieve.getAttribute("value");
            System.out.println(retrieved);
            test.pass("Retrieved value: " + retrieved);

            WebElement emailBox = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div[1]/div/form/div[6]/div/input"));
            emailBox.sendKeys("sraafih810@gmail.com"+Keys.TAB);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            test.pass("Email entered successfully");

        } catch (Exception e) {
            test.fail("Test failed: "+e.getMessage());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
