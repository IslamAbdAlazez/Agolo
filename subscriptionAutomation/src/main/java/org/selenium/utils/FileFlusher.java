package org.selenium.utils;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FileFlusher {

	public void WriteValuesToFile(List<List<String>> countriesSubscriptionsData) throws FileNotFoundException, UnsupportedEncodingException {

	    try (PrintStream fileStream = new PrintStream(new File("Subcriptions Details.txt"), "UTF-8")) {
	        for (List<String> data : countriesSubscriptionsData) {
	            for (String entry : data) {
	                fileStream.println(entry);
	            }
	        }
	    }
	}

}