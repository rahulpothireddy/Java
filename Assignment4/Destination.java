/***************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 4                                  FALL 18
  * zid : z1829984
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  5th Oct 2018/assignment4
  * Purpose : Its a java console program which displays the travell history of flyer and the conditions
  *           on frequency of flying using the miles travelled. Here in this program, all the required variables
  *           used for programming, and their instantiation using contructors, also declaring setters and getters
  * ************************************************************************************************************/

/*class Destination to intialize the variables given*/
public class Destination 
{
 private String destinationCity;
 private int normalMiles;
 private int frequentFlyerMiles;
 private int upgradeMiles;
 private int startMonth;
 private int endMonth;

 /*contructor "Destination" to instantiate the variables*/
 Destination(String destinationCity, int normalMiles, int frequentFlyerMiles, int upgradeMiles,
  int startMonth, int endMonth) 
 {
  this.destinationCity = destinationCity;
  this.normalMiles = normalMiles;
  this.frequentFlyerMiles = frequentFlyerMiles;
  this.upgradeMiles = upgradeMiles;
  this.startMonth = startMonth;
  this.endMonth = endMonth;
 }

 /*setter and getters for all variables used*/
 public void setDestinationCity(String destinationCity) {
  this.destinationCity = destinationCity;
 }

 public String getDestinationCity() {
  return this.destinationCity;
 }

 public void setNornalMiles(int normalMiles) {
  this.normalMiles = normalMiles;
 }

 public int getNormalMiles() {
  return this.normalMiles;
 }
 
 public void setFrequentFlyerMiles(int frequentFlyerMiles) {
  this.frequentFlyerMiles = frequentFlyerMiles;
 }

 public int getFrequentFlyerMiles() {
  return this.frequentFlyerMiles;
 }

 public void setUpgradeMiles(int upgradeMiles) {
  this.upgradeMiles = upgradeMiles;
 }

 public int getUpgradeMiles() {
  return this.upgradeMiles;
 }

 public void setStartMonth(int startMonth) {
  this.startMonth = startMonth;
 }

 public int getStartMonth() {
  return this.startMonth;
 }

 public void setEndMonth(int endMonth) {
  this.endMonth = endMonth;
 }

 public int getEndMonth() {
  return this.endMonth;
 }
}