/***************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 5                                FALL 18
  * zid : z1829984
  * section : CSCI 502/section 1
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  12th Oct 2018/assignment5
  * Purpose : To write a program that adds detaisl given by the user into a address book which already exists
  * ************************************************************************************************************/
/*Imports the required packages for the program*/
import java.io.*;
import java.lang.*;
import java.util.*;

/*****************************************************************************************************
  * Name : AddressBookEntry
  * Use :Address book entry class is called along with the variables like name, email and cell number 
  *      which are needed
  ****************************************************************************************************/
public class AddressBookEntry 
{
 private String name;
 private String email;
 private String cellNumber;
/*constructor is called with three parameters  and their types*/
 AddressBookEntry(String name, String email, String cellNumber) 
 {
/*this is a keyword used for reference*/
  this.name = name;
  this.email = email;
  this.cellNumber = cellNumber;
 }
/*setters and getters methods are implemented where get methods returns the instance varaibles and set method is used to set/modify its value*/
 public String getName()
 {
  return this.name;
 }

 public String getEmail() 
 {
  return this.email;
 }

 public String getCellNumber()
 {
  return this.cellNumber;
 }

 public void setName(String name)
 {
  this.name = name;
 }

 public void setEmail(String email) 
 {
  this.email = email;
 }

 public void setCellNumber(String cellNumber)
 {
  this.cellNumber = cellNumber;
 }
}