package org.selenium.utils;

import java.util.Properties;

/*Singleton Design pattern*/
public class ConfigLoader {

	private static final String OVERRIDE_REPORTS = "override_reports";
	private static final String RETRY_FAILED_TESTS = "retry_failed_tests";
	private static final String BASE_URL = "baseUrl";

	private static final String CONFIG_PROPERTIES = "_config.properties";

	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private Properties properties;
	// private final Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {

			}

	
	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}
	public String getRetryFailedTests() {
		return getPropertyValue(RETRY_FAILED_TESTS);
	}

	public String getOverrideReports() {
		return getPropertyValue(OVERRIDE_REPORTS);
	}
}
