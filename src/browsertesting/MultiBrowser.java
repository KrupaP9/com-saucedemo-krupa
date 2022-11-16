package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowser {
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        //declare scanner
        Scanner scanner = new Scanner(System.in);
        //print for user entry
        System.out.println("Enter browser for automation:");
        //store user entry into userBrowser
        String userBrowser = scanner.next();
        try{
        if(userBrowser.equalsIgnoreCase("chrome")){
            //set properties Key Webdriver to Value chromedriver
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            //declare an object
            driver = new ChromeDriver();
        } else if (userBrowser.equalsIgnoreCase("edge")) {
            //Set properties of key webdriver to value edgedriver
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            //declare an object
            driver = new EdgeDriver();
        } else if (userBrowser.equalsIgnoreCase("firefox")) {
            //set properties of key webdriver to value firefox driver
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            //declare an object
            driver = new FirefoxDriver();
        }else{
            System.out.println("Invalid Browser");
        }
            //launch driver
            driver.get(baseUrl);
            //maximize window
            driver.manage().window().maximize();
            //implicit define timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //Print the title of the page
            System.out.println("Title: "+driver.getTitle());
            //Print the current url
            System.out.println("URL: "+driver.getCurrentUrl());
            //Print the page source
            System.out.println("Page Source: "+driver.getPageSource());
            //locate the username field
            WebElement usernameField = driver.findElement(By.id("user-name"));
            //Enter the username to username field
            usernameField.sendKeys("standard_user");
            //locate the password field
            WebElement passwordField = driver.findElement(By.id("password"));
            //Enter the password to password field
            passwordField.sendKeys("secret_sauce");
            //Close the browser
            driver.quit();
        }catch(Exception e){
            System.out.println("Invalid Browser Entry");
            System.exit(0);
        }
    }
}
