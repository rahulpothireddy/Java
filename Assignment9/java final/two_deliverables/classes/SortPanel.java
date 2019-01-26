

/* importing the required packages */

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;


/*********************************************************
  * class sort pael extends JPanel and contains all the
  * implementations of the panels and boxes required
  * *****************************************************/
class SortPanel extends JPanel{

 private SortSubPanel firstSubPanel, secondSubPanel;
 private String[] arrayOrderStrings = {"Random", "Asceding", "Desceding"};
 private JComboBox<String> arrayOrders = new JComboBox<String>(arrayOrderStrings);
 private String[] speedStrings = {"Fast", "Medium", "Slow"};
 private JComboBox<String> speeds = new JComboBox<String>(speedStrings);
 private SortPanel thisPanel = this;
 private Thread t1 = null, t2 = null;
 private int flag[] = null;
 
 /*These are the buttons of the bottom panel of the entire frame*/
 private JPanel bottomPanel;
 private JButton populateArrayButton = new JButton("Populate Array");
 private JButton sortButton = new JButton("Sort"); /*sort button*/
 private JButton pauseButton = new JButton("Pause");/*pause button*/
 
 /*The borders of sortpanel is set here with preferred sizes*/
 public SortPanel(int width, int height) {
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  setPreferredSize(new Dimension(width, height));
 /*empty panel with preferred sizes and horizontal panel in the box layout*/
  JPanel emptyPanel = new JPanel();
  emptyPanel.setPreferredSize(new Dimension(20, 20));
  JPanel horizontalPanel = new JPanel();
  horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.LINE_AXIS));
  /*first sub panel and second subpanel are declared here with required height and width*/
  firstSubPanel = new SortSubPanel(width, (int)(height/1.1));
  secondSubPanel = new SortSubPanel(width, (int)(height/1.1));
  /*We are adding the three above declared panels making them togethor*/
  horizontalPanel.add(firstSubPanel); /*first sub panel*/
  horizontalPanel.add(emptyPanel); /*empty panel*/
  horizontalPanel.add(secondSubPanel); /*second sub panel*/
  add(horizontalPanel); /*horizonatal panel*/
  
  bottomPanel = new JPanel(); /*new panel in the bottom*/
  bottomPanel.setLayout(new FlowLayout()); /*flow layout is used to add from left to right continuously as a flow*/
  populateArrayButton = new JButton("Populate Array"); /*populate array button is declared*/
  populateArrayButton.setFocusable(false); /*set foucsable*/
  arrayOrders.setFocusable(false);/*false assigned*/
  pauseButton.setFocusable(false);
  sortButton = new JButton("Sort"); /*sort button*/
  sortButton.setFocusable(false);
  sortButton.setEnabled(false);
  speeds.setEnabled(false);/*enabled is made false*/
  speeds.setFocusable(false);
  pauseButton.setEnabled(false);/*pause button*/
  bottomPanel.add(populateArrayButton); /*adds populate button to here*/
  bottomPanel.add(arrayOrders);/*adds array of orders to bottom panel*/
  bottomPanel.add(sortButton);/*sort button adding*/
  bottomPanel.add(speeds);/*speeds button adding*/
  bottomPanel.add(pauseButton);/*adding pause button*/
  
  speeds.addActionListener (new ActionListener () {
  public void actionPerformed(ActionEvent e) {
  firstSubPanel.setSpeed((String)speeds.getSelectedItem());
  secondSubPanel.setSpeed((String)speeds.getSelectedItem());
      }
  });
  /********************************************************************
   * When populateArrayButton is clicked both sub panels must be
   * initialized with the same array. The array is created based on
   * the order that has been selected. Also the proper buttons are
   * enabled and disabled
   ********************************************************************/
  populateArrayButton.addActionListener(new ActionListener()
  {
  public void actionPerformed(ActionEvent e)
  {
  firstSubPanel.setEnabledCheckBox(true);/*enabledheck box made true*/
  secondSubPanel.setEnabledCheckBox(true);/*enabledcheckbox made true*/
  populateArrayButton.setEnabled(false); /*populate array button made false*/
  arrayOrders.setEnabled(false);
  sortButton.setEnabled(true);
  speeds.setEnabled(true);
  /*creates and array of integers*/
  int array[] = firstSubPanel.createArray((String)arrayOrders.getSelectedItem());
  firstSubPanel.setArray(array); /*first sub panel is asisgned with array*/
  secondSubPanel.setArray(array);/*second sub panel is asisgned with array*/
  }
});
  
  /*******************************************************************************
   * when sortButton is clicked two threads are created and run seperately
   * the algorithms that have been selected in each case. Also it enables
   * and disables the proper buttons.
   *******************************************************************************/
  sortButton.addActionListener(new ActionListener()
  {
  public void actionPerformed(ActionEvent e)
  {
  sortButton.setEnabled(false);
  firstSubPanel.setEnabledCheckBox(false);
  secondSubPanel.setEnabledCheckBox(false);
  firstSubPanel.setEnabledStopButton(true);
  secondSubPanel.setEnabledStopButton(true);/*second sub panel, stop button is true*/
  pauseButton.setEnabled(true);/*pause button enabled true*/
  flag = new int[1];
  t1 = firstSubPanel.createThread(thisPanel, flag, (String)speeds.getSelectedItem());
  t2 = secondSubPanel.createThread(thisPanel, flag, (String)speeds.getSelectedItem());
  t1.start();/*starting first sub panel*/
  t2.start();/*starting second sub panel*/
  }
});
  
  /****************************************************************************************
   * When pause is clcked then for prettier interaction it's text
   * changes to "Resume". Then if it's clicked again the two
   * threads continue with their job and the button's text changes
   * back to 'Pause' . 
   ****************************************************************************************/
  pauseButton.addActionListener(new ActionListener()
  {
  public void actionPerformed(ActionEvent e)
  {
  /*if the action performed is pause, then the button is paused and state is changed to resume option*/
  if (pauseButton.getText().equals("Pause")) {
  pauseButton.setText("Resume");
  }
  else {
  pauseButton.setText("Pause");
  }
  firstSubPanel.pause();/*pausing first sub panel*/
  secondSubPanel.pause();/*pausing second sub panel*/
  }
 });
  add(bottomPanel); /*adding to bottom panel*/
 }
 /*reset buttons back to initial state*/
  public void resetButtons() {
   populateArrayButton.setEnabled(true);
   arrayOrders.setEnabled(true);
   sortButton.setEnabled(false);
   speeds.setEnabled(false);
   pauseButton.setEnabled(false);
 }
}

 /*this panel will draw the sorting algorithm process*/
 class SortSubPanel extends JPanel{
 private SortAnimationPanel sortAnimationPanel;
 /*create the combo box for algorithm selection*/
  private String[] sortingAlgorithmStrings = {"Bubble Sort", "Insertion Sort", "Quick Sort"}; /*three typs of sorting algorithms implemented*/
  private JComboBox<String> sortingAlgorithms = new JComboBox<String>(sortingAlgorithmStrings);
  private String[] orderStrings = {"Asceding", "Desceding"}; /*types of sorting*/
  private JComboBox<String> orders = new JComboBox<String>(orderStrings);
  private JButton stopButton = new JButton("Stop");/*stop button*/
 /*initialize the created components*/
  public SortSubPanel(int width, int height) {
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  sortAnimationPanel = new SortAnimationPanel(width, height);
  add(sortAnimationPanel);
  sortingAlgorithms.setEnabled(false);/*it's disabled at the beginning*/
  sortingAlgorithms.setFocusable(false);
  orders.setEnabled(false);/*it's disabled at the beginning*/
  orders.setFocusable(false);
  stopButton.setEnabled(false);/*it's disabled at the beginning*/
  stopButton.setFocusable(false);
  stopButton.addActionListener(new ActionListener()
   {
   /*stop current's panel process*/
   public void actionPerformed(ActionEvent e)
   {
    stopButton.setEnabled(false);
    sortAnimationPanel.stop();
   }
 });
  /*bottom pannel*/
  JPanel bottomPanel = new JPanel();
  bottomPanel.setLayout(new FlowLayout());
  bottomPanel.add(sortingAlgorithms);/*adding elements to the bottom panel*/
  bottomPanel.add(orders);
  bottomPanel.add(stopButton);
  add(bottomPanel);
 }
 /*create array of elements*/
 public int[] createArray(String arrayOrder) {
  return sortAnimationPanel.createArray(arrayOrder);
 }
 /*set array of elements*/
 public void setArray(int array[]) {
  sortAnimationPanel.setArray(array);
 }
 /*pause method*/
 public void pause() {
  sortAnimationPanel.pause();
 }
 /*working with check box*/
 public void setEnabledCheckBox(boolean b) {
  sortingAlgorithms.setEnabled(b);
  orders.setEnabled(b);
 }
 /*enabled stop button*/
 public void setEnabledStopButton(boolean b) {
  stopButton.setEnabled(b);
 }
 /*create the animation panel thread that will animate the selected sorting algorithm*/
 public Thread createThread(SortPanel sortPanel, int flag[], String speedMode) {
  sortAnimationPanel.init(sortPanel, flag, stopButton, (String)sortingAlgorithms.getSelectedItem(), (String)orders.getSelectedItem());
  setSpeed(speedMode);
  return new Thread(sortAnimationPanel);
 }
 /*change the speed mode (Fast, Medium, Slow)*/
 public void setSpeed(String speedMode) {
  sortAnimationPanel.setTimeSleep(speedMode);
 }
}

