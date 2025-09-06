package org.example.pages;

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
    public String get_name_of_title(){
        return driver.findElement(title).getText();
    }
    public void clickscribe(){
        driver.findElement(subcribe).click();
    }
    public void add_email(String text){
        driver.findElement(email).sendKeys(text);
    }

    public void clickaccount(){
        driver.findElement(account).click();
    }

    public void clicklogin(){
        driver.findElement(login).click();
    }
}
