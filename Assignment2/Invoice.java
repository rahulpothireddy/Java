/**********************************************************************************************************
  * Name : Rahul Pothireddy
  * ZID : Z1829984
  * Question : 3.12
  * section : csci 502
  * Assignement 2 Due on 14th sep2018
  * Purpose : To create a invoice class with isntances and then creation a test case named invoice test to 
              display the the amount for total number of items purchased.
  *********************************************************************************************************/



public class Invoice
{
  /*creating invoice class instance variables along with data type*/
    private String partnum;          /*type of the variable is provied i.e, string,int, double*/
    private String partdesc;
    private int itemquan;
    private double priceperitem;
    
    
   /*intializing instance and creating a  constructor*/ 
    public Invoice(String num, String des, int quan, double priceitem)
    {
      partnum = num;             /* assigning the varibales    */
      partdesc = des;
      itemquan = quan;
      priceperitem = priceitem;
    }
    
    
    
    /*set and get methods */
    
    public void setpartnum(String num)  /*setting the partnum*/
    {
      partnum = num;
    }
    public String getpartnum()
    {
      return partnum;            /*getting the partnum*/
    }
    
    public void setpartdesc(String des) /* setting the partdescription*/
    {
      partdesc = des;
    }
    public String getpartdesc() /*getting the description of the part after giving input*/
    {
      return partdesc;
    }
    
    public void setitemquan(int quan) /*set method for itemquantity*/
    {
       itemquan = quan;          /* checking the conditions for quantity i.e, if quantity is less than 0, then set it to zero */
       if(itemquan<0)
       quan=0;
    }
    public int getitemquan() /*get the item quantity*/
    {
      return itemquan;
    }
    
    public void setpriceperitem(double priceitem)  /*setting method for the item of price*/
    {
      priceperitem = priceitem;    /*checking condition if the price is less than 0*/
      if(priceitem<0)
      priceperitem = 0.0;
    }
    public double getpriceperitem()
    {
      return priceperitem;
    }

    /*calculate the total amount */
    public double getInvoiceAmount()
    { 
    double amount;  /*type of amount is double*/
     amount = priceperitem*itemquan; /*calculating amount by multuplying*/
     return amount;
    }  
}

