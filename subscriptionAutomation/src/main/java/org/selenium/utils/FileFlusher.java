package org.selenium.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.json.simple.JSONObject;

public class FileFlusher {

	 public void WriteValuesToFile(List<JSONObject> values) {
	        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Subcriptions Details.txt"), "UTF-8"))) {
	            for (JSONObject obj : values) {
	                writer.write(obj.toJSONString() + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}