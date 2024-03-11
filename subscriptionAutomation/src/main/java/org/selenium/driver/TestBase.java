package org.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestBase implements DriverManager_OC {

	WebDriver driver;
	@Override
	public WebDriver createDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://subscribe.stctv.com/ ");
		
		return driver;
	}
	@AfterTest
	public void stopDriver() 
	{
		driver.quit();
	}
}
