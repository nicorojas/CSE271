// Nico Rojas
// CSE 271, Project 2
// May 2016

package edu.miamioh.rojasnm;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * A GUI for the 8-Queens Puzzle. Includes 'Check Progress' and 'Hint' features.
 * @author rojasnm
 */
public class EightQueensGUI extends JFrame implements MouseListener, MouseMotionListener {

	private ArrayList<Queen> queens = new ArrayList<Queen>();
	private ArrayList<Integer> queenLocation = new ArrayList<>();
	private ArrayList<Integer> incorrectQueen = new ArrayList<>();
	private ArrayList<Color> original = new ArrayList<Color>(); // used with "Hint"
	private ArrayList<Color> notSafeOriginal = new ArrayList<>(); // used with "Check Progress"
	private ArrayList<Component> occupiedSpace = new ArrayList<Component>(); // holds components where a queen is
	private ArrayList<Integer> notValid = new ArrayList<Integer>();
	
	private int queenCount = 0;
	private boolean hintOn = false, progressOn = false, emptyZero = true;
	
	private JToolBar tools;
	private JLayeredPane layeredPane;
	private JPanel chessBoard;
	private JLabel chessPiece, message;
	private JLabel countMessage = new JLabel("Queens Placed: " + queenCount);
	private JMenuBar menuBar;
	private static JFrame frame;

	/**
	 * Creates welcome screen and game frame.
	 * @param args
	 */
	public static void main(String[] args) {

		// Welcome Screen
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("", new ImageIcon("EightQueensWelcome.jpg"), SwingConstants.CENTER));
		window.setBounds(400, 150, 500, 333);
		window.setVisible(true);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window.setVisible(false);
		window.dispose();

