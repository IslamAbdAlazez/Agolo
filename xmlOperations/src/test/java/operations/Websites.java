package operations;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "websites")
@XmlAccessorType(XmlAccessType.FIELD)
public class Websites {
    @XmlElement(name = "Website")
    private List<Website> websites;

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }
    public void addWebsite(Website website) {
        this.websites.add(website);
    }
}