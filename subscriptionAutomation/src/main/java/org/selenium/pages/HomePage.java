package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.components.MyHeader;

public class HomePage extends BasePage {

	private MyHeader myHeader;

	public HomePage(WebDriver driver) {
		super(driver);
		myHeader = new MyHeader(driver);
	}

	public MyHeader getMyHeader() {
		return myHeader;
	}

	public HomePage load() {
		load("");
		wait.until(ExpectedConditions.titleContains("AskOmDch"));
		return this;
	}

}
