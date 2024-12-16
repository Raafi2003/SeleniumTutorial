package part1;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static pageObjects.webDriverManager.webDriverInitializer;

public class ButtonExample {
    WebDriver driver;
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void setup(){
        WebDriver driver = webDriverInitializer("Chrome");
        driver.get("https://leafground.com/button.xhtml");
        // boolean in enabled/disabled
        WebElement disabledButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt92']"));
        Boolean isButtonEnabled = disabledButton.isEnabled();
        System.out.print(isButtonEnabled);
        // position
        WebElement pbtn = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt94']"));
        Point p = pbtn.getLocation();
        System.out.println(p.getX());
        System.out.println(p.getY());

        // color
        WebElement colbtn = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = colbtn.getCssValue("background-color");
        System.out.println(color);



    }
}
