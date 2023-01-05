package testRunner;


import io.cucumber.testng.*;
import org.apiguardian.api.API;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.util.*;

@API(
		status = API.Status.STABLE
)

@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = {"stepDefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/reports/Testrunner-cucumber-html-report.html"},
		tags = "@Sanity"
		)
public class RunnerTest extends AbstractTestNGCucumberTests{
	private TestNGCucumberRunner testNGCucumberRunner;
	public String currentTestName = "Szczerba";


	@BeforeClass(
			alwaysRun = true
	)
	public void setUpClass(ITestContext context) {
		System.out.println("setUpClass runnerTest");
		XmlTest currentXmlTest = context.getCurrentXmlTest();
		Objects.requireNonNull(currentXmlTest);
		CucumberPropertiesProvider properties = currentXmlTest::getParameter;
		this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
	}

	@Test(
			groups = {"cucumber"},
			description = "Runs Cucumber Scenarios",
			dataProvider = "scenarios"
	)
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
//		if( testList.contains(pickleWrapper.getPickle().getName())){
		if( true ){
			System.out.println("Setting currentTestName to: " + pickleWrapper.getPickle().getName());
			currentTestName = pickleWrapper.getPickle().getName();
			System.out.println("Starting scenario: " + pickleWrapper.getPickle().getName());
			this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
		} else {
			System.out.println("Skipping scenario: " + pickleWrapper.getPickle().getName());
		}
	}

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(
			alwaysRun = true
	)
	public void tearDownClass() {
		if (this.testNGCucumberRunner != null) {
			this.testNGCucumberRunner.finish();
		}
	}
}
