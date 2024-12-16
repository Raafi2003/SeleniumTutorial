package part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static pageObjects.webDriverManager.webDriverInitializer;

public class textBox {
    WebDriver driver = webDriverInitializer("Chrome");
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void setup() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");

        WebElement nameBox = driver.findElement(By.xpath("//*[@id='j_idt88:name']"));
        nameBox.sendKeys("Raafih");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement appendBox = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
        appendBox.sendKeys(", India");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement verifyDisabledBox = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']"));
        boolean isEnabled = verifyDisabledBox.isEnabled();
        if(isEnabled){
            System.out.println("Field is Enabled");
        }else{
            System.out.println("Field is Disabled");
        }

        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();
        clearText.sendKeys("hello");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement retrieve = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt97']"));
        String retrieved = retrieve.getAttribute("value");
        System.out.println(retrieved);

        WebElement emailBox = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt99']"));
        emailBox.sendKeys("sraafih810@gmail.com"+Keys.TAB);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
