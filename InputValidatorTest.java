
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileOutputStream;

//import com.sun.source.tree.AssertTree; // should delete.
//import java.beans.Transient; // should delete.

/*
 *  Unit tests for the InputValidator class.
 * 
 * - Name
 * - Last Name
 * - Email
 * - Username
 * - Password
 * - Phone Number
 * - Date of Birth
 * - Postal Code
 * - Title
 * - Description
 * - Image
 * - Dimension 
 * - Medium
 * - Creation Date
 * - Price
 *
 */

public class InputValidatorTest 
{
    // Test cases for NAME field
    @Test
    public void testNameFieldIsNotEmpty() 
    { 
        assertFalse(InputValidator.validateName(" "));          //should return False
        assertTrue(InputValidator.validateName("Maria"));       //should return True
    }

    @Test
    public void testNameWithMultipleSpaces() 
    {
        // multiple spaces between words in the name are accepted, as long as it's valid after trimming.
        assertTrue(InputValidator.validateName("  John  Doe  "));  // should return true 
        assertTrue(InputValidator.validateName("Maria     Lopez")); // should return true
    }

    @Test
    public void testNameTooShort() 
    {
        assertFalse(InputValidator.validateName("A"));           //should return False
    }

    @Test
    public void testNameContainNumbers() 
    {
        assertFalse(InputValidator.validateName("Mimi123"));     //should return False
    }

    @Test
    public void testNameWithDiacritics ()
    {
        assertFalse(InputValidator.validateName(" "));           //should return False
        assertTrue(InputValidator.validateName("María López"));  //should return True
        assertTrue(InputValidator.validateName("Mỹ Linh")); //should return True
    }

    @Test
    public void testNameWithNonASCII() 
    {
        // names from different writing systems are accepted 
        assertTrue(InputValidator.validateName("Александр"));    // should return true - Cyrillic characters
        assertTrue(InputValidator.validateName("张伟"));          // should return true - Chinese characters
        assertTrue(InputValidator.validateName("李四"));          // should return true - Chinese characters
    }

    @Test
    public void testNameWithSpecialCharacters() 
    {
        assertFalse(InputValidator.validateName("John@Doe"));       // should return false - contains '@'
        assertFalse(InputValidator.validateName("Alice! Smith"));  // should return false - contains '!'
        assertFalse(InputValidator.validateName("Bob#123"));       // should return false - contains '#'
    }

    
    // Test cases for LAST NAME field
    @Test
    public void testValidLastName() 
    {
        assertTrue(InputValidator.validateLastName("Pérez-García"));   // A last name with a hyphen, should returns True 
        assertTrue(InputValidator.validateLastName("O'Conner-Smith")); // A last name with multiple hyphens, should returns True 
    }

    @Test
    public void testValidLastNameShort() 
    {
        assertTrue(InputValidator.validateLastName("Lê")); // should returns True 
    }

    @Test
    public void testLastNameStartEndWithDash() 
    {
        // last name cannot starts/ends with a dash, should returns False
        assertFalse(InputValidator.validateLastName("-Anna"));
        assertFalse(InputValidator.validateLastName("Anna-"));
    }

    @Test
    public void testLastNameWithNumbers() 
    {
        assertFalse(InputValidator.validateLastName("Lee123")); //contains numbers, should returns False
    }

    @Test
    public void testLastNameWithSpaces() 
    {
        assertTrue(InputValidator.validateLastName("Van der Merwe")); // last name with a space, should returns True 
    }

    
    // Test cases for EMAIL field
    @Test
    public void testValidEmail() 
    {
        assertTrue(InputValidator.validateEmail("Maria_Lopez@gmail.com")); // valid email with a proper format, should returns True.
    }

    @Test
    public void testEmailMissingDomain() 
    {
        assertFalse(InputValidator.validateEmail("Maria_Lopez@")); // missing domain, should return False 
    }

    @Test
    public void testEmailDoubleAt() 
    {
        assertFalse(InputValidator.validateEmail("Maria@@")); // email with multiple @ symbols, should returns False.
    }

    @Test
    public void testEmailWithoutDotInDomain() {
        assertFalse(InputValidator.validateEmail("user@examplecom")); // email without a '.' in the domain part, should returns False 
    }

    @Test
    public void testEmailWithSubdomain() {
        assertTrue(InputValidator.validateEmail("user@mail.example.com")); //email with a subdomain is valid, should returns True 
    }

