package operations;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Website {
    @XmlElement(name = "URL")
    private String url;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "CreatedDate")
    private String createdDate;
    
    // New attributes
    @XmlElement(name = "Author")
    private String author;
    @XmlElement(name = "Category")
    private String category;

    // Getters and setters for the new attributes
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }   
}
