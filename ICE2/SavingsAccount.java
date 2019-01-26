public class SavingsAccount
{
  private static double annualInterestRate;
  private double savingsBalance;
  public SavingsAccount()
  {
  }
  public SavingsAccount(double annualInterestRate, double savingsBalance)
  {
    this.annualInterestRate = annualInterestRate;
    this.savingsBalance = savingsBalance;
  }
  
  public double getAnnualInterestRate()
  {
    return this.annualInterestRate;
  }
  public double getSavingsBalance()
  {
    return this.savingsBalance;
  }
  public void setAnnualInterestRate(double annualInterestRate)
  {
    this.annualInterestRate = annualInterestRate;
  }
  public void setSavingsBalance(double savingsBalance)
  {
    this.savingsBalance = savingsBalance;
  }
  public double calculateMonthlyInterest()
  {
    double x = getSavingsBalance();
    double d = getAnnualInterestRate()/100;
    x = x + ((getSavingsBalance() * d)/ 12);   
    setSavingsBalance(x);
    return getSavingsBalance(); 
  }
 public static void modifyInterestRate(double newInterestRate)   
  {
   SavingsAccount sac = new SavingsAccount();
    sac.setAnnualInterestRate(newInterestRate);
  }
}