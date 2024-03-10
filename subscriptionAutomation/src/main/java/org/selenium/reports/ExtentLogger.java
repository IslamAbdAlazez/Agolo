package org.selenium.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.selenium.utils.ConfigLoader;
import static org.selenium.constants.FrameworkConstants.YES;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void pass(Markup message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void fail(Markup message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void skip(Markup message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void pass(String message, boolean isScreeshotNeeded) {
			pass(message);
		
	}

	public static void pass(Markup message, boolean isScreeshotNeeded) {
		pass(message);
	}

	public static void fail(String message, boolean isScreeshotNeeded) {
		fail(message);
	}

	public static void fail(Markup message, boolean isScreeshotNeeded) {
		fail(message);
	}

	public static void skip(String message, boolean isScreeshotNeeded) {
		skip(message);
	}

	public static void skip(Markup message, boolean isScreeshotNeeded) {
		skip(message);
	}

}
