package part2;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Point;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static pageObjects.webDriverManager.webDriverInitializer;

public class dropdownTest{
    WebDriver driver = webDriverInitializer("Chrome");

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void setup() throws InterruptedException{

        driver.get("https://leafground.com/select.xhtml");

        WebElement firstDropDown = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/div/div/select"));
        Select select1 = new Select(firstDropDown);
        select1.selectByIndex(1);

        List<WebElement> optionList = select1.getOptions();
        System.out.println(optionList.size());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
}
