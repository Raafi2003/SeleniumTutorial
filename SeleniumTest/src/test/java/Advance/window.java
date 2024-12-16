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

import java.time.Duration;
import java.util.*;

import static pageObjects.webDriverManager.webDriverInitializer;

public class window {

    WebDriver driver = webDriverInitializer("Chrome");
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void setup() throws InterruptedException{
        driver.get("https://leafground.com/window.xhtml");

        String oldWindow = driver.getWindowHandle();
        System.out.println(oldWindow);

        WebElement button_1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        button_1.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Set<String> windowsSet = driver.getWindowHandles();
        for(String win:windowsSet){
            if(!win.equals(oldWindow)){
                driver.switchTo().window(win);
            }
        }
//        driver.switchTo().window(oldWindow);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        System.out.println(driver.getWindowHandle());
    }

}
