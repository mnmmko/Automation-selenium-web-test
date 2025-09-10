package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import propreties.configreader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Random;

public class BaseTest {

    public static WebDriver driver;
    public static String url;
    configreader prop;

    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browser) throws Exception {
        prop = new configreader();
//        url= prop.getproperty("url");
        url="http://live.techpanda.org/index.php/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOption());
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

    public static ChromeOptions chromeOption() {


        ChromeOptions options = new ChromeOptions();
        //HashMap key object
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        //arguments
//        options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        //by dafult of chrome ,chrome doesn't appeare options
        chromePrefs.put("profile.default.content_settings.popups", 0);
        //path of folder
        // chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        //accept ssl files and all files
        //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }
}
