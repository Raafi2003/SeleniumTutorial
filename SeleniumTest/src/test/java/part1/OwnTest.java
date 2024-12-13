package part1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class OwnTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void setup(){
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/index.html");
        WebElement inputField = driver.findElement(By.xpath("//*[@id='input1']"));
        Boolean isInputFieldEnabled =  inputField.isEnabled();
        System.out.println(isInputFieldEnabled);
    }
}
