package stepDefinitions;

import io.cucumber.java.Scenario;
import org.testng.Assert;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import testRunner.RunnerTest;

public class steps extends BaseClass {
	
	@Before
	public void setup(Scenario scenario) throws IOException {
		System.out.println("*************Creating the driver***************");

		// replace access key
		String accessKey = "";
		//replace url
		String endpoint = "https://commerzbank.experitest.com/wd/hub";
	    DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("testName", scenario.getName());
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("appiumVersion", "1.22.3");
		dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		dc.setCapability("browserName", "Chrome");
		driver = new AndroidDriver(new URL(endpoint), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
//		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
//		System.out.println("*************Opening url***************");
//		driver.get(url);
		
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
//		lp.setUsername(email);
//		lp.setPassword(password);
		
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
//		lp.clickLogin();
//		Thread.sleep(3000);
		
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
//		if(driver.getPageSource().contains("Login was unsuccessful.")) {
//			driver.quit();
//			Assert.assertTrue(false);
//		}else {
//			System.out.println("Expected title is "+ title);
//			System.out.println("Actual title is "+ driver.getTitle());
//			Assert.assertEquals(title, driver.getTitle());
//		}
		
	}

	@Then("Closes browser")
	public void closes_browser() {
		driver.quit();
	}

}
