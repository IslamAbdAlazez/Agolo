/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 * Tutor: Amuthan Sakthivel (https://www.testingminibytes.com/)
 */

/***************************************************/

package org.selenium.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.selenium.constants.FrameworkConstants;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.selenium.constants.FrameworkConstants.*;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			
			extent.attachReporter(spark);

			// spark.config().setEncoding("utf-8");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle(FrameworkConstants.getProjectName() + " - ALL");
			spark.config().setReportName(FrameworkConstants.getProjectName() + " - ALL");

		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		// ExtentManager.setExtentTest(extent.createTest(testCaseName));
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}

	synchronized public static void addAuthors(Author[] authors) {
		for (Author author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author.toString());
		}
	}

	// public static void addCategories(String[] categories) {
	synchronized public static void addCategories(Category[] categories) {
		// for (String category : categories) {
		for (Category category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}

}
