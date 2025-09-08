package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage extends Page{
    public Registerpage(WebDriver driver) {
        super(driver);
    }

    private By fname= By.id("firstname");
    private By mname= By.id("middlename");
    private By lname= By.id("lastname");
    private By email= By.id("email_address");
    private By password= By.id("password");
    private By confirmpassword= By.id("confirmation");
    private By check_is_registered= By.id("is_subscribed");
    private By register= By.xpath("//button[@title='Register']");
    private By back= By.xpath("//a[@class='back-link']");

    public void register_full(String firstname, String middlename, String lastname, String emails, String passwords, String confirmation) {
        sendtext(fname, firstname);
        sendtext(mname, middlename);
        sendtext(lname, lastname);
        sendtext(email,emails);
        sendtext(password,passwords);
        sendtext(confirmpassword,confirmation);
        clickbutton(check_is_registered);
        clickbutton(register);
    }

    public void addfname(String firstname) {
        sendtext(fname,firstname);
    }

    public void addmiddlename(String middlename) {
        sendtext(mname,middlename);
    }

    public void addlname(String lastname) {
        sendtext(lname,lastname);
    }
    public void addemail(String emails) {
        sendtext(email,emails);
    }

    public void addpassword(String passwords) {
        sendtext(password,passwords);
    }
    public void addconfirmation(String confirmation) {
        sendtext(confirmpassword,confirmation);
    }

    public void clickcheck_is_registered() {
        clickbutton(check_is_registered);
    }

    public void clickregister() {
        clickbutton(register);
    }

    public void clickback() {
        clickbutton(back);
    }
}
