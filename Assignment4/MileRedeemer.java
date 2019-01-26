/***************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 4                                  FALL 18
  * zid : z1829984
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due : 5th Oct 2018/assignment4
  * Purpose :To encapsulate the logic for redeeming mileage. This program shouldhave private instance variables 
  *          for an array of Destination objects, and an integer to represent the remaining miles after the 
  *          user's Frequent Flyer Miles have been redeemed.
  ************************************************************************************************************/
import java.io.*;
import java.util.*;

/***********************************************************************************************************
 * Purpsose :Milegage comparator function to calculate the mileage between two destinations
 ***********************************************************************************************************/
class MileageComparator implements Comparator<Destination> 
{
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.getNormalMiles() - d1.getNormalMiles());
   }
}

/****************************************************************************************************************
  * Purpose :MileRedeemer class implements the logic of finding out the redemption of miles based on destination,
  *          number of destination, remaining frequent fyinging miles and then allows you to know how many more 
  *          miles are required to upgrade to higher class.
  ***************************************************************************************************************/
public class MileRedeemer {
 private Destination destination[];
 private int remainingFrequentFlyerMiles;
 private int numberOfDestinations;

/***********************************************************************************************************************
  * Purpose : For this method, we use a Scanner object as the input parameter and reuse it to read files   
              from different sources.  This method should use the Scanner object to read and parse the destination 
              data into an array of Destination objects.Andfinally the method should sort the array of Destination 
              objects in descending order by normal mileage. Also IOException is used to handle erros while reading file
  **********************************************************************************************************************/
public void readDestinations(Scanner fileScanner) throws IOException {
   ArrayList<Destination> destinationList = new ArrayList<Destination>();
   while(fileScanner.hasNext()) {
   String input = fileScanner.nextLine();           
   String[] arrOfStr = input.split(";", 5);
   String destinationCity = arrOfStr[0];
   int normalMiles = Integer.parseInt(arrOfStr[1]);
   int frequentFlyerMiles = Integer.parseInt(arrOfStr[2]);
   int upgradeMiles = Integer.parseInt(arrOfStr[3]);
   String[] month = arrOfStr[4].split("-", 2);
   int startMonth = Integer.parseInt(month[0]);
   int endMonth = Integer.parseInt(month[1]);      /*a new destination object is created*/
   Destination newObj = new Destination(destinationCity, normalMiles, frequentFlyerMiles, upgradeMiles, startMonth, endMonth);
   destinationList.add(newObj);  
   }
   this.numberOfDestinations = destinationList.size();
   Collections.sort(destinationList,new MileageComparator());
  
   destination = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
   }

/**********************************************************************************************************************************
  * Purpose : This getCityNames-method will iterarte through the array of Destination objects and create an array of String objects 
  *           from the city names.  This array can be sorted in ascending order and returned just for the display of 
  *           all possible destinations.
  **********************************************************************************************************************************/
public String[] getCityNames() {
   String name[] = new String[this.numberOfDestinations];
   for(int i=0; i<this.numberOfDestinations; i++) {
   name[i] = destination[i].getDestinationCity();
   }
   Arrays.sort(name);       /*after getting the destination city, it sorts them in ascending order*/
   return name;
   }

/**********************************************************************************************************************************
  * Purpose : This method-redeemmiles, miles is the total available miles, and month is the desired month of departure.This method 
  *           will return an array of String objects containing descriptions of redeemed tickets to be printed out by the main program.
  *           It will also save the miles remaining after the tickets have been redeemed
  *********************************************************************************************************************************/
public String[] redeemMiles(int miles, int month) {
  this.remainingFrequentFlyerMiles = miles;
  ArrayList<String> result = new ArrayList<String>();   /*the result is stored in an array list*/
  ArrayList<String> cityNames = new ArrayList<String>();/*the citynames are stored into an array list */
  int isAnyDestinationSelected = 0;                     /*initally the destinations selected is intialised to 0*/ 
  for(int i=0; i<this.numberOfDestinations; i++) {
  if(destination[i].getStartMonth() == month || month == destination[i].getEndMonth()) {
  if(destination[i].getFrequentFlyerMiles() <= this.getRemainingMiles()) {
  isAnyDestinationSelected = 1;
  result.add("* A trip to " + destination[i].getDestinationCity() + " in Economy"); /*based on start and end months the cities are added to result*/
  cityNames.add(destination[i].getDestinationCity());
  this.remainingFrequentFlyerMiles -= destination[i].getFrequentFlyerMiles(); /*remaining miles are calculated by subtracting it from frequentfylersmiles*/
  }
 } /*the below condition displays the flow of logic when normal miles is less than remaining miles and finally prompts enough miles not accumulated*/
  else {
  if(destination[i].getNormalMiles() <= this.getRemainingMiles()) {
  isAnyDestinationSelected = 1;
  result.add("* A trip to " + destination[i].getDestinationCity() + " in Economy");
  cityNames.add(destination[i].getDestinationCity());
  this.remainingFrequentFlyerMiles -= destination[i].getNormalMiles();
   }
  }
 }
  if(isAnyDestinationSelected == 0) {
  String returnResult[] = new String[1];
  returnResult[0] = "*** Your client has not accumulated enough Frequent Flyer Miles ***";
  return returnResult;
  }
  int it = 0;
  for(int i=0; i<this.numberOfDestinations; i++) {
  if(this.destination[i].getDestinationCity() == cityNames.get(it)) {
  if(this.destination[i].getUpgradeMiles() <= this.getRemainingMiles()) {
  result.set(it, "* A trip to " + this.destination[i].getDestinationCity() + " in first class");
  this.remainingFrequentFlyerMiles -= this.destination[i].getUpgradeMiles();
  }
  it++;
  if(it >= cityNames.size()) {
  break;
  }
 }
}

/*********************************************************************************************************
  * Purpose : This method-returns result i.e, the saved remaining miles.
  * ******************************************************************************************************/
  String returnResult[] = new String[result.size() + 1];
  for(int i=0; i<result.size(); i++) {
  returnResult[i] = result.get(i);
  } /*it just displays the clien's remaining frequent flyer miles*/
  returnResult[result.size()] = "Your client's remaining Frequent Flyer Miles: " + this.getRemainingMiles();
  return returnResult;
  }
  /*gets the remaining miles and returns the final result*/
  public int getRemainingMiles( ) {
  return this.remainingFrequentFlyerMiles;
  }
 }