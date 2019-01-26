
public class BubbleSort extends SortingAlgorithm{

	//source: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
	public BubbleSort(SortAnimationPanel sortAnimationPanel) {
		super();
		//the panel that will repaint after each swap
		this.sortAnimationPanel = sortAnimationPanel;
	}
	  

    //bubble sort algorithm
    public void sort(){
        int n = array.length;
        int k;
        boolean swap = false;
                
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
            	//if user pressed stop button then end current algorithm
            	if (stop) {
            		end();
            		return;
            	}
            	pauseWait();
            	
                k = i + 1;
                
                //define the sorting order
                if (arrayOrder.equals("Asceding")) {
                	swap = array[i] > array[k];
                }
                else {
                	swap = array[i] < array[k];
                }
                
                if (swap) {
                    swapNumbers(i, k, array);
                    //redraw the array after each swap
                    if (sortAnimationPanel != null) {
                    	sortAnimationPanel.repaint();
                    }
                    
                    //wait some milliseconds till next iteration
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
  
    private void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
   
}