/*class sortanimation panel extends the jpannel and implements runnabel*/
class SortAnimationPanel extends JPanel implements Runnable{
 private int array[];
 private int PANEL_WIDTH = 0, PANEL_HEIGHT = 0;
 private String arrayOrder = "";
 //which algorithm will be used for sorting
 private SortingAlgorithm sortingAlgorithm = null;
 public SortAnimationPanel(int width, int height) {
 setPreferredSize(new Dimension(width, height));
 }
 public void init(SortPanel sortPanel, int flag[], JButton stopButton, String algorithmName, String arrayOrder) {
 this.arrayOrder = arrayOrder;
 /*set the sorting algorithm based on selected algorithm text*/
 if (algorithmName.equals("Bubble Sort")) {
 sortingAlgorithm = new BubbleSort(this);
  }
  else if (algorithmName.equals("Insertion Sort")) {
   sortingAlgorithm = new InsertionSort(this);
  }
  else {
   sortingAlgorithm = new QuickSort(this);
  }
  /*initialize some crucial variables*/
  sortingAlgorithm.setPanel(sortPanel);
  sortingAlgorithm.setFlag(flag);
  sortingAlgorithm.setStopButton(stopButton);
 }
 /*change milliseconds variable based on selected text*/
 public void setTimeSleep(String speedMode) {
 int milliSecondsSleep = 100;
 if (speedMode.equals("Fast")) {
 milliSecondsSleep = 1;
 }//fast
 else if (speedMode.equals("Medium")) {
 milliSecondsSleep = 5;
 }//medium
 else {
 milliSecondsSleep = 10;
 }
 if (sortingAlgorithm != null) {
 sortingAlgorithm.setTimeSleep(milliSecondsSleep);
 } // until sorting algorithms are null
 }
 /*to pause*/
 public void pause() {
 if (sortingAlgorithm != null) {
 sortingAlgorithm.pause();  }
 }
 /*to stop*/
 public void stop() {
  if (sortingAlgorithm != null) {
   sortingAlgorithm.stop();
  }
 }
 /*create an initial array based on the selected text*/
 public int[] createArray(String arrayOrder) {
  if (arrayOrder.equals("Random")) {
   return createRandomArray();
  }
  else if (arrayOrder.equals("Asceding")) {
   return createAscedingArray();
  }
  else {
   return createDescedingArray();
  }
 }
/*creating a random array*/
 public int [] createRandomArray() {
  int array[] = new int[PANEL_WIDTH];
  Random random = new Random();
  
  for (int i = 0; i < PANEL_WIDTH; i++) {
   array[i] = random.nextInt(PANEL_HEIGHT);
  }
  return array;
 }
 /*create an asceding number array from 0 to min(PANEL_WIDTH, PANEL_HEIGHT)*/
 public int[] createAscedingArray() {
  int array[] = new int[PANEL_WIDTH];
  for (int i = 0; i < PANEL_WIDTH; i++) {
  if (i > PANEL_HEIGHT) {
  array[i] = PANEL_HEIGHT;
   }
  else {
  array[i] = i;
   }
   }
  return array; /*returns array*/
   }
 /*create an desceding number array min(PANEL_WIDTH, PANEL_HEIGHT) to 0*/
 public int[] createDescedingArray() {
  int array[] = new int[PANEL_WIDTH];
  for (int i = PANEL_WIDTH-1; i >= 0; i--) {
  if (i > PANEL_HEIGHT) {
  array[PANEL_WIDTH-i-1] = PANEL_HEIGHT;
  }
  else {
  array[PANEL_WIDTH-i-1] = i;
  }
  }
  return array;/*returns array*/
  }
  //create a copy of the array
  public void setArray(int array[]) {
  this.array = new int[array.length];
  for (int i = 0; i < array.length; i++) {
   this.array[i] = array[i];
  }
  repaint();
  }
  public int[] getArray() {
  return array;
 }
 