    @Test
    public void testEmailWithPlusTag() {
        assertTrue(InputValidator.validateEmail("user+tag@example.com")); //an email with a plus tag is valid, should returns True 
    }

    @Test
    public void testEmailWithMultipleDots() {
        assertTrue(InputValidator.validateEmail("user.name@sub.domain.com")); // email with multiple dots in the domain is valid, should returns True
    }

    @Test
    public void testEmailWithSpaceInDomain() {
        assertFalse(InputValidator.validateEmail("user@exa mple.com")); // email with an invalid character in the domain, should return False
    }

    @Test
    public void testEmailMissingLocalPart() 
    {
        assertFalse(InputValidator.validateEmail("@example.com")); // email with no local part before the '@', should returns False 
    }

    @Test
    public void testEmailNullInput() {
        assertFalse(InputValidator.validateEmail(null)); // null input, should returns False 
    }

    @Test
    public void testEmailEmpty() 
    {
        assertFalse(InputValidator.validateEmail("")); //empty string = not a valid email, should returns False
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

    
    // Test cases for PASSWORD field
    @Test
    public void passwordTest()
    {
        assertTrue(InputValidator.valPassword("Password1"));
    }

    @Test
    public void shortPasswordTest()
    {
        // shorter than 8 characters is rejected, should returns False 
        assertFalse(InputValidator.valPassword("Pass1")); 
    }

    @Test
    public void testOnlyNumbers() 
    {
        // password with only numeric character is rejected, should returns False
        assertFalse(InputValidator.valPassword("12345678"));
    }

    @Test
    public void noNumPasswordTest()
    {
        // password with no numeric character is rejected, should returns False
        assertFalse(InputValidator.valPassword("myPassword"));
    }

    @Test
    public void lowCasePasswordTest()
    {
        // a password with no lowercase letter is rejected, should returns False 
        assertFalse(InputValidator.valPassword("PASSWORD1"));
    }

    @Test
    public void upCasePasswordTest()
    {
        // a password with no uppercase letter is rejected, should returns False 
        assertFalse(InputValidator.valPassword("password1"));
    }

    @Test
    public void testSymbolOnlyPassword() 
    {
        // contains symbols but lacks required character types, should returns False 
        assertFalse(InputValidator.valPassword("@#$%^&*()"));
    } 

    public void testNullPassword() 
    {
        assertFalse(InputValidator.valPassword(null));
    }

    
    // Test cases for PHONE NUMBER field
    @Test
    public void testPhoneNumberValidation()
    {
        assertTrue(InputValidator.isPhoneNumValid("1234567890"));
        assertTrue(InputValidator.isPhoneNumValid("123-456-7890")); // phone number with dashes.
        assertTrue(InputValidator.isPhoneNumValid("123 456 7890")); // phone number with spaces.

        assertTrue(InputValidator.isPhoneNumValid("")); //empty.
        assertTrue(InputValidator.isPhoneNumValid(null));

        assertFalse(InputValidator.isPhoneNumValid("12345")); //too short.
        assertFalse(InputValidator.isPhoneNumValid("123-45-67890")); //wrong way to write the phone number.

    }

    
    // Test cases for DOB field
    @Test
    public void testDateOfBirthValidation()
    {
        assertTrue(InputValidator.dateOfBirthIsValid("2001-03-26")); 
        assertTrue(InputValidator.dateOfBirthIsValid("2005-06-13")); 
        assertTrue(InputValidator.dateOfBirthIsValid("2003-11-01"));

        assertFalse(InputValidator.dateOfBirthIsValid("2025-05-01")); //a date that hasn't happen.
        assertFalse(InputValidator.dateOfBirthIsValid("05-05-2005")); // format is wrong.
    }

    
    // Test cases for POSTAL CODE field
    @Test
    public void testPostalCodeValidation() 
    {
        // Valid US ZIP code
        assertTrue(InputValidator.isPostalCodeValid("12345", true));

        // Too short
        assertFalse(InputValidator.isPostalCodeValid("1234", true));

        // Too long
        assertFalse(InputValidator.isPostalCodeValid("123456", true));

        // Contains letters
        assertFalse(InputValidator.isPostalCodeValid("12a45", true));

        // Non-USA empty postal code
        assertTrue(InputValidator.isPostalCodeValid("", false));

        // Non-USA non-empty postal code
        assertFalse(InputValidator.isPostalCodeValid("ABC123", false));
    }

    
    // Test cases for TITTLE field
    @Test
    public void testTitleValidation()
    {
        assertFalse(InputValidator.checkTitle(""));   // empty title, should return False 
        assertFalse(InputValidator.checkTitle(null)); // null title, should return False 
        assertTrue(InputValidator.checkTitle("This is My title"));
    }

    @Test
    public void testTitleExactly99Chars() 
    {
        // a title exactly 99 characters long is accepted, should returns True 
        String title = "a".repeat(99);
        assertTrue(InputValidator.checkTitle(title));
    }

    @Test
    public void testTitleExactly100Chars() 
    {
        // a title exactly 100 characters long is rejected, should returns False 
        String title = "a".repeat(100);
        assertFalse(InputValidator.checkTitle(title));
    }

    // Test cases for DESCRIPTION field
    @Test
    public void testValidDescription() 
    {
        assertTrue(InputValidator.isValidDescription("A short and vivid description of the painting."));
        // A description with a valid length (<= 1000 characters), should returns true
    }

    @Test
    public void testEmptyDescription() 
    {
        assertFalse(InputValidator.isValidDescription("")); //empty description, should returns false
    }

    @Test
    public void testNullDescription() 
    {
        assertFalse(InputValidator.isValidDescription(null)); // a null description, should returns false
    }

    @Test
    public void testTooLongDescription() 
    {
        // A description longer than 1000 characters, should returns false
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++) sb.append("a"); // creates 1001 characters
        assertFalse(InputValidator.isValidDescription(sb.toString()));
    }