		// Game Frame
		frame = new EightQueensGUI();
		frame.setTitle("The 8 Queens Game");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // displays frame in middle of screen							   
		frame.setVisible(true);            // instead of top left corner
	}

	/**
	 * Calls for toolbar to be made. Creates LayeredPane as well as the chessboard pattern.
	 */
	public EightQueensGUI() {

		createToolBar();
		Dimension boardSize = new Dimension(600, 600);

		// create LayeredPane
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// create board
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		chessBoard.addMouseListener(this);
		chessBoard.addMouseMotionListener(this);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;

			// color squares
			if (row == 0) {
				if (i % 2 == 0)
					square.setBackground(Color.DARK_GRAY);
				else
					square.setBackground(Color.WHITE);
			}
			else {
				if (i % 2 == 0)
					square.setBackground(Color.WHITE);
				else
					square.setBackground(Color.DARK_GRAY);
			}
		}
	}

	/**
	 * Creates toolbar and adds buttons.
	 */
	public void createToolBar() {

		// Create menu and tool bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		tools = new JToolBar();
		tools.setFloatable(false);
		menuBar.add(tools, BorderLayout.PAGE_START);
		message = new JLabel();

		// Progress Button
		Action progressAction = new AbstractAction("Check Progress") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!hintOn)
					checkProgress();
			}
		};

		// Hint Button
		Action hintAction = new AbstractAction("Hint") {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(!progressOn){
					if (queenCount < 1) {
						tools.remove(message);
						tools.remove(countMessage);
						message = new JLabel("You must place a queen first!");
						message.setForeground(Color.RED);
						tools.add(message);
						updatePiece();
					}
					else if(queenCount < 8)
						hint();
				
					else {
						tools.remove(message);
						tools.remove(countMessage);
						message = new JLabel("Only available when 1 to 7 queens are placed.");
						message.setForeground(Color.RED);
						tools.add(message);
						updatePiece();
					}
				}
			}
		};

		// Encouragement Button
		Action encourageAction = new AbstractAction("☺") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (queenCount < 8 && !hintOn && !progressOn)
					encouragement();
			}
		};
		
		tools.add(progressAction);
		tools.addSeparator();
		tools.add(hintAction);
		tools.addSeparator();
		tools.add(encourageAction);
		tools.addSeparator();
		tools.add(countMessage);
	}

	/**
	 * Updates the frame whenever called by modifying size.
	 */
	public void updatePiece() {
		frame.setSize(600, 646);
		frame.setSize(600, 645);
	}

	/**
	 * Checks to see if all placed queens are safe or not. If there are any non-safe pieces, then 
	 * notSafe() is called.
	 */
	public void checkProgress() {

		// reset all values
		queens.clear();
		queenLocation.clear();
		incorrectQueen.clear();

		// adds occupied spaces to ArrayList<Queen>
		for (int i = 1; i <= 64; i++) {

			Component c = chessBoard.getComponent(i - 1);

			if (i == 1) { // deals with removing index [0] bug
				if (!emptyZero) {
					queens.add(new Queen(chessBoard.getComponent(i - 1).getX(), chessBoard.getComponent(i - 1).getY()));
					queenLocation.add(i);
				}
			}
			else if (occupiedSpace.contains(c)) {
				queens.add(new Queen(chessBoard.getComponent(i - 1).getX(), chessBoard.getComponent(i - 1).getY()));
				queenLocation.add(i);
			}
		}
		boolean safe = true;
		if (queens.size() > 1) {
			for (int i = 0; i < queens.size() - 1; i++) {
				for (int x = 1; x < queens.size(); x++) {
					if (queens.get(i).attacks(queens.get(x)) && (i != x)) { // uses stephamd's Queen.java
						if (!incorrectQueen.contains(i))
							incorrectQueen.add(i);
						if (!incorrectQueen.contains(x))
							incorrectQueen.add(x);

						safe = false;
					}
				}
			}
		}
		if (safe) {
			if (queenCount < 1) {
				tools.remove(message);
				tools.remove(countMessage);
				message = new JLabel("You must place a queen first!");
				message.setForeground(Color.RED);
				tools.add(message);
			}
			else {
				tools.remove(message);
				tools.remove(countMessage);
				message = new JLabel("All queens are safe.");
				message.setForeground(Color.RED);
				tools.add(message);
			}
			updatePiece();
		}
		else notSafe();
	}

	/**
	 * Changes the color of any non-safe placed queens.
	 */
	public void notSafe() {

		if (progressOn) {
			for (int i = 0; i < incorrectQueen.size(); i++) {
				chessBoard.getComponent(queenLocation.get(incorrectQueen.get(i)) - 1)
						  .setBackground(notSafeOriginal.get(i));
			}
			notSafeOriginal.clear();
			tools.remove(message);
			tools.remove(countMessage);
			countMessage = new JLabel("Queens Placed: " + queenCount);
			tools.add(countMessage);
			chessBoard.addMouseListener(this);
			progressOn = false;
			updatePiece();
		}
		else {
			// Set tile color of incorrect queens to red, save original colors
			for (int i = 0; i < incorrectQueen.size(); i++) {
				notSafeOriginal.add(chessBoard.getComponent(queenLocation.get(incorrectQueen.get(i)) - 1).getBackground());
				chessBoard.getComponent(queenLocation.get(incorrectQueen.get(i)) - 1).setBackground(Color.RED);
			}
			chessBoard.removeMouseListener(this);
			progressOn = true;
			tools.remove(message);
			tools.remove(countMessage);
			message = new JLabel("Press 'Check Progress' to move conflicting red queens.");
			message.setForeground(Color.RED);
			tools.add(message);
			updatePiece();
		}
	}

	/**
	 * Changes color of all non-safe potential spaces.
	 */
	public void hint() {

		if (hintOn) {
			for (int i = 0; i < original.size(); i++) // sets all moves back to original color
				chessBoard.getComponent(notValid.get(i) - 1).setBackground(original.get(i));
			
			original.clear();
			hintOn = false;
			tools.remove(message);
			tools.remove(countMessage);
			countMessage = new JLabel("Queens Placed: " + queenCount);
			tools.add(countMessage);
			chessBoard.addMouseListener(this);
		}
		else {
			hintOn = true;
			chessBoard.removeMouseListener(this);
			tools.remove(message);
			tools.remove(countMessage);
			message = new JLabel("Press 'Hint' again to continue & select a non-red square.");
			message.setForeground(Color.RED);
			tools.add(message);

			ArrayList<Integer> taken = new ArrayList<Integer>();

			for (int i = 1; i <= 64; i++) {
				Component c = chessBoard.getComponent(i - 1);

				if (occupiedSpace.contains(c)) 
					taken.add(i);
			}
			findInvalidMoves(taken);
			
			original.clear();

			for (int i = 0; i < notValid.size(); i++) {
				Color temp = chessBoard.getComponent(notValid.get(i) - 1).getBackground();
				original.add(temp);
				chessBoard.getComponent(notValid.get(i) - 1).setBackground(Color.RED); // sets bad moves to red
			}
		}
		updatePiece();
	}

	/**
	 * Finds all unsafe spaces (where-ever a placed queen can attack) and adds them
	 * to an ArrayList.
	 * 
	 * @param taken
	 */
	public void findInvalidMoves(ArrayList<Integer> taken) {

		notValid.clear(); // reset so old spots aren't saved
		notValid.addAll(taken); // adds all already taken spots to array

		// create an array of spots that are not safe
		for (int i = 0; i < taken.size(); i++) {

			int spot = taken.get(i);
			int remainder = spot % 8;

			if (spot % 8 == 0) {
				for (int x = 1; x < 8; x++) {
					if (!notValid.contains(spot - x))
						notValid.add(spot - x);
				}
			}

			for (int x = 0; x < remainder - 1; x++) {
				int a = spot - remainder + 1 + x;

				if (!notValid.contains(a))
					notValid.add(a); // adds all spots to left of taken spot
			}

			for (int x = 0; x < (8 - remainder); x++) {
				if (spot % 8 != 0) {
					if (!notValid.contains(spot + 1 + x))
						notValid.add(spot + 1 + x); // adds all spots to right
				}
			}

			for (int x = 1; x < 8; x++) {
				int a = spot - (8 * x);
				if (a > 0)
					if (!notValid.contains(a))
						notValid.add(a); // adds all spots above taken spot
			}

			for (int x = 1; x < 8; x++) {
				int a = spot + (8 * x);
				if (a <= 64)
					if (!notValid.contains(a))
						notValid.add(a); // adds all spots below taken spot
			}

			for (int x = 1; x < 8; x++) {
				int a = spot - (7 * x);
				if (spot % 8 != 0) {
					if ((a > 0))
						if (!notValid.contains(a))
							notValid.add(a); // adds right diagonals above spot
					if ((a % 8 == 0))
						x = 8;
				}
			}

			for (int x = 1; x < 8; x++) {
				if (spot % 8 != 1) {
					int a = spot + (7 * x);
					if (a <= 64)
						if (!notValid.contains(a))
							notValid.add(a); // adds left diagonals below spot
					if ((a % 8 == 1))
						x = 8;
				}
			}

			for (int x = 1; x < 8; x++) {
				int a = spot + (9 * x);
				if ((a % 8 == 1))
					x = 8;
				else {
					if (a <= 64)
						if (!notValid.contains(a))
							notValid.add(a); // adds right diagonals below spot
				}
			}

			for (int x = 1; x < 8; x++) {
				int a = spot - (9 * x);
				if (spot % 8 != 1) {
					if ((a > 0))
						if (!notValid.contains(a))
							notValid.add(a); // adds left diagonals above spot
					if ((a % 8 == 1))
						x = 8;
				}
			}
		}
	}

	/**
	 * Randomly displays one of five encouraging messages.
	 */
	public void encouragement() {

		String[] phrase = {"You can do it!", "You got it!", "You're almost there!", "I believe in you!",
				"Keep trying!"};
		tools.remove(message);
		tools.remove(countMessage);
		int x = (int)(Math.random() * 5);
		message = new JLabel(phrase[x]);
		message.setForeground(Color.MAGENTA);
		tools.add(message);
		updatePiece();	
	}

	/**
	 * MouseMotionListener implemented method. Listener for when mouse is pressed.
	 * @param e
	 */
	public void mousePressed(MouseEvent e) {

		chessPiece = null;

		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		if (c instanceof JPanel)
			return;

		chessPiece = (JLabel) c;
	}

	/**
	 * MouseMotionListener implemented method. Listener for when mouse is released.
	 * @param e
	 */
	public void mouseReleased(MouseEvent e) { }

	/**
	 * MouseMotionListener implemented method. Listener for when mouse is clicked.
	 * Adds/removes queens from the board when a space/queen is clicked.
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {

		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		Container parent = (Container) c;
		
		tools.remove(message); // resets message whenever piece is clicked
		tools.remove(countMessage);

		// Add piece
		if (chessPiece == null) {
			if (queenCount < 8) {
				JLabel piece = new JLabel(new ImageIcon("queen_copy.png"));
				parent.add(piece);
				updatePiece();
				queenCount++;
				occupiedSpace.add(c); // add component to occupied spaces
				if((chessBoard.findComponentAt(e.getX(), e.getY()).getX() == 0)&&
				   (chessBoard.findComponentAt(e.getX(), e.getY()).getY() == 0))
						emptyZero = false;
			}
		}

		// Remove piece
		else {
			chessPiece.setVisible(false);
			parent.remove(chessPiece);
			if((chessBoard.findComponentAt(e.getX(), e.getY()).getX() == 0)&&
			   (chessBoard.findComponentAt(e.getX(), e.getY()).getY() == 0))
					emptyZero = true; // index [0] is empty
			queenCount--;
			occupiedSpace.remove(chessBoard.findComponentAt(e.getX(), e.getY())); // remove
		}
		countMessage = new JLabel("Queens Placed: " + queenCount);
		tools.add(countMessage);
	}

	/**
	 * MouseMotionListener implemented method. Listener for when mouse is dragged.
	 * @param e
	 */
	public void mouseDragged(MouseEvent e) { }

	/**
	 * MouseMotionListener implemented method. Listener for when mouse enters.
	 * @param e
	 */
	public void mouseEntered(MouseEvent e) { }

	/**
	 * MouseMotionListener implemented method. Listener for when mouse exits.
	 * @param e
	 */
	public void mouseExited(MouseEvent e) { }

	/**
	 * MouseMotionListener implemented method. Listener for when mouse is moved.
	 * @param e
	 */
	public void mouseMoved(MouseEvent e) { }
}