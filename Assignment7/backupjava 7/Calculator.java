/********************************************************************************************************************
  * NAME : Rahul Pothireddy           Assignment 7                             FALL 18
  * zid : z1829984
  * section : CSCI 502/section 1
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  7th Nov 2018/assignment 7
  * Purpose : This program implements a a graphical user interface of a simple caluclator. As instructed by the 
  *           professor, no need of showing the functionality and instead showed pop-ups for all the options chosen.
  * *****************************************************************************************************************/  
/*importing packages that are required */
  
  import javax.swing.*;
  import java.awt.event.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.awt.event.KeyEvent;
  import java.awt.event.KeyListener;
 
/*calculator class implementinf action listener events and also extends JFrame options*/
  class Calculator extends JFrame implements ActionListener
    {
     JFrame f;
     JTextField t;
     /*declaring the required buttons*/
     JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bdec,beq;
     Calculator()
      {
        /*intialising all the buttons with JFrame objects*/
        f=new JFrame("Calculator");
        t=new JTextField();
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b0=new JButton("0");
        badd=new JButton("+");
        bsub=new JButton("-");
        bmul=new JButton("*");
        bdiv=new JButton("/");
        bdec=new JButton(".");
        beq=new JButton("=");
        /*setting the boundaries of buttons i.e, setting the size of buttons*/
        t.setBounds(30,40,275,30);
        b7.setBounds(40,100,50,40);
        b8.setBounds(110,100,50,40);
        b9.setBounds(180,100,50,40);
        bdiv.setBounds(250,100,50,40);
        b4.setBounds(40,170,50,40);
        b5.setBounds(110,170,50,40);
        b6.setBounds(180,170,50,40);
        bmul.setBounds(250,170,50,40);
        b1.setBounds(40,240,50,40);
        b2.setBounds(110,240,50,40);
        b3.setBounds(180,240,50,40);
        bsub.setBounds(250,240,50,40);
        b0.setBounds(40,310,50,40);
        bdec.setBounds(110,310,50,40);
        beq.setBounds(180,310,50,40);
        badd.setBounds(250,310,50,40);
        /*adding the buttons to the form created earlier
         * adding theese buttons in a particular order of their appearence*/
        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
       /*adjusting the size of the main big frame of the caluclator*/
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(345,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
       /*al the buttons used in the calculator are beeing added as objects or attributes of the action listerner events performed */
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
    }
 
    /**********************************************************************************************
      * actions performed are invoked, where a pop up appears after you select a particular option,
      * and that option is displayed in a text field.
      * *******************************************************************************************/
  
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
        t.setText(t.getText().concat("1"));
        JOptionPane.showMessageDialog(null," you entered 1");
        }
        if(e.getSource()==b2)
        {
        t.setText(t.getText().concat("2"));
        JOptionPane.showMessageDialog(null,"you entered 2");
        }
        if(e.getSource()==b3)
        {  
        t.setText(t.getText().concat("3"));
        JOptionPane.showMessageDialog(null,"you entered 3");
        }
        if(e.getSource()==b4)
        {
        t.setText(t.getText().concat("4"));
        JOptionPane.showMessageDialog(null,"you entered 4");
        }   
        if(e.getSource()==b5)
        {
        t.setText(t.getText().concat("5"));
        JOptionPane.showMessageDialog(null,"you entered 5");
        }
        if(e.getSource()==b6)
        {
        t.setText(t.getText().concat("6"));
        JOptionPane.showMessageDialog(null,"you entered 6");
        }
        if(e.getSource()==b7)
        {
        t.setText(t.getText().concat("7"));
        JOptionPane.showMessageDialog(null,"you entered 7");
        }
        if(e.getSource()==b8)
        {
        t.setText(t.getText().concat("8"));
        JOptionPane.showMessageDialog(null,"you entered 8");
        }
        if(e.getSource()==b9)
        {
        t.setText(t.getText().concat("9"));
        JOptionPane.showMessageDialog(null,"you entered 9");
        }
        if(e.getSource()==b0)
        {
        t.setText(t.getText().concat("0"));
        JOptionPane.showMessageDialog(null,"you entered 0");
        }
        if(e.getSource()==bdec)
        {
        t.setText(t.getText().concat("."));
        JOptionPane.showMessageDialog(null,"you entered decimal");
        }
        if(e.getSource()==badd)
        {
        t.setText(t.getText().concat("+"));
        JOptionPane.showMessageDialog(null,"you entered addition option");
        } 
        if(e.getSource()==bsub)
        {
        t.setText(t.getText().concat("-"));
        JOptionPane.showMessageDialog(null,"you entered subtraction option");
        }
        if(e.getSource()==bmul)
        {
        t.setText(t.getText().concat("*"));
        JOptionPane.showMessageDialog(null,"you entered multiplication option");
        }
        if(e.getSource()==bdiv)
        {
        t.setText(t.getText().concat("/"));
        JOptionPane.showMessageDialog(null,"you entered division option");
        }
        if(e.getSource()==beq)
        {
        t.setText(t.getText().concat("="));  
        JOptionPane.showMessageDialog(null,"you entered equals to option");
        }
    }
}
  
