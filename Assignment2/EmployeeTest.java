import java.util.Scanner; /*importing required packages*/

public class EmployeeTest             
{
  public static void main(String [] args)  /*creating main function*/
  {
    Scanner input = new Scanner(System.in);  /* new input*/
    System.out.println("First employee details");  /* employee 1 details*/
    System.out.println("Enter First Name :");  
    String firstname = input.nextLine();       /*reads employee 1's first name*/
    System.out.println("Enter Last Name : ");
    String lastname = input.nextLine();        /*reads employee 1's last name*/
    System.out.println("Enter Monthly Salary :");
    double monthlysalary = input.nextDouble();    /*reads employee 1's  monthly salary*/
    
    Employee e1 = new Employee(firstname, lastname, monthlysalary); /*first employee object creation*/
    System.out.println("First Employee: "+e1.getFirstName()+" "+e1.getLastName()+"\n"); /*employee 1's yearly salary is calculated and displayed from employee class*/
    System.out.println("The salary  for 1 year :"+e1.getYearlySalary()+"\n\n");
    e1.salaryraise();System.out.println("After Increase the salary is: "+e1.getMonthlySalary()); /*increase in yearly ssalary*/
    input.close(); 
   
    Scanner input1 = new Scanner(System.in);  
    String firstname1 = " ";
    System.out.println("Second Employee details");
    System.out.println("Enter First Name :"); 
    firstname1 = input1.nextLine();             /*reads employee 2's first name*/
    System.out.println("Enter Last Name : ");
    String lastname1 = input1.nextLine();       /*reads employee 2's last name*/
    System.out.println("Enter Monthly Salary :");
    double monthlysalary1 = input1.nextDouble();/*reads employee 2's monthly salary*/
    
    Employee e2 = new Employee(firstname1, lastname1, monthlysalary1); /*second employee object creation*/
    System.out.println("Second Employee: "+e2.getFirstName()+" "+e2.getLastName()+"\n");
    System.out.println("The salary  for 1 year :"+e2.getYearlySalary()+"\n\n"); /*calculating the yearly salary from  function in employee class*/
    e2.salaryraise();System.out.println("After Increase the salary is: "+e2.getMonthlySalary()); /*increase in yearly salary by 0.1%*/
    input1.close();
}
}