 /*******************************************************************
  * This function draws current array. It is called via repaint()
  * every time a swap is performed
  *******************************************************************/
 public void paintComponent (Graphics g)
 {
     super.paintComponent (g);
     PANEL_WIDTH = this.getWidth();
     PANEL_HEIGHT = this.getHeight();
     if (array != null) {
     for (int i = 0; i < PANEL_WIDTH; i++) {
     g.drawRect(i, PANEL_HEIGHT-array[i], 1, array[i]);  
     g.setColor(Color.BLUE);  
     g.fillRect(i, PANEL_HEIGHT-array[i], 1, array[i]);  
     }
   }
 }
/*the function that each thread runs*/
 public void run() {
  sortingAlgorithm.initialize(array, arrayOrder);
  sortingAlgorithm.sort();
 }
}
/**************************************************************************
  * sorting algorithm implements different sorts on the given array and
  * populates the output
  * ***********************************************************************/
 abstract class SortingAlgorithm {
 protected int array[];//the array which will be used for sorting
 protected String arrayOrder;//Asceding or Desceding
 protected SortAnimationPanel sortAnimationPanel; //the panel that will be repaint after each swap
 protected SortPanel sortPanel;
 protected int millisecondsSleep = 10; /*milliseconds to sleep after each iteration*/
 protected boolean stop = false; /*if the user presses the stop button this variable becomes true*/
 protected boolean pause = false; /*if the user presses the pause button this variable becomes true*/
 protected int flag[] = null; /*this variable is used to check if both animation panels have completed their execution.*/ 
 protected JButton stopButton = null;
 
 public abstract void sort();
 
 public SortingAlgorithm(){
   stop = false;
 }
 
 public void initialize(int[] array, String order) {
  this.array = array;
  this.arrayOrder = order;
 }
 /*settimesleep*/
 public void setTimeSleep(int milliseconds) {
  millisecondsSleep = milliseconds;
 }
 /*set panel*/
 public void setPanel(SortPanel sortPanel) {
  this.sortPanel = sortPanel;
 }
 /*stopbutton*/
 public void setStopButton(JButton stopButton) {
  this.stopButton = stopButton;
 }
 /*setflag*/
 public void setFlag(int flag[]) {
  this.flag = flag;
 }
 /*pause*/
 public void pause() {
  pause = !pause;
 }
  /******************************************************************************
  * This function is called when user presses the pause button. Every 20ms
  * it checks if the pause variable is still true. When the user presses
  * resume then this variable will become false and current thread will
  * continue it's work
  *******************************************************************************/
 public void pauseWait() {
 while (pause) {
 try {
 Thread.sleep(20);
 } catch (InterruptedException e) {
 e.printStackTrace();
 break;
 }
 }
 }
 public void stop() {
  stop = true;
 }
 /*********************************************************************************** 
  * This function is used to check if both animation panels have finished with
  * their jobs. The synchronized is used as a mutex so each time only one
  * thread will have access to this variable. When both threads are finished
  * with their job then the initial buttons the sort panel's button need to reset
  ***********************************************************************************/
 public void end() {
 synchronized (flag) {
 if (flag[0] == 0) {
 flag[0] = 1;
 }
 else {
 sortPanel.resetButtons();
 }
 }
 stopButton.setEnabled(false);
 }
 /*function of print numbers*/
 public void printNumbers(int[] array) {
 for (int i = 0; i < array.length; i++) {
 System.out.print(array[i]);
 if (i < array.length - 1) {
 System.out.print(", ");
  }
 }
 System.out.println("\n");
   }
 }
 /*quicksort , one of the algorithm*/
 class QuickSort extends SortingAlgorithm{
 /*the panel that will repaint after each swap*/
 public QuickSort(SortAnimationPanel sortAnimationPanel) {
 super();
 this.sortAnimationPanel = sortAnimationPanel;
 }
/*sort*/
  public void sort() {
  int length = array.length;
  quickSort(0, length - 1);
  end();
  }
  private void quickSort(int lowerIndex, int higherIndex) {
  int i = lowerIndex;
  int j = higherIndex;
 /* calculate pivot number, I am taking pivot as middle index number*/
  int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
  boolean b1 = false, b2 = false;
 /*Divide into two arrays*/
  while (i <= j) {
  if (stop) {
  end();
  return;
   }
 /*if user pressed stop button then end current */
  pauseWait();
 /*define the sorting order*/
  if (arrayOrder.equals("Asceding")) {
  b1 = array[i] < pivot;
  }/*checking the conditions*/
  else {
  b1 = array[i] > pivot;
  }
  while (b1) {
  i++;
  if (arrayOrder.equals("Asceding")) {
  b1 = array[i] < pivot;
  }
  else {
  b1 = array[i] > pivot;
  }
  }/*sorting*/
  if (arrayOrder.equals("Asceding")) {
  b2 = array[j] > pivot;
  }
  else {
  b2 = array[j] < pivot;
  }
  while (b2) {
  j--;
  /*sorting*/
  if (arrayOrder.equals("Asceding")) {
  b2 = array[j] > pivot;
  }
  else {
  b2 = array[j] < pivot;
  }
  }
  if (i <= j) {
  exchangeNumbers(i, j);
  /*move index to next position on both sides*/
  i++;
  j--;
  if (sortAnimationPanel != null) {
  sortAnimationPanel.repaint();
  }
  try {
  /*thread sleeps*/  
  Thread.sleep(millisecondsSleep);
  } catch (InterruptedException e) {
  e.printStackTrace();
  }
  }
  }
  /*call quickSort() method recursively*/
  if (lowerIndex < j)
  quickSort(lowerIndex, j);
  if (i < higherIndex)
  quickSort(i, higherIndex);/*swappping*/
  }
  private void exchangeNumbers(int i, int j) {
  int temp = array[i];
  array[i] = array[j];
  array[j] = temp;
  }
  }
  /**************************************************************************************
    * Insertion sort is a simple sorting algorithm that builds the final sorted 
    * array (or list) one item at a time. It is much less efficient on large lists 
    * than more advanced algorithms such as quicksort, heapsort, or merge sort.
    *************************************************************************************/
  class InsertionSort extends SortingAlgorithm{
  public InsertionSort(SortAnimationPanel sortAnimationPanel) {
  super();
  this.sortAnimationPanel = sortAnimationPanel;
  }
  public void sort(){
  int temp; /*declaring temp and swap functions*/
  boolean swap;
  for (int i = 1; i < array.length; i++) {
  for(int j = i ; j > 0 ; j--){
  if (stop) {
  end();
  return;
  }/*calling pause wait function*/
  pauseWait();
  if (arrayOrder.equals("Asceding")) {
  swap = array[j] < array[j-1];
  }
  else {
  swap = array[j] > array[j-1];
  }
  if(swap){
  temp = array[j];/*swapping function*/
  array[j] = array[j-1];
  array[j-1] = temp;
  /*checking for the condition if sortanimation panel is not null*/
  if (sortAnimationPanel != null) {
  sortAnimationPanel.repaint();/*calling repaint function*/
  }
  try {
  Thread.sleep(millisecondsSleep);
  } catch (InterruptedException e) {
  e.printStackTrace();
    }
   }
  }
 }
  end();
 }
}
 /*******************************************************************************
   * Bubble Sort is the simplest sorting algorithm that works by repeatedly 
   * swapping the adjacent elements if they are in wrong order.
   ******************************************************************************/
  class BubbleSort extends SortingAlgorithm{
  public BubbleSort(SortAnimationPanel sortAnimationPanel) {
  super();
  this.sortAnimationPanel = sortAnimationPanel;
  }
 // logic to sort the elements
  public void sort(){
  int n = array.length;
  int k;
  boolean swap = false;
  for (int m = n; m >= 0; m--) {
  for (int i = 0; i < n - 1; i++) {
  if (stop) {
  end();
  return;
  }
  pauseWait();
  k = i + 1;
  if (arrayOrder.equals("Asceding")) {
  swap = array[i] > array[k];
  }
  else {
  swap = array[i] < array[k];
  }
  if (swap) {
  swapNumbers(i, k, array);
  /*checking condition if sortanimationpanel is not null*/
  if (sortAnimationPanel != null) {
  sortAnimationPanel.repaint();
  }
  /*implementing try fucntions*/
  try {
  Thread.sleep(millisecondsSleep);/*implementing sleep function with threads*/
  } catch (InterruptedException e) {
  e.printStackTrace(); /*print the stack trace*/
    }
   }
  }
 }
  end();
  }
  /*swapping of numbers by using temperary varaible*/
  private void swapNumbers(int i, int j, int[] array) {
  int temp;
  temp = array[i];
  array[i] = array[j];
  array[j] = temp;
  }
 }