    @Test
    public void testValidDescriptionWithArtText() 
    {
        // a valid description containing art-related text is accepted 
        String desc = "This is a beautiful piece of art.";
        assertTrue(InputValidator.isValidDescription(desc));
    }

    @Test
    public void testShortDescriptionWithSymbols() 
    {
        // Short description with symbols and numbers
        String desc = "Version 2.0 - Featuring #AI-generated textures!";
        assertTrue(InputValidator.isValidDescription(desc));
    }

    @Test
    public void testMultilineDescription() 
    {
        // Multiline description (newline characters) 
        String desc = "This painting was created over 3 months.\nEach layer represents a season.\nInspired by Van Gogh.";
        assertTrue(InputValidator.isValidDescription(desc));
    }

    
    // Test cases for IMAGE field
    private File createTempFileWithSize(String filename, int sizeInBytes) throws IOException 
    {
        // we will create temporary file using for testing without needing real image files in the project.
        File temp = File.createTempFile("temp", filename);
        
        try (FileOutputStream fos = new FileOutputStream(temp)) 
        {
            byte[] data = new byte[sizeInBytes]; // fills the file with dummy bytes (just empty data) to simulate its size.
            fos.write(data);
        }
        return temp;
    }
    
    @Test
    public void testValidJPGImageUnder4MB() throws IOException 
    {
        File tempFile = File.createTempFile("test", ".jpg");
        Files.write(tempFile.toPath(), new byte[1024 * 1024]); // 1MB dummy data

        assertTrue(InputValidator.isValidImage(tempFile));

        tempFile.delete(); // Clean up
    }

    @Test
    public void testValidJPGUnder4MB() throws IOException 
    {
        File tempFile = createTempFileWithSize("test.jpg", 1024 * 1024 * 2); // valid extension + 2MB, should returns True 
        assertTrue(InputValidator.isValidImage(tempFile));
        tempFile.delete();
    }

    @Test
    public void testTooLargePNGFile() throws IOException 
    {
        File tempFile = createTempFileWithSize("image.png", 1024 * 1024 * 5); // valid extension but 5MB, should returns False 
        assertFalse(InputValidator.isValidImage(tempFile));
        tempFile.delete();
    }

    @Test
    public void testInvalidExtension() throws IOException 
    {
        File tempFile = createTempFileWithSize("notimage.gif", 1024 * 100); // invalid extension + 100KB, should returns False 
        assertFalse(InputValidator.isValidImage(tempFile));
        tempFile.delete();
    }


    // Test cases for DIMENSIONS field
    @Test
    public void testValidDimensionsInInches() 
    {
        assertTrue(InputValidator.isValidDimensions("20x30 inches"));
        // follow the format width x height [unit] and valid unit 
        // should return False 
    }

