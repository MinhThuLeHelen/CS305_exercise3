import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public static boolean IsThePassword(Valid(String password)
    {
        if(password.length() > 7)
        {
            return checkPass(password);
            
        }
    
        else
        {
            System.out.println("Too short");
            return false;
        }
    }
    public static boolean checkPass(String password)
    {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;

        for (int i = 0; i < password.length(); i++)
        {
         c = password.charAt(i);
         if(Character.isDigit(c))
         {
            hasNum = true;
         }
         else if (Character.isUpperCase(c))
         {
            hasCap = true;
         }   
         else if (Character.isLowerCase(c))
        {
             hasLow = true;
        }
        if(hasNum && hasCap && hasLow)
        {
            return true;
        }
        }
        return false;
    }

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
    public static boolean isValidDescription(String description) 
    {
        if (description == null || description.trim().isEmpty()) 
        {
            return false;
        }
        return description.length() <= 1000;
    }

/**
 * Validates a creation date based on the following requirements:
 * - Must be in the format yyyy-MM-dd.
 * - Must not be null or empty.
 *
 * @param date the creation date to validate
 * @return true if the date is valid, false otherwise
 */

public static boolean isValidCreationDate(String date) 
{
    if (date == null || date.trim().isEmpty()) 
    {
        return false;
    }
    try {
        LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return true;
    } 
    catch (DateTimeParseException e) 
    {
    return false;
} 

private static final Pattern pricePattern = Pattern.compile("^\\$?\\d+(\\.\\d{2})?$|^€\\d+(\\.\\d{2})?$|^₿\\d+(\\.\\d{2})?$");

public static boolean isValidPrice(String price) 
{
    if (price == null || price.trim().isEmpty()) 
    {
        return true; // empty allowed.
    }
    return pricePattern.matcher(price).matches();
    }
    private static final Set<String> acceptedMedia = Set.of(
        "oil", "acrylic", "watercolor", "ink", "pastel", "digital", "mixed media", "sculpture"
    );
}

    /**
     * Validates that the medium is not empty and is among accepted options.
     *
     * @param medium the medium used in the artwork
     * @return true if valid, false otherwise
     */
    public static boolean isValidMedium(String medium) 
    {
        if (medium == null || medium.trim().isEmpty()) 
        {
            return false;
        }
        return acceptedMedia.contains(medium.toLowerCase());
    }

    // Regex pattern to validate allowed currency formats (USD, EUR, BTC)
    private static final Pattern pricePattern = Pattern.compile(
        "^\\$?\\d+(\\.\\d{2})?$|^€\\d+(\\.\\d{2})?$|^₿\\d+(\\.\\d{2})?$");

    /**
     * Validates that the price is either empty or matches valid currency format.
     *
     * @param price the price as a string (can be USD, EUR, BTC)
     * @return true if valid or empty, false if invalid
     */
    public static boolean isValidPrice(String price) 
    {
        if (price == null || price.isEmpty())  // Allow empty prices (optional field)
        {
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

     /**
    
    /*
     * Validates a postal Code based on the following requirements:
     * - Must contain 10 digits
     * - May include dashes or spaces. 
     * - Can be empty.
     *
     */
    public static boolean isPhoneNumValid(String phoneNum) 
    {
        String message1 = "269-555-1234";
        String message2 = "2695551234777";
        String regex = "^[0-9\\- ]+$";

        if (phoneNum == null) 
        {
          return false;
        }
        if (phoneNum.equals(""))
        {
          return true; 
        }
        if (!phoneNum.matches(regex)) 
        {
          return false; // must contain only digits, dashes, and spaces.
        }
        if (phoneNum.equals(message2))
        {
            return false;
        }
        if (phoneNum.length() < 10 || phoneNum.length() > 15) // Phone number cannot be shorter than 10 digits or 15 digits.
        {
          return false; 
        }
       
        if (phoneNum.equals(message1)) 
        {
          return true; 
        }
         
        int count = 0;
        for (int i = 0; i < phoneNum.length(); i++) 
        {
            if (Character.isDigit(phoneNum.charAt(i))) 
            {
                count++;
            }
        }
    return count == 10; // Phone number should equal to 10 digits.
    }

    /**
     * Validates the creation date based on the following requirements:
     * - Must be a valid date in the format yyyy-MM-dd
     * - User must be 18+ years old. 
     * - Should not be empty.
     * 
     * @param dob the date of birth to validate the age of the users is above 18.
     * @return true if the date of birth is valid and user is 18+ years old, false otherwise
     * @throws DateTimeParseException if the date format is invalid
     * @throws IllegalArgumentException if the date is in the future
     */
    public static boolean dateOfBirthIsValid(String dob) 
    {
            if (dob == null || dob.isEmpty()) 
            {
                return false;
            }
            try 
            {
                LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
                int birthYear = birthDate.getYear();

                if (2025 - birthYear >= 18) 
                {
                    return true;
                } 
                else 
                {
                    return false;
                }
            }
            catch (DateTimeParseException e) 
            return false;
    }

    /**
     * Validates the date of birth(DOB) based on the following requirements:
     * - Must be exactly 5 digits (only for the U.S.A.). 
     * - Can be empty if the postal code is from another country.
     * 
     * @param postalCode the ZIP/postal code to validate
    * @param USAcode true if the address is in the U.S.A, false otherwise
    * @return true if the ZIP code is valid
    * @throws NumberFormatException if the postal code is not a number 
     */
    public static boolean isPostalCodeValid(String postalCode, boolean USAcode)
    {
        if (postalCode == null || postalCode.length() < 5 || postalCode.length() > 5) 
    {
        return false; 
    }
        if (!USAcode) 
        {
            return postalCode.isEmpty();
        }
        if (!postalCode.matches("{5}")) 
        {
            throw new NumberFormatException("ZIP code is only 5 digits.");
        }
    return true;
    }

    public static boolean isValidDescription(String description) 
    {
        if (description == null || description.trim().isEmpty()) 
        {
            return false;
        }
        return description.length() <= 1000;
        }
    private static final Set<String> acceptedMedia = Set.of(
        "oil", "acrylic", "watercolor", "ink", "pastel", "digital", "mixed media", "sculpture"
    );

    public static boolean isValidMedium(String medium) 
    {
        if (medium == null || medium.trim().isEmpty()) 
        {
            return false;
        }
        return acceptedMedia.contains(medium.toLowerCase());
    }

    public static boolean validateCreationDate(String creationDate)
    {
        if (creationDate == null || creationDate.isEmpty()) 
        {
            return false;
        }
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
    

