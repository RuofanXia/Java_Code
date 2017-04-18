package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class Example  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://my.sc.edu");
        
        driver.findElement(By.linkText("Sign in to Self Service Carolina (SSC)")).click();
        
        driver.findElement(By.id("username")).sendKeys("00246928");
        driver.findElement(By.id("password")).sendKeys("----");
        driver.findElement(By.name("submit")).click();
        
    }
}
