public class InsertionSort extends SortingAlgorithm{
 
	//source: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
	public InsertionSort(SortAnimationPanel sortAnimationPanel) {
		super();
		//the panel that will repaint after each swap
		this.sortAnimationPanel = sortAnimationPanel;
	}
	
	//insertion sort algorithm
    public void sort(){
        int temp;
        boolean swap;
        
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
            	if (stop) {
            		//if user pressed stop button then end current algorithm
            		end();
            		return;
            	}
            	pauseWait();
            	
            	//define the sorting order
            	if (arrayOrder.equals("Asceding")) {
            		swap = array[j] < array[j-1];
            	}
            	else {
            		swap = array[j] > array[j-1];
            	}
            	
                if(swap){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    
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
    
}