import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class SortPanel extends JPanel{
 
 //private static final long serialVersionUID = -9055649941224195180L;
 //create two subpanels. At each subpanel a thread will run
 //seperately a sorting algorithm and it will visualize the result
 private SortSubPanel firstSubPanel, secondSubPanel;
 //create the combo box for 'creating array order' selection
 private String[] arrayOrderStrings = {"Random", "Asceding", "Desceding"};
 private JComboBox<String> arrayOrders = new JComboBox<String>(arrayOrderStrings);
 //create the combo box for speed selection
 private String[] speedStrings = {"Fast", "Medium", "Slow"};
 private JComboBox<String> speeds = new JComboBox<String>(speedStrings);
 //thisPanel will be parsed as an argument to the panels where the sorting algorithm
 //is performed. When the algorithm of both subpanels finish the buttons of thisPanel
 //need to be refreshed
 private SortPanel thisPanel = this;
 //these threads will run seperately the sorting algorithms
 private Thread t1 = null, t2 = null;
 //flag variable will be used to check wherever the two threads have finished their
 //job or they stopped
 private int flag[] = null;
 
 //bottom panel variables
 private JPanel bottomPanel;
 private JButton populateArrayButton = new JButton("Populate Array");
 private JButton sortButton = new JButton("Sort");
 private JButton pauseButton = new JButton("Pause");
 
 
 public SortPanel(int width, int height) {
  //set sort panel's layout and size
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  setPreferredSize(new Dimension(width, height));
  
  //create an empty panel two create a gap between the two sub panels
  JPanel emptyPanel = new JPanel();
  emptyPanel.setPreferredSize(new Dimension(20, 20));
  
  //create an horizontal panel to add the two sub panels
  JPanel horizontalPanel = new JPanel();
  horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.LINE_AXIS));
  
  firstSubPanel = new SortSubPanel(width, (int)(height/1.1));
  secondSubPanel = new SortSubPanel(width, (int)(height/1.1));
  
  horizontalPanel.add(firstSubPanel);
  horizontalPanel.add(emptyPanel);
  horizontalPanel.add(secondSubPanel);
  add(horizontalPanel);
  
  //create the bottom panel with the proper buttons and combo boxes
  bottomPanel = new JPanel();
  bottomPanel.setLayout(new FlowLayout());
  populateArrayButton = new JButton("Populate Array");
  populateArrayButton.setFocusable(false);
  arrayOrders.setFocusable(false);
  pauseButton.setFocusable(false);
  sortButton = new JButton("Sort");
  sortButton.setFocusable(false);
  sortButton.setEnabled(false);
  speeds.setEnabled(false);
  speeds.setFocusable(false);
  pauseButton.setEnabled(false);
  bottomPanel.add(populateArrayButton);
  bottomPanel.add(arrayOrders);
  bottomPanel.add(sortButton);
  bottomPanel.add(speeds);
  bottomPanel.add(pauseButton);
  
  speeds.addActionListener (new ActionListener () {
      public void actionPerformed(ActionEvent e) {
         firstSubPanel.setSpeed((String)speeds.getSelectedItem());
         secondSubPanel.setSpeed((String)speeds.getSelectedItem());
      }
  });
  
  /*
   * When populateArrayButton is clicked both sub panels must be
   * initialized with the same array. The array is created based on
   * the order that has been selected. Also the proper buttons are
   * enabled and disabled
   */
  populateArrayButton.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
       {
        firstSubPanel.setEnabledComboBox(true);
        secondSubPanel.setEnabledComboBox(true);
        populateArrayButton.setEnabled(false);
        arrayOrders.setEnabled(false);
        sortButton.setEnabled(true);
        speeds.setEnabled(true);
        int array[] = firstSubPanel.createArray((String)arrayOrders.getSelectedItem());
        firstSubPanel.setArray(array);
        secondSubPanel.setArray(array);
       }
     });
  
  /*
   * when sortButton is clicked two threads are created and run seperately
   * the algorithms that have been selected in each case. Also it enables
   * and disables the proper buttons
   */
  sortButton.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
       {
        sortButton.setEnabled(false);
        firstSubPanel.setEnabledComboBox(false);
        secondSubPanel.setEnabledComboBox(false);
        firstSubPanel.setEnabledStopButton(true);
        secondSubPanel.setEnabledStopButton(true);
        pauseButton.setEnabled(true);
        flag = new int[1];
        t1 = firstSubPanel.createThread(thisPanel, flag, (String)speeds.getSelectedItem());
        t2 = secondSubPanel.createThread(thisPanel, flag, (String)speeds.getSelectedItem());
        t1.start();
        t2.start();
     
       }
     });
  
  /*
   * When pause is clcked then for prettier interaction it's text
   * changes to "Resume". Then if it's clicked again the two
   * threads continue with their job and the button's text changes
   * back to 'Pause'
   */
  pauseButton.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
       {
        if (pauseButton.getText().equals("Pause")) {
         pauseButton.setText("Resume");
        }
        else {
         pauseButton.setText("Pause");
        }
        
        firstSubPanel.pause();
        secondSubPanel.pause();
       }
     });
  
  
  add(bottomPanel);
 }
 
 //reset buttons back to initial state
 public void resetButtons() {
   populateArrayButton.setEnabled(true);
     arrayOrders.setEnabled(true);
   sortButton.setEnabled(false);
   speeds.setEnabled(false);
   pauseButton.setEnabled(false);
 }
}
