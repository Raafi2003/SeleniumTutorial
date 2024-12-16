package part1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pageObjects.webDriverManager.webDriverInitializer;

public class AssertTest {
    @Test
    public void setup(){
        String str = "str";
        boolean valid = true;

        Assert.assertEquals(str, "str");
//        Assert.assertEquals(str, "sr"); // fails
        Assert.assertTrue(valid, "It is false"); // verifies if the given condition is true, if false message is displayed
//        Assert.assertFalse(valid, "It is true"); //fails - verifies if the given condition is false, if not message is displayed

        WebDriver driver = webDriverInitializer("chrome");

    }
}
