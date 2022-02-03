package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class HandlingMultipleWindows {
    public static void main(String[] args) {
        String BASE_URL = "https://nxtgenaiacademy.com/multiplewindows/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        driver.findElement(By.name("newbrowserwindow123")).click();
        driver.findElement(By.name("newbrowsertab453")).click();
        System.out.println("***************** Normal Handling windows using Set and For loop *********************");

        String parentWindow = driver.getWindowHandle(); // Single window
        Set<String> allWindows = driver.getWindowHandles(); // Give set of all windows
        int count = allWindows.size();
        System.out.println("Total window count is: "+count);

        // Normal Handling windows using Set and For loop
        for(String child:allWindows)
        {
            if(!parentWindow.equals(child)){
                driver.switchTo().window(child);
                driver.manage().window().maximize();
                System.out.println("Child window title is:"+ driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window URL is: "+driver.getCurrentUrl());

        // Handling windows using ArrayList and get() method
        System.out.println("***************** Handling windows using ArrayList and get() method *********************");
        driver.get(BASE_URL);
        driver.findElement(By.name("newbrowserwindow123")).click();
        driver.findElement(By.name("newbrowsertab453")).click();
        Set<String> multiWindow = driver.getWindowHandles(); // Give set of all windows
        int count1 = multiWindow.size();
        System.out.println("Total window count is: "+count1);

        ArrayList<String> tabs = new ArrayList<>(multiWindow);  // Changing Set to ArrayList so that we can use get() method.
        driver.switchTo().window(tabs.get(1));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Java For Automation']")).click();
        driver.close();

        driver.switchTo().window(tabs.get(2));
        driver.manage().window().maximize();
        System.out.println("Child window title is: "+driver.getTitle());
        driver.findElement(By.xpath(" //span[contains(text(),'Python NumPy') and @class='elementor-button-text']")).click();

        driver.switchTo().window(tabs.get(0));
        System.out.println("Parent window URL is: "+driver.getCurrentUrl());
        driver.quit();

    }
}
