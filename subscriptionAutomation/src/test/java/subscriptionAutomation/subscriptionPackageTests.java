package subscriptionAutomation;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.selenium.driver.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.selenium.pages.HomePage;
import org.selenium.utils.FileFlusher;
import org.selenium.utils.JsonObjectHandler;
import org.selenium.utils.SubscriptionPackagesDataReader;

public class subscriptionPackageTests extends TestBase{
	HomePage homeObject = new HomePage(createDriver());
	FileFlusher flush = new FileFlusher();
	JsonObjectHandler jsonHandler = new JsonObjectHandler();

	@Test()
	public void UserCanRegisterSuccssfully() throws InterruptedException, IOException {	 		
	    SubscriptionPackagesDataReader reader = new SubscriptionPackagesDataReader();
	    List<JSONObject> ExpectedSubscriptionPackageData = reader.getSubscriptionPropertiesAsJSON();
	    
	    // Get actual subscription data for each country
	    List<JSONObject> ActualSubscriptionPackageDataForFirstCountry = homeObject.getSupscriptionForCountry();

	    // Iterate over each country's subscription data
	    for (int i = 0; i < ExpectedSubscriptionPackageData.size(); i++) {
	        JSONObject expectedPackage = ExpectedSubscriptionPackageData.get(i);
	        JSONObject actualPackage = ActualSubscriptionPackageDataForFirstCountry.get(i);
	        flush.WriteValuesToFile(ActualSubscriptionPackageDataForFirstCountry);
	        flush.WriteValuesToFile(ExpectedSubscriptionPackageData);
	        // Assert that price, name, and currency are equal for each subscription package
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("price").toString()));
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("name").toString()));
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("currency").toString()));
	    }
	    homeObject.selectCountry("البحرين");
	 // Get actual subscription data for each country
	    List<JSONObject> ActualSubscriptionPackageDataForSecondCountry = homeObject.getSupscriptionForCountry();

	    // Iterate over each country's subscription data
	    for (int i = 0; i < ExpectedSubscriptionPackageData.size(); i++) {
	        JSONObject expectedPackage = ExpectedSubscriptionPackageData.get(i);
	        JSONObject actualPackage = ActualSubscriptionPackageDataForSecondCountry.get(i);
	        flush.WriteValuesToFile(ActualSubscriptionPackageDataForSecondCountry);
	        flush.WriteValuesToFile(ExpectedSubscriptionPackageData);
	        // Assert that price, name, and currency are equal for each subscription package
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("price").toString()));
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("name").toString()));
	        assertTrue(expectedPackage.toString().contains(actualPackage.get("currency").toString()));
	    }
	    homeObject.selectCountry("الكويت");
		 // Get actual subscription data for each country
		    List<JSONObject> ActualSubscriptionPackageDataForThirdCountry = homeObject.getSupscriptionForCountry();

		    // Iterate over each country's subscription data
		    for (int i = 0; i < ExpectedSubscriptionPackageData.size(); i++) {
		        JSONObject expectedPackage = ExpectedSubscriptionPackageData.get(i);
		        JSONObject actualPackage = ActualSubscriptionPackageDataForThirdCountry.get(i);
		        flush.WriteValuesToFile(ActualSubscriptionPackageDataForThirdCountry);
		        flush.WriteValuesToFile(ExpectedSubscriptionPackageData);
		        // Assert that price, name, and currency are equal for each subscription package
		        assertTrue(expectedPackage.toString().contains(actualPackage.get("price").toString()));
		        assertTrue(expectedPackage.toString().contains(actualPackage.get("name").toString()));
		        assertTrue(expectedPackage.toString().contains(actualPackage.get("currency").toString()));
		    }
	}
}
