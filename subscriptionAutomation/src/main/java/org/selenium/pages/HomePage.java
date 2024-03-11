package org.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.utils.SubscriptionPackagesDataReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class HomePage extends BasePage {

	@FindBy(id="country-name")
	WebElement countryBtn ;
	
	@FindBy(id="bh-contry-flag")
	WebElement BahrainDiv ;
	
	@FindBy(id="kw-contry-flag")
	WebElement KuwaitDiv ;
	
	@FindBy(id="country-selct")
	WebElement countryList ;

	@FindBy(id="name-لايت")
	WebElement lightPkg;
	@FindBy(xpath = "//*[@id=\"currency-لايت\"]/b")
	WebElement lightpkgPrice;
	@FindBy(id = "currency-لايت")
	WebElement lightpkgCurrency;
	@FindBy(id="name-الأساسية")
	WebElement mainPkg;
	@FindBy(xpath = "//*[@id=\"currency-الأساسية\"]/b")
	WebElement mainpkgPrice;
	@FindBy(id = "currency-الأساسية")
	WebElement mainpkgCurrency;
	@FindBy(id="name-بريميوم")
	WebElement premPkg;
	@FindBy(xpath = "//*[@id=\"currency-بريميوم\"]/b")
	WebElement prempkgPrice;
	@FindBy(id = "currency-بريميوم")
	WebElement prempkgCurrency;
	
	String[] countriescodes = {"sa", "bh", "kw"};
	
	SubscriptionPackagesDataReader reader;
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
		reader = new SubscriptionPackagesDataReader();
	}
		public void selectCountry(String country) {
			clickButton(countryBtn);
			if(country.equals("البحرين")) {
				BahrainDiv.click();
			}
			else if(country.equals("الكويت")) {
				KuwaitDiv.click();
			}
		}
		public List<JSONObject> getSupscriptionForCountry() {
			List<JSONObject> subscriptionList = new ArrayList<>();
	    
	    List<JSONObject> SASubscriptionsData = new ArrayList<JSONObject>();
	    SASubscriptionsData.add(getSubscriptionData("لايت"));
	    SASubscriptionsData.add(getSubscriptionData("الأساسية"));
	    SASubscriptionsData.add(getSubscriptionData("بريميوم"));
	    subscriptionList.addAll(SASubscriptionsData);   return subscriptionList;
	}
	
		public JSONObject getSubscriptionData(String PackageName) {
		    if(PackageName.equals("لايت")) {
		    	JSONObject lightPackage = new JSONObject();
			    lightPackage.put("name", lightPkg.getText());
			    lightPackage.put("price", lightpkgPrice.getText());
			    lightPackage.put("currency", lightpkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
			    return lightPackage;
		    }
		    else if(PackageName.equals("الأساسية")) {
		    	 JSONObject mainPackage = new JSONObject();
				    mainPackage.put("name", mainPkg.getText());
				    mainPackage.put("price", mainpkgPrice.getText());
				    mainPackage.put("currency", mainpkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
				    return mainPackage;
		    }
		    else if(PackageName.equals("بريميوم")) {
		    	JSONObject premiumPackage = new JSONObject();
			    premiumPackage.put("name", premPkg.getText());
			    premiumPackage.put("price", prempkgPrice.getText());
			    premiumPackage.put("currency", prempkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
			    return premiumPackage;
		    }
			return new JSONObject();
		}
}