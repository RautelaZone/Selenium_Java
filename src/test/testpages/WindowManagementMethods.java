package testpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Position;

public class WindowManagementMethods {
    public static void main(String[] args) throws InterruptedException {
        String URL = "https://demo.guru99.com/test/guru99home/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        System.out.println("********** Window Height and Width ********** ");
        // Getting window height and width
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        System.out.println("Window Width is: "+width);
        System.out.println("Window Height is: "+height);

        Dimension size = driver.manage().window().getSize();
        System.out.println("Window Width using Dimension is: "+size.getWidth());
        System.out.println("Window Height using Dimension is: "+size.getHeight());

        System.out.println("********** Window X and Y Points ********** ");
        // Getting window X and Y axis
        int xAxis = driver.manage().window().getPosition().getX();
        int yAxis = driver.manage().window().getPosition().getY();
        System.out.println("Window X-Axis is: "+xAxis);
        System.out.println("Window Y-Axis is: "+yAxis);

        Point axis = driver.manage().window().getPosition();
        System.out.println("Window X-Axis using Point is: "+axis.getX());
        System.out.println("Window Y-Axis using Point is: "+axis.getY());

        System.out.println("********** Window Size as required ********** ");
        // Setting window size as per user
        driver.manage().window().setSize(new Dimension(800,600));

        System.out.println("********** Moving Window To Some Point ********** ");
        // Moving window to some particular point
        driver.manage().window().setPosition(new Point(500,100));

        System.out.println("********** Maximize/Minimize/FullScreen of Window ********** ");
        // Setting window size as per user
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().fullscreen();



        driver.quit();
    }
}
