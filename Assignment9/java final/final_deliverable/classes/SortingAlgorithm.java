import javax.swing.JButton;

public abstract class SortingAlgorithm {

	protected int array[]; //the array which will be used for sorting
	protected String arrayOrder; //Asceding or Desceding
	protected SortAnimationPanel sortAnimationPanel; //the panel that will be repaint after each swap
	protected SortPanel sortPanel;
	protected int millisecondsSleep = 10; //milliseconds to sleep after each iteration
	protected boolean stop = false; //if the user presses the stop button this variable becomes true
	protected boolean pause = false; //if the user presses the pause button this variable becomes true
	protected int flag[] = null; //this variable is used to check if both animation panels have completed their
								//execution. 
	protected JButton stopButton = null; //this be disabled after the end of the execution
							
	
	public abstract void sort();
	
	public SortingAlgorithm(){
		 stop = false;
	}
	
	public void initialize(int[] array, String order) {
		this.array = array;
		this.arrayOrder = order;
	}
	
	public void setTimeSleep(int milliseconds) {
		millisecondsSleep = milliseconds;
	}
	
	public void setPanel(SortPanel sortPanel) {
		this.sortPanel = sortPanel;
	}
	
	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}
	
	public void setFlag(int flag[]) {
		this.flag = flag;
	}
	
	public void pause() {
		pause = !pause;
	}
	
	/*
	 * This function is called when user presses the pause button. Every 20ms
	 * it checks if the pause variable is still true. When the user presses
	 * resume then this variable will become false and current thread will
	 * continue it's work
	 */
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
	
	/*
	 * This function is used to check if both animation panels have finished with
	 * their jobs. The synchronized is used as a mutex so each time only one
	 * thread will have access to this variable. When both threads are finished
	 * with their job then the initial buttons the sort panel's button need to reset
	 */
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
	
}
