/********************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 4                                  FALL 18
  * zid : z1829984
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due : 5th Oct 2018/assignment4
  * Purpose :MileedemptionApp takes the input of source file, and after reading displays the welcome message and 
  *          the destinations list the client has travelled to. Then takes the option of y-yes and n-no to contiue.
  *         If y-then ask for accumulated frequent miles of client and month of departure then displays the remaining 
  *         frequent miles to be accumulated and finally to execute the button-n- which displays a bye(courtsey) 
  *         messsage. 
  *******************************************************************************************************************/
 import java.io.*;  /*importing all the required packages*/
 import java.util.*;
 public class MileRedemptionApp {
 public static void main(String[] args) throws IOException {
 Scanner sc = new Scanner(System.in);
 MileRedeemer mr = new MileRedeemer();
 /*reads the destinations files list and also the miles*/
 System.out.print("Please enter the name of the file: destination ");
 String filename = sc.next();
 Scanner fc = new Scanner(new FileInputStream(filename));
 mr.readDestinations(fc);
 /*displays a welcome message and whe given the mileage.txt file displays all the cities travelled to*/
 System.out.println("\n ----------------------------------------------------------------" +
 "\nWELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP" +
 "\n----------------------------------------------------------------" + 
 "\n\nList of destination cities your client can travel to:\n\n");
 String[] cityNames = mr.getCityNames();
 for(int i=0; i<cityNames.length; i++) {
 System.out.println(cityNames[i]);
 }
 
 /*if the choice of users is given y-yes, then it prompts the user to enter accumulated frequent miles and month of departure*/
 char choice = 'y';
 do{
 System.out.println("----------------------------------------------------------------\n");
 System.out.print("Please enter your client's accumulated Frequent Flyer Miles: ");
 int flyerMiles = sc.nextInt();  
 System.out.print("Please enter your client's month of departure (1-12):  ");
 int month = sc.nextInt();
 String[] ans = mr.redeemMiles(flyerMiles, month);
 if(ans.length == 1 && ans[0].charAt(1) == '*'){
 /*displays a message which has not got enough frequent flyer miles*/  
 System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
 System.out.println("Your client's remaining flyer miles are :" +flyerMiles);
 }
 else {
 for(int i=0; i<ans.length; i++){
 System.out.println(ans[i]);
 }
}
 System.out.print("Do you want to continue (y/n)? ");
 choice = sc.next().charAt(0);
 }while(choice == 'y' || choice == 'Y');
 sc.close();
 fc.close();
 System.out.println("\n-------------------------------------------------------------------------" +
 "\nTHANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP" +
 "\n-------------------------------------------------------------------------");
 }
}