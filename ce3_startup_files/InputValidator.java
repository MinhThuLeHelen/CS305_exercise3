import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * Methods to validate inputs from the user. 
 */

public class InputValidator 
{
   public static boolean isValidDescription(String description) {
    if (description == null || description.trim().isEmpty()) {
        return false;
    }
    return description.length() <= 1000;
}
private static final Set<String> acceptedMedia = Set.of(
    "oil", "acrylic", "watercolor", "ink", "pastel", "digital", "mixed media", "sculpture"
);

public static boolean isValidMedium(String medium) {
    if (medium == null || medium.trim().isEmpty()) {
        return false;
    }
    return acceptedMedia.contains(medium.toLowerCase());
}
public static boolean isValidCreationDate(String date) {
    if (date == null || date.trim().isEmpty()) {
        return false;
    }
    try {
        LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
} 
private static final Pattern pricePattern = Pattern.compile("^\\$?\\d+(\\.\\d{2})?$|^€\\d+(\\.\\d{2})?$|^₿\\d+(\\.\\d{2})?$");

public static boolean isValidPrice(String price) {
    if (price == null || price.trim().isEmpty()) {
        return true; // empty allowed
    }
    return pricePattern.matcher(price).matches();
}

}

