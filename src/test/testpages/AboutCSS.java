package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutCSS {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Using IDs (#)
        driver.findElement(By.cssSelector("ul#categories"));
        driver.findElement(By.cssSelector("#categories"));

        // Using Class(.)
        driver.findElement(By.cssSelector("input.form-control"));
        driver.findElement(By.cssSelector(".form-control"));
        driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email"));

        // Using tags
        driver.findElement(By.cssSelector("input[id='username']"));
        driver.findElement(By.cssSelector("input[id='username'][type='email']"));

        // Using contains(*) -- Useful when dynamic id like test_123
        driver.findElement(By.cssSelector("input[id*='test_']"));
        driver.findElement(By.cssSelector("input[id*='user']"));

        // Use of first-of-type -- gives the first link/option from the list
        driver.findElement(By.cssSelector("ul#categories>li:first-of-type"));

        // Use of last-of-type -- gives the last link/option from the list
        driver.findElement(By.cssSelector("ul#categories>li:last-of-type"));

        // Use of nt-of-type -- gives the nth(user choice) from the list
        driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(3)")); // will give 3rd link/option from the list

        // Use of sibling(+)
        driver.findElement(By.cssSelector("div.private-form__input-wrapper + div"));
        driver.findElement(By.cssSelector("div.private-form__input-wrapper + div"));
        driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(3)+li"));

        // Use of parent(>)
        driver.findElement(By.cssSelector("ul#categories>li")); // will give all list

        // Use of starts-with(^)
        driver.findElement(By.cssSelector("input[id^='user']"));

        // Use of ends-with($)
        driver.findElement(By.cssSelector("input[id$='name']"));
    }

}
