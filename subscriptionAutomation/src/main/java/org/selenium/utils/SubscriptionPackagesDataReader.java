package org.selenium.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPackagesDataReader {

	public List<JSONObject> getSubscriptionPropertiesAsJSON() {
	    List<JSONObject> propertiesList = new ArrayList<>();

	    JSONParser parser = new JSONParser();

	    try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/SubscriptionPackagesTestData.json", StandardCharsets.UTF_8)) {
	        JSONArray subscriptions = (JSONArray) parser.parse(reader);

	        for (Object subscription : subscriptions) {
	            JSONObject jsonObject = (JSONObject) subscription;
	            propertiesList.add(jsonObject);
	        }
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }

	    return propertiesList;
	}

}