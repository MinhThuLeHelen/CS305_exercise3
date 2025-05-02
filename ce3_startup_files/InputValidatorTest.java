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
        assertFalse(InputValidator.validateName(" "));          //should return Fail
        assertTrue(InputValidator.validateName("Maria"));       //should return True
    }

    @Test
    public void testNameTooShort() 
    {
        assertFalse(InputValidator.validateName("A"));           //should return Fail
        assertTrue(InputValidator.validateName("Maria"));        //should return True
    }

    @Test
    public void testNameContainNumbers() 
    {
        assertFalse(InputValidator.validateName("Mimi123"));     //should return Fail
        assertTrue(InputValidator.validateName("Maria"));        //should return True
    }

    @Test
    public void testNameWithDiacritics ()
    {
        assertFalse(InputValidator.validateName(" "));           //should return False
        assertTrue(InputValidator.validateName("María López"));  //should return True
        assertTrue(InputValidator.validateName("Đặng Mỹ Linh")); //should return True
    }

    // Test cases for LAST NAME field
    @Test
    public void testValidLastName() 
    {
        assertTrue(InputValidator.validateLastName("Pérez-García"));
    }

    @Test
    public void testValidLastNameShort() 
    {
        assertTrue(InputValidator.validateLastName("Lê"));
    }

    @Test
    public void testLastNameStartEndWithDash() 
    {
        assertFalse(InputValidator.validateLastName("-Anna"));
        assertFalse(InputValidator.validateLastName("Anna-"));
    }
    
    // Test cases for LAST NAME field
    
   
    // Test cases for EMAIL field

    // Test cases for USERNAME field



    @Test
    public void passwordTest()
    {
        assertTrue(InputValidator.valPassword("Password1"));
    }

    @Test
    public void shortPasswordTest()
    {
        assertFalse(InputValidator.valPassword("Pass1"));
    }

    @Test
    public void noNumPasswordTest()
    {
        assertFalse(InputValidator.valPassword("myPassword"));
    }

    @Test
    public void lowCasePasswordTest()
    {
        assertFalse(InputValidator.valPassword("PASSWORD1"));
    }

    @Test
    public void upCasePasswordTest()
    {
        assertFalse(InputValidator.valPassword("password1"));
    }

    @Test
    public void testLastNameWithNumbers() 
    {
        assertFalse(InputValidator.validateLastName("Lee123"));
    }
    
    // Test cases for EMAIL field
    @Test
    public void testValidEmail() 
    {
        assertTrue(InputValidator.validateEmail("Maria_Lopez@gmail.com"));
    }

    @Test
    public void testEmailMissingDomain() 
    {
        assertFalse(InputValidator.validateEmail("Maria_Lopez@"));
    }

    @Test
    public void testEmailDoubleAt() 
    {
        assertFalse(InputValidator.validateEmail("Maria@@"));
    }

    @Test
    public void testEmailEmpty() 
    {
        assertFalse(InputValidator.validateEmail(""));
    }
    

    // Test cases for USERNAME field
    @Test
    public void testUsername() 
    {
        assertTrue(InputValidator.validateUsername("anna_123"));
    }

    @Test
    public void testUsernameTooLong() 
    {
        assertFalse(InputValidator.validateUsername("usernamethatiswaytoolongforthis"));
    }

    @Test
    public void testUsernameIsEmpty() 
    {
        assertFalse(InputValidator.validateUsername(""));
    }

    @Test
    public void testUsernameWithDot() 
    {
        assertTrue(InputValidator.validateUsername("ana.maria"));
    }
    
    @Test
    public void testUsernameIsUnique()
    {
        // Create a list of existing usernames
        List<String> existingUsernames = Arrays.asList("Alice", "Bob", "Charlie");
        
        //assertFalse("Username 'Bob' is not unique", InputValidator.isUsernameUnique("Bob", existingUsernames));  // should return False (Bob is taken)
        assertTrue("Username 'David' is unique",InputValidator.isUsernameUnique("David", existingUsernames)); // should return True (David is not taken);
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
        assertFalse(InputValidator.isPhoneNumValid("2695551234777")); // message2.
        assertFalse(InputValidator.isPhoneNumValid(null)); 
        }

    @Test
    public void testDateOfBirthValidation()
        {
         assertTrue(InputValidator.dateOfBirthIsValid("2001-03-26")); 
        assertTrue(InputValidator.dateOfBirthIsValid("2005-06-13")); 
        assertTrue(InputValidator.dateOfBirthIsValid("2003-11-01"));
    
        assertFalse(InputValidator.dateOfBirthIsValid("2025-05-01")); //a date that hasn't happen.
        assertFalse(InputValidator.dateOfBirthIsValid("05-05-2005")); // format is wrong.
        }

    @Test
    public void testPostalCodeValidation()
        {
        assertTrue(InputValidator.isZipCodeValid("12345"));
        
        assertFalse(InputValidator.isZipCodeValid("1234"));  //too short.
        assertFalse(InputValidator.isZipCodeValid("123456")); //too long.
        assertFalse(InputValidator.isZipCodeValid("12a45"));  //letters aren't allowed in a postal code.
        }

    @Test
    public void testCreationDateValidation()
        {
            assertTrue(InputValidator.validateCreationDate("2024-04-01"));
            assertTrue(InputValidator.validateCreationDate("2000-01-01"));

            assertFalse(InputValidator.validateCreationDate("04-01-2024")); 
            assertFalse(InputValidator.validateCreationDate("abcd-ef-gh")); //invalid characters.
            assertFalse(InputValidator.validateCreationDate("")); //empty string.
        }
    // Test cases for USERNAME field

        //Test cases for DESCRIPTION field 
    public void testValidDescription() 
    {
        String desc = "This is a beautiful piece of art.";
        assertTrue(InputValidator.isValidDescription(desc));
    }

    public void testEmptyDescription() 
    {
        assertFalse(InputValidator.isValidDescription(""));
    }

    public void testNullDescription() 
    {
        assertFalse(InputValidator.isValidDescription(null));
    }

    public void testTooLongDescription() 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) sb.append("a");
        assertFalse(InputValidator.isValidDescription(sb.toString()));
    }

        //Test cases for MEDIUM field
    public void testValidMedium() 
    {
        assertTrue(InputValidator.isValidMedium("oil"));
    }

    public void testInvalidMedium() 
    {
        assertFalse(InputValidator.isValidMedium("wood"));
    }

    public void testEmptyMedium() 
    {
        assertFalse(InputValidator.isValidMedium(""));
    }

    public void testNullMedium() 
    {
        assertFalse(InputValidator.isValidMedium(null));
    }

    public void testCaseInsensitiveMedium() 
    {
        assertTrue(InputValidator.isValidMedium("Acrylic"));
    }

        //Test cases for CREATION DATE field
    public void testValidCreationDate() 
    {
        assertTrue(InputValidator.isValidCreationDate("2022-05-14"));
    }

    public void testInvalidCreationDateFormat() 
    {
        assertFalse(InputValidator.isValidCreationDate("14-05-2022"));
    }

    public void testEmptyCreationDate() 
    {
        assertFalse(InputValidator.isValidCreationDate(""));
    }

    public void testNullCreationDate() 
    {
        assertFalse(InputValidator.isValidCreationDate(null));
    }
        
        //Test cases for PRICE field
    public void testValidUSPrice() 
    {
        assertTrue(InputValidator.isValidPrice("$1500.00"));
    }

    public void testValidEuroPrice() 
    {
        assertTrue(InputValidator.isValidPrice("€1500.00"));
    }

    public void testValidBitcoinPrice() 
    {
        assertTrue(InputValidator.isValidPrice("₿0.05"));
    }

    public void testEmptyPrice() 
    {
        assertTrue(InputValidator.isValidPrice(""));
    }

    public void testInvalidPriceFormat() 
    {
        assertFalse(InputValidator.isValidPrice("1500"));
    }

    public void testInvalidPriceLetters() 
    {
        assertFalse(InputValidator.isValidPrice("fifteen hundred"));
    } 

     // Test cases for DESCRIPTION field
   @Test
    public void testValidDescription() 
    {
        assertTrue(InputValidator.isValidDescription("A short and vivid description of the painting."));
    }

    /**
     * Tests that an empty string is considered invalid as a description.
     */
    @Test
    public void testEmptyDescription() 
    {
        assertFalse(InputValidator.isValidDescription(""));
    }

    /**
     * Tests that a null input is considered invalid as a description.
     */
    @Test
    public void testNullDescription() 
    {
        assertFalse(InputValidator.isValidDescription(null));
    }

    /**
     * Tests that a description longer than 1000 characters is considered invalid.
     */
    @Test
    public void testTooLongDescription() 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) sb.append("a"); // creates 1001 characters
        assertFalse(InputValidator.isValidDescription(sb.toString()));
    }

    // Test cases for MEDIUM field

    /**
     * Tests that a valid medium from the allowed list returns true.
     */
    @Test
    public void testValidMedium() 
    {
        assertTrue(InputValidator.isValidMedium("oil"));
    }

    /**
     * Tests that a medium not in the allowed list returns false.
     */
    @Test
    public void testInvalidMedium() 
    {
        assertFalse(InputValidator.isValidMedium("wood"));
    }

    /**
     * Tests that an empty string is not valid for medium.
     */
    @Test
    public void testEmptyMedium() 
    {
        assertFalse(InputValidator.isValidMedium(""));
    }

    /**
     * Tests that a null input is not valid for medium.
     */
    @Test
    public void testNullMedium() 
    {
        assertFalse(InputValidator.isValidMedium(null));
    }

    /**
     * Tests that capitalization of valid mediums is ignored (case-insensitive check).
     */
    @Test
    public void testCaseInsensitiveMedium() 
    {
        assertTrue(InputValidator.isValidMedium("Acrylic")); // Should pass due to case-insensitivity
    }


    // Test cases for PRICE field

    /**
     * Tests that a valid US dollar format price is accepted.
     */
    @Test
    public void testValidUSPrice() 
    {
        assertTrue(InputValidator.isValidPrice("$1500.00"));
    }

    /**
     * Tests that a valid Euro currency price is accepted.
     */
    @Test
    public void testValidEuroPrice() 
    {
        assertTrue(InputValidator.isValidPrice("€999.99"));
    }

    /**
     * Tests that a valid Bitcoin format price is accepted.
     */
    @Test
    public void testValidBitcoinPrice() 
    {
        assertTrue(InputValidator.isValidPrice("₿0.05"));
    }

    /**
     * Tests that an empty price input is valid (because price is optional).
     */
    @Test
    public void testEmptyPrice() 
    {
        assertTrue(InputValidator.isValidPrice(""));
    }

    /**
     * Tests that price without a currency symbol is considered invalid.
     */
    @Test
    public void testInvalidPriceFormat() 
    {
        assertFalse(InputValidator.isValidPrice("1500")); // missing currency symbol
    }

    /**
     * Tests that a non-numeric price is considered invalid.
     */
    @Test
    public void testInvalidPriceLetters() 
    {
        assertFalse(InputValidator.isValidPrice("fifteen hundred"));
    }
}
