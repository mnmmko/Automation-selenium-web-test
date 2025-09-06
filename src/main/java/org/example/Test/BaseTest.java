package org.example.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static WebDriver driver;
    public static String url;

    @BeforeSuite
    public void open(){
        url="http://live.techpanda.org/index.php/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);

    }

    @AfterSuite
    public void close(){
        driver.quit();
    }
}
