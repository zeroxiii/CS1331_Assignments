/* Name: Rahmaan Lodhia
 * Prism: rlodhia3
 * Collaboration: "I worked on the homework assignment
 *  alone, using only course materials." 
 */

import javax.swing.JFrame;

/**
 * GameOfLife
 * Contains the main method and creates
 * a frame to run the GUI of the game
 */
public class GameOfLife 
{ 
	/**
	 * Creates the Frame for the GUI
	 * and displays the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GamePanel(20,20));
		
		frame.pack();
		frame.setVisible(true);
	}
}
