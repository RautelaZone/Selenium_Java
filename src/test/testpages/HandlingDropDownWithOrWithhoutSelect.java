package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingDropDownWithOrWithhoutSelect {
    public static void main(String[] args) throws InterruptedException
    {
        /*
            We can use following options:
            selectByVisibleText()/deselectByVisibleText() -- selects/deselects an option by its displayed text
            selectByValue()/deselectByValue() -- selects/deselects an option by the value of its “value” attribute
            selectByIndex()/deselectByIndex() -- selects/deselects an option by its index
            isMultiple() -- returns TRUE if the drop-down element allows multiple selection at a time else FALSE
            deselectAll() -- deselects all previously selected options
            getOptions() -- give the list of all the options (will help in finding size and printing)
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

        boolean flag = daySelect.isMultiple();  // will check whether multiselect or not
        System.out.println("Day select drop-down is multi-select?: " +flag);

        String dob = "5-Oct-1990";
        String dobArray[] = dob.split("-");     // Splitting on the basis of hyphen(-)
        String dd = dobArray[0];
        String mm = dobArray[1];
        String yy = dobArray[2];

        // Calling method to avoid creating instance of Select class again and again
        selectValueFromDropDown(day, dd);
        selectValueFromDropDown(month, mm);
        selectValueFromDropDown(year, yy);

        // Find the count of the day drop-down
        List<WebElement> daysList = daySelect.getOptions();
        int dayCount = daysList.size();
        System.out.println("Total number of days: "+dayCount);
        System.out.println("********************************");

        // Printing all the values
        System.out.println("Printing all the options using Advance For Loop:");
        for(WebElement val:daysList){
            System.out.println(val.getText());
        }
        System.out.println("********************************");
        System.out.println("Printing all the options using Standard For Loop");
        for (int i=0;i<dayCount;i++){
            String dayVal = daysList.get(i).getText();
            System.out.println(dayVal);
        }
        System.out.println("********************************");

        // Selecting a particular option from a list
        System.out.println("Selecting a particular option from a list");
        for (int i=0;i<dayCount;i++){
            String dayVal = daysList.get(i).getText();
            String userData = "25";
            if(dayVal.equals(userData)){
                daysList.get(i).click();
                System.out.println("Clicked "+userData+"th option from the list.");
                break;
            }
        }
        System.out.println("********************************");

        // Working with Drop-Down without Select class -- by findElements
        System.out.println("Working with Drop-Down without using Select Class");
         List<WebElement> monthLists = driver.findElements(By.xpath("//select[@id='month']//option"));
        System.out.println("Month Size is:" +monthLists.size());
    }
    // Making a common method so that we don't need to create instance of Select class
    public static void selectValueFromDropDown(WebElement element, String value)
    {
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }
}
