package operations;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class XMLSerialization {
	private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Websites deserialize() {
        try {
            // Create JAXB context and instantiate unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Websites.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Specify the path to the XML file
            File xmlFile = new File("src/test/java/operations/websites.xml");

            // Unmarshal XML file
            Websites websites = (Websites) jaxbUnmarshaller.unmarshal(xmlFile);

            
            // Print the deserialized data
            for (Website website : websites.getWebsites()) {
                System.out.println("URL: " + website.getUrl());
                System.out.println("Title: " + website.getTitle());
                System.out.println("Description: " + website.getDescription());
                System.out.println("Created Date: " + website.getCreatedDate());
                System.out.println("Author: " + website.getAuthor());
                System.out.println("Category: " + website.getCategory());
                System.out.println();
                return websites;
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
		return new Websites();
    }
    public static void serializeToXML(Websites websites, String filePath) {
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), websites);
            System.out.println("Serialization to XML successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
