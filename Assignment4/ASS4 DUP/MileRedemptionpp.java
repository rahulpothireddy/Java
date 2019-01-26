import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MileRedemptionpp
{
  public static void main(String args[]) throws IOException
  {
    String fileName;
    Scanner keyScan = new Scanner (System.in);
    System.out.println("please en;ter the name of detsination file\n : ");
    fileName = keyScan.nextLine();
      Scanner fileScan = new Scanner (new File(fileName));
    MileRedeemer mileRedeemer = new MileRedeemer();
    mileRedeemer.readDestinations(fileScan);
    
    keyScan.close();
    fileScan.close();
  }
}