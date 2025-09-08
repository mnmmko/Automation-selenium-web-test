package steps;

import Test.BaseTest;
import pages.Registerpage;
import pages.homepage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class TestRegister extends BaseTest {

    homepage hp;
    Registerpage rp;

    @Given("user in register page")
    public void user_open_registerpage() {
        hp=new homepage(driver);
        hp.clickaccount();
        hp.clickregister();
    }

    @When("user enter fname {string} and mname {string} and lname {string} and password {string} and conpass {string}")
    public void user_enter_all_fields(String fname, String mname, String lname, String password, String conpass) {
        rp=new Registerpage(driver);
        rp.addfname(fname);
        rp.addmiddlename(mname);
        rp.addlname(lname);
        rp.addemail(random_email());
        rp.addpassword(password);
        rp.addconfirmation(conpass);
        rp.clickcheck_is_registered();
    }

    @When("click register button")
    public void click_register_button() throws InterruptedException {
        rp.clickregister();
        hp.clicksendaway();
    }

    @Then("register successfully")
    public void check_register_successfully() {
        System.out.println(hp.register_success_msg());
        Assert.assertEquals("Thank you for registering with Main Website Store.",hp.register_success_msg());
    }
}
