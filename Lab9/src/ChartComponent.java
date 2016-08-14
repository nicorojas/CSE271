
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class ChartComponent extends JComponent {
	/*
	 * (non-Javadoc) * @see
	 * javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */ @Override
	protected void paintComponent(Graphics g) {
		g.fillRect(10, 20, 10, 300);
		g.fillRect(0, 30, 300, 10);
		g.fillRect(0, 50, 100, 10);
		g.drawLine(350, 35, 305, 35);
		g.drawLine(350, 65, 205, 15);
		g.setColor(Color.GRAY);
		g.fillOval(350, 25, 35, 20);
		g.setColor(Color.MAGENTA);
		g.fillOval(150, 25, 35, 20);
		g.setColor(Color.CYAN);
		g.fillOval(550, 25, 35, 20);
	}
}