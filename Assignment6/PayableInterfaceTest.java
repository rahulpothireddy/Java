/***************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 6                               FALL 18
  * zid : z1829984
  * section : CSCI 502/section 1
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  19th Oct 2018/assignment 6
  * Purpose : This program is has a class PayableInterfaceTest where total 6 objects are created and if the 
  *           current is in basepluscommissionEmployee, then calualted the 10% increment in base salary.
  * ************************************************************************************************************/

// Fig. 10.15: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.
public class PayableInterfaceTest 
{
   public static void main(String[] args)
   {
      // create four-element Payable array
      Payable[] payableObjects = new Payable[6];
      
      // populate array with objects that implement Payable.Added three more classes with values passed according to their data type passed
      payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
      payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      payableObjects[2] = 
         new SalariedEmployee("Steve", "Smith", "111-11-1111", 650.00);
      payableObjects[3] = 
         new HourlyEmployee("Karen", "Json", "222-22-2222", 16.75, 40);
      payableObjects[4] = 
         new CommissionEmployee("Mark", "Antony", "333-33-3333", 10000, .08);
      payableObjects[5] = 
         new BasePlusCommissionEmployee("Bobby", "Jones", "444-44-4444", 5000, .04, 400);
         
      //displays the payables and invoices with the classes in it.
      System.out.println("Invoices and Payables are processed polymorphically:"); 
       for (int j = 0; j < payableObjects.length; j++)
         System.out.printf("Payable %d is a %s%n", j, 
            payableObjects[j].getClass().getName()); 
       
      //for loop to iterate all the payableObjects 
      for (Payable currentPayable : payableObjects) 
      {
         System.out.println(currentPayable); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee, if yes performs calculation.
         if (currentPayable instanceof BasePlusCommissionEmployee) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee payableObjects1 = 
               (BasePlusCommissionEmployee) currentPayable;
            //calculates 10% increase in base salary.
            payableObjects1.setBaseSalary(1.10 * payableObjects1.getBaseSalary());

            System.out.printf( "new base salary with 10%% increase is: $%,.2f%n", payableObjects1.getBaseSalary());
         } 
            System.out.printf("earned $%,.2f%n%n", currentPayable.getPaymentAmount());
      } 
   } // end main
}

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/