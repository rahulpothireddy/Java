/***********************************************************************************************
  * NAME : Rahul Pothireddy           ASSIGNMENT 3                         FALL 2018
  * zid : z1829984
  * section : CSCI 502
  * Assignment Due :  21st sep 2018/assignment3
  * Purpose : To create a date class with three instance variables and using them to calculate 
  *           number of days since january 1st of the same year by reading the input values of
  *           day, month, year from the user and calling the function from the other file to 
  *           return the number of days since jan1.
  * ********************************************************************************************/
import java.util.Scanner; /*importing the required package*/
public class DateDemo extends Date
{
  public static void main(String[]args)
  {
     Scanner input = new Scanner (System.in); 
     System.out.print("Enter the Day");   /*prompting to enter the day*/
     int day = input.nextInt();           /*reading the values of day input*/
     System.out.print("Enter the Month"); /*prompting to enter the month*/
     int month = input.nextInt();         /*reading the values of month input*/
     System.out.print("Enter the Year");  /*prompting to enter the year*/
     int year = input.nextInt();          /*reading the values of year input*/
     Date days = new Date(day, month, year); /*the day object with three paramters*/
     System.out.print("Total Days: " +days.daysSincejan1()); /*displays the final results i.e, days since jan1*/
     input.close();
  }
}