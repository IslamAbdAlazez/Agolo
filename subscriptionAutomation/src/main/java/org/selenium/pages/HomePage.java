package org.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public HomePage load() {
		load("");
		wait.until(ExpectedConditions.titleContains("AskOmDch"));
		return this;
	}

	
	public List<List<String>> getCountrySubscriptions() 
	{   
		List<List<String>> allCountriesSubscriptionData = new ArrayList<List<String>>();
		List<String> SubscriptionDataForSaudiArabia = getSubscriptionData();
		allCountriesSubscriptionData.add(SubscriptionDataForSaudiArabia);
		clickButton(countryBtn);
		clickButton(BahrainDiv);
		List<String> SubscriptionDataForBahrain = getSubscriptionData();
		allCountriesSubscriptionData.add(SubscriptionDataForBahrain);
		clickButton(countryBtn);
		clickButton(KuwaitDiv);
		List<String> SubscriptionDataForKuwait = getSubscriptionData();
		allCountriesSubscriptionData.add(SubscriptionDataForKuwait);
		return allCountriesSubscriptionData;
	}
	public List<String> getSubscriptionData() {
		List<String> countriesSubscriptionsData = new ArrayList<String>();
        countriesSubscriptionsData.add(lightPkg.getText());
        countriesSubscriptionsData.add(lightpkgPrice.getText());
        countriesSubscriptionsData.add(lightpkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
        
        countriesSubscriptionsData.add(mainPkg.getText());
        countriesSubscriptionsData.add(mainpkgPrice.getText());
        countriesSubscriptionsData.add(mainpkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
        
        countriesSubscriptionsData.add(premPkg.getText());
        countriesSubscriptionsData.add(prempkgPrice.getText());
        countriesSubscriptionsData.add(prempkgCurrency.getText().replace("/شهر", "").replaceAll("\\d+(\\.\\d+)?", ""));
        return countriesSubscriptionsData;
	}
}