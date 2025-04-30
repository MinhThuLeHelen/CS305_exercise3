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

    //Test cases for DESCRIPTION field 
public void testValidDescription() {
    String desc = "This is a beautiful piece of art.";
    assertTrue(InputValidator.isValidDescription(desc));
}

public void testEmptyDescription() {
    assertFalse(InputValidator.isValidDescription(""));
}


public void testNullDescription() {
    assertFalse(InputValidator.isValidDescription(null));
}

public void testTooLongDescription() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 1001; i++) sb.append("a");
    assertFalse(InputValidator.isValidDescription(sb.toString()));
}

    //Test cases for MEDIUM field
public void testValidMedium() {
    assertTrue(InputValidator.isValidMedium("oil"));
}

public void testInvalidMedium() {
    assertFalse(InputValidator.isValidMedium("wood"));
}

public void testEmptyMedium() {
    assertFalse(InputValidator.isValidMedium(""));
}

public void testNullMedium() {
    assertFalse(InputValidator.isValidMedium(null));
}

public void testCaseInsensitiveMedium() {
    assertTrue(InputValidator.isValidMedium("Acrylic"));
}

    //Test cases for CREATION DATE field
public void testValidCreationDate() {
    assertTrue(InputValidator.isValidCreationDate("2022-05-14"));
}

public void testInvalidCreationDateFormat() {
    assertFalse(InputValidator.isValidCreationDate("14-05-2022"));
}

public void testEmptyCreationDate() {
    assertFalse(InputValidator.isValidCreationDate(""));
}

public void testNullCreationDate() {
    assertFalse(InputValidator.isValidCreationDate(null));
}
    
    //Test cases for PRICE field
public void testValidUSPrice() {
    assertTrue(InputValidator.isValidPrice("$1500.00"));
}

public void testValidEuroPrice() {
    assertTrue(InputValidator.isValidPrice("€1500.00"));
}

public void testValidBitcoinPrice() {
    assertTrue(InputValidator.isValidPrice("₿0.05"));
}

public void testEmptyPrice() {
    assertTrue(InputValidator.isValidPrice(""));
}

public void testInvalidPriceFormat() {
    assertFalse(InputValidator.isValidPrice("1500"));
}

public void testInvalidPriceLetters() {
    assertFalse(InputValidator.isValidPrice("fifteen hundred"));
} 
}