import javax.swing.JComponent;
import javax.swing.JFrame;

public class ChartViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 200);
		frame.setTitle("A bar chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent component = new ChartComponent();
		frame.add(component);
		frame.setVisible(true);
	}
}