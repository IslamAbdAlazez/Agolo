package operations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.FileUtils;

public class main {
	public static void main(String[] args) {
		try {
			// Deserialize XML content
            XMLSerialization xmlSerialization = new XMLSerialization();
            Websites websites = xmlSerialization.deserialize();

            // Create a new Website object
            Website addedWebsite = new Website();
            addedWebsite.setAuthor("idomyate");
            addedWebsite.setCreatedDate("03/09/2024");
            addedWebsite.setDescription("description");
            addedWebsite.setTitle("title");
            addedWebsite.setUrl("www.url.com");
            addedWebsite.setCategory("category");

            // Add the new Website object to the list
            websites.addWebsite(addedWebsite);

            // Serialize the updated Websites object to XML
            XMLSerialization.serializeToXML(websites, "output.xml");

            // Convert XML content to JSON
            String xmlContent = FileUtils.readFileToString(new File("src/test/java/operations/websites.xml"), StandardCharsets.UTF_8);
            String json = XMLtoJSONConverter.convert(xmlContent);
            System.out.println("JSON representation of XML content:");
            System.out.println(json);
			// Print the deserialized data
			for (Website deseralizedWebsite : websites.getWebsites()) {
				System.out.println("URL: " + deseralizedWebsite.getUrl());
				System.out.println("Title: " + deseralizedWebsite.getTitle());
				System.out.println("Description: " + deseralizedWebsite.getDescription());
				System.out.println("Created Date: " + deseralizedWebsite.getCreatedDate());
				System.out.println("Author: " + deseralizedWebsite.getAuthor());
				System.out.println("Category: " + deseralizedWebsite.getCategory());
				System.out.println();
				XMLtoJSONConverter jsonConverter = new XMLtoJSONConverter();				
			}
			// Get websites created after September 1st
            List<Website> websitesAfterSept1 = DataComparer.compareDates(websites, "09/01/2021");

            // Print websites created after September 1st
            System.out.println("Websites created after September 1st:");
            int websiteCount = 1;
            for (Website website : websitesAfterSept1) {
                System.out.println("Website " + websiteCount + ":");
                System.out.println("URL: " + website.getUrl());
                System.out.println("Title: " + website.getTitle());
                System.out.println("Description: " + website.getDescription());
                System.out.println("Created Date: " + website.getCreatedDate());
                System.out.println();
                websiteCount++;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
