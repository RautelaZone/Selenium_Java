package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingFrames {
    public static void main(String[] args) {
        String URL = "https://demo.guru99.com/test/guru99home/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // Switching to iFrame
        // We can switch iFrame by id, name and index
        driver.switchTo().frame("a077aa5e");
        System.out.println("******** We are switch to the iFrame *******");
        System.out.println("******** Performing action inside iFrame ****");
        driver.findElement(By.xpath("html/body/a/img")).click(); // performing action on iFrame
        System.out.println("********* Switching back to parent frame ***************");

        driver.switchTo().parentFrame();    // Switching back to main page
        // driver.switchTo().defaultContent(); // Switching back to main page
        System.out.println("******** Performing action to parent window ****");
        driver.findElement(By.id("philadelphia-field-email")).sendKeys("user@gmail.com");



    }
}
