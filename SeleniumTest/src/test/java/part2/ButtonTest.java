package part2;

import ExtentReport.BaseSetup;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static pageObjects.webDriverManager.webDriverInitializer;

public class ButtonTest extends BaseSetup {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = webDriverInitializer("chrome");
    }

    @Test
    public void testButtonCases(){
        ExtentTest test = extent.createTest("Button Functionality Test");
        test.log(Status.INFO, "Testing Button.xhtml");
        driver.get("https://leafground.com/button.xhtml");
        try{
            WebElement firstButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/button"));
            firstButton.click();

            String title = driver.getTitle();
            System.out.println(title);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.navigate().back();

            WebElement blockedButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[2]/button"));

            String disabledAttribute = blockedButton.getAttribute("disabled");
            if(disabledAttribute != null){
                System.out.println("Button is disabled");
            }else{
                System.out.println("Button is enabled");
            }

            WebElement positionButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[3]/button"));
            Point point = positionButton.getLocation();
            System.out.println("X - "+point.getX());
            System.out.println("Y - "+point.getY());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            WebElement saveButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[4]/button"));
            System.out.println("Save Button Color: "+saveButton.getCssValue("background-color"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            WebElement sizeButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[1]/button"));
            System.out.println("Size Button Height: "+ sizeButton.getSize().getHeight());
            System.out.println("Size Button Width: "+ sizeButton.getSize().getWidth());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            WebElement colorButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[2]/button"));
            new Actions(driver).moveToElement(colorButton).perform();
            System.out.println("Color after hover: "+colorButton.getCssValue("background-color"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } catch (Exception e) {
            test.fail("Test failed: "+e.getMessage());
        }

        test.pass("Button.xhtml Functionality Test Passed!");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
