package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends Page{
    public Loginpage(WebDriver driver) {
        super(driver);
    }

    private By login_title= By.tagName("h1");
    private By emails=By.id("email");
    private By password=By.id("pass");
    private By login=By.xpath("//button[@title='Login']");

    public String login_title(){
        return driver.findElement(login_title).getText();
    }

    public void enter_email(String email){
        sendtext(emails,email);
    }

    public void enter_password(String pass){
        sendtext(password,pass);
    }

    public void click_login(){
        clickbutton(login);
    }
}
