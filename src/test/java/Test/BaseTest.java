package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import propreties.configreader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Random;

public class BaseTest {

    public static WebDriver driver;
    public static String url;
    configreader prop;

    @BeforeSuite
    public void open(){
        prop = new configreader();
//        url= prop.getproperty("url");
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

    protected static String random_email(){
        String pattern="ABCDEFGHIJKLMNOPQRSTDNEpUTHQoQUJMHLrErGJyHg89uy71MyuH234567890";
        Random random=new Random();
        StringBuilder rand_email=new StringBuilder();
        while (rand_email.length()<10){
            int index=(int)(random.nextFloat()*pattern.length());
            rand_email.append(pattern.charAt(index));
        }
        String email=rand_email.toString();
        return email+"@gmail.com";
    }
}
