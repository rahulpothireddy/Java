/********************************************************************************************************************
  * NAME : Rahul Pothireddy               ASSIGNEMENT 3                                        FALL 2018
  * zid : z1829984
  * Instructor : Prof Geoffrey Decker
  * section : CSCI 502
  * Assignment Due :  21st sep 2018/assignment3
  * Purpose : To create a USMoney class with two instance (dollars and cents) variables and 
  *           using them to calculate total amount which includes dollars and cents taken as 
  *           input from keyboard  and also converts the cents to dollars if the count of cents is greater than 99.
  * *****************************************************************************************************************/
import java.util.Scanner; /*importin the required package*/
public class USMoneyDemo extends USMoney
{
  public static void main(String[]args)
  {
    Scanner input = new Scanner (System.in);
    USMoney x = new USMoney(); /*object x with two parameters*/
    USMoney y = new USMoney();
    System.out.print("Enter the dollars"); /*prompts to enter the input of dollars */
    int dollars = input.nextInt(); /*reads the input of dollars */
    x.setDollars(dollars);
    System.out.print("Enter cents");       /*prompts to enter the input of cents */
    int cents = input.nextInt();           /*reads the input of cents */
    x.setCents(cents);
    System.out.println("Entered dollars : "+ x.getDollars()); 
    System.out.println("Entered cents : "+ x.getCents());
    
    System.out.println("Enter the dollars"); /*prompts to enter the input of dollars */
    int dollars1 = input.nextInt();   /*reads the input of dollars */
    y.setDollars(dollars1);
    System.out.print("Enter cents");       /*prompts to enter the input of cents */
    int cents1 = input.nextInt();          /*reads the input of cents */     
    y.setCents(cents1);
    System.out.println("Entered dollars : "+ y.getDollars()); 
    System.out.println("Entered cents : "+ y.getCents());
    
    input.close();
    USMoney z = x.plus(y);                 /*adds the values of dollars and cents and stores the result in z*/
    System.out.print( z.toString()); /*displays the final result i.e, total amount*/
     
  }
}
    
   