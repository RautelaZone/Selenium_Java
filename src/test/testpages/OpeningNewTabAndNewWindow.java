package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningNewTabAndNewWindow {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String URL = "https://google.com";
        driver.get(URL);

        // Opening a New Tab
        driver.switchTo().newWindow(WindowType.TAB);
        String URL1 = "https://gmail.com";
        driver.get(URL1);

        // Opening a New Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String URL2 = "https://www.youtube.com/";
        driver.get(URL2);
        driver.close();

    }
}
