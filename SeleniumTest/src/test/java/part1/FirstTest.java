package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import javax.swing.*;

public class FirstTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @AfterClass
    public void tearDown() throws InterruptedException{
        driver.quit();
    }
    @Test()
    public void firstTest() throws InterruptedException{
        driver.findElement(By.id("APjFqb")).sendKeys("Hello"+Keys.RETURN);
//        Thread.sleep(3000);
//        new Actions(driver).keyDown(Keys.RETURN).perform();
    }
    @Test()
    @Parameters({"Name", "age"})
    public void secondTest(String name, int age){
        System.out.println(name);
        System.out.println(age);
        WebDriver dri = new ChromeDriver();
        dri.get("https://www.google.com");
        dri.quit();
//        driver.navigate().back();
    }
}
