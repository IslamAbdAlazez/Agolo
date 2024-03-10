package subscriptionAutomation;

import java.io.IOException;

import org.selenium.driver.DriverManagerFirefox;
import org.testng.annotations.Test;
import org.selenium.pages.HomePage;

public class subscriptionPackageTests extends DriverManagerFirefox{
	HomePage homeObject ; 


	// 1- User Registration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws InterruptedException, IOException {
		homeObject = new HomePage(createDriver()); 
		homeObject.getCountrySubscriptions();
	}
}
