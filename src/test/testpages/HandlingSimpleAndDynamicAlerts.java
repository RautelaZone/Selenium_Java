package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingSimpleAndDynamicAlerts {
    public static void main(String[] args) throws InterruptedException {
        String URL = "https://mypage.rediff.com/login/dologin";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        Alert alertObj = driver.switchTo().alert(); // Switching to alert
        String alertMessage = alertObj.getText();   // getting alert message
        System.out.println("Alert message is: "+alertMessage);
        alertObj.accept();  // accepting or click on Ok on alert pop-up

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='Login']")).click(); // Clicking to generate pop-up to show dismiss functionality
        alertObj.dismiss(); // dismiss/close or click on cancel on alert pop-up

        /* Handling Dynamic Popup which displayed only sometimes. We have two logic for this:
         1) Using ExpectedConditions.alertIsPresent
         2) Using Try Catch
         */

        driver.findElement(By.cssSelector("input[value='Login']")).click();
        try{
            alertObj.accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("Alert not found...");
            e.printStackTrace();

        }
        driver.quit();
    }
}
