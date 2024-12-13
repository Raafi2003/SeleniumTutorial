package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {
    WebDriver driver;
    @Test
    @Parameters({"username", "password"})
    public void setup(String username, String passWord) throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(passWord);
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginBtn.click();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
