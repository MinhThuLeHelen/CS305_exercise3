/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import com.sun.source.tree.AssertTree;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

import java.beans.Transient;

public class InputValidatorTest 
{
    /*
     * Example test method for a possible Name field validator method in your 
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */

        // Test cases for NAME field
    @Test
    public void testNameFieldIsNotEmpty() 
    { 
        assertFalse(InputValidator.isNameValid(" "));          //should return Fail
        assertTrue(InputValidator.isNameValid("Maria"));       //should return True
    }

    @Test
    public void testNameTooShort() 
    {
        assertFalse(InputValidator.isNameValid("A"));           //should return Fail
        assertTrue(InputValidator.isNameValid("Maria"));        //should return True
    }

    @Test
    public void testNameContainNumbers() 
    {
        assertFalse(InputValidator.isNameValid("Mimi123"));     //should return Fail
        assertTrue(InputValidator.isNameValid("Maria"));        //should return True
    }

    @Test
    public void testNameWithDiacritics ()
    {
        assertFalse(InputValidator.isNameValid(" "));           //should return False
        assertTrue(InputValidator.isNameValid("María López"));  //should return True
        assertTrue(InputValidator.isNameValid("Đặng Mỹ Linh")); //should return True
    }

        // Test cases for LAST NAME field
    @Test
    public void testValidLastName() 
    {
        assertTrue(InputValidator.isLastNameValid("Pérez-García"));
    }

    @Test
    public void testValidLastNameShort() 
    {
        assertTrue(InputValidator.isLastNameValid("Lê"));
    }

    @Test
    public void testLastNameStartEndWithDash() 
    {
        assertFalse(InputValidator.isLastNameValid("-Anna"));
        assertFalse(InputValidator.isLastNameValid("Anna-"));
    }

    @Test
    public void testLastNameWithNumbers() 
    {
        assertFalse(InputValidator.isLastNameValid("Lee123"));
    }

    // Test cases for EMAIL field
    @Test
    public void testValidEmail() 
    {
        assertTrue(InputValidator.isEmailValid("Maria_Lopez@gmail.com"));
    }

    @Test
    public void testEmailMissingDomain() 
    {
        assertFalse(InputValidator.isEmailValid("Maria_Lopez@"));
    }

    @Test
    public void testEmailDoubleAt() 
    {
        assertFalse(InputValidator.isEmailValid("Maria@@"));
    }

    @Test
    public void testEmailEmpty() 
    {
        assertFalse(InputValidator.isEmailValid(""));
    }
    
    // Test cases for USERNAME field

    @Test
    public void testUsername() 
    {
        assertTrue(InputValidator.isUsernameValid("anna_123"));
    }

    @Test
    public void testUsernameTooLong() 
    {
        assertFalse(InputValidator.isUsernameValid("usernamethatiswaytoolongforthis"));
    }

    @Test
    public void testUsernameIsEmpty() 
    {
        assertFalse(InputValidator.isUsernameValid(""));
    }

    @Test
    public void testUsernameWithDot() 
    {
        assertTrue(InputValidator.isUsernameValid("ana.maria"));
    }

     @Test
    public void testUsernameIsUnique()
    {
        // Create a list of existing usernames
        List<String> existingUsernames = Arrays.asList("Alice", "Bob", "Charlie");
        
        //assertFalse("Username 'Bob' is not unique", InputValidator.isUsernameUnique("Bob", existingUsernames));  // should return False (Bob is taken)
        assertTrue("Username 'David' is unique",InputValidator.isUsernameUnique("David", existingUsernames)); // should return True (David is not taken);
    }

        // Test cases for PASSWORD field
    @Test
    public void passwordTest()
    {
        assertTrue(InputValidator.isPasswordValid("Password1"));
    }

    @Test
    public void shortPasswordTest()
    {
        assertFalse(InputValidator.isPasswordValid("Pass1"));
    }

    @Test
    public void noNumPasswordTest()
    {
        assertFalse(InputValidator.isPasswordValid("myPassword"));
    }

    @Test
    public void lowCasePasswordTest()
    {
        assertFalse(InputValidator.isPasswordValid("PASSWORD1"));
    }

