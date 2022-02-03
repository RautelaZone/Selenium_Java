package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumWaitConcept {
    public static void main(String[] args) {
        /* Question: What is synchronization or how will you handle timeout?
        1) Implicit Wait:
        Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before throwing an exception.
        Once this time is set, WebDriver will wait for the element before the exception occurs.
        It always applied globally as applicable for all web elements for which driver is interacting.

        2) Explicit Wait:
        Explicit Wait directs the Selenium WebDriver to wait until a certain condition occurs before
        proceeding with executing the code.
        Setting Explicit Wait is important in cases where there are certain elements that naturally take more time to load.
        In order to declare explicit wait, we have to use “ExpectedConditions”

        3) Fluent/Smart Wait:
        Fluent Wait in Selenium marks the maximum amount of time and frequency for Selenium WebDriver
        to wait for a certain condition/element becomes visible.
        It also defines how frequently WebDriver will check if the condition appears before throwing the “ElementNotVisibleException”.
        Basically, Fluent Wait looks for a web element repeatedly at regular intervals until timeout happens or until the object is found.
        These often occurs in Ajax applications.

         */

        String URL = "https://html.com/input-type-file/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".classlocator")));

        // Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>()
        {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("someID"));
            }
        });
        foo.click();




    }
}
