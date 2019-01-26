/***************************************************************************************************************
  *                                   Assignment 8
  * NAME : Rahul Pothireddy (Team Lead), Karri Hari, Ashton Dsouza                                       FALL 18
  * zid : z1829984 (RP), Z1830680(KH), Z1828205(AD)
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  28th Nov 2018/assignment8
  * Purpose : Its a java console program which calcultes the difference between the miles
  * ************************************************************************************************************/

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