    @Test
    public void testValidDecimalDimensions() 
    {
        assertTrue(InputValidator.isValidDimensions("0.5 x 1.2 meter")); 
        // follow the format width x height [unit] and valid unit 
        // should return False 
    }

    @Test
    public void testMissingUnit() 
    {
        assertFalse(InputValidator.isValidDimensions("20x30")); // missing unit, should returns False
    }

    @Test
    public void testEmptyDimensions() 
    {
        assertFalse(InputValidator.isValidDimensions("")); // empty, should return False 
    }

    @Test
    public void testInvalidFormat() 
    {
        assertFalse(InputValidator.isValidDimensions("30 inches x 40 inches")); 
        // not follow the format width x height [unit], should return False 
    }

    
    // Test cases for MEDIUM field
    @Test
    public void testValidMediums() {
        // Test with all valid media types in the accepted set, should all return True 
        assertTrue(InputValidator.isValidMedium("oil"));
        assertTrue(InputValidator.isValidMedium("acrylic"));
        assertTrue(InputValidator.isValidMedium("watercolor"));
        assertTrue(InputValidator.isValidMedium("ink"));
        assertTrue(InputValidator.isValidMedium("pastel"));
        assertTrue(InputValidator.isValidMedium("digital"));
        assertTrue(InputValidator.isValidMedium("mixed media"));
        assertTrue(InputValidator.isValidMedium("sculpture"));
    } 

    @Test
    public void testInvalidMedium() 
    {
        assertFalse(InputValidator.isValidMedium("wood")); //non-recognized mediums, should return False  
    }

    @Test
    public void testEmptyMedium() 
    {
        assertFalse(InputValidator.isValidMedium("")); // empty medium, should return False 
    }

    @Test
    public void testNullMedium() 
    {
        assertFalse(InputValidator.isValidMedium(null)); // empty medium, should return False 
    }

    @Test
    public void testCaseInsensitiveMedium() // This test ensures that the method is case-insensitive and correctly validates recognized mediums.
    {
        // Test with a valid medium "Acrylic", should return True even with different cases
        assertTrue(InputValidator.isValidMedium("Acrylic")); 
        assertTrue(InputValidator.isValidMedium("acrylic")); // check lowercase input
        assertTrue(InputValidator.isValidMedium("ACRYLIC")); // check uppercase input
    }

    
    //Test cases for CREATION DATE field
    @Test
    public void testValidCreationDate() 
    {
        assertTrue(InputValidator.validateCreationDate("2022-05-14"));
    }

    @Test
    public void testInvalidCreationDateFormat() 
    {
        assertFalse(InputValidator.validateCreationDate("14-05-2022"));
    }

    @Test
    public void testNonExistentDate() {
        assertFalse(InputValidator.validateCreationDate("2023-02-30")); // Feb 30 doesn't exist, should return False 
    }

    @Test
    public void testDateWithLetters() {
        assertFalse(InputValidator.validateCreationDate("YYYY-MM-DD")); // non numeric, should returns False 
    }

    @Test
    public void testEmptyCreationDate() 
    {
        assertFalse(InputValidator.validateCreationDate("")); // empty string, should returns False 
    }

    @Test
    public void testNullCreationDate() 
    {
        assertFalse(InputValidator.validateCreationDate(null));
    }

    
    // Test cases for PRICE field
    @Test
    public void testValidUSPrice() // Test with valid US dollar price format 
    {
        assertTrue(InputValidator.isValidPrice("$1500.00")); // test with valid US dollar price format 
    }

    @Test
    public void testValidEuroPrice() 
    {
        assertTrue(InputValidator.isValidPrice("€999.99")); // test with valid Euro price format
    }

    @Test
    public void testValidBitcoinPrice() 
    {
        assertTrue(InputValidator.isValidPrice("₿0.05")); // test with valid Bitcoin price format
    }

    @Test
    public void testEmptyPrice() 
    {
        assertTrue(InputValidator.isValidPrice("")); // test with an empty string, should return True 
    }

    @Test(expected = IllegalArgumentException.class) // Expected exception
    public void testInvalidPriceFormat() 
    {
        InputValidator.isValidPrice("1500"); // missing currency symbol, should return False
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPriceLetters() 
    {
        assertFalse(InputValidator.isValidPrice("fifteen hundred")); // price written in words (letters), should throw an exception
    }      
}
