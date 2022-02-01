package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
    public static void main(String[] args) throws InterruptedException {
        String URL = "https://google.com";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800,600));
        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Clicking on an element
        WebElement btn = driver.findElement(By.name("btnI"));
        js.executeScript("arguments[0].click();", btn);

        // Printing to browser console
        js.executeScript("console.log('Printing using JS Executor')");

        // This  will scroll vertically-Down
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(4000);

        // This  will scroll vertically-Up
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(4000);

        // This will scroll horizontally-- to right side
        js.executeScript("window.scrollBy(1000,0)");
        Thread.sleep(4000);

        // This will scroll horizontally-- to left side
        js.executeScript("window.scrollBy(-1000,0)");
        Thread.sleep(4000);

        // This  will scroll down to the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);

        // This  will scroll up to the top of the page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        Thread.sleep(4000);

        // This will scroll by visible element
        js.executeScript("arguments[0].scrollIntoView();", btn);





    }
}
