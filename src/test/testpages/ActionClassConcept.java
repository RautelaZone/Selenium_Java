package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassConcept {
    public static void main(String[] args) throws InterruptedException {
        String mouseHoverURL = "http://mrbool.com/";
        String dragDropURL = "https://jqueryui.com/droppable/";
        String rightClickURL = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mouseHoverURL);

        Actions act = new Actions(driver);

        // Mouse Hover
        WebElement menuList = driver.findElement(By.className("menulink"));
        act.moveToElement(menuList).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Courses']")).click();

        // Drag and Drop - click and hold and then move to element and release
        driver.get(dragDropURL);
        driver.switchTo().frame(0); // Switching to iFrame using Index
        WebElement sourceEle = driver.findElement(By.id("draggable"));
        WebElement targetEle = driver.findElement(By.id("droppable"));
        act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();

        // Right Click Action
        driver.get(rightClickURL);
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
        act.contextClick(rightClickBtn).build().perform();
        driver.findElement(By.cssSelector("ul.context-menu-list.context-menu-root>li:nth-of-type(4)")).click(); // check AboutCSS class for more detail




    }
}
