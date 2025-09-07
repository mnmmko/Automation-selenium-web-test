package org.example.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.propreties.configreader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;

public class BaseTest {

    public static WebDriver driver;
    public static String url;
    configreader prop;

    @BeforeSuite
    public void open(){
        prop = new configreader();
//        url= prop.getproperty("url");
        url="ttp://live.techpanda.org/index.php/";
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
