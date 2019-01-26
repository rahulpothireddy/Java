import java.util.Scanner; /*importing package*/
 
public class DateTest {
  
  /* main function */
  public static void main (String [] args) {
         
        /*new object creation and giving default values*/
        Date display = new Date (0,0,0);
        Scanner input = new Scanner (System.in);
        /*entering the values which are taken from the keyboard*/
        System.out.print ("Enter Month: ");
        display.setMonth(input.nextInt()); /*takes the value for month*/
        System.out.print ("Enter Day: ");
        display.setDay(input.nextInt());  /*takes the value for day*/
        System.out.print ("Enter Year: ");
        display.setYear(input.nextInt()); /*takes the vslue for year*/
        display.displayDate();
        input.close();
    }
}