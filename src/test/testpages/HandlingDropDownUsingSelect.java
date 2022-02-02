package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDownUsingSelect {
    public static void main(String[] args) throws InterruptedException
    {
        /*
            We can use following options:
            selectByVisibleText()/deselectByVisibleText() -- selects/deselects an option by its displayed text
            selectByValue()/deselectByValue() -- selects/deselects an option by the value of its “value” attribute
            selectByIndex()/deselectByIndex() -- selects/deselects an option by its index
            isMultiple() -- returns TRUE if the drop-down element allows multiple selection at a time else FALSE
            deselectAll() -- deselects all previously selected options
         */
        String URL = "https://www.facebook.com/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
        Thread.sleep(2000);

        WebElement day = driver.findElement(By.id("day"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement year = driver.findElement(By.id("year"));

        Select daySelect = new Select(day);
        daySelect.selectByVisibleText("15");    // selectByVisibleText
        Select monthSelect = new Select(month);
        monthSelect.selectByIndex(9);   // selectByIndex
        Select yearSelect = new Select(year);
        yearSelect.selectByValue("1910");   // selectByValue

        // Calling method to avoid creating instance of Select class again and again
        selectValueFromDropDown(day, "5");
        selectValueFromDropDown(month, "Oct");
        selectValueFromDropDown(year, "1990");
        }

    // Making a common method so that we don't need to create instance of Select class
    public static void selectValueFromDropDown(WebElement element, String value)
    {
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }
}