    @Test
    public void upCasePasswordTest()
    {
        assertFalse(InputValidator.isPasswordValid("password1"));
    }
    
    
    @Test
    public void testPhoneNumberValidation()
    {
        assertTrue(InputValidator.isPhoneNumValid("1234567890"));
        assertTrue(InputValidator.isPhoneNumValid("123-456-7890")); // phone number with dashes.
        assertTrue(InputValidator.isPhoneNumValid("123 456 7890")); // phone number with spaces.
        assertTrue(InputValidator.isPhoneNumValid("")); //empty.
            
        assertFalse(InputValidator.isPhoneNumValid("12345")); //too short.
        assertFalse(InputValidator.isPhoneNumValid("123-45-67890")); //wrong way to write the phone number.
        assertFalse(InputValidator.isPhoneNumValid(null)); 
    }

    @Test
    public void testDateOfBirthValidation()
    {
        assertTrue(InputValidator.isDateOfBirthValid("2001-03-26")); 
        assertTrue(InputValidator.isDateOfBirthValid("2005-06-13")); 
        assertTrue(InputValidator.isDateOfBirthValid("2003-11-01"));
    
        assertFalse(InputValidator.isDateOfBirthValid("2025-05-01")); //a date that hasn't happen.
        assertFalse(InputValidator.isDateOfBirthValid("05-05-2005")); // format is wrong.
    }

    @Test
    public void testPostalCodeValidation()
    {
        assertTrue(InputValidator.isPostalCodeValid("12345"));
            
        assertFalse(InputValidator.isPostalCodeValid("1234"));  //too short.
        assertFalse(InputValidator.isPostalCodeValid("123456")); //too long.
        assertFalse(InputValidator.isPostalCodeValid("12a45"));  //letters aren't allowed in a postal code.
    }

        //Test cases for CREATION DATE field
    
     @Test
    public void testValidCreationDate() 
    {
        assertTrue(InputValidator.isCreationDateValid("2022-05-14"));
    }
    
    @Test
    public void testInvalidCreationDateFormat() 
    {
        assertFalse(InputValidator.isCreationDateValid("14-05-2022"));
    }

     @Test
    public void testEmptyCreationDate() 
    {
        assertFalse(InputValidator.isCreationDateValid(""));
    }
    
     @Test
    public void testNullCreationDate() 
    {
        assertFalse(InputValidator.isCreationDateValid(null));
    }

        // Test cases for DESCRIPTION field
    
   @Test
    public void testValidDescription() 
    {
        assertTrue(InputValidator.isDescriptionValid("A short and vivid description of the painting."));
    }

    @Test
    public void testEmptyDescription() 
    {
        assertFalse(InputValidator.isDescriptionValid(""));
    }

    @Test
    public void testNullDescription() 
    {
        assertFalse(InputValidator.isDescriptionValid(null));
    }
    
    @Test
    public void testValidDescription() 
    {
        String desc = "This is a beautiful piece of art.";
        assertTrue(InputValidator.isDescriptionValid(desc));
    }
    
    @Test
    public void testTooLongDescription() 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) sb.append("a"); // creates 1001 characters
        assertFalse(InputValidator.isDescriptionValid(sb.toString()));
    }

        // Test cases for MEDIUM field
    @Test
    public void testValidMedium() 
    {
        assertTrue(InputValidator.isMediumValid("oil"));
    }

    @Test
    public void testInvalidMedium() 
    {
        assertFalse(InputValidator.isMediumValid("wood"));
    }

    @Test
    public void testEmptyMedium() 
    {
        assertFalse(InputValidator.isMediumValid(""));
    }

    @Test
    public void testNullMedium() 
    {
        assertFalse(InputValidator.isMediumValid(null));
    }
    
    @Test
    public void testCaseInsensitiveMedium() 
    {
        assertTrue(InputValidator.isMediumValid("Acrylic"));
    }

    // Test cases for PRICE field

    @Test
    public void testValidUSPrice() 
    {
        assertTrue(InputValidator.isValidPrice("$1500.00"));
    }
    
    @Test
    public void testValidEuroPrice() 
    {
        assertTrue(InputValidator.isPriceValid("€999.99"));
    }
    
    @Test
    public void testValidBitcoinPrice() 
    {
        assertTrue(InputValidator.isPriceValid("₿0.05"));
    }
    
    @Test
    public void testEmptyPrice() 
    {
        assertTrue(InputValidator.isPriceValid(""));
    }
    
    @Test
    public void testInvalidPriceFormat() 
    {
        assertFalse(InputValidator.isPriceValid("1500"));
    }
    
    @Test
    public void testInvalidPriceLetters() 
    {
        assertFalse(InputValidator.isPriceValid("fifteen hundred"));
    }      
}

