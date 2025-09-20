package Test;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
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
    public Eyes eyes;
    configreader prop;

    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browser) throws Exception {
        prop = new configreader();
//        url= prop.getproperty("url");
        url="http://live.techpanda.org/index.php/";
        eyes = new Eyes();
        eyes.setApiKey("q1KaDyLjMiUMcRWkhqp9Bc18SS1HZi5CO2TAXeSmjbk110");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOption());
        driver.navigate().to(url);
        driver.manage().window().maximize();
        eyes.open(driver,"Magento","open app",new RectangleSize(1200, 800));
        eyes.setForceFullPageScreenshot(true);
        eyes.check("Magento Home page", Target.window().fully());


    }

    @AfterSuite
    public void close(){
        driver.quit();
        eyes.close();
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

//        options.setBinary("C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
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
