/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

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
    
}