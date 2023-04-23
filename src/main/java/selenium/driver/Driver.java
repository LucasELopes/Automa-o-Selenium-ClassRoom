package selenium.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    
    public static WebDriver driver;
    public static WebDriverWait wait; 

    public Driver() {
        
    }

    public Driver(boolean bool) {
        
        if(System.getProperty("os.name").contains("Linux")) {
            System.getProperty("webdriver.chrome.driver", "/src/main/java/selenium/chromedrive/chromedriver");
        }
        else if(System.getProperty("os.name").contains("Windows")) {
            System.getProperty("webdriver.chrome.driver", "src\\main\\java\\selenium\\chromedrive\\chromedriver.exe");
        }

        if(bool == true) {
            driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        }
        else {
            driver = new ChromeDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
