package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class webDriverManager {
    public static WebDriver webDriverInitializer(String browser){
        
        switch (browser.toLowerCase()){
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "/Library/chromedriver");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.safari.driver", "/Library/chromedriver");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }


}
