import java.util.*;
import java.io.*;
import java.lang.*;

public class Validator
{
 // validate menu choices
 public static boolean checkMenuChoice(int choice)
 {
  if (choice < 1 || choice>3)
   return false;
  return true;
 }

 // validate non empty values for name, email and cellNumber
 
 public static boolean checkName(String name) 
 {
   
   List<String> specialCharactersInSolr = Arrays.asList(new String[]{
            "+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^",
            "~", "*", "?", ":","\"","\\"," "});
   int i=0;
   for(i=0;i<name.length();i++)
   {
     char c = name.charAt(i);
     if(specialCharactersInSolr.contains(c))
     {
       return false;
     }
   }
   return true;
}
 
 
 
 public static boolean checkInput(String email) 
 {
   
   List<String> specialCharactersInSolr = Arrays.asList(new String[]{
            "@", "."});
   int i=0;
   for(i=0;i<email.length();i++)
   {
     char c=email.charAt(i);
     if(specialCharactersInSolr.contains(c))
     {
       return false;
     }
   }
   return true;
}
 
 public static boolean checkPhone(String phone) 
 {
   
   List<String> specialCharactersInSolr = Arrays.asList(new String[]{
            "1", "2","3","4","5","6","7","8","9","0"});
   int i=0;
   if(phone.length()==10)
   {
     for(i=0;i<phone.length();i++)
     {
       char c = phone.charAt(i);
       if(!specialCharactersInSolr.contains(c))
       {
         return false;
       }
     }
     return true;
   }
   return false;
}
}