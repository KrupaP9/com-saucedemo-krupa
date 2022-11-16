package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {
    public static void main(String[] args) {
        //define URL to test
        String baseUrl = "https://www.saucedemo.com/";
        //set properties Key Webdriver to Value chromedriver
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //declare an object
        WebDriver driver = new ChromeDriver();
        //launch URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //implicitly define timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("Title: "+driver.getTitle());
        //Print the current url
        System.out.println("URL: "+driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page Source:"+driver.getPageSource());
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
