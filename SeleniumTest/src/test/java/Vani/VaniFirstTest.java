package Vani;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class VaniFirstTest {

    WebDriver driver;
    @AfterTest
    public void tearDown() {
//        Thread.sleep(3000);
//        driver.quit();
    }
    @Test(priority = 0)
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.vanihq.com/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_id")).sendKeys("raafih.s@zohocorp.com");
        driver.findElement(By.id("nextbtn")).click();
    }

}
