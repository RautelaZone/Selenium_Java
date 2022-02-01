package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LaunchingChromeUsingWebDriverManager {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String URL = "https://google.com";
        String URL1 = "https://gmail.com";
        driver.get(URL);
        System.out.println("Current URL is: "+driver.getCurrentUrl());
        System.out.println("Page title is : "+driver.getTitle());
        driver.navigate().to(URL1);
        System.out.println("Current URL is: "+driver.getCurrentUrl());
        System.out.println("Page title is : "+driver.getTitle());
        driver.navigate().back();
        System.out.println("Current URL is: "+driver.getCurrentUrl());
        System.out.println("Page title is : "+driver.getTitle());
        driver.navigate().forward();
        System.out.println("Current URL is: "+driver.getCurrentUrl());
        System.out.println("Page title is : "+driver.getTitle());
        driver.navigate().refresh();

        driver.quit();
    }
}
