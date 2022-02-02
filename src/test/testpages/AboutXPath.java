package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Using tags
        driver.findElement(By.xpath("//a[text()='Features']"));
        driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));

        // Using contains
        driver.findElement(By.xpath("//a[contains(text(),'Features')]"));

        // Use of AND -- not case-sensitive
        driver.findElement(By.xpath("//button[@type='button' and @class='btn']"));

        // Use of OR -- not case-sensitive
        driver.findElement(By.xpath("//*[@type='submit' OR @name='btnReset']"));

        // Use of following
        driver.findElement(By.xpath("//*[@type='text']//following::input"));

        // Use of preceding
        driver.findElement(By.xpath("//*[@type='submit']//preceding::input"));

        // Use of parent and preceding-sibling
        driver.findElement(By.xpath("//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input"));

        // Use of parent and following-sibling
        driver.findElement(By.xpath("//a[text()='test2 test2']//parent::td[@class='datalistrow']//following-sibling::td[@class='datalistrow']//input"));

        // Use of starts-with
        driver.findElement(By.xpath("//span[starts-with(@class, 'field-submit-text')]"));

        // Use of ends-with
        driver.findElement(By.xpath("//span[ends-with(@name, 'field-submit')]"));


    }


}
