package org.selenium.constants;

import java.time.Duration;

import org.selenium.utils.ReportPathUtils;

public class FrameworkConstants {

	private static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String YES = "yes";
	public static final String NO = "no";

	private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
	public static final int WAIT = 5;

	public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
	public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
	private static String extentReportFilePath = "";

	private static final String Project_Name = "Automation Test Suite Report - STC Subscriptions";

	public static String getProjectPath() {
		return PROJECT_PATH;
	}

	public static String getProjectName() {
		return Project_Name;
	}

	public static String getExtentReportFilePath() {

		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = ReportPathUtils.createExtentReportPath();
		}
		return extentReportFilePath;
	}

	public static Duration getExplicitWait() {
		return EXPLICIT_WAIT;
	}

}