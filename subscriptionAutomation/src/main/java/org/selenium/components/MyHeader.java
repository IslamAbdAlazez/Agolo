package org.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;
import org.selenium.pages.BasePage;
import org.selenium.pages.HomePage;

public class MyHeader extends BasePage {

	public MyHeader(WebDriver driver) {
		super(driver);
	}

	private final By countryMenuLink = By.xpath("//li[@id='menu-item-1227']//a");

	/* Fluent Interface */
	public HomePage navigateToStoreUsingMenu() {
		// driver.findElement(storeMenuLink).click();
		//wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
		click(countryMenuLink, WaitStrategy.CLICKABLE, "Country Menu Link");
		return new HomePage(driver);
	}

}
