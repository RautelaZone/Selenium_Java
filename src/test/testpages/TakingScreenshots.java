package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenshots {
    public static void main(String[] args) throws IOException {
        String URL = "https://demo.guru99.com/test/guru99home/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // Taking screenshot of a complete page
        File imgFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(imgFile, new File("./fullPageSS.png"));

        // Taking screenshot of a particular WebElement
        WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Bank Project')]"));
        File elementImgFile = ele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementImgFile, new File("./ElementSS.png"));

        driver.quit();




    }
}
