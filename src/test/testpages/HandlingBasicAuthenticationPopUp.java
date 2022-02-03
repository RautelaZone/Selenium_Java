package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBasicAuthenticationPopUp {
    public static void main(String[] args) {
        /*
            We can handle basic authentication pop-up by adding username:password@ after https://
            https://username:password@test.com
         */
        String URL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        System.out.println("Message is: "+ pageMessage);
        driver.quit();
    }
}
