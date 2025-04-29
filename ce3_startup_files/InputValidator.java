/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * Methods to validate inputs from the user. 
 */

public class InputValidator 
{
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
    public static boolean checkPass(String password)
    {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;

        for (int i = 0; i < password.length(); i++)
        {
         c = password.charAt(i);
         if(Character.isDigit(c))
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
        if(hasNum && hasCap && hasLow)
        {
            return true;
        }
        }
        return false;
    }

}
