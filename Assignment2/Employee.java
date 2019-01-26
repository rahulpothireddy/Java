/***************************************************************************************************************
  * Name : Rahul Pothireddy
  * ZID : Z1829984
  * question  : 3.13
  * section : csci 502
  * Assignement 2 Due on 14th sep2018
  * Purpose : To create a employee class with three instances and then create a test case named employeetest to 
              display the employee's yearly salary and yearly salary after 0.1% increase.
  **************************************************************************************************************/
/*creating a class employee and declaring instances*/
public class Employee 
{
  private String FirstName;   
  private String LastName;
  private double MonthlySalary;
  private double YearlySalary;
 /* creating a constructor and initialising instances*/
  Employee(String firstname, String lastname, double monthlysalary)
  {
    FirstName = firstname;      
    LastName = lastname;
    MonthlySalary = monthlysalary;
    
  }
  //Accessor methods 
  
  public void setFirstName(String firstname)
  {
    FirstName = firstname;               /*set and get methods for first name detaisl*/
  }
  
  public String getFirstName()
  {
    return FirstName;
  }
  
  
   public void setLastName(String lastname)
  {
    LastName = lastname;                 /*set and get methods for last name detaisl*/
  }
  
  public String getLastName()
  {
    return LastName;
  }
  
   public void setMonthlySalary(double monthlysalary)   /*set and get methods for monthly salary detaisl*/
  {
    if(monthlysalary >0.0) //condition to check whether the salary is greater than zero
    MonthlySalary = monthlysalary;
    else if(monthlysalary<0.0)
      System.out.println("invalid");
  }
  
  public double getMonthlySalary()
  {
    return MonthlySalary;
   
  }
  public double getYearlySalary() /*function to get yearly salary taking a month's salary as input*/
  {
    YearlySalary= MonthlySalary*12;  /*yearly salary is calculated by multiplying monthly salary into 12 times*/
    return YearlySalary;
  }
  public void salaryraise(){
    double yearly = (getYearlySalary())/10.00;
    double newSalary = getYearlySalary() + yearly;       /*raise in the salary is calucalted by incrementing 0.1%*/
    setMonthlySalary(newSalary);
}
  
}