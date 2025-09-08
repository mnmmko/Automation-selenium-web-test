package Test;

import pages.homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01 extends BaseTest {
    public  homepage hp;

    @Test(priority = 0)
    public  void vertify_title() {
        hp=new homepage(driver);
        Assert.assertEquals("THIS IS DEMO SITE FOR   ",hp.get_name_of_title());
        System.out.println(hp.get_name_of_title());
    }

    @Test(priority = 1,dependsOnMethods = "vertify_title")
    public  void vertify_email() {
        hp.add_email(random_email());
    }

    @Test(priority = 2,dependsOnMethods = "vertify_email")
    public  void click_scribe() throws InterruptedException {
        hp.clickscribe();
        hp.clicksendaway();
    }

}
