package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
