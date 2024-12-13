package Advance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.*;

public class window {

    WebDriver driver;
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://leafground.com/window.xhtml");

        String oldWindow = driver.getWindowHandle();
        System.out.println(oldWindow);

        WebElement button_1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        button_1.click();

        Thread.sleep(2000);
        Set<String> windowsSet = driver.getWindowHandles();
        for(String win:windowsSet){
            if(!win.equals(oldWindow)){
                driver.switchTo().window(win);
            }
        }
//        Thread.sleep(1000);1000
//        driver.switchTo().window(oldWindow);
        Thread.sleep(2000);
//        System.out.println(driver.getWindowHandle());
    }

}
