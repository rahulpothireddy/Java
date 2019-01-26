/***********************************************************************************************
  * NAME : Rahul Pothireddy          ASSIGNEMENT 3                           FALL 2018
  * zid : z1829984
  * section : CSCI 502
  * Assignment Due :  21 st sep 2018/assignment3
  * Purpose : To create a date class with three instance variables and using them to calculate 
  *           number of days since january 1st of the same year and display the result
  * ********************************************************************************************/
  public class Date    /*a class date with three private interger variables */
  {
    private int day;
    private int month ;
    private int year;  
    
  Date()              /*default constructor*/
  {
    day=0;
    month=0;
    year=0;
  }
  
  public Date(int Day, int Month, int Year) /*a construcor with three parameters for instializing the variables*/
  {
    day = Day;
    month = Month;
    year = Year;
    if(month>2)
    {
    if(year % (400) == 0 || (year % 4 ==0 && year% (100) != 0)) /*checking for the conditions of the leap year*/
      {
        day = day+1;                                           /*if it is a leap year then it returns an extra day*/
    }
  }
 }  
    
  
  /***********************************************************************************************************************
    *  The method daySincejan1 takes the value of the day,month and year and calculates the number of days since january1
    *********************************************************************************************************************/
  public int daysSincejan1()
  {
    int high=31;     //highest number of  days for a month i.e, depicts months with 31 days
    int low = 30;    // depicts months with 30 days
    
    if(month==1)     //the block of month=1 is commented because since we are counting days from jan, it isnt required
    {
      day = 0+day;       // it is jsut written to show the sequence of months starting from jan, feb, mar......dec.
    }
    else if(month==2)
    {
      day = day + high;
    }
    else if(month==3)
    {
      day = day + high + 28;                /*using the condition , the days are returned based upon the month number entered*/
    }
    else if(month==4)
    {
      day = day + (high*2) + 28;           /*suppose if the month is 4,techincally april, it sums the days from jan days to the april days*/
    }
   else if(month==5)
    {
      day = day + (high*2) + 28 + (low);
    }
    else if(month==6)
    {
      day = day + (high*3) + 28 + (low);
    }
    else if(month==7)
    {
      day = day + (high*3) + 28 + (low*2) ;
    }
   
    else if(month==8)
    {
      day = day + (high*4) + 28 + (low*2) ;
    }
   else if(month==9)
    {
      day = day + (high *5) + 28 + (low * 2);
    }
    else if(month==10)
    {
      day = day + (high*5) + 28 +(low *3);
    }
    else if(month==11)
    {
     day = day + (high*6) + 28 +(low*3);
    }
    else if(month==12)
    {
    day = day + (high*6) + 28 + (low*4);
    } 
    return day;                                     /*returns day according to day, month year entered*/ 
  }
 }
       
          

    
    
  
  
          

    
    
  