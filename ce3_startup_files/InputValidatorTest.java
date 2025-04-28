/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest 
{
    
    /*
     * Example test method for a possible Name field validator method in your 
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */
    @Test
    public void testNameFieldIsNotEmpty() 
    {
    @Test
    public void testPhoneNumberValidation()
        {
        assertTrue(InputValidator.validatePhoneNumber("1234567890"));
        assertTrue(InputValidator.validatePhoneNumber("123-456-7890"));
        assertTrue(InputValidator.validatePhoneNumber("123 456 7890"));
        
        //test for invalid phone numbers.
        assertFalse(InputValidator.validatePhoneNumber("12345")); //too short.
        assertFalse(InputValidator.validatePhoneNumber("abcdefghij")); //letters aren't allowed.
        assertFalse(InputValidator.validatePhoneNumber("123-45-67890")); //wrong way to write the phone number.
        }

    @Test
    public void testDateOfBirthValidation()
        {
        assertTrue(InputValidator.validateDateOfBirth("2005-05-2")); 
        assertTrue(InputValidator.validateDateOfBirth("1999-01-01")); 

        //test for invalid DOB.
        assertFalse(InputValidator.validateDateOfBirth("abcd-ef-gh")); //invalid format.
        assertFalse(InputValidator.validateDateOfBirth("2025-05-01")); //a date that hasn't happen.
        }

    @Test
    public void testPostalCodeValidation()
        {
        assertTrue(InputValidator.validatePostalCode("12345"));
        
        assertFalse(InputValidator.validatePostalCode("1234"));  //too short.
        assertFalse(InputValidator.validatePostalCode("123456")); //too long.
        assertFalse(InputValidator.validatePostalCode("12a45"));  //letters aren't allowed in a postal code.
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
    }
}

