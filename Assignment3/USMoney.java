/***********************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 3                                    FALL 18
  * zid : z1829984
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  21st sep 2018/assignment3
  * Purpose : To create a USMoney class with three instance variables and using them to calculate 
  *           total amount which includes dollars and cents and also converts the cents to dollars
  *           if the count of cents is greater than 99
  * ********************************************************************************************/

 public class USMoney     /*class USMoney with two private instance variables dollars and cents*/
  {
     private int dollars;
     private int cents;
 USMoney()
  {
   dollars=0;           /*default constructor*/
   cents=0;
  }
 
 public USMoney( int d, int c) /*constructor USMoney with two parameters to initalize the objects*/
  {
   
   if(c > 99)       
    {
      cents=c%100;     /*if the cents value is more than zero, after adding all values,the amount of cents will deducted from tot amount*/
      dollars=d+(c/100);
    }
    else 
    {
      cents = c;
      dollars=d;
    }
  }
  
 
/**************************************************************                                                            
  *  getDollars returns the instance variable dollars.  
  *  getCents returns the instance variable cents
  *  setDollars sets the value of dollars
  *  setCents sets the value of cents
***************************************************************/
 public void setDollars(int dol)
   {
     if(dol<0)
      {
       this.dollars=0;  /* setDollars and setCents are use to set the values of variables*/
      }
    else
       dollars=dol;      /*if the mount of dollars or cents is given negative , it turns out to be 0*/
   }

 public void setCents(int cen)
    {
      if(cen<0)
      {
        this.cents=0;
      }
   else
       cents=cen;
   }
 
 public int getDollars()  /* getDollars and getCents are use to modify and get the values of variables*/
    {
      return dollars;
    }

 public int getCents()
    {
      return cents;
    }
     
 public String toString()  /*converts the object values to string*/
    {
         String str;
         dollars = getDollars() + (getCents() / 100); /*getters are used to assign the calculated values to dollars &cents*/
         cents = getCents() % 100;
         str = " The total amount is : " + "$" + dollars + "." + cents +"";
         return str;
    } 
  
/**********************************************************************
   * USMoney takes the parameter and calculates the total value of
     dollars and cents togethor and return the value. It also
     checks if cents are greater than 100 and converts them to dollars
  *******************************************************************/
    
 public USMoney plus(USMoney C)
  {
    USMoney C1 = new USMoney(dollars,cents);
    C1.dollars = dollars + C.dollars;
    C1.cents = cents + C.cents;
    if(cents < 0 || cents > 99) /*plus method checks for conditions of cents between 0 and 99*/
    {
       dollars = getDollars() + (getCents() / 100);
       cents = (getCents() % 100);
    }
    return C1;                 /*retunrs the value c1*/                      
  }
 
}