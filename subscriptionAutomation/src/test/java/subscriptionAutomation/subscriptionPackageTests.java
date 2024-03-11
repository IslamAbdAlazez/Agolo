package subscriptionAutomation;

import java.io.IOException;
import java.util.List;
import org.selenium.driver.TestBase;
import org.testng.annotations.Test;
import org.selenium.pages.HomePage;
import org.selenium.utils.FileFlusher;

public class subscriptionPackageTests extends TestBase{
	HomePage homeObject = new HomePage(createDriver());
	FileFlusher flush = new FileFlusher();
	@Test()
	public void UserCanRegisterSuccssfully() throws InterruptedException, IOException {	 		
		List<List<String>> supscriptionPackages = homeObject.getCountrySubscriptions();
		flush.WriteValuesToFile(supscriptionPackages);
	}
}
