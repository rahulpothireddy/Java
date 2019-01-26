/***************************************************************************************************************
  *                                   Assignment 8
  * NAME : Rahul Pothireddy (Team Lead), Karri Hari, Ashton Dsouza                                       FALL 18
  * zid : z1829984 (RP), Z1830680(KH), Z1828205(AD)
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  28th Nov 2018/assignment8
  * Purpose : To encapsulate the logic for redeeming mileage. This program shouldhave private instance variables 
  *          for an array of Destination objects, and an integer to represent the remaining miles after the 
  *          user's Frequent Flyer Miles have been redeemed.
  * ************************************************************************************************************/
import java.util.Scanner; // To take input
import java.io.IOException; // To throw IOException while taking input
import java.util.ArrayList; // To create an arraylist of the type Destination
import java.util.Arrays; // To use create arrays and use Arrays.sort()


/* The Class which will perform the entire functioning of the Miles Redemption App 
 * Each method in it is explained below. It is used to drive the program */

public class MileRedeemer 
{
  
 
  public Destination[] destinationArray; // This array holds all the objects of the type Destination[]
  
  ArrayList<Destination> destinationList = new ArrayList<Destination>(); // This is the arraylist which will be used to store the Destination objects when they are read in the input.
  
  public int remainingMiles = 0; // A variable to help me track and store the remaining miles.
  
  /* Allows me to set the destination array in the readDestination() method to be able to use it in other methods */
  
  public void setDestinationArray(Destination[] destinationArray)
  {
    this.destinationArray = destinationArray;
  }
  
  /* Allows me to retreive the destinationArray when it is required */
  
  public Destination[] getDestinationArray()
  {
    return this.destinationArray;
  }
  
  /* Setter for the variable Remaining miles declared above */
   
   public void setRemainingMiles(int miles)
  {
    this.remainingMiles = miles;
  }
  
  /* Getter for the variable Remaining miles declared above */
   
  
  public int getRemainingMiles()
  {
    return this.remainingMiles;
  }
  
  
  
  
  /* Method which reads the input from a filename typed into the system and splits it in a way
   * that it forms objects of the type Destination[] and stores it in an arraylist.
   * This arraylist is then converted into an array for sorting purposes and then sorted.
   * Also sets the destinationArray */
  
  public void readDestination(Scanner fileScan) throws IOException
  {
    
    String record=""; // String to hold the input
    
    while (fileScan.hasNext()) // Read till end
    {
      record = fileScan.nextLine(); // Store line on the string
      
      /* Splits the line by ; . For example we get Berlin 17250 12750 5250 3-5 */
      
      String[] splits = record.split(";");
      
      /* Splits the element at index 4 ie. 3-5 into 3 and 5 by removing the - */
      
      String[] months = splits[4].split("-");
      
      /* Adds the splitted parts into the arrayList destinationList in the format of its parameters 
       * Since all the parameters except the first one are integers in class Destination I use Integer.parseInt() to convert the string into Integers */
      
      destinationList.add(new Destination(splits[0],Integer.parseInt(splits[1]),Integer.parseInt(splits[2]),Integer.parseInt(splits[3]),Integer.parseInt(months[0]),Integer.parseInt(months[1])));
    
    }
    
    // Assigns the array destinationArray its size based on the number of lines in the text file 
    Destination[] destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
    
    // Using the Arrays.sort(array,comparator) We sort the array elements on the descending order of thier normalMiles
    
    Arrays.sort(destinationArray, new MileageComparator());
    
    // Sets the destination array to use in other functions.
    setDestinationArray(destinationArray);
  }

  
  
  
/* Returns the String array of city names sorted alphabetically to display on console */
    
  public String[] getCityNames()
  {
    destinationArray = getDestinationArray(); // Get the destinationArray containing all the Destination Objects
    
    String[] cityList = new String[destinationArray.length]; // Initializing string to hold the city names
    
    /* While looping through destinationArray we add the city names to the String cityList 
     * with help of the method getDestinationCity of Class Destination */
    
    for (int i = 0; i < destinationArray.length; i++)
    {
      
      cityList[i] = destinationArray[i].getDestinationCity();
    
    }
    
    
   Arrays.sort(cityList); // Sorting in ascending order.
 
   return cityList;
    
  }
  
/* Returns String array containing list of cities the client can afford travel tickets and thier flight status (Economy/first) 
 * given thier frequent flyer miles and the month in which they will be using those miles */
  
  public String[] redeemMiles(int miles, int month) 
  {
    String[] affordableCityList = new String[destinationArray.length]; // String array to hold the list of cities 
    String eco = " in Economy Class "; // String to append if they dont qualify for first class
    String first = " in First Class "; // String to append if they qualify for first class
    String city =""; // String to hold a city name
    
    
    // Loops through every single destinationArray element
    
    for (int i = 0; i < destinationArray.length; i++)
    {
      // Checks if the client is flying within the frequent flyer months of the destinationCity
      if ( month >= destinationArray[i].getStartMonth() && month <= destinationArray[i].getEndMonth())
      {
        /* If they are indeed doing so, then we check if they have enough miles to do so.
         * If they do have enough miles we substract them from the total miles and
         * add the city name to affordableCityList array */
        
        if ( miles > destinationArray[i].getFrequentMiles() )
        {
          
        miles = miles - destinationArray[i].getFrequentMiles();
        affordableCityList[i] = (destinationArray[i].getDestinationCity());
        
        }
      }
      // This will be true for when they fly in the off season
      // Same as above we substract and add city name to the list
      else if( miles > destinationArray[i].getNormalMiles() )
      {
  
        miles = miles - destinationArray[i].getNormalMiles();
        affordableCityList[i] = destinationArray[i].getDestinationCity();
       
    
      }
      
    } 
    // Setting the variable miles to check the class later
    
      setRemainingMiles(miles); 
    
    // The code below checks if they will be in economy class or first class
    
    String[] flightStyle = new String[affordableCityList.length]; // String that will be returned to the main program which includes the flight style

    
    // Looping throught the list of cities the client can afford travel to and fro.
    for (int i =0; i < affordableCityList.length;i++)
    {
     if (affordableCityList[i] != null) // Check if the element is not null since we dont need null errors.
     {
       city = destinationArray[i].getDestinationCity(); // Get the city name
       
       // Check if they qualify for first class ie. Remaining miles are more than the additionalMiles needed to upgrade
       if ( miles > destinationArray[i].getAdditionalMiles() ) 
       {
          setRemainingMiles(miles - destinationArray[i].getAdditionalMiles() ); // Reduce the number of miles remaining after upgrade
          flightStyle[i] = city.concat(first); // Concat the first class string
       }
       else flightStyle[i] = city.concat(eco); // Else concat the economy class string
     }
   }
   return flightStyle; // Return the elements
  } 
}