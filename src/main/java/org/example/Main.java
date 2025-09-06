package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Test.Test01;
import org.example.pages.homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static WebDriver driver;
   public static String url;
   public static homepage hp;
   public static Test01 t1;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

//    open();
//    hp=new homepage(driver);
//    System.out.println(hp.get_name_of_title());
//
//    hp.sendtxt("cmido86@yahoo.com");
//    hp.clickbtn();
//    Thread.sleep(5000);
//    close();
//        t1=new Test01();
//        t1.vertify_title();


    }
    public static void close(){
        driver.quit();
    }
    public static void open(){
        url="http://live.techpanda.org/index.php/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
}