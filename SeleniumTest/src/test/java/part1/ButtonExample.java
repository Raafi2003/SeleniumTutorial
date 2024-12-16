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
    WebDriver driver = webDriverInitializer("Chrome");

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void setup(){


        driver.get("https://leafground.com/button.xhtml");

        WebElement disabledButton = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[2]/button"));
        Boolean isButtonEnabled = disabledButton.isEnabled();
        System.out.print(isButtonEnabled);

        // position
        WebElement pbtn = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[3]/button"));
        Point p = pbtn.getLocation();
        System.out.println(p.getX());
        System.out.println(p.getY());

        // color
        WebElement colbtn = driver.findElement(By.id("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[4]/button"));
        String color = colbtn.getCssValue("background-color");
        System.out.println(color);



    }
}
