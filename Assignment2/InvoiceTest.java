import java.util.Scanner; /*importing package*/
public class InvoiceTest /*creating a class InvoiceTest*/
{
  public static void main(String[] args)   /*main function*/
  {
    Invoice invoice = new Invoice("a","b",0,0);  /*new object instantiation by giving some default values*/
     Scanner input = new Scanner(System.in);
        
     System.out.print("Enter the part number: "); /*fetches the get,set methods from invoice program and takes the input of the part number*/
     invoice.setpartnum(input.nextLine());
 
     System.out.print("Enter the part description: ");/*function for part description*/
     invoice.setpartdesc(input.nextLine());

     System.out.print("Enter the quantity : "); /*for quantity of the items*/
     invoice.setitemquan(input.nextInt());  

     System.out.print("Enter the price per item : "); /*for price per item*/
     invoice.setpriceperitem(input.nextDouble());
     
     /* getting the total invoice amount as well as displaying the details */
        System.out.println("The part number is is :"+invoice.getpartnum());
         System.out.println("The part description is :"+invoice.getpartdesc());
       System.out.println("The Total Amount is :"+invoice.getInvoiceAmount());
       input.close();
       
 
    
  }
}
