import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class Validator
{
	// validate menu choices
	public static boolean checkMenuChoice(int choice)
	{
		if (choice < 1 || choice>3)
			return false;
		return true;
	}

	// validate name
	public static boolean checkName(String name) 
	{
		String regexUserName = "^[A-Za-z\\.\\-\\s]+$";
		if(Validator.validate(regexUserName, name))
		{
			return true;
		}
		return false;
	}

	// validate email
	public static boolean checkEmail(String email) 
	{
		String regexUserName = "^(.+)@(.+.com)$";
		if(Validator.validate(regexUserName, email))
		{
			return true;
		}
		return false;
	}

	// validate cell number
	public static boolean checkCellNumber(String cellNumber) 
	{
		String regexUserName = "^(\\(?[0-9]{3}\\)?)((\\s|\\-){1})?[0-9]{3}((\\s|\\-){1})?[0-9]{4}$";
		if(Validator.validate(regexUserName, cellNumber))
		{
			return true;
		}
		return false;
	}

	public static boolean validate(String regex, String toValidate) 
	{
		Pattern pattern = Pattern.compile(new String (regex));
	    Matcher matcher = pattern.matcher(toValidate);
	    if(matcher.matches())
	    {
	         //if pattern matches
	    	return true;
	    }
        //if pattern does not matches
    	return false;
	}
	// // validate non empty values for name, email and cellNumber
	// public static boolean checkInput(String input)
	// {
	// 	if(input.length() == 0)
	// 		return false;
	// 	return true;
	// }
}