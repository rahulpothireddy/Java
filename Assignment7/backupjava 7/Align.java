/********************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 7                             FALL 18
  * zid : z1829984
  * section : CSCI 502/section 1
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  7th Nov 2018/assignment 7
  * Purpose : This program implements a a graphical user interface of a simple form kind of structure which has check-
  *           boxes, text fields and 3 buttons. Here the checkboxes and buttons when invoked shows a pop up messages,
  *           but for the text field, after entering the text and then pressing the "enter button" ,will pop up the 
  *           string entered.
  * *****************************************************************************************************************/  
/*importing the required packages*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*creating a class align which extends JFrameand thereby implemets action and key listeners*/
public class Align extends JFrame implements ActionListener, KeyListener
{
 /*declaring the required and given variables*/ 
 JCheckBox snapToGrid, showGrid;
 JLabel xLabel, yLabel;
 JTextField xField, yField;
 JButton ok, cancel, help;
 boolean flag1=true;
 boolean flag2 = true;
 
 public Align()
  {
     super("Align");
     /*creating a container as a whole to place all the objects into it*/
     Container container = getContentPane();
     /*creating the given two lables of checkboxes*/
     snapToGrid = new JCheckBox("Snap to Grid");
     showGrid = new JCheckBox("Show Grid");
     /*creating the text fields and their labels*/
     xLabel = new JLabel("X:");
     yLabel = new JLabel("Y:");
     xField = new JTextField(4);
     yField = new JTextField(4);
     /*creating buttons along with the button names*/
     ok = new JButton("OK");
     cancel = new JButton("Cancel");
     help = new JButton("Help");
     /*vertical boxes for the snapToGrid and showGrid*/
     Box box1 = Box.createVerticalBox();
     Box box2 = Box.createVerticalBox();
     /*creating panels for x and y*/
     JPanel xPanel = new JPanel();
     JPanel yPanel = new JPanel();
     /*creating for ok, cancel and help buttons*/
     JPanel buttonPanel = new JPanel();
     buttonPanel.setLayout(new GridLayout(3, 1,5,5));
    /*Layout is designed in order to allocate a proper position for each element*/
     xPanel.setLayout(new FlowLayout());
     yPanel.setLayout(new FlowLayout());
     xPanel.add(xLabel);
     xPanel.add(xField);
     yPanel.add(yLabel);
     yPanel.add(yField);
   /*setting up the show and snap grids*/
     box1.add(snapToGrid);
     box1.add(showGrid);
   /*Setting up the x and y components*/
     box2.add(xPanel);
     box2.add(yPanel);
  /*setting up buttons*/
     buttonPanel.add(ok);
     buttonPanel.add(cancel);
     buttonPanel.add(help);
  /*action listeners*/
     ok.addActionListener(this);
     ok.addKeyListener(this);
     cancel.addActionListener(this);
     help.addActionListener(this);
     snapToGrid.addActionListener(this);
     showGrid.addActionListener(this);
     xField.addKeyListener(this);
     yField.addKeyListener(this);
 /*adding all the elements to the container*/
     container.setLayout(new FlowLayout());
     container.add(box1);
     container.add(box2);
     container.add(buttonPanel);
     setSize(350, 150);
     setVisible(true);
 }
 
 /***************************************************************************************************************************
  * keypressed is used especially for the purpose of the text fields (x,y).After entering a text in the given box and then
  * pressing the "enter" button, will result in a pop up message by checking for the following conditions as shown below
  ***************************************************************************************************************************/
   public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
    if(xField.getText().isEmpty()){
         /*when there is no text in x field, and there is a text in y field which is displayed*/
         JOptionPane.showMessageDialog(null,"you entered y field: "+yField.getText()); 
          }
          else if(yField.getText().isEmpty())
          {
            /*when there is no text in y field, and there is a text in x field which is displayed*/
            JOptionPane.showMessageDialog(null,"you entered x field: "+xField.getText());
          }
          else
          {
            /*when there is text in both the fields*/
            JOptionPane.showMessageDialog(null,"you entered in both fields : " + xField.getText() + " " + yField.getText());
          }
      }
    }
     /*default methods for some key events*/
     @Override
     public void keyReleased(KeyEvent arg0) {
     }
     @Override
     public void keyTyped(KeyEvent arg0) {
     }
     public void actionPerformed(ActionEvent e)
     {
      if(e.getSource()==ok)
        {
          /*when you perform the action of clicking th "ok" button */
          JOptionPane.showMessageDialog(null," you entered OK");
        }
          /*when you perform the action of clicking th "cancel" button */
         if(e.getSource()==cancel)
        {
          JOptionPane.showMessageDialog(null," you entered cancel");
        }
          if(e.getSource()==help)
        {
          /*when you perform the action of clicking th "help" button */  
         JOptionPane.showMessageDialog(null," you entered help");
        }
          /*displaying a pop up message for snapToGrid when checking and unchecking the boxes*/
          if(e.getSource()==snapToGrid)
        {
            if(flag1==true){  
              flag1 = false;
         JOptionPane.showMessageDialog(null," you checked snapToGrid");
        }
            else
            {
              flag1 = true;
              JOptionPane.showMessageDialog(null," you Unchecked snapToGrid");
            }
        }  /*displaying a pop up message for showGrid when checking and unchecking the boxes*/
           if(e.getSource()==showGrid)
        {
             if(flag2==true){
             flag2 = false;
         JOptionPane.showMessageDialog(null," you checked showGrid");
        }
             else
             {
               flag2 = true;
               JOptionPane.showMessageDialog(null," you Unchecked showGrid");
             }
        }
       }   
      }


          
                                     
                                     
              
   
  
          
 