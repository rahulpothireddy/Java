
import java.awt.EventQueue;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*implementation of sortanimationapplication class*/
public class SortAnimationApplication {
private JFrame frame;
private int WINDOW_WIDTH = 950;
private int WINDOW_HEIGHT = 550;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
/*create and show the window*/  
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
/*initialize the frame*/
private void initialize(String title) {
frame = new JFrame();/*new JFrame*/
frame.setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);/*setting the boundaries*/
frame.setResizable(false);/*resizable made false*/
frame.setTitle(title);/*setting the title*/
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
int sortPanelWidth = (int)(WINDOW_WIDTH/2.2); /*panel width divided by 2.2*/
int sortPanelHeight = (int)(WINDOW_HEIGHT/1.1);/*panel width divided by 1.1*/
panel.add(new SortPanel(sortPanelWidth, sortPanelHeight));
frame.add(panel);/*add panel*/
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
