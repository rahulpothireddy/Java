public class QuickSort extends SortingAlgorithm{
     
	//source: http://www.java2novice.com/java-sorting-algorithms/quick-sort
	public QuickSort(SortAnimationPanel sortAnimationPanel) {
		super();
		//the panel that will repaint after each swap
		this.sortAnimationPanel = sortAnimationPanel;
	}
	
	//quick sort algorithm
	public void sort() {
        int length = array.length;
        quickSort(0, length - 1);
        end();
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        boolean b1 = false, b2 = false;
        
        // Divide into two arrays
        while (i <= j) {
        	if (stop) {
        		//if user pressed stop button then end current algorithm
        		end();
        		return;
        	}
        	pauseWait();
           
        	//define the sorting order
        	if (arrayOrder.equals("Asceding")) {
        		b1 = array[i] < pivot;
        	}
        	else {
        		b1 = array[i] > pivot;
        	}
        	
            while (b1) {
                i++;
                //define the sorting order
                if (arrayOrder.equals("Asceding")) {
            		b1 = array[i] < pivot;
            	}
            	else {
            		b1 = array[i] > pivot;
            	}
                
            }
            //define the sorting order
            if (arrayOrder.equals("Asceding")) {
        		b2 = array[j] > pivot;
        	}
        	else {
        		b2 = array[j] < pivot;
        	}
            
            while (b2) {
                j--;
                //define the sorting order
                if (arrayOrder.equals("Asceding")) {
            		b2 = array[j] > pivot;
            	}
            	else {
            		b2 = array[j] < pivot;
            	}
            }
                        
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
                
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
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
        
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     

}