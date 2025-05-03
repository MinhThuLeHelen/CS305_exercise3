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
 * The InputValidator class provides static utility methods to validate
 * various types of user input such as password, description, creation date,
 * price, medium, last name, email, username, phone number, DOB, postal code, 
 * description Methods include proper JavaDoc and in-line code comments for
 * better readability and maintenance.
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
     public static boolean validateName(String name) 
     {
         if (name == null                 // if the input is null (nothing was passed in)
                 || name.trim().isEmpty() // if there is space even after trimming
                 || name.length() < 2)    // if there is last than 2 characters in the name
             return false;
         return name.matches("[\\p{L} ]+"); // we will accept letters (in any language with diacritics)
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
        // we'll accept letters (in any language with diacritics) but not starts and/or ends with a dash .
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
     * @param username the username to validate.
     * @return true if the username meets all requirements, false otherwise.
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
     * Validates a password based on length and content requirements.
     * @param password the password to validate
     * @return true if valid, false otherwise
     */

    public static boolean valPassword(String password)
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
    
    /**
     * Checks if password contains at least one number, one uppercase,
     * and one lowercase character.
     */
     public static boolean checkPass(String password) 
      {
            boolean hasNum = false;
            boolean hasCap = false;
            boolean hasLow = false;
    
            for (int i = 0; i < password.length(); i++) 
            {
                char c = password.charAt(i);
                if (Character.isDigit(c)) 
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
                if (hasNum && hasCap && hasLow)
                {
                  return true;
                }
            }
            return false;
        }

        /*
     * Validates a phone number based on the following requirements:
     * - Must contain 10 digits.
     * - May include dashes or spaces. 
     * - Can be empty.
     *
     * @param phoneNum the input phone number string to validate.
     * @return true if the phone number is valid, false otherwise.
     */
    public static boolean isPhoneNumValid(String phoneNum) 
   {
    if (phoneNum == null) 
  {
  return false; 
  }
    if (phoneNum.equals("")) 
    { 
      return true; 
    }
    String regex = "^[0-9\\- ]+$";  // Allows only digits, hyphens, and spaces
    if (!phoneNum.matches(regex)) 
    { 
      return false; 
    }
    int count = 0;
    for (char c : phoneNum.toCharArray()) 
    {
        if (Character.isDigit(c)) count++;
    }
    return count == 10; //digts must be 10.
}
    

    /**
     * Validates the DOB based on the following requirements:
     * - Must be a valid date in the format yyyy-MM-dd
     * - User must be 18+ years old. 
     * - Should not be empty.
     * 
     * @param ValidateS the DOB of the user is above the age of 18 years.
     * @return true if the date of birth is valid and the user is 18+ years old, false otherwise.
     * @throws DateTimeParseException if the date format is invalid.
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
    {
        return false;
    }
    }

    /**
     * Validates the postal code based on the following requirements:
     * - Must be exactly 5 digits (only for the U.S.A.). 
     * - Can be empty if the postal code is from another country.
     * 
     * @param postalCode 
    * @param USAcode true if the address is in the U.S.A., false otherwise.
    * @return true if the ZIP code is valid.
    * @throws NumberFormatException if the postal code is not a number.
     */
    public static boolean isPostalCodeValid(String postalCode, boolean USAcode)
    {
        if (postalCode == null || postalCode.length() != 5)
        {
            if (!USAcode && "".equals(postalCode)) // Allow empty string for non-USA postal codes.
            {
                return true;
            }
            return false;
        }
        else if (USAcode && postalCode.matches("\\d{5}"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

     /**
     * Validates whether the title is valid based on the following requirements:
     * - Must not be null or empty.
     * - Must be less than 100 characters long.
     *
     * @param title the title of the artwork to validate
     * @return true if the title is valid, false otherwise
     */
    public static boolean checkTitle(String title)
    {
        if(title != null && title.length() > 0 && title.length() < 100)
        {
            return true;            
        }
        else
        {
            return false;
        }
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
        "oil", "acrylic", "watercolor", "ink", "pastel", "digital", "mixed media", "sculpture");
    
    /**
     * Validates whether the medium is one of the accepted media types based on the following requirements:
     * - Should be one of the accepted media (the field for a painting medium is a dropdown menu). 
     * - Should not be empty.
     *
     * @param medium the medium used in the artwork (e.g., "oil", "acrylic")
     * @return true if the medium is valid, false otherwise
     */
    public static boolean isValidMedium(String medium) 
    {
        if (medium == null || medium.trim().isEmpty()) 
        {
            return false;
        }
        return acceptedMedia.contains(medium.toLowerCase());
    }

    /**
     * Validates a creation date based on the following requirements:
     * - Must be in the format yyyy-MM-dd.
     * - Must not be null or empty.
     *
     * @param date the creation date to validate
     * @return true if the date is valid, false otherwise
     */
    
    public static boolean validateCreationDate(String date) 
      {
            if (date == null || date.isEmpty()) 
            {
                return false;
            }
            try 
              {
                LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE); //yyyy-MM-dd.
                return true;
            } 
            catch (DateTimeParseException e) 
            {
                return false;
            }
        }

    // Valid currencies: USD ($), CAD (C$), Euro (€), Mexican Peso (MX$), Bitcoin (₿)
    // Regex allows symbols followed by 1+ digits, a decimal point, and 2 decimal digits
    private static final Pattern pricePattern = Pattern.compile(
        "^(\\$|C\\$|€|MX\\$|₿)?\\d+(\\.\\d{2})?$");

    
    /**
     * Validates that the price is either empty or matches valid currency format.
     *
     * @param price the price as a string (can be USD, EUR, BTC)
     * @return true if valid or empty, false if invalid
     */    
    public static boolean isValidPrice(String price) 
  {
        if (price == null || price.trim().isEmpty()) 
        {
            return true; // Allow empty prices (optional field)
        }
        return pricePattern.matcher(price).matches();
    }


}
