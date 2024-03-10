package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.*;

//final -> We do not want any class to extend this class
public final class ReportPathUtils {

	// private -> We do not want anyone to create the object of this class
	// Private constructor to avoid external instantiation
	private ReportPathUtils() {
	}

	public static String createExtentReportPath() {
		if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(NO)) {
			
			return EXTENT_REPORT_FOLDER_PATH + "_" + "_"
					+ EXTENT_REPORT_NAME;

		} else {
			return EXTENT_REPORT_FOLDER_PATH + EXTENT_REPORT_NAME;
		}
	}
}
