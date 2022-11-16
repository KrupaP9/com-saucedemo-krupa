package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {
    public static void main(String[] args) {
        //define URL to test
        String baseUrl = "https://www.saucedemo.com/";
        //Set properties of key webdriver to value edgedriver
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        //declare an object
        WebDriver driver = new EdgeDriver();
        //launch URL
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //set implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("Title: "+driver.getTitle());
        //Print the current url
        System.out.println("URL: "+driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page Source: "+driver.getPageSource());
        //locate username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        //Enter the username to username field
        usernameField.sendKeys("standard_user");
        //locate password field
        WebElement passwordField = driver.findElement(By.id("password"));
        //Enter the password to password field
        passwordField.sendKeys("secret_sauce");
        //Close the browser
        driver.quit();
    }
}
