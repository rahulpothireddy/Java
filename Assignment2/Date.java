/*************************************************************************************
  * Name : Rahul Pothireddy
  * ZID : Z1829984
  * section : csci 502
  * question  : 3.14
  * Assignement 2 Due on 14th sep2018
  * Purpose : To create a data class with few isntances and then creation a test case to 
              display the date in the required format(mm/dd/yyyy)
  *************************************************************************************/

/* Class date with instance variables */

public class Date {
    private int year; 
    private int month;
    private int day;
 
    /* creating constructor and initialising the isntaaces  */
    public Date(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }
 
    /*set and get methods*/
    public void setYear(int y){
        year = y;                  /*set method for year*/
    }
    public void setMonth(int m){
        month = m;                 /*set method for month*/
    }
    public void setDay(int d){
        day = d;                   /*set method for day*/
    }
 
    public int getYear(){
        return year;               /*get method for year*/
    }
    public int getMonth(){
        return month;             /*get method for year*/
    }
    public int getDay(){
        return day;               /*get method for year*/
    }
 
    /*writing display date function to display date in the required format*/
    public void displayDate(){
        System.out.println("Today's date is " +month+ "/" +day+ "/" +year+" ");
        
    }
 
}