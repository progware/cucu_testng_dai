package utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import stepDefinitions.BaseClass;

public class WaitHelper extends BaseClass {
	
	public WaitHelper(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	

}
