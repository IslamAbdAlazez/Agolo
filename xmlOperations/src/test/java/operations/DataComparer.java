package operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataComparer {
    public static List<Website> compareDates(Websites websites, String dateStr) {
        List<Website> websitesAfterDate = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            // Parse the date string
            Date date = dateFormat.parse(dateStr);

            // Compare each website's creation date with the specified date
            for (Website website : websites.getWebsites()) {
                Date creationDate = dateFormat.parse(website.getCreatedDate());
                if (creationDate.after(date)) {
                    websitesAfterDate.add(website);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return websitesAfterDate;
    }
}
