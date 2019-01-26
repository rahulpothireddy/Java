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
/*imports the required packages needed for the program*/
import java.lang.*;
import java.io.*;
import java.util.*;

/*********************************************************************************************************************
  * Name: AddressBookEntryApp
  * Use : This class intitially displays the menu options and asks the user to enter from one of the below options.
  *       If the option entered is one then it displays the list of entries and if the otion is 2 then it promts the 
  *       user to enter name, email address and cell number. Here it also checks if the details entered in any options
  *       is valid(correct).
  ********************************************************************************************************************/
class AddressBookEntryApp
{
 public static void main(String args[])
 {
  /*Takes the input from the user*/
  Scanner sc = new Scanner(System.in);
  int choice;
  boolean name1,email1,cell1; 
  String name,email,cellNumber;
  System.out.println("Welcome to the Address Book Application\n");
  do
  {
  /*Options that are intially displayed*/
   System.out.println("1. List entries");
   System.out.println("2. Add entry");
   System.out.println("3. Exit\n");
   System.out.print("Enter Menu Number: ");
   choice = sc.nextInt();
   if(Validator.checkMenuChoice(choice) == false) {
    choice = 5;
   }
   String eatNewLine = sc.nextLine(); 
   switch(choice)
   {
  /*switch case is implemented for different otions taken as different cases*/   
    case 1: String entries = AddressBookIO.getEntriesString();
      System.out.println("\n" + entries);
      break;
  /*Prompts to enter a name, and validates the input given by user by calling the validator class and also using flags(c1,c2,c3)*/  
     case 2: 
  /*intially the flag c1 is 0, if name i coreect then it is made 1 else again shows 0 -promting the user to enter the name again*/    
       int c1 = 0; 
       do{
       System.out.print("\nEnter Name: ");
       name = sc.nextLine();
       name1 = Validator.checkName(name);
       if(name1 == false)
       {
       System.out.println("Name validation fails, kindly re-enter");
       }
       else{
       c1 =1;
       }
      }while(c1==0);
  /*Prompts to enter a email, and validates the input given by user by calling the validator class*/     
       int c2=0;
       do{
       System.out.print("Enter email Address: ");
       email = sc.nextLine();
       email1 = Validator.checkEmail(email);
       if(email1 == false)
       {
       System.out.println("email validation fails, kindly re-enter");
       }
       else{
       c2 = 1;
      }
     }while(c2==0);
  /*Prompts to enter a name, and validates the input given by user by calling the validator class*/     
       int c3 =0;
       do{ 
       System.out.print("Enter Phone Number: ");
       cellNumber = sc.nextLine();
       cell1= Validator.checkCellNumber(cellNumber);
       if(cell1 == false)
       {
       System.out.println("cellNumber validation fails, kindly re-enter");
       }
       else{
       c3 =1;
       }
      }while(c3==0);
       AddressBookEntry abeObj = new AddressBookEntry(name, email, cellNumber);
       if(AddressBookIO.saveEntry(abeObj))
       {
       System.out.println("\nThis entry has been saved.");
       }
       else{
       System.out.println("Error in saving entry, please try again");
       }
       break;
  /*displays the good bye message*/    
    case 3: System.out.println("\nGoodbye.");
    break;
    default: System.out.println("\nInvalid choice");
    break;
   }
  }while(choice != 3);
 }
}