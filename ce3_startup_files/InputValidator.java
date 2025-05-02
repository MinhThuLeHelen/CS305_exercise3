import java.util.List;
import java.time.LocalDate;
import java.time.Period;
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
    /**
     * Validates a name based on the following requirements:
     * - Can contain letters and spaces.
     * - Must be at least 2 characters long.
     * - May include diacritic marks.
     * - Must not be null or empty.
     *
     * @param name the name to validate
     * @return true if the name is valid, false otherwise
     */
    public static boolean isValidDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        return description.length() <= 1000;
    }

    // List of accepted mediums for artwork.
    private static final Set<String> acceptedMedia = Set.of(
        "oil", "acrylic", "watercolor", "ink", "pastel", "digital", "mixed media", "sculpture"
    );

    /**
     * Validates that the medium is not empty and is among accepted options.
     *
     * @param medium the medium used in the artwork
     * @return true if valid, false otherwise
     */
    public static boolean isValidMedium(String medium) {
        if (medium == null || medium.trim().isEmpty()) {
            return false;
        }
        return acceptedMedia.contains(medium.toLowerCase());
    }


    // Regex pattern to validate allowed currency formats (USD, EUR, BTC)
    private static final Pattern pricePattern = Pattern.compile(
        "^\\$?\\d+(\\.\\d{2})?$|^€\\d+(\\.\\d{2})?$|^₿\\d+(\\.\\d{2})?$"
    );

    /**
     * Validates that the price is either empty or matches valid currency format.
     *
     * @param price the price as a string (can be USD, EUR, BTC)
     * @return true if valid or empty, false if invalid
     */
    public static boolean isValidPrice(String price) {
    // Allow empty prices (optional field)
    if (price == null || price.isEmpty()) {
        return true;
    }

    // Valid currencies: USD ($), CAD (C$), Euro (€), Mexican Peso (MX$), Bitcoin (₿)
    // Regex allows symbols followed by 1+ digits, a decimal point, and 2 decimal digits
    String priceRegex = "^(\\$|C\\$|€|MX\\$|₿)\\d+(\\.\\d{2})$";

    return price.matches(priceRegex);
}



    /**
     * Validates a last name based on the following requirements:
     * - Can contain letters, spaces, and dashes.
     * - Must be at least 2 characters long.
     * - May include diacritic marks.
     * - Must not be null or empty.
     * - It cannot start or end with a dash.
     *
     * @param lastName the last name to validate
     * @return true if the last name is valid, false otherwise
     */
    public static boolean validateLastName(String lastName) 
    {
        if (lastName == null                  // if the input is null (nothing was passed in)
                || lastName.trim().isEmpty()  // if there is space even after trimming
                || lastName.length() < 2)     // if there is last than 2 characters in the last name
            return false;
        return lastName.matches("[\\p{L} \\-]+") && !lastName.startsWith("-") && !lastName.endsWith("-");
        // we will accept letters (in any language with diacritics) but not starts and/or ends with a dash 
    }

    /**
     * Validates an email address based on the following requirements:
     * - Must not be null or empty.
     * - Must follow a valid email format (e.g., name@example.com).
     *
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean validateEmail(String email) 
    {
        if (email == null                   // if the input is null (nothing was passed in)
                || email.trim().isEmpty())  // if there is space even after trimming
            return false;
        
        // Find the position of the @ symbol
        int atPosition = email.indexOf('@');
        
        // Check if @ exists and isn't the first or last character
        if (atPosition <= 0 || atPosition == email.length() - 1)
            return false;
        
        // Check if there is at least one '.' after the '@' symbol
        String domainPart = email.substring(atPosition + 1); // get everything after @
        if (domainPart.indexOf('.') == -1)
            return false;
        
        // If all checks pass, return true
        return true;
    }

    /**
     * Validates a username based on the following requirements:
     * - Must not be null or empty.
     * - Must not exceed 20 characters in length.
     * - May contain only letters, numbers, underscores, and dots.
     *
     * @param username the username to validate
     * @return true if the username meets all requirements, false otherwise
     */
    public static boolean validateUsername(String username) 
    {
        if (username == null                    // if input is null (nothing was passed in)
                || username.trim().isEmpty()    // if there is space even after trimming
                || username.length() > 20)      //if username is longer than 20 characters 
            return false;
        return username.matches("[\\w.]+");     // accepts username that contains letters, numbers, underscore, dot
    }
    
    /**
     * Checks whether the given username is unique by comparing it to a list of existing usernames.
     *
     * @param username the username to check
     * @param existingUsernames the list of usernames already in use
     * @return true if the username is unique, false otherwise
     
    */public static boolean isUsernameUnique(String username, List<String> existingUsernames) 
    {
         // Check if the username exists in the list
         // Case-insensitive check (UserName" and "username" as two distinct usernames)
        return !existingUsernames.contains(username.toLowerCase());
    } 

 /*
     * The isValidPhoneNum method is used to validate a phone number. 
     *
     */
    public static boolean isValidPhoneNum(String phoneNum) 
    {
        //String message = "269-555-1234";

        if (phoneNum == null)
        {
            return false;  
        }
        
        if (phoneNum.isEmpty()) 
        {
            return true;  //accepts empty phone numbers.
        }

        int count = 0;
        for (int i = 0; i < phoneNum.length(); i++) 
        {
            char OneChar = phoneNum.charAt(i); //one character at the time.
            if (Character.isDigit(OneChar)) 
            {
                count++;
            } 
            else if (OneChar != '-' && OneChar != ' ') 
            {
                return false;  //only #'s', dashes and spaces allowed.
            }
        }

        return count == 10;
    }

    public static boolean validateDateOfBirth(String dob)
    {
        if (dob == null || dob.isEmpty()) return false;
        try
        {
            LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate today = LocalDate.now();
            int age = Period.between(birthDate, today).getYears();
            return age >= 18;
        }
        catch (DateTimeParseException e)
        {
            return false;
        }
    }

    public static boolean validatePostalCode(String postalCode)
    {
        if (postalCode == null || postalCode.isEmpty()) return true; // can be  empty string only if it's not a US postal code.
        return postalCode.matches("5"); //must be exactly 5 digits in the postal code.
    }

    public static boolean validateCreationDate(String creationDate)
    {
        if (creationDate == null || creationDate.isEmpty()) return false;
        try
        {
            LocalDate.parse(creationDate, DateTimeFormatter.ISO_LOCAL_DATE); //yyyy-MM-dd.
            return true;
        }
        catch (DateTimeParseException e)
        {
            return false;
        }
    }
}

