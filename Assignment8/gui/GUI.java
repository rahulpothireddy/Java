/***************************************************************************************************************
  *                                   Assignment 8
  * NAME : Rahul Pothireddy (Team Lead), Karri Hari, Ashton Dsouza                                       FALL 18
  * zid : z1829984 (RP), Z1830680(KH), Z1828205(AD)
  * section : CSCI 502
  * Instructor : Prof Geoffrey Decker
  * Assignment Due :  28th Nov 2018/assignment8
  * Purpose : The purpsoe of this java program is to create a GUI which displays a window containing different
  *           input boxes like miles text box and destinations list which displays the required output after
  *           calculation
  * ************************************************************************************************************/
/*importing the required packages and other elements*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.FlowLayout; /*flow layout is used to add the elements from left to right in the sequence*/
import java.io.IOException; /*to handle exception*/
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.lang.String;
import javax.swing.JFormattedTextField;

/*extending JFrame using graphical user interface*/
public class GUI extends JFrame
{
    private final JLabel NormalMiles; /*labels whichever are needed*/
    private final JLabel UpgradeCost;
    private final JLabel SuperSaverDates;
    private final JLabel MilesEntered;
    private final JLabel SuperSaverMiles;
    private final JLabel DepartureMonth;
    private final JLabel RedeemMiles;
    private final JButton RedeemMilesButton;
    private final JList<String> destinationList;/*string of destinations list*/
    private final JSpinner Spinnermonths;
    private final JTextField MilesEnteredText; /*text boxes to enter miles text*/
    private final JTextField SuperSaverMilesText;
    private final JTextField UpgradeCostText;
    private final JTextField RemainingMilesText;
    private final JTextField NormalMilesText;
    private final JTextField SuperSaverDatesText;
    private final GridBagConstraints firstPanel;
    private final GridBagConstraints secondPanel;
    private final JPanel Panel1; /*for the left panel*/
    private final JPanel Panel2; /*for the right panel*/
    private final JTextArea EmptySpace;
    private final DefaultListModel<String> defaultList;
    private final TitledBorder destinationBorder;
    private final TitledBorder redeemBorder; /*elements on the border of console window*/
    int intmonth,milesremaining=0; /*intialising to 0*/
    /*gragical user interface class throws an IOexception*/
    public GUI() throws IOException
    {
        super("Mile Redemption App"); /*title of the wndow which is later used again as a reference*/
        String months[] = {"Jan", "Feb", "Mar","Apr","May","June","July","Aug","Sept","Oct","Nov", "Dec"};
        String[] newarray; /*new array being declared*/
        NormalMiles = new JLabel("Normal miles"); /*JLabels for all the inout boxes required*/
        MilesEntered = new JLabel("Enter your miles     ");
        RedeemMiles = new JLabel("Your remaining miles");
        SuperSaverMiles = new JLabel("Supersaver miles");
        UpgradeCost = new JLabel("Upgrade cost");
        SuperSaverDates = new JLabel("Supersaver Dates");
        DepartureMonth = new JLabel("Select the month of departure");  
        Panel1 = new JPanel(new GridBagLayout()); /*the left panel is being set in*/
        Panel1.setBackground(new Color(143,188,143));/*new background color values are given (green)*/
        Panel1.setSize(340,300);/*size given which is convinient*/
        destinationBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Destinations");
        destinationBorder.setTitleJustification(TitledBorder.CENTER); /*keeping the title in the center*/
        Panel1.setBorder(destinationBorder);/*border of the destination*/
        Panel1.setLayout(new GridBagLayout());
        firstPanel = new GridBagConstraints();/*to make the layout flexible with rows and columns*/
        firstPanel.fill = GridBagConstraints.BOTH;
        Panel2 = new JPanel(new GridBagLayout()); /*for the right layout*/
        Panel2.setBackground(new Color(147,112,219)); /*assigning the background color (blue)*/
        Panel2.setSize(340,300); /*setting the size*/
        redeemBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Redeem Miles");
        redeemBorder.setTitleJustification(TitledBorder.CENTER);         
        Panel2.setBorder(redeemBorder);
        Panel2.setLayout(new GridBagLayout());
        secondPanel = new GridBagConstraints(); /*GBC for the second panel*/
        secondPanel.fill = GridBagConstraints.BOTH;
        defaultList = new DefaultListModel<>(); /*default list model*/
        String name = JOptionPane.showInputDialog("Enter the File Name :"); /*reads the text file*/
        Scanner fileScan = new Scanner(new File(name));/*scans it*/
        MileRedeemer mr = new MileRedeemer();
        mr.readDestination(fileScan);
        newarray = mr.getCityNames(); /*gets all the city names*/
        for(String x : newarray) /*reads all the elements in the new array*/
        {
          defaultList.addElement(x); /*adds elements*/
        }
        EmptySpace = new JTextArea(12,40);/*empty space panel with suitable size*/
        EmptySpace.setEditable(false);
        RedeemMilesButton = new JButton("Redeem miles");/*button for redeem miles*/
        MilesEnteredText = new JTextField(24);/*text field to display miles*/
        RemainingMilesText = new JTextField(24);/*text field to display remaining miles*/
        RemainingMilesText.setEditable(false);
        NormalMilesText = new JTextField(18); /*text field to display normal miles*/
        NormalMilesText.setEditable(false);
        SuperSaverMilesText = new JTextField(18);/*text field to display super saver miles*/
        SuperSaverMilesText.setEditable(false);
        UpgradeCostText = new JTextField(18);/*text field to display upgraded costs*/
        UpgradeCostText.setEditable(false);
        SuperSaverDatesText = new JTextField(18);/*text field to display dates*/
        SuperSaverDatesText.setEditable(false);
        /*********************************************************************************************************
          * JSpinners are a single line input field that lets the user select a number or an object 
          * value from an ordered sequence. Spinners typically provide a pair of tiny arrow buttons for stepping 
          * through the elements of the sequence
          * ******************************************************************************************************/
        Spinnermonths = new JSpinner(new SpinnerListModel(months));
        JFormattedTextField spin=((JSpinner.DefaultEditor)Spinnermonths.getEditor()).getTextField();
        spin.setEditable(false);
        destinationList = new JList<>(defaultList);
       /*setting the grid values of every in and out grid*/
        firstPanel.gridwidth = 3;
        firstPanel.gridx = 0;
        firstPanel.gridy = 0;
        Panel1.add(destinationList,firstPanel);
        firstPanel.gridwidth = 1;
        firstPanel.gridx = 0;
        firstPanel.gridy = 1;
        Panel1.add(NormalMiles,firstPanel);               
        firstPanel.gridx = 0;
        firstPanel.gridy = 2;
        Panel1.add(SuperSaverMiles,firstPanel);
        firstPanel.gridx = 0;
        firstPanel.gridy = 3;
        Panel1.add(UpgradeCost,firstPanel);
        firstPanel.gridx = 0;
        firstPanel.gridy = 4;
        Panel1.add(SuperSaverDates,firstPanel);
        firstPanel.gridx = 1;
        firstPanel.gridy = 1;
        Panel1.add(NormalMilesText,firstPanel);
        firstPanel.gridx = 1;
        firstPanel.gridy = 2;
        Panel1.add(SuperSaverMilesText,firstPanel);
        firstPanel.gridx = 1;
        firstPanel.gridy = 3;
        Panel1.add(UpgradeCostText,firstPanel);
        firstPanel.gridx = 1;
        firstPanel.gridy = 4;
        Panel1.add(SuperSaverDatesText,firstPanel);
        /*setting the all the in and out grid points value for second panel*/
        secondPanel.gridx = 0;
        secondPanel.gridy = 0;
        Panel2.add(MilesEntered,secondPanel);
        secondPanel.gridx = 0;
        secondPanel.gridy = 1;
        Panel2.add(DepartureMonth,secondPanel);
        secondPanel.gridx = 0; 
        secondPanel.gridy = 2;
        secondPanel.gridwidth = 8;
        Panel2.add(RedeemMilesButton,secondPanel);
        secondPanel.gridx = 0; 
        secondPanel.gridy = 3;
        Panel2.add(EmptySpace,secondPanel);
        secondPanel.gridx = 0;
        secondPanel.gridy = 4;
        Panel2.add(RedeemMiles,secondPanel);
        secondPanel.gridx = 1;
        secondPanel.gridy = 0;
        Panel2.add(MilesEnteredText,secondPanel);
        secondPanel.gridx = 1;
        secondPanel.gridy = 1;
        Panel2.add(Spinnermonths,secondPanel);
        secondPanel.gridx = 1;
        secondPanel.gridy = 4;
        Panel2.add(RemainingMilesText,secondPanel);
        /*action performed upon clicking redeem miles button*/      
        RedeemMilesButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0){
        JFrame f = new JFrame();
        String miles1 = MilesEnteredText.getText();/*takes the miles input*/
        int miles = Integer.valueOf(miles1);
        for(int i=0;i<12;i++)/*from o to 12 months*/{
        if(Spinnermonths.getValue() == months[i]){
        intmonth = i+1; /*increments the value of month*/
        }
       }
        String[] affordableCityListStyle = mr.redeemMiles(miles,intmonth);
        int count =0;/*count being intialised to 0*/
        String places ="";
        for(String x : affordableCityListStyle){
        if(x != null)/*until x not equals to null*/{
        places = places + x + "\n" ; 
        count++; /*count value is incremented*/
        }
       }
       if(count == 0)/*if count value is 0*/{
       /*dispalys a concern message about not satisfying the requirments*/
       EmptySpace.setText("*** Your client has not accumulated enough Frequent Flyer Miles ***");
       }
       else{  
       EmptySpace.setText(places);
       }
       milesremaining = mr.getRemainingMiles();
       RemainingMilesText.setText(String.valueOf(milesremaining)); /*gets the value of remaining miles*/
       }
   });
       /*adding both panel one and panel two*/ 
       add(Panel1);
       add(Panel2);     
       Destination[] list = mr.getDestinationArray();/*list gets the array values of destinations*/
       destinationList.addListSelectionListener(new ListSelectionListener() {
       @Override   
       public void valueChanged(ListSelectionEvent evt) 
       {
       if (evt.getValueIsAdjusting())
       {
       String cityName = destinationList.getSelectedValue();/*selected city from destiantion list options*/
       for (Destination x : list){
       if (x.getDestinationCity().equals(cityName)) /*checking condition*/
       {
       NormalMilesText.setText(Integer.toString(x.getNormalMiles()));/*converting the normal miles to string*/
       SuperSaverMilesText.setText(Integer.toString(x.getFrequentMiles()));
       UpgradeCostText.setText(Integer.toString(x.getAdditionalMiles()));
       String startMonth = months[x.getStartMonth()-1]; 
       String endMonth = months[x.getEndMonth()-1];      /*dates is taken as difference between the first and last month given*/
       SuperSaverDatesText.setText(startMonth + " - " + endMonth);
       }
      }
     }
    }
   });
  }
}