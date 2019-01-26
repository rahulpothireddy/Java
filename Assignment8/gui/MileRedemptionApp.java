/**************************************************************************************************************************
  *                                   Assignment 8
  * NAME : Rahul Pothireddy (Team Lead), Karri Hari, Ashton Dsouza                                       FALL 18
  * zid : z1829984 (RP), Z1830680(KH), Z1828205(AD)
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  28th Nov 2018/assignment8
  * Purpose : :MileedemptionApp takes the input of source file, and after reading displays the welcome message and 
  *           the destinations list the client has travelled to. Then takes the option of y-yes and n-no to contiue.
  *           If y-then ask for accumulated frequent miles of client and month of departure then displays the remaining 
  *           frequent miles to be accumulated and finally to execute the button-n- which displays a bye(courtsey) 
  *           messsage.
  * **********************************************************************************************************************/
/*******************************************
  * Importing the required packages
  * ****************************************/
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.util.Scanner;      // To take input
import java.io.File;           // To handle files
import java.io.IOException;    // To Throw IOException
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;


/* Main class to run the console program based on methods in MileRedeemer and Destination */
public class MileRedemptionApp extends JFrame
{
  public static void main(String[] args) throws IOException // Catch input/output exceptions
  { 
       GUI i = new GUI(); /*new object i for gui*/
       i.setVisible(true); /*set visible true*/
       i.setSize(790,340); /*setting size points*/
       i.setResizable(false);/*resizable cannot be done*/
       i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       i.setLayout(new FlowLayout()); /*flow layout is used to add attributes from left to right in the given sequence*/
  }
}