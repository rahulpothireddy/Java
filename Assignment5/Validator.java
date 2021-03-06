/***************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 5                                FALL 18
  * zid : z1829984
  * section : CSCI 502/section 1
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  12th Oct 2018/assignment5
  * Purpose : This program is a test if a program can be enhanced an existing application given a minimum of 
  *           description and one of the classes necessary.Initially dispalys 3 menu options and has few entries.
  *           The program helps in adding details to the address book and check or validates if the data entered
  *            is correct(valid)
  * ************************************************************************************************************/
/*imports the required packages*/
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class Validator
{
/* validate menu choices*/
public static boolean checkMenuChoice(int choice)
{
 if (choice < 1 || choice>3)
 return false;
 return true;
}

/*validates the nameby checking if the input given by user is valid i.e, no specail characters are given*/
public static boolean checkName(String name) 
{   
 String regexUserName = "^[A-Za-z\\.\\-\\s]+$";
 if(Validator.validate(regexUserName, name))
 {
  return true;
 }
  return false;
 }

/*validates the email by checking if the input given by the user is valid or not*/
public static boolean checkEmail(String email) 
{
 String regexUserName = "^(.+)@(.+\\.com)$";
 if(Validator.validate(regexUserName, email))
 {
  return true;
 }
  return false;
}

 /*validates the cell number by checking if the user entered proper and valid number*/
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
   /*if the pattern matches  then it returns true*/
    return true;
   }
  /*if the pattern does not match then returns false*/
    return false;
 }
}