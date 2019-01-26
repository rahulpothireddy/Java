/************************************************************
 *                                                          *
 *  CSCI 502          Assignment 4           Fall 2018      *                                             
 *                                                          *
 *  Programmer: Ashton Dsouza (Z1828205)                    *  
 *                                                          *
 *  Date Due:   10/05/2018  11.59pm                         *                          
 *                                                          *
 *  Purpose:    To create a java console program            *
 *              to be able to book flights                  *
 *                                                          *
 *                                                          * 
 ***********************************************************/

import java.util.Comparator; // To use the comparator package.


/* Allows us to compare the normalMiles variable of two objects of the type Destination and gives us the Bigger one.
 * Thus we get the list of the farthest cities in descending order */


public class MileageComparator implements Comparator<Destination> 
{
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.getNormalMiles() - d1.getNormalMiles());
   }
}
