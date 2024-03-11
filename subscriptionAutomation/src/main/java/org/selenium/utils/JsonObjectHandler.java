package org.selenium.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonObjectHandler {
	
	public static List<JSONObject> CombineJsonObjects(List<List<String>> values) {
		List<JSONObject> jsonObjects = new ArrayList<>();
		for (List<String> list : values) {
            JSONObject jsonObject = createJsonObject(list);
            jsonObjects.add(jsonObject);
        }
		return jsonObjects;
	}

	private static JSONObject createJsonObject(List<String> subscriptions) {
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("country", subscriptions.get(0));

	    JSONArray jsonArray = new JSONArray();
	    for (String subscription : subscriptions) {
	        jsonArray.add(subscription);
	    }
	    jsonObject.put("subscriptions", jsonArray);

	    return jsonObject;
	}
public static String getJsonValue(JSONObject jsonObject, String Country, String Key) {
	// Extracting prices from the JSON object
    List<Integer> prices = new ArrayList<>();
    String value = null;
    Object dataObject = jsonObject.get(Country);
    if (dataObject instanceof List) {
        List<JSONObject> countryDataList = (List<JSONObject>) dataObject;
        for (JSONObject JSONObject : countryDataList) {
        	value = JSONObject.get(Key).toString();
            
        }
        
}
    return value;
}
}