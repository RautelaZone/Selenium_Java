package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFileUploadPopUp {
    public static void main(String[] args) {
        String URL = "https://html.com/input-type-file/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        String filePath = "C:/Users/Admin/Desktop/Anil_Rautela_Resume.pdf";

        // type should be file in DOM for Browser/Choose File button then following logic will work 100%
        // Never click on Choose File, instead give file as sendKeys
        driver.findElement(By.cssSelector("#fileupload")).sendKeys(filePath);
    }
}
