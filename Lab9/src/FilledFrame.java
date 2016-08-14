import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrame extends JFrame { // Use instance variables for
											// components
	private JButton button;
	private JLabel label;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;

	class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			label.setText("WoWWWWWWW!");
			System.out.println("I was pushed.");
		}
	}

	public FilledFrame() {
		// Now we can use a helper method
		createComponents();

		// It is a good idea to set the size in the frame constructor
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {
		button = new JButton("Click me!");
		ActionListener myAssistant = new ClickListener();
		button.addActionListener(myAssistant);
		label = new JLabel("Hello, World!");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		add(panel);
	}
}