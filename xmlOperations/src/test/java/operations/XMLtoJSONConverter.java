package operations;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class XMLtoJSONConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convert(String xmlContent) {
        try {
            // Create XmlMapper
            XmlMapper xmlMapper = new XmlMapper();

            // Read XML to JsonNode
            JsonNode jsonNode = xmlMapper.readTree(xmlContent);

            // Enable indentation for JSON output
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Convert JsonNode to JSON String
            String json = objectMapper.writeValueAsString(jsonNode);

            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
