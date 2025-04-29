/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import com.sun.source.tree.AssertTree;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testNameWithDiacritics ()
    {
        //assertTrue(InputValidator.validateNameField(""));
        //assertFalse (InputValidator.validateNameField(" "));
    }
    public void testNameFieldIsNotEmpty() 
    {
        assertTrue(InputValidator.validateNameField("Helen"));
        assertFalse (InputValidator.validateNameField(" "));
    }

    public void testNameTooShort() 
    {
        assertTrue(InputValidator.validateNameField("Mark"));
        assertFalse (InputValidator.validateNameField("A"));
    }

    public void testNameContainNumbers() 
    {
        assertTrue(InputValidator.validateNameField("Schareene"));
        assertFalse (InputValidator.validateNameField("Mimi123"));
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
    
    
}

