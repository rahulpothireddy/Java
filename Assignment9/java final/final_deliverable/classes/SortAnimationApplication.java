import java.awt.EventQueue;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortAnimationApplication {

	private JFrame frame;
	private int WINDOW_WIDTH = 750;
	private int WINDOW_HEIGHT = 450;

	/*
	 * Main application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//create and show the window
					SortAnimationApplication window = new SortAnimationApplication("Sorting Animation");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SortAnimationApplication(String title) {
		initialize(title);
	}

	private void initialize(String title) {
		//initialize the frame
		frame = new JFrame();
		frame.setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setTitle(title);
		//
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		//empirically set the width and height of the sort panel
		int sortPanelWidth = (int)(WINDOW_WIDTH/2.2);
		int sortPanelHeight = (int)(WINDOW_HEIGHT/1.1);
		panel.add(new SortPanel(sortPanelWidth, sortPanelHeight));
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
