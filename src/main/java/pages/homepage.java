package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage extends Page{
    public homepage(WebDriver driver) {
        super(driver);
    }

    private By title=By.tagName("h2");
    private By subcribe=By.xpath("//button[@title='Subscribe']");
    private By email=By.xpath("//input[@type='email']");
    private By account=By.xpath("//a//span[text()='Account']");
    private By login=By.xpath("//a[@title='Log In']");
    private By logout=By.xpath("//a[text()='Log Out']");
    private By register=By.xpath("//a[text()='Register']");
    private By sendaway=By.xpath("//button[text()='Send anyway']");
    private By register_msg_success=By.xpath("//li[@class='success-msg']//ul//li//span");
    public String get_name_of_title(){
        return gettext(title);
    }
    public void clickscribe(){
        clickbutton(subcribe);
    }
    public void add_email(String text){
        driver.findElement(email).sendKeys(text);
    }

    public void clickaccount(){
            clickbutton(account);
    }

    public void clicklogin(){
            clickbutton(login);
    }
    public void clicklogout(){
            clickbutton(logout);
    }
    public void clickregister(){
            clickbutton(register);
    }
    public void clicksendaway() throws InterruptedException {
        Thread.sleep(500);
        doubleclickbutton(sendaway);
    }

    public String register_success_msg(){
        return gettext(register_msg_success);
    }
}
