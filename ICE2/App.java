/************************************************************
 *                                                          *
 *  CSCI 470/502     In-Class Exercise 2        Fall 2018   *                        
 *                                                          *
 *  Programmer:  Rahul Pothireddy  Z1829984                 *  
 *               Ashton Dsouza Z1828200                    *
 *               Hari Karri Z1830680                        * 
 *                                                          *   
 *                                                          *
 *  Purpose:    To study Classes and Methods. It calculates *
 *              monthly interest at rate of 4% and 5%       *      
 *  Dat Due: 10-03-2018 11.59 P.M                           *                             *
 ************************************************************/ 
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App
{
  public static void displayBalances(double balance)
  {   
    DecimalFormat moneyFormat = new DecimalFormat("$###,##0.00");
    System.out.printf("  %11s", moneyFormat.format(balance));
  }
  public static void main (String[] args)
  {
    //Scanner sc = new Scanner(System.in);
    ArrayList<SavingsAccount> accountList = new ArrayList<SavingsAccount>();
    SavingsAccount account1 = new SavingsAccount(4,3000);
    SavingsAccount account2 = new SavingsAccount(4,4000);
    SavingsAccount account3 = new SavingsAccount(4,5000);
    SavingsAccount account4 = new SavingsAccount(4,6000);
    SavingsAccount account5 = new SavingsAccount(4,7000);
    accountList.add(account1);
    accountList.add(account2);
    accountList.add(account3);
    accountList.add(account4);
    accountList.add(account5);
    System.out.print("Monthly Interest Growth");
    System.out.println("\tInterest Rate : 4%");
    System.out.print("Accounts");
    for(int j = 1; j <= 12; j++)
    {
      System.out.print("      Month"+j+" ");
     }
    System.out.println("");
    SavingsAccount[] savingsArray = (SavingsAccount[]) accountList.toArray(new SavingsAccount[accountList.size()]);
    for(int i = 0; i< savingsArray.length ; i++)
    {
     System.out.print("Accounts"+(i+1));
     savingsArray[i].modifyInterestRate(4);
     for(int j = 0; j < 12; j++)
     {
      double saa = savingsArray[i].calculateMonthlyInterest();  
      displayBalances(saa);
     }
     System.out.println(" ");
    }
    System.out.println("Interest Rate : 5% ");
    ArrayList<SavingsAccount> accountList1 = new ArrayList<SavingsAccount>();
    SavingsAccount account11 = new SavingsAccount(4,3000);
    SavingsAccount account12 = new SavingsAccount(4,4000);
    SavingsAccount account13 = new SavingsAccount(4,5000);
    SavingsAccount account14 = new SavingsAccount(4,6000);
    SavingsAccount account15 = new SavingsAccount(4,7000);
    accountList1.add(account11);
    accountList1.add(account12);
    accountList1.add(account13);
    accountList1.add(account14);
    accountList1.add(account15);
    SavingsAccount[] savingsArray1 = (SavingsAccount[]) accountList1.toArray(new SavingsAccount[accountList1.size()]);
    System.out.print("Accounts");
    for(int j = 1; j <= 12; j++)
    {
      System.out.print("      Month"+j+" ");
    }
    System.out.println("");
    for(int i = 0; i< savingsArray1.length ; i++)
    {
      savingsArray1[i].modifyInterestRate(5);
      System.out.print("Accounts"+(i+1));
      for(int j = 0; j < 12; j++)
      {
        double saa = savingsArray1[i].calculateMonthlyInterest();  
        displayBalances(saa);
      }
      System.out.println(" ");
    }
  }
}