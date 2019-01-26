import java.util.Scanner;
import java.io.IOException;

public class MileRedeemer
{
  //AraayList<Destination> destinationsList = new ArrayList<Destination>();
  
  public void readDestinations(Scanner fileScan) throws IOException
  {
     String record;
     
     while (fileScan.hasNext())
     {
       record =fileScan.nextLine();
       
       System.out.println(record);
  }
}
}