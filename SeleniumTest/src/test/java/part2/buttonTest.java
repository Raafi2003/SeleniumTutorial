package part2;

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

public class buttonTest {
    WebDriver driver;
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://leafground.com/button.xhtml");

        WebElement firstButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']"));
        firstButton.click();

        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement blockedButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt92']"));
        String disabledAttribute = blockedButton.getAttribute("disabled");
        if(disabledAttribute != null){
            System.out.println("Button is disabled");
        }else{
            System.out.println("Button is enabled");
        }

        WebElement positionButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt94']"));
        Point point = positionButton.getLocation();
        System.out.println("X - "+point.getX());
        System.out.println("Y - "+point.getY());

        Thread.sleep(3000);

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt96']"));
        System.out.println("Save Button Color: "+saveButton.getCssValue("background-color"));
        Thread.sleep(1000);

        WebElement sizeButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt98']"));
        System.out.println("Size Button Height: "+ sizeButton.getSize().getHeight());
        System.out.println("Size Button Width: "+ sizeButton.getSize().getWidth());
        Thread.sleep(1000);

        WebElement colorButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt100']"));
        new Actions(driver).moveToElement(colorButton).perform();
        System.out.println("Color after hover: "+colorButton.getCssValue("background-color"));
        Thread.sleep(2000);
    }
}
