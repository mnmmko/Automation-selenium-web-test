package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    WebDriver driver;
    Actions actions;
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String gettext(By element){
        wait_for_element(driver,20,element);
        return driver.findElement(element).getText();
    }

    public void clickbutton(By element){
        wait_for_element(driver,20,element);
        driver.findElement(element).click();
    }
    public void doubleclickbutton(By element){
        wait_for_element(driver,20,element);
        actions=new Actions(driver);
        actions.doubleClick(driver.findElement(element)).perform();

    }

    public void sendtext(By element, String text){
        wait_for_element(driver,20,element);
        driver.findElement(element).sendKeys(text);
    }

    public String get_text_of_placeholeder(By element){
        wait_for_element(driver,20,element);
        return driver.findElement(element).getAttribute("placeholder");
    }

    public WebElement get_element(By element){
        return driver.findElement(element);
    }

    public void wait_for_element(WebDriver driver, int time, By element){
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
