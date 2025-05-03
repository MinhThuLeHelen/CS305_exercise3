## **TEAM MEMBERS:
1. Minh Thu Le (Helen)
2. Schareene Romero Rivera
3. Jason P. Morales Alonson 
4. Dillon C. Rodriguez

<br>

## **CLASSES DESCRIPTION**

Important files in this exercise include:
- **README.md**: Provides instructions on how to run the tests (see the HOW TO USE section) and includes a team reflection at the end.
- **InputValidator.java**: Contains methods for validating input fields from the Art Catalog.
- **InputValidatorTest.java**: Contains JUnit test methods to verify that each validation method in the InputValidator class works correctly.

<br>

## **HOW TO USE**:

To run the tests in the InputValidatorTest class, each test method needs a @Test annotation. Without this annotation, JUnit will not recognize or run the method as a test.

<ins>isNameValid</ins>: Use it to validate a last name based on the following requirements:
- Can contain letters, spaces, and dashes.
- Must be at least 2 characters long.
- May include diacritic marks.
- Must not be null or empty.

<ins>isLastNameValid</ins>: Use it to validate a last name based on the following requirements:
- Can contain letters, spaces, and dashes.
- Must be at least 2 characters long.
- May include diacritic marks.
- Must not be null or empty.
- It cannot start or end with a dash.

<ins>isEmailValid</ins>: Use it to validate an email address based on the following requirements:
- Must not be null or empty.
- Must follow a valid email format (e.g., name@example.com).

<ins>isUsernameValid</ins>: Use it to validate a username based on the following requirements:
- Must not be null or empty.
- Must not exceed 20 characters in length.
- May contain only letters, numbers, underscores, and dots.

<ins>isUsernameUnique</ins>: Checks whether the given username is unique by comparing it to a list of existing usernames.

<ins>isPasswordValid</ins>: Use it to check if the password is valid to then call checkPass.
- For more than 7 characters.
- If it is, then it calls the checkPass method.
- Has a number.

<ins>checkPass</ins>: Checks if password has all requirements:
- Has caps.
- Has a lowercase letter.
- Has special character(!, -, *,.).

<ins>isDescriptionValid</ins>: Use it to validate is the description is valid.
- Must not be empty.
- Shouldn't be more than 1000 characters long.

<ins>isPhoneNumValid</ins>: Use it to validate a phone number based on the following requirements:
- Must contain 10 digits.
- May include dashes or spaces.
- Can be empty.

<ins>isDateOfBirthValid</ins>: Use it to validate Date of Birth based on the following requirements:
- Must be a valid date in the format yyyy-MM-dd.
- User must be 18+ years old. 
- Should not be empty.

<ins>isPostalCodeValid</ins>: Use it to validate a postal Code based on the following requirements:
- Must be exactly 5 digits (only for the U.S.A.).
- Can be empty if the postal code is from another country.

<ins>isImage</ins>: Use it to validate if the file is an image.
- It should have the extension JPG or PNG.
- It should not be more than 4 MB in size.

<ins>fileSize:</ins>: Checks if file size is not more than 4MB.

<ins>isMediumValid</ins>:
- Should be one of the accepted media (the field for a painting medium is a dropdown menu). 
- Should not be empty.

<ins>checkTitle</ins>: Use it to validate if a title is more than 0 characters but less than 100 characters.

<ins>validateCreationDate</ins>: Use it to validate a creation date based on the following requirements:
- Must be a valid date in the format yyyy-MM-dd.
- Should not be empty.

<ins>isValidPrice</ins>: Use it to validate the currency.
- Must be a valid currency (US or Canadian dollar, Euro, Mexican Peso, or Bitcoin) in the format 0.00. 
- Can be empty.

<br>

## **REFLECTION** 
**1. How did writing tests first help (or slow down) your development?**

Initially, writing a test before implementing the actual validation methods slowed us down since we would need to test case by case and make our code better in the end. However, this approach required us to think ahead and more carefully about the requirements for each method before writing the implementation. Once we got the hang of the process, it became more intuitive and actually helped us catching bugs and errors earlier earlier than if we had written the implementation first and tested afterward.

<br>

**2.Did your team face any conflicts when merging or reviewing code?** 

Yes, our team did encounter some conflicts when merging and reviewing code. Since we each focused on different validation fields, conflicts naturally appeared when we brought everything together. These conflicts challenged us to more clearly, review review each other's changes more closely, and resolve merge issues collaboratively. In the end, this helped us  ensure  our methods and tests were consistent and readable among each other and for anyone else reading our code.

<br>

**3. How would you expand or refactor your validator for future use?** 

In the future, we could improve the InputValidator class by breaking it into smaller parts. This would make the code easier to manage and update. Right now, all validation methods are grouped into one large class, which makes the file harder to navigate and scale as we add more fields. To improve this, we could split the class into multiple smaller validator classes based on their categories.
For example: 
- UserValidator class will contain methods like: validateUsername, validateEmail, validateDateOfBirth
- ArtworkValidator class will contain methods like: isValidMedium, isValidPrice, isValidDescription
- Contactvalidator class will contain methods like: isPhoneNumValid, isZipCodeValid

We also have duplicate logic like date parsing and empty/null checks, which  could be abstracted into helper methods to avoid repetition and make the code cleaner. In doing this it would helped us also reduce duplication and improve code clarability. 

