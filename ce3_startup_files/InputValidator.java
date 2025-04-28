import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

public class InputValidator 
{
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





 
   