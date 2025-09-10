package Test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import excel.Read_excel;
import pages.Loginpage;
import pages.homepage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test02 extends BaseTest{

    public homepage hp;
    public Loginpage lp;

    @Test(priority = 3)
    public  void vertify_login_page() {
        hp=new homepage(driver);
        lp=new Loginpage(driver);
        hp.clickaccount();
        hp.clicklogin();
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT",lp.login_title());
        System.out.println(lp.login_title());
    }

    @Test(priority = 4,dependsOnMethods = "vertify_login_page",dataProvider = "logindata")
    public void vertify_login(String email, String password) throws InterruptedException {
        lp.enter_email(email);
        lp.enter_password(password);
        lp.click_login();
        hp.clicksendaway();
        hp.clickaccount();
        hp.clicklogout();
        hp.clickaccount();
        hp.clicklogin();
    }

    @Test(priority = 5,dependsOnMethods = "vertify_login")
    public void vertify_invalid_email() {
        lp.enter_email("invalid_email");
        lp.click_login();
        Assert.assertEquals("Please include an '@' in the email address. 'invalid_email' is missing an '@'.",lp.get_email_validtied());
        System.out.println(lp.get_email_validtied());
    }




    @DataProvider(name = "logindata")
    public Object[][] data() throws IOException, InvalidFormatException {
        return Read_excel.readsheet("login");
    }
}
