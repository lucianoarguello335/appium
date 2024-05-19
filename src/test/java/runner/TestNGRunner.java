package runner;

import java.io.File;

import org.testng.annotations.*;
import utils.ConfigFileReader;
import io.cucumber.testng.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = "@JamesRider",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json"
        })


public class TestNGRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private ExtentSparkReporter spark;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        spark = new ExtentSparkReporter("target/cucumber-reports/report.html");
        spark.loadXMLConfig(new File(ConfigFileReader.getConfigPropertyVal("reportConfigPath")));
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

